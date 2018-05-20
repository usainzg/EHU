#include <stdio.h>
#include <stdlib.h>	    // srand, rand,...
#include <unistd.h>
#include <time.h>       // time 

#include "nds.h"
#include "fondos.h"
#include "sprites.h"
#include "defines.h"
#include "rutservs.h"
#include "teclado.h"
#include "temporizadores.h"
#include "auxiliares.h"

void MoverSobreIzquierda() {
    posicionX_sobre -= 5;
    if (posicionX_sobre <= -16) posicionX_sobre = 255;
}

void ControladorSobre() {
    MostrarSobre(posicionX_sobre, POSICION_Y_SOBRE);
}
// final SOBRES

void MostrarPuntuacion(int recogidos, int no_recogidos) {
    iprintf("\x1b[10;10H %d", recogidos);
    iprintf("\x1b[11;10H %d", no_recogidos);  
}

