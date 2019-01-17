serialmake: page_s.c filter.c encrypt.c pixmap.o prepare_up.c upload.o
	gcc page_s.c filter.c encrypt.c pixmap.o prepare_up.c upload.o -lm -o page_serial
