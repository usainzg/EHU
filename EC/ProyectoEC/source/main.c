/*---------------------------------------------------
Este codigo se ha implementado basandose en el ejemplo "Simple sprite demo" de 
dovoto y otro de Jaeden Amero
---------------------------------------------------*/

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
#include "juego.h"

// Procedimiento habilita entorno grafico
void HabilitarGraficos() {
	/* Definir variables */	
	touchPosition pos_pantalla;

	/* Poner en marcha el motor grafico 2D. */
    powerOn(POWER_ALL_2D);

	/* Establecer la pantalla inferior como principal, inicializar el sistema grafico
       y configurar el sistema de fondos. */
    lcdMainOnBottom();
    initVideo();
    initFondos();

    /* Mostrar fondos en pantalla. */
    SetFondo();
	//mostrarFondoSub();

	/* Inicializar memoria de sprites y guardar en ella los sprites */
	initSpriteMem();
	guardarSpritesEnMemoria();

	/* Establecer las paletas para los sprites */
	establecerPaletaPrincipal();
	establecerPaletaSecundaria();

	/* Inicializa la consola (superior) de texto. 
	   Nota.- Para borrar la pantalla existe la funcion consoleClear() */
	consoleDemoInit();

    /* Para inicializar el generador de numeros aleatorios en funcion de una semilla,
	   en este caso time(NULL). srand() solo se suele activar una vez por ejecucion y
	   no devuelve ningun valor. 
	   La funcion para generar valores aleatorios en el resto del programa es rand() */
	srand (time(NULL));	
}

// Procedimiento para imprimir bienvenida
void MostrarMensajeBienvenida() {
    iprintf("\x1b[02;00H  +--------------------------+  ");
    iprintf("\x1b[03;00H  : EC 17/18           G13   :  ");
    iprintf("\x1b[04;00H  +--------------------------+  ");
	iprintf("\x1b[05;00H     Para comenzar,   toque     ");
	iprintf("\x1b[07;00H      la pantalla taactil.      ");
}

// Esta funcion consulta si se ha tocado la pantalla tactil
int TactilTocada() {
	touchPosition pos_pantalla;
	touchRead(&pos_pantalla);
  	return !(pos_pantalla.px == 0 && pos_pantalla.py == 0);
}

void Setup() {
	HabilitarGraficos();
	Interrupciones();
	MostrarMensajeBienvenida();
}

//---------------------------------------------------
// main
//---------------------------------------------------
int estado = ESTADO_INICIO;
int main() {

	Setup();

    while(estado == ESTADO_INICIO) {
		estado = TactilTocada();
    } // while
	
	while(1) {
		int tecla = TeclaPulsada(TIPO_ENCUESTA);
		if(tecla == 4) {
			MoverSobreDerecha();
		}
	}

} //main


