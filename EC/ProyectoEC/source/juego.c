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

/* FUNCIONES SOBRE PUNTOS PARTIDA */
void SumarPunto(int puntos) {
    puntos += 1;
}

void RestarPunto(int puntos) {
    puntos -= 1;
}

bool MaxPuntosAlcanzado(int puntos) {
    return (puntos >= MAX_PUNTOS);
}

void PasarAMostrarBorrar() {
    iprintf("\x1b[05;00H       PUNTUACION JUEGO         ");
	iprintf("\x1b[07;00H -----------------------------  ");
    estado = ESTADO_BORRAR_MOSTRAR;
}

void MostrarFinalPartida() {
    printf("\x1b[12;00H     FINAL PARTIDA                ");
}

void ComprobarEstadoActual(int estado) {
    switch(estado) {
        case ESTADO_INICIO:
            if(TactilTocada()) {
            }
            break;
        case ESTADO_JUGANDO:
            break;
        case ESTADO_BORRAR_MOSTRAR:
            break;
        case ESTADO_APAGADO:
            break;
        default:
            break;
    }
}
// final ESTADOS

/* FUNCIONES QUE MANEJAN EL SOBRE */
void MoverSobreDerecha() {

    
}

void MoverSobreIzquierda() {
    posicionX_sobre -= 5;
    if (posicionX_sobre <= -16) posicionX_sobre = 255;
}

void ControladorSobre() {
    MostrarSobre(posicionX_sobre, 172);
}
// final SOBRES

void MostrarPuntuacion(int recogidos, int no_recogidos) {
    if (recogidos < 10 ){
        iprintf("\x1b[10;00H    Ganados: 0%d", recogidos);
    } else {
        iprintf("\x1b[10;00H    Ganados:  %d", recogidos);
    }

    if (no_recogidos < 10 ){
        iprintf("\x1b[12;00H    Perdidos: 0%d", recogidos);
    } else {
        iprintf("\x1b[12;00H    Perdidos:  %d", recogidos);
    }    
}

