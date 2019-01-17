parallelmake: page_s.c filter.c encrypt.c pixmap.o prepare_up.c upload.o
	gcc page_s.c filter.c encrypt.c pixmap.o prepare_up.c upload.o -lm -fopenmp -o page_parallel
