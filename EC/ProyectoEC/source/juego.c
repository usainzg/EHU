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

void SetupVariables() {
    posX_billete_1 = rand() % 250;
    posX_billete_2 = rand() % 250;
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

void EncargadoTiempo(int segundos) {
    if(TIEMPO_PARTIDA <= segundos) {
        estado = ESTADO_BORRAR_MOSTRAR;
        MostrarFinalPartida();
    } else {
        MostrarTiempoRestante(segundos);
    }
}

void ComprobarEstadoActual(int segundos) {

    switch(estado) {
        case ESTADO_INICIO:
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

void BucleJuego(int segundos) {
    ComprobarEstadoActual(segundos);
    EncargadoTiempo(segundos);
}

