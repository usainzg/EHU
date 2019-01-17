/************************************************************************************
     File: prepare_up.c

       Contains the funtions used to prepare the upload of the page
***********************************************************************************/

#include "pixmap.h"
#include "upload.h"


/* Prepares the upload of the page                      */
/***********************************************************************************/

void prepare_up(page in_page) {
	int i, j;
//////////////////////////////////////////////////////////////////////////////////////
/* TO COMPLETE: code to prepare the upload of the page          */
//////////////////////////////////////////////////////////////////////////////////////
	#pragma omp parallel for schedule(dynamic, 4) private(i, j)
	for (i = 0; i < in_page.h; i++)
		for (j = 0; j < in_page.w; j++)
			upload(in_page.im[i][j], i, j, in_page.h, in_page.w);
}

