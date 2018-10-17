#include <stdio.h>

void main()
{	
 int x1=1088;
 char c;
 unsigned char uc;

 c=x1;
 printf ("%x -- %c -- %d\n", c, c, c);

 c=255;
 x1=c;
 printf ("%x -- %d\n", x1, x1);

 uc=255;
 x1=uc;
 printf ("%08x -- %d\n", x1, x1);
}
