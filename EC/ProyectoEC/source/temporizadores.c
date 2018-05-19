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
int segundos_restantes = 0;

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
            MostrarTiempoRestante(segundos_restantes);
            if (EsFinPartida()) {
                AcabarPartida(n_segundos);
            }
            ControladorBillete();
            ControladorTiempo();
            break;
        case ESTADO_BORRAR_MOSTRAR:
        case ESTADO_APAGADO:
        default:
            break;
    }
}

void TimerJuego() {
    if (t >= 512 && estado == ESTADO_JUGANDO) {
        segundos_restantes -= 1;
        MostrarTiempoRestante(segundos_restantes);
        t_billete += 1;
        t = 0;
    }
}

void MostrarTiempoRestante(int segundos_restantes) {
    iprintf("\x1b[12;10H %d", segundos_restantes);
}

int EsFinPartida() {
    if (segundos_restantes <= 0) return 1;
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

void ControladorTiempo() {
    n_segundos_partida -= 1;
    if (n_segundos_partida == 0) AcabarPartida();
}





