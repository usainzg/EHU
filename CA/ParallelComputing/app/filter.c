/************************************************************************************
   File: filter.c 

   Includes the functions required to filter the page. 
***********************************************************************************/
#include <stdio.h>
#include <math.h>
#include "pixmap.h"
#include <omp.h>

#define NUM_IT 100


/*  Copy page in_page in page out_page */
/***************************************************/
void copy_page(page *in_page, page *out_page)
{
 int i,j;

 for (i=0;i<in_page->h;i++)
  for (j=0;j<in_page->w;j++) out_page->im[i][j]=in_page->im[i][j];
}


/* Apply the filter to a page                            */
/***********************************************************************************/

double filter_page (page *in_page, page *out_page)
{

//////////////////////////////////////////////////////////////////////
/* TO DO: code to apply the smoothing filter to the page       */
/* the filter will be applied to page in_page (generates out_page)    */
/* the function returns the average value of the pixels of the filtered  */
/* page minus the minimum pixel value */
/////////////////////////////////////////////////////////////////////
  double min = 257;
  double avg = 0;
  double value = 0;
  #pragma omp parallel for schedule(dynamic, 4) reduction(min:min) reduction(+:avg) private(value)
  for(int i = 1; i < out_page->h-1; i++) {
    for(int j = 1; j < out_page->w-1; j++) {
        int m[] = {
          out_page->im[i-1][j-1],
          out_page->im[i][j-1],
          out_page->im[i+1][j-1],
          out_page->im[i-1][j],
          out_page->im[i][j],
          out_page->im[i+1][j],
          out_page->im[i-1][j+1],
          out_page->im[i][j+1],
          out_page->im[i+1][j+1],
        };
        double sum = 0;
        for(int t = 0; t < 9; t++) sum += m[t];
        double value = sum / 9;
        out_page->im[i][j] = (int) value;
        if(value < min) min = value;
        avg += value;
      }
  }
  avg /= ((out_page->w-1)*(out_page->h-1));
  return avg - min;
}


/* generate the filtered page               */
/**************************************/
void generate_filtered_page ( page *in_page, page *out_page, float limit)
{

  generate_page(out_page,in_page->h,in_page->w,BLACK);
  copy_page(in_page,out_page);

/////////////////////////////////////////////////////////////////////////
 /* TO DO: generate the filtered page from the original page             */
 /*conditions to finish the process when applying the filter:            */
 /*     (a) to overtake the number of iterations                         */
 /*     (b) the average value for the pixels minus the minimum values is */
/*           smaller than the limit                                      */
 /* store the final page in variable out_page                          */
 /////////////////////////////////////////////////////////////////////////
  double avgMinus = 0;
  int i = 0;
  do {
    avgMinus = filter_page(in_page, out_page);
    i += 1;
    printf("%d -> %f\n", i, avgMinus);
  } while(avgMinus > limit);
}


