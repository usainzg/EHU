void BorrarPantalla() {
    for(int i = 5; i < 16; i++) {
        printf("\x1b[%d;00H                          ", i);
    }
}