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

static int posX_billete_1 = 0;
static int posX_billete_2 = 0;
static int posX_billete_3 = 0;

double posX_sobre = POS_X_SOBRE_INICIAL;
double posY_sobre = POS_Y_SOBRE_INICIAL;

void SetupVariables() {
}

void SetupEntornoJuego() {
    SetupVariables();
}

void MoverBillete(int posX, int posY) {
    MostrarBillete(1, posX_billete_1, posY);
    MostrarBillete(2, posX_billete_2, posY);
}

void MostrarTiempoRestante(int segundosTranscurridos) {
    int tiempo = TIEMPO_PARTIDA - segundosTranscurridos;
    if(tiempo < 10) {
        printf("\x1b[12;00H     TIEMPO:    0%d", tiempo);
    } else {
        printf("\x1b[12;00H     TIEMPO:    %d", tiempo);
    }
    
}

void MostrarFinalPartida() {
    printf("\x1b[12;00H     FINAL PARTIDA   ");
}

void MostrarPuntuacion() {
    printf("\x1b[14;00H     PUNTUACION:    ");
}

void PasarAJugando() {
	iprintf("\x1b[05;00H     PANTALLA TOCADA            ");
	iprintf("\x1b[07;00H                                ");
	estado = ESTADO_JUGANDO;
}

void PasarAMostrarBorrar() {
    iprintf("\x1b[05;00H       PUNTUACION JUEGO         ");
	iprintf("\x1b[07;00H -----------------------------  ");
    estado = ESTADO_BORRAR_MOSTRAR;
}

void EncargadoTiempo(int segundos) {
    if(TIEMPO_PARTIDA <= segundos) {
        MostrarFinalPartida();
        PasarAMostrarBorrar();
    } else {
        MostrarTiempoRestante(segundos);
    }
}

void MoverSobreDerecha() {
    if(posX_sobre < 240) posX_sobre += 0.0005;
}

void MoverSobreIzquierda() {

}

void ControladorSobre() {
    MostrarSobre(posX_sobre, posY_sobre);
}

void ComprobarEstadoActual(int segundos) {

    switch(estado) {
        case ESTADO_INICIO:
            PasarAJugando();
            break;
        case ESTADO_JUGANDO:
            EncargadoTiempo(segundos);
            break;
        case ESTADO_BORRAR_MOSTRAR:
            MostrarPuntuacion();
            break;
        case ESTADO_APAGADO:

            break;
        default:
            break;
    }

}

void BucleJuego(int segundos) {
    ComprobarEstadoActual(segundos);
    EncargadoTiempo(segundos);
}

