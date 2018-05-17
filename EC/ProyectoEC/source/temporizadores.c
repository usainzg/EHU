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

int tDerecha = 0;

static int n_segundos = 0;

void TimerJuego() {
    if (t >= 512 && estado == ESTADO_JUGANDO) {
        n_segundos++;
        t = 0;
        BucleJuego(n_segundos);
    }
}

bool TimerMovimientoDerecha() {
    if (tDerecha != 0) return true;
    return false;
}

void SetTimerDerecha() {
    tDerecha = 0;
}

void ControladorTimerDerecha() {
    if (t >= 256) {
        tDerecha = 1;
    }
}

// Rutina de atencion a la interrupcion del temporizador
void IntTemp() {
    t++;
    ControladorTimerDerecha();
    TimerJuego();
    ControladorSobre();
}





