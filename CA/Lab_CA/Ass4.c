#include <stdio.h>
#include <stdlib.h>

void set_vec(int *A) 
{
    for(int i = 0; i < 5; i++) {
        int input;
        printf("> Intro n%d: \n", i);
        scanf("%d", &input);
        A[i] = input;
    }
}

void set_matrix(float M[][2]) 
{
    for(int i = 0; i < 2; i++) {
        for(int j = 0; j < 2; j++) {
            int input;
            printf("> Intro %d:%d \n", i, j);
            scanf("%d", &input);
            M[i][j] = input;
        }
    }
}

float calculate_avg(int *V, int n)
{
    int addition = 0;
    for (int i = 0; i < n; i++)
    {
        addition += V[i];
    }

    float avg = 0;
    avg = addition / n;
    return avg;
}

void sum_avg_matrix(float M[][2], float avg) 
{
    for(int i = 0; i < 2; i++) {
        for(int j = 0; j < 2; j++) {
            M[i][j] += avg;
        }
    }
}

void show_matrix(float M[][2])
{
    for(int i = 0; i < 2; i++) {
        for(int j = 0; j < 2; j++) {
            printf("> %d:%d: %1.0f \n", i, j, M[i][j]);
        }
    }
}

int main()
{
    int A[5];
    float M[2][2];

    set_vec(A);
    set_matrix(M);

    float avg = calculate_avg(A, 5);

    printf("\n Avg: %1.2f\n", avg);

    printf("Matrix before adding average: \n");
    show_matrix(M);

    printf("Matrix after adding average: \n");
    sum_avg_matrix(M, avg);
    show_matrix(M);

    return 0;
}
