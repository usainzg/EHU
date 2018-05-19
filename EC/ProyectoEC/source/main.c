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

int n_segundos_partida = 0;

int dificultad_partida = DIF_BAJA; 
int flag_principal = 0;

int timerDerecha = 0;

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

void MostrarTocarTactil() {
	iprintf("\x1b[07;03H Para comenzar toque");
	iprintf("\x1b[08;04H la pantalla tactil.");
}

void MostrarMenu() {
	iprintf("\x1b[09;03H DIFICULTLAD:");
	iprintf("\x1b[10;04H Baja");
	iprintf("\x1b[11;04H Media");
	iprintf("\x1b[12;04H Alta");
}

void MostrarPantallaInit() {
	estado = ESTADO_INICIO;
	BorrarPantalla();
	MostrarTocarTactil();
	MostrarMenu();
} 

void BuclePrincipal() {
	switch(estado) {
        case ESTADO_INICIO:
            if(TactilTocada()) {
				InitPartida();
            }
			// TODO: AÑADIR DIFICULTADES
            break;
        case ESTADO_JUGANDO:
			if (tecla == DCHA) {
				if (timerDerecha >= 1000) {
					timerDerecha = 0;
					posicionX_sobre += 1;
					if(posicionX_sobre >= 256) posicionX_sobre = 0;
					flag_principal |= FLAG_ACTUALIZACION_SOBRE;
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
            // dificultades
            break;
        case ESTADO_JUGANDO:
			// actualizacion sobre
			if (flag_principal & FLAG_ACTUALIZACION_SOBRE) ControladorActualizacionSobre();

			// creacion billetes
			if (flag_principal & FLAG_CREACION_BILLETE) ControladorCreacionBilletes();

			// movimiento billetes
			if (flag_principal & FLAG_MOVIMIENTO_BILLETE) ControladorMovimientoBilletes();
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
	DesactivarFlagActualizacionSobre();

}

void ControladorCreacionBilletes() {
	CrearBillete();
	DesactivarFlagCreacionBillete();
}

void ControladorMovimientoBilletes() {
	MovimientoBilletes();
	DesactivarFlagMovimientoBillete();
}

void DesactivarFlagActualizacionSobre() {
	flag_principal &= ~FLAG_ACTUALIZACION_SOBRE;
}

void CrearBillete() {
	for(int i = 0; i < 6; i++) {
		if (billetes[i][0] == -1) {
			SetBillete(billetes[i], i);
			MostrarBillete(i, billetes[1], billetes[2]);
			break;
		}
	}
}

void SetBillete(int billete[], int i) {
	billete[0] = i;
	billete[1] = rand() % 235;
	billete[2] = 12;
	billete[3] = ((rand() % 2) == 0);
}

void MovimientoBilletes() {
	for(int i = 0; i < 6; i++) {
		if (billetes[i][0] != -1) {
			MoverBillete(billetes[i]);
			ControladorColisiones(billetes[i]);
		}
	}
}

void MoverBillete(int billete[]) {
	billete[2] += 1;
}

void ControladorColisiones(int billete[]) {
	if (EstaBilleteCerca(billete[2])) {
		if(HayColisionConSobre(billete[1])) {
			if (EsBilleteNormal(billete[3])) {
				BorrarBillete(billete[0], billete[1], billete[2]);
				BilletePorDefecto(billete);
				billetes_recogidos += 1;
				MostrarPuntuacion(billetes_recogidos, billetes_no_recogidos);
			} else {
				AcabarPartida();
			}
		} else if (EstaPerdidoBillete(billete[2])) {
			BorrarBillete(billete[0], billete[1], billete[2]);
			BilletePorDefecto(billete);
			billetes_no_recogidos += 1;
			MostrarPuntuacion(billetes_recogidos, billetes_no_recogidos);
		}
		MostrarBillete(billete[0], billete[1], billete[2]);
	}
}

int EstaBilleteCerca(int posBillete) {
	return posBillete + 8 >= POSICION_Y_SOBRE;
}

int HayColisionConSobre(int posBillete) {
	return ((posBillete + 16 >= posicionX_sobre) && (posBillete < posicionX_sobre + 16));
}

int EsBilleteNormal(int tipoBillete) {
	return tipoBillete == 0;
}

int EstaPerdidoBillete(int posBillete) {
	return posBillete >= 191;
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
	EscogerDificultad();
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
	ResetBilletes();
	ResetSobre();
	MostrarBorrarMostrar();
	estado = ESTADO_BORRAR_MOSTRAR;
}

void ResetBilletes() {
	for(int i = 0; i < 10; i++) {
		BorrarBillete(billetes[i][0], billetes[i][1], billetes[i][2]);
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




