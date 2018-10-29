#include <stdio.h>
#include <stdlib.h>

int main() {
    int size;

    int **M;

    do {
        printf("Intro the matrix size (max 1000): \n");
        scanf("%d", &size);
    } while (size > 1000);
    
    M = malloc(size * sizeof(int *));
    for(int i = 0; i < size; i++) {
        M[i] = (int*) malloc(sizeof(int));
    }

    for(int i = 0; i < size; i++) {
        for(int j = 0; j < size; j++) {
            M[i][j] = rand() % 20 - 10;
            printf(" %d ", M[i][j]);
        }
        printf("\n");
    }
    
    printf("%d size", size);

    return 0;
}