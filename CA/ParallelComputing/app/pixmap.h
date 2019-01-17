/* File: pixmap.h */

#define BLACK   0       
#define WHITE   255
#define MAX_VAL 256     /* Rank of possible grey values */

typedef struct
{
  int w;                 /* Width */
  int h;                 /* Height */
  unsigned char *dat;    /* Image */
  unsigned char **im;
}page;

extern int load_pixmap(char *filename, page *iimage);
extern void store_pixmap(char *filename, page oimage);

extern void  generate_page(page *opage, int h, int w, unsigned char val);
extern void  free_page(page ipage);

