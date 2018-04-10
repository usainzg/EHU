/*-------------------------------------
 teclado.c
-------------------------------------*/

// Anadir los includes que sean necesarios
#include <nds.h>
#include <stdlib.h>
#include <stdio.h>
#include "defines.h"
#include "sprites.h"

int ComprobarTecla(int idTecla) {
    return TECLAS_DAT & (1 << idTecla);
}

// Esta funcion tiene que devolver el valor de la tecla pulsada
int  TeclaPulsada() {
   // Devuelve el valor asociado a la tecla pulsada: 
   // A=0; B=1; Select=2; Start=3; Der=4; Izq=5;
   // Arriba=6; Abajo=7; R=8; L=9;
   // -1 en otros casos
   for (int i = 0; i <= 9; i++) {
       if (!ComprobarTecla(i)) return i;
   }
   return -1;
}



// Rutina de atencion a la interrupcion del teclado
void IntTec() {
		
} 


