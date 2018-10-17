#include <stdio.h>
#include <stdlib.h>

long facto (int n)
{
	long res; 
	int i;
		
	for (i=1, res=1; i<=n; i++) res*=i;
	return(res);
}

void main ()
{
	int num;
	long factorial;

	printf ("Introduce a number: ");
	scanf("%d", &num);
	if (num<0) printf("Error: negative number! \n");
	else
	{
		factorial = facto(num);
		printf ("The factorial of %d is %ld\n",num,factorial); 
	}	
	
} 
