/*-------------------------------------
 teclado.c
-------------------------------------*/

// Anadir los includes que sean necesarios
#include <nds.h>
#include <stdlib.h>
#include <stdio.h>
#include "defines.h"
#include "sprites.h"
#include "temporizadores.h"

int TECLAS_ENCUESTA_ARR[] = {3, 4};
int TECLAS_INTERRUPT_ARR[] = {1, 2, 5};
const char *TECLAS_STR[] = { "<B>", "<SELECT>", "<START>", "<DCHA>", "<IZDA>" };

// Rutina de atencion a la interrupcion del teclado
void IntTec() {
    int t = TeclaPulsada(TIPO_INTERRUPT);
    switch(estado) {
        case ESTADO_INICIO:
            break;
        case ESTADO_JUGANDO:
            if(t == 5) {
                MoverSobreIzquierda();
                flag_principal |= FLAG_ACTUALIZACION_SOBRE;
            }

            if (t == 1) {
                AcabarPartida();
            }
            break;
        case ESTADO_BORRAR_MOSTRAR:
            if (t == 2) {
                MostrarPantallaInit();
            }
            break;
        case ESTADO_APAGADO:
        default:
            break;
    }
} 

// Funcion auxiliar para comprobar tecla pulsada
int ComprobarTecla(int idTecla) {
    return TECLAS_DAT & (1 << idTecla);
} // final

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
} // final




