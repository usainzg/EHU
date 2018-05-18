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
#include "auxiliares.h"

// Variables
int tecla = -1;
int v_billete = 4; // depende la dificultad, esta valor puede variar 3, 4 o 5

int posicionX_sobre = 128;
int posicionY_sobre = 172;

int billetes_recogidos = 0;
int billetes_no_recogidos = 0;

int timer = 0;

int dificultad_partida = 0; 
// final

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
	}

} //final

// ---- FUNCIONES ----
void SetupEntornoJuego() {
    
}

// Procedimiento que pone a punto el entorno
void Setup() {
	HabilitarGraficos();
	Interrupciones();
	MostrarMensajeBienvenida();
} // final

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
} // final

// Procedimientos para mensajes y menus
void MostrarMensajeBienvenida() {
    iprintf("\x1b[02;00H  +--------------------------+  ");
    iprintf("\x1b[03;00H  : EC 17/18           G13   :  ");
    iprintf("\x1b[04;00H  +--------------------------+  ");
}

void MostrarTocarTactil() {
	printf("\x1b[07;03   Para comenzar toque");
	printf("\x1b[08;04   la pantalla tactil.");
}

void MostrarMenu() {
	printf("\x1b[09;03   DIFICULTLAD:        ");
	printf("\x1b[10;04   Baja");
	printf("\x1b[11;04   Media");
	printf("\x1b[12;04   Alta");
}

void MostrarPantallaInit() {
	estado = ESTADO_INICIO;
	BorrarPantalla();
	MostrarTocarTactil();
	MostrarMenu();
} // final


void InitPartida() {
	billetes_recogidos = 0;
	billetes_no_recogidos = 0;
	flag_principal = 0;
	BorrarPantalla();
	MostrarPuntuacion(billetes_recogidos, billetes_no_recogidos);
	posicionX_sobre = 128;
	ControladorSobre();
	estado = ESTADO_JUGANDO;


}

void EscogerDificultad() {
	switch(dificultad_partida) {
		case DIF_BAJA:
			v_billete = 3;
			break;
		case DIF_MEDIA:
			v_billete = 4;
			break;
		case DIF_ALTA:
			v_billete = 5;
			break;
		default:
			break;
	}
}
void AcabarPartida() {

}

// Esta funcion consulta si se ha tocado la pantalla tactil
int TactilTocada() {
	touchPosition pos_pantalla;
	touchRead(&pos_pantalla);
  	return !(pos_pantalla.px == 0 && pos_pantalla.py == 0);
} // final




