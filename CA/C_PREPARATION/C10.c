#include <stdio.h>

struct image {
    int w, h;
    unsigned char im[16][16];
};

int identical(struct image *im1, struct image *im2) {
    return 1;
}

int main() {
    return 0;
}