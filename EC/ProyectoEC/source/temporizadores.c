/*-------------------------------------
 temporizadores.c
-------------------------------------*/
// Anadir los includes que sean necesarios
#include "defines.h"
#include "sprites.h"
#include <nds.h>
#include <stdio.h>

static int t = 0;

static int n_segundos = 0;


// Rutina de atencion a la interrupcion del temporizador
void IntTemp() {
    t++;
    if (t >= 512) {
        n_segundos++;
        t = 0;
    }
}





