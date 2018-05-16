/*-------------------------------------
 temporizadores.c
-------------------------------------*/
// Anadir los includes que sean necesarios
#include "defines.h"
#include "sprites.h"
#include <nds.h>
#include <stdio.h>
#include "juego.h"

static int t = 0;

static int n_segundos = 0;



// Rutina de atencion a la interrupcion del temporizador
void IntTemp() {
    t++;
    // TODO: cambiar dificultad
    if (t >= 512 && estado == ESTADO_JUGANDO) {
        n_segundos++;
        t = 0;
        BucleJuego(n_segundos);
    }
    ControladorSobre();
}





