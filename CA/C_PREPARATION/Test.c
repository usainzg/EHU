#include <stdio.h>
#include <stdlib.h>

#define PI 3.14
#define NAME "Unai"

void printSizes() {
    printf("-- Sizes --\n");
    printf("%lu bytes for char\n", sizeof(char));
    printf("%lu bytes for int\n", sizeof(int));
    printf("%lu bytes for long\n", sizeof(long));
    printf("%lu bytes for int pointer\n", sizeof(int*));
    printf("%lu bytes for double\n", sizeof(double));
}

void printConstants() {
    printf("-- Constants --\n");
    printf("%.2f \n", PI);
    printf("%s \n", NAME);
}

void printOperations() {
    printf("-- Operations --\n");
    int i = 5;
    float t = 55.5;
    int rI = i * t;
    float rF = i * t;

    printf("%d int out, %.2f float out\n", rI, rF);
}

void printVector() {
    printf("-- Vector --\n");
    int x[] = {0, 1, 2, 3};
    int *a = &x[0];
    printf("%d x[0] before\n", *a);
    a += 1;
    printf("%d x[1] before\n", *a);
    *a += 40;
    printf("%d x[1] after\n", x[1]);
}

void printPointer() {
    printf("-- Pointer --\n");
    int i = 10;
    int *p;
    p = &i;
    int *k = p;
    printf("%d point->point before\n", *k);
    *p += 10;
    printf("%d point->point after\n", *k);

    if(p == k) {
        printf("Equal pointers\n");
    }

    if(*p == *k) {
        printf("Equal pointers value\n");
    }
}

void printStrings() {
    printf("-- Strings --\n");
    char *str;
    char x[5] = "unai";
    str = x;
    printf("%s\n", str);

    char *names[] = {"unai", "irati"};
    char **p;
    p = &names[1];
    printf("%s\n", *p);
}

void printDynamicAlloc() {
    printf("-- Dynamic --\n");
    int *vec;
    vec = (int*) malloc(10 * sizeof(int));
    for(int i = 0; i < 10; i++) {
        vec[i] = i;
        printf("%d", vec[i]);
    }

    int **vec3;

    vec3 = (int**) malloc(10 * sizeof(int*));
    for(int i = 0; i < 10; i++) {
        vec3[i] = (int*) malloc(10 * sizeof(int));
    }

    for(int i = 0; i < 10; i++) {
        for(int j = 0; j < 10; j++) {
            vec3[i][j] = i + j;
            printf(" %d ", vec3[i][j]);
        }
        printf("\n");
    }

    free(vec);
    free(vec3);
}

void byValue(int a) {
    a++;
    printf("%d -> a\n", a);
}

void byRef(int *a) {
    *a += 1;
    printf("%d -> a\n", *a);
}

void printFunction() {
    printf("-- Function --\n");
    int a = 10;
    byValue(a);
    printf("%d -> a after by value\n", a);
    byRef(&a);
    printf("%d -> a after reference\n", a);
}

struct Person {
    int dni;
    char *name;
};

void readPerson(struct Person *p) {
    p->dni = 798;
    p->name = "Irati";
    printf("Pointer: %d dni, %s\n", p->dni, p->name);
}

int main(int argc, char* argv[]) {

    #ifdef ENG
        printf("UNAI ENG\n");
    #endif // DEBUG

    printSizes();
    printConstants();
    printOperations();
    printVector();
    printPointer();
    printStrings();
    printDynamicAlloc();
    printFunction();

    for(int i = 0; i < argc; i++) {
        printf("%s\n", argv[i]);
    }

    struct Person p1;
    struct Person *pPointer;

    p1.dni = 7999;
    p1.name = "Unai";

    printf("%d dni, %s\n", p1.dni, p1.name);

    pPointer = &p1;

    printf("Pointer: %d dni, %s\n", pPointer->dni, pPointer->name);

    readPerson(pPointer);

    printf("Pointer: %d dni, %s\n", pPointer->dni, pPointer->name);

    FILE *f = fopen("Files/images1.dat", "r");
    int a;
    while(!feof(f)) {
        fscanf(f, "%d", &a);
        printf(" %d ", a);
    }
    fclose(f);

    return 0;
}