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
int v_billete = 3;

int posicionX_sobre = 128;
int posicionY_sobre = POSICION_Y_SOBRE;

int billetes_recogidos = 0;
int billetes_no_recogidos = 0;

int n_segundos_partida = 0;

int dificultad_partida = DIF_JUEGO; 
int flag_principal = 0;

int timerDerecha = 0;

int sprite_principal = 0;

/*
	Estructura del billete (se podia haber hecho una struct)
	[][0] -> indice (numero billete)
	[][1] -> x (posicion x)
	[][2] -> y (posicion y)
	[][3] -> si es bueno o malo (0 para bueno, 1 para malo)
*/
int billetes[6][4] = {
	{ -1, -1, -1, -1 },
	{ -1, -1, -1, -1 },
	{ -1, -1, -1, -1 },
	{ -1, -1, -1, -1 },
	{ -1, -1, -1, -1 },
	{ -1, -1, -1, -1 }
};
// final

//---------------------------------------------------
// main
//---------------------------------------------------
int estado = ESTADO_INICIO;
int main() {

	Setup();
	MostrarPantallaInit();

    while(estado != ESTADO_APAGADO) {
		tecla = TeclaPulsada(TIPO_ENCUESTA);
		BuclePrincipal();
    } // while

} //final

// ---- FUNCIONES ----

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

void MostrarMenu() {
	iprintf("\x1b[09;03H Para comenzar a jugar,");
	iprintf("\x1b[11;03H pulse la pantalla tactil");
}

void MostrarPantallaInit() {
	estado = ESTADO_INICIO;
	BorrarPantalla();
	MostrarMenu();
} 

void BuclePrincipal() {
	switch(estado) {
        case ESTADO_INICIO:
            if(TactilTocada()) {
				InitPartida();
            }
            break;
        case ESTADO_JUGANDO:
			if (tecla == DCHA) {
				if (timerDerecha >= 256) {
					timerDerecha = 0;
					posicionX_sobre += 1;
					if(posicionX_sobre >= 256) posicionX_sobre = 0;
				} else {
					timerDerecha += 1;
				}
			}
            break;
        case ESTADO_BORRAR_MOSTRAR:
			if (tecla == START) InitPartida();
            break;
        case ESTADO_APAGADO:
            break;
        default:
            break;
    }
	ActualizarFlagPrincipal();
}
// final

void ActualizarFlagPrincipal() {
	switch(estado) {
		case ESTADO_INICIO:
            break;
        case ESTADO_JUGANDO:
			/* ACTUALIZACION DEL SOBRE */
            ControladorActualizacionSobre();

			/* CREACION DEL BILLETE */
            if (flag_principal & FLAG_CREACION_BILLETE){
                ControladorCreacionBilletes();
            }
			/* MOVIMIENTO DEL BILLETE */
            if (flag_principal & FLAG_MOVIMIENTO_BILLETE){
                ControladorMovimientoBilletes();
            }
            break;
        case ESTADO_BORRAR_MOSTRAR:
            break;
        case ESTADO_APAGADO:
            break;
        default:
            break;
	}
}

void ControladorActualizacionSobre() {
	ControladorSobre();
}

void ControladorCreacionBilletes() {
	CrearBillete();
	DesactivarFlagCreacionBillete();
}

void ControladorMovimientoBilletes() {
	MovimientoBilletes();
	DesactivarFlagMovimientoBillete();
}

void CrearBillete() {
	for(int i = 0; i<10;i++){
		if (billetes[i][0] == -1){
			SetBillete(billetes[i], i);
			MostrarBillete(billetes[0], billetes[1], billetes[2], billetes[3]);
			break;
		}
	}
}

void SetBillete(int billete[], int i) {
	billete[0] = i;
	billete[1] = rand() % 235;
	billete[2] = 16;
	billete[3] = ((rand() % 5) == 1);
}

void MovimientoBilletes() {
	for(int i = 0; i < 6; i++){
		if (billetes[i][0] != -1) { // billetes ya seteado
			billetes[i][2] += 1; // mover billete
			if (EstaBilleteCerca(billetes[i][2])){
				if (HayColisionConSobre(billetes[i][1])){
					if(EsBilleteNormal(billetes[i][3])){
						BorrarBillete(billetes[0], billetes[1], billetes[2], billetes[3]);
						BilletePorDefecto(billetes[i]);
						billetes_recogidos++;
						MostrarPuntuacion(billetes_recogidos, billetes_no_recogidos);
						if(billetes_recogidos == 1){
							CambiarSprite();
						}
					} else {
						AcabarPartida();
					}
				} else if (EsNoRecogidoBillete(billetes[i][2])) {
					BorrarBillete(billetes[0], billetes[1], billetes[2], billetes[3]);
					BilletePorDefecto(billetes[i]);
					billetes_no_recogidos++;
					MostrarPuntuacion(billetes_recogidos, billetes_no_recogidos);
				}
			}
			MostrarBillete(billetes[i][0], billetes[i][1], billetes[i][2], billetes[i][3]);
		}
	}
}

void CambiarSprite() {
	if (sprite_principal == 0) sprite_principal = 1;
}

int EstaBilleteCerca(int posBillete) {
	if (posBillete + 8 > POSICION_Y_SOBRE) return 1;
	return 0;
}

int HayColisionConSobre(int posBillete) {
	if(posBillete + 16 > posicionX_sobre && posBillete < posicionX_sobre + 16) return 1; // por ser sprite 16x16
	return 0;
}

int EsBilleteNormal(int tipoBillete) {
	if(tipoBillete == 0) return 1;
	return 0;
}

int EsNoRecogidoBillete(int posBillete) {
	if(posBillete >= 180) return 1;
	return 0;
}

void DesactivarFlagCreacionBillete() {
	flag_principal &= ~FLAG_CREACION_BILLETE;
}

void DesactivarFlagMovimientoBillete() {
	flag_principal &= ~FLAG_MOVIMIENTO_BILLETE;
}


void InitPartida() {
	billetes_recogidos = 0;
	billetes_no_recogidos = 0;
	flag_principal = 0;
	segundos_restantes = 30;
	BorrarPantalla();
	MostrarPuntuacion(billetes_recogidos, billetes_no_recogidos);
	MostrarEstructuraDatos();
	MostrarTiempoRestante(segundos_restantes); 
	posicionX_sobre = 128;
	ControladorSobre();
	estado = ESTADO_JUGANDO;
	dificultad_partida = DIF_JUEGO;
	v_billete = 3;
	sprite_principal = 0;
}

void AcabarPartida() {
	ResetBilletes();
	ResetSobre();
	MostrarBorrarMostrar();
	estado = ESTADO_BORRAR_MOSTRAR;
}

void ResetBilletes() {
	for(int i = 0; i < 10; i++) {
		BorrarBillete(billetes[i][0], billetes[i][1], billetes[i][2], billetes[i][3]);
		BilletePorDefecto(billetes[i]);
	}
}

void BilletePorDefecto(int billete[]) {
	billete[0] = -1;
	billete[1] = -1;
	billete[2] = -1;
}

void ResetSobre() {
	BorrarSobre(posicionX_sobre, 172);
}

void MostrarBorrarMostrar() {
	iprintf("\x1b[12;00H Pulse <Start> para reiniciar juego");
	iprintf("\x1b[13;00H Pulse <Select> para apagar");
}

void MostrarEstructuraDatos() {
	iprintf("\x1b[10;00H Ganados: ");
	iprintf("\x1b[11;00H Perdidos: ");
	iprintf("\x1b[12;00H Tiempo: ");
}

// Esta funcion consulta si se ha tocado la pantalla tactil
int TactilTocada() {
	touchPosition pos_pantalla;
	touchRead(&pos_pantalla);
  	return !(pos_pantalla.px == 0 && pos_pantalla.py == 0);
} // final




