/************************************************************************************
     File: encrypt.c

 	Generates the encrypted page
***********************************************************************************/

#include "pixmap.h"
#include <omp.h>

void encrypt (unsigned char *v1, unsigned char *v2)
{

//////////////////////////////////////////////////////////////////////////////////////
/* TO COMPLETE: code to calculate the encryption        */
//////////////////////////////////////////////////////////////////////////////////////
	int enc_m[2][2] = {{21, 35},{18, 79}};
	int n1 = (enc_m[0][0] * *v1 + enc_m[0][1] * *v2) % 256;
	int n2 = (enc_m[1][0] * *v1 + enc_m[1][1] * *v2) % 256;
	*v1 = n1;
	*v2 = n2;
}


void generate_encrypted_page(page in_page, page *out_page)
{

 generate_page(out_page,in_page.h,in_page.w,BLACK);

//////////////////////////////////////////////////////////////////////////////////////
/* TO COMPLETE: code to generate the encrypted page*/
//////////////////////////////////////////////////////////////////////////////////////
	
	int n = (in_page.h*in_page.w);
	#pragma omp parallel for schedule(guided)
	for(int i = 0; i < n-1; i+=2) {
		out_page->dat[i] = in_page.dat[i];
		out_page->dat[i+1] = in_page.dat[i+1];
		encrypt(&out_page->dat[i], &out_page->dat[i+1]);
	}
}


