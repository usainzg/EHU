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

int puntos = 0;

/* FUNCIONES SOBRE PUNTOS PARTIDA */
void SumarPunto() {
    puntos += 1;
}

void RestarPunto() {
    puntos -= 1;
}

bool MaxPuntosAlcanzado() {
    return (puntos >= MAX_PUNTOS);
}

void MostrarPuntuacion() {
    if (puntos < 10) {
        printf("\x1b[14;00H     PUNTUACION:    0%d", puntos);
    } else {
        printf("\x1b[14;00H     PUNTUACION:    %d", puntos);
    }
    
}
// final PUNTOS

/* FUNCIONES SOBRE CAMBIO DE ESTADO */
void BorrarMensajeBienvenida() {
    iprintf("\x1b[02;00H  +--------------------------+  ");
    iprintf("\x1b[03;00H  : EC 17/18           G13   :  ");
    iprintf("\x1b[04;00H  +--------------------------+  ");
	iprintf("\x1b[05;00H                                 ");
	iprintf("\x1b[07;00H                                 ");   
}

void PasarAJugando() {
	BorrarMensajeBienvenida();
    puntos = 0;
	estado = ESTADO_JUGANDO;
}

void PasarAMostrarBorrar() {
    iprintf("\x1b[05;00H       PUNTUACION JUEGO         ");
	iprintf("\x1b[07;00H -----------------------------  ");
    estado = ESTADO_BORRAR_MOSTRAR;
}

void MostrarFinalPartida() {
    printf("\x1b[12;00H     FINAL PARTIDA                ");
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
    if(posX_sobre < 240 && estado == ESTADO_JUGANDO) posX_sobre += 0.5;
}

void MoverSobreIzquierda() {
    if(posX_sobre >= 15 && estado == ESTADO_JUGANDO) posX_sobre -= 8;
}

void ControladorSobre() {
    MostrarSobre(posX_sobre, posY_sobre);
}
// final SOBRES

void MoverBillete(int posX, int posY) {
    MostrarBillete(1, posX_billete_1, posY);
    MostrarBillete(2, posX_billete_2, posY);
}

/* FUNCIONES CONTROLADORES DE LOS TIEMPOS */
void MostrarTiempoRestante(int segundosTranscurridos) {
    int tiempo = TIEMPO_PARTIDA - segundosTranscurridos;
    if(tiempo < 10) {
        printf("\x1b[12;00H     TIEMPO:    0%d", tiempo);
    } else {
        printf("\x1b[12;00H     TIEMPO:    %d", tiempo);
    }
}

void EncargadoTiempo(int segundos) {
    if(TIEMPO_PARTIDA <= segundos) {
        MostrarFinalPartida();
        PasarAMostrarBorrar();
    } else {
        MostrarTiempoRestante(segundos);
    }
}
// final TIEMPOS

/* FUNCION CONTROLADORA DEL JUEGO */
void BucleJuego(int segundos) {
    ComprobarEstadoActual(segundos);
    EncargadoTiempo(segundos);
    MostrarPuntuacion();
}
// final BUCLE PRINCIPAL

