/*-------------------------------------
 temporizadores.c
-------------------------------------*/
// Anadir los includes que sean necesarios
#include "defines.h"
#include "sprites.h"
#include <nds.h>
#include <stdio.h>
#include "juego.h"

int t = 0;
int n_segundos = 0;

int t_billete = 0; 

// Rutina de atencion a la interrupcion del temporizador
void IntTemp() {
    ControladorTimer();
}

void ControladorTimer() {
    switch(estado) {
        case ESTADO_INICIO:
            break;
        case ESTADO_JUGANDO:
            t++;
            TimerJuego();
            MostrarTiempoRestante(n_segundos);
            if (EsFinPartida()) {
                AcabarPartida();
            }
            ControladorBillete();
            break;
        case ESTADO_BORRAR_MOSTRAR:
        case ESTADO_APAGADO:
        default:
            break;
    }
}

void TimerJuego() {
    if (t >= 512 && estado == ESTADO_JUGANDO) {
        n_segundos++;
        t_billete++;
        t = 0;
    }
}

void MostrarTiempoRestante(int segundosTranscurridos) {
    int tiempo = TIEMPO_PARTIDA - segundosTranscurridos;
    if(tiempo < 10) {
        printf("\x1b[12;00H     TIEMPO:    0%d", tiempo);
    } else {
        printf("\x1b[12;00H     TIEMPO:    %d", tiempo);
    }
}

int EsFinPartida() {
    int tiempo = TIEMPO_PARTIDA - n_segundos;
    if (tiempo <= 0) return 1;
    return 0;
}

void ControladorBillete() {
    if (t_billete >= 1) {
        flag_principal |= 0x4;
        t_billete = 0;
    }

    if (t % v_billete == 0) {
        flag_principal |= 0x8;
    }
}





