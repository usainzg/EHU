#include <stdio.h>

int main() {
    int x = 0;
    int a = 1;

    if (x > 0) a++;
    else if (x == 0) a--; // es (==) no (=)
    else a /= 2;
    return 0;
}