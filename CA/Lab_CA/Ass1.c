// C laboratory -- ass1.c – TO COMPLETE 

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define N  100

void generate_vec (int *A) {
  int  i;
  for (i=0; i<N; i++) A[i] = rand() % 100;
} 

void main () {
  int  A[N];

  generate_vec (A);

  // section a: add vector elements until one smaller tha 5 appears
  int addition = 0;
  int position = 0;
  for(int i = 0; A[i] >= 5 && i < N; i++) {
    addition += A[i];
    position = i;
  }


  printf ("\n  Addition = %d    Up to position = %d \n", addition, position);


  // section b: add all the elments greater than 5 in a vector

  addition = 0;
  int number = 0;
  for(int i = 0; i < N; i++) {
    if(A[i] > 5) {
      addition += A[i];
      number++;
    }
  }

  printf ("\n  Addition = %d    number = %d \n", addition, number);

}

