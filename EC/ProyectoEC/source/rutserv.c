/*-------------------------------------
 rutserv.c
-------------------------------------*/
// Anadir los includes que sean necesarios
#include <stdio.h>
#include "teclado.h"
#include "defines.h"
#include "temporizadores.h"
#include "nds.h"

// Este procedimiento inicializa la tabla de interrupciones para que el gestor de interrupciones sepa
// que rutina de atencion tiene que ejecutar cuando le llega una peticion de interrupcion. 
// Ademas es aqui donde se configuran los registros de control de los perifericos.


void HabilitarInterrupciones() { // En el Controlador de Interrupciones
  //Primero se inhiben todas las interrupciones
  IME = 0;
  
  //Escribir un 1 en el bit correspondiente 
  IE = IE | 0x8;
  IE = IE | 0x1000;
  
  //Se vuelven a habilitar todas las interrupciones
  IME = 1;
}


void ProgramarRegistrosControl() { 
  //Registro de Control del Teclado
  
  //Registro de Control de los Temporizadores
  // TIMER0_CNT   
  //   El temporizador se activa poniendo un 1 en el bit 7.
  //   El temporizador interrumpira al desbordarse el contador, 
  //      si hay un 1 en el bit 6.
  //   Los dos bits de menos peso indican lo siguiente:
  //      00 frecuencia 33554432 hz
  //      01 frecuencia 33554432/64 hz
  //      10 frecuencia 33554432/256 hz
  //      11 frecuencia 33554432/1024 hz
  // TIMER0_DAT 
  //   Se utiliza para indicar a partir de que valor tiene que empezar a contar (latch)
  TECLAS_CNT = 0x4026;
}


void DefinirVectorInterrupciones() { // Rutinas de atencion
  //Rutina de Atencion al Teclado
  irqSet(IRQ_KEYS, IntTec);

  //Rutinas de Atencion a los Temporizadores
}


void InhibirInterrupciones() { // En el Controlador de Interrupciones
  //Primero se inhiben todas las interrupciones
  IME = 0;
  
  //Escribir un 0 en el bit correspondiente 
  IE &= 0xCFF7;

  //Se vuelven a habilitar todas las interrupciones
  IME = 1;
}


void Interrupciones() {
  HabilitarInterrupciones();
  ProgramarRegistrosControl();
  DefinirVectorInterrupciones();
}



