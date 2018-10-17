// C laboratory -- ass2.c – TO COMPLETE 
// dynamic memory assignation: average of the elements of a vector.

#include <stdio.h>
#include <stdlib.h>


void generate_vec (int *A, int size)
{
  int  i;
  for (i=0; i<size; i++) A[i] = rand () % 100;
}    


int main ()
{
  int  i, size, addition;
  int *A;

  printf ("\n Number of elements > ");
  scanf ("%d", &size); 

  A = (int *) malloc(size * sizeof(int));

  generate_vec (A, size);

  addition = 0;

  for(int i = 0; i < size; i++) {
    addition += A[i];
  }

  float avg = 0;
  avg = addition / size;

  printf ("\n Addition: %4d -- Av: %1.2f -- size: %4d\n", addition, avg, size);

  free(A);

  return 0;
}
