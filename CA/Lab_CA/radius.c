#include <stdio.h>


void main ( )
{
	int r;
	float area, perimeter;

	printf ("Introduce the radius of the circle\n");
	scanf ("%d", &r); 
	area = 3.14159 * r * r;
	perimeter = 2 * 3.14159 * r;
	printf ("In a circle with radius %d\n",r);
	printf ("the area is: %f\n", area);
	printf ("and the perimeter: %f\n", perimeter);
}

