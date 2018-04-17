/*-------------------------------------
 teclado.c
-------------------------------------*/

// Anadir los includes que sean necesarios
#include <nds.h>
#include <stdlib.h>
#include <stdio.h>
#include "defines.h"
#include "sprites.h"

int TECLAS_ENCUESTA_ARR[] = {3, 4};
int TECLAS_INTERRUPT_ARR[] = {1, 2, 5};
const char *TECLAS_STR[] = { "<B>", "<SELECT>", "<START>", "<DCHA>", "<IZDA>" };


int ComprobarTecla(int idTecla) {
    return TECLAS_DAT & (1 << idTecla);
}

// Esta funcion tiene que devolver el valor de la tecla pulsada
int  TeclaPulsada(int tipoTecla) {
    int teclaRet = -1;
    switch(tipoTecla) {
        case TIPO_ENCUESTA:
            if (!ComprobarTecla(TECLAS_ENCUESTA_ARR[0])) teclaRet = TECLAS_ENCUESTA_ARR[0];
            if (!ComprobarTecla(TECLAS_ENCUESTA_ARR[1])) teclaRet = TECLAS_ENCUESTA_ARR[1];
            break;
        case TIPO_INTERRUPT:
            if (!ComprobarTecla(TECLAS_INTERRUPT_ARR[0])) teclaRet = TECLAS_INTERRUPT_ARR[0];
            if (!ComprobarTecla(TECLAS_INTERRUPT_ARR[1])) teclaRet = TECLAS_INTERRUPT_ARR[1];
            if (!ComprobarTecla(TECLAS_INTERRUPT_ARR[2])) teclaRet = TECLAS_INTERRUPT_ARR[2];
            break;
        default:
            break;
    }
    return teclaRet;
}

void ImprimirTeclaPulsada(int tecla, int tipoTecla) {
    if(tipoTecla == TIPO_INTERRUPT) {
        iprintf("\x1b[10;00H     TECLA INTERRUP: %s", TECLAS_STR[tecla - 1]);
    } 
    if(tipoTecla == TIPO_ENCUESTA) {
        iprintf("\x1b[10;00H     TECLA ENCUESTA: %s", TECLAS_STR[tecla - 1]);
    }
}

// Rutina de atencion a la interrupcion del teclado
void IntTec() {
    int t = TeclaPulsada(TIPO_INTERRUPT);
    ImprimirTeclaPulsada(t, TIPO_INTERRUPT);
} 




