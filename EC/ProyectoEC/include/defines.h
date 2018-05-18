/*-------------------------------------
defines.h
-------------------------------------*/

#include <nds.h>
#include <stdio.h>

// Aqui se definen los registros del gestor de interrupciones
#define IME		(*(vuint16*)0x04000208) //Interrupt Master Enable - Habilita o deshabilita todas las interrupciones
#define IE		(*(vuint32*)0x04000210) //Interrupt Enable - Activa o desactiva las interrupciones una a una
#define IF		(*(vuint32*)0x04000214) //Interrupt Flag - Guarda las peticiones de interrupcion

// Aqui se definen algunas funciones para el tratamiento de las interrupciones
#define EnableInts() 	IME=1 //Habilita todas las interrupciones
#define DisableInts() 	IME=0 //Deshabilita todas las interrupciones

// Aqui se definen los registros del teclado 
#define TECLAS_DAT	(*(vuint16*)0x4000130) //Registro de datos del teclado
#define TECLAS_CNT	(*(vuint16*)0x4000132) //Registro de control del teclado

// Aqui se definen los registros del temporizador
#define TIMER0_CNT   	(*(vuint16*)0x04000102) //Registro de control del temporizador
// El temporizador se activa poniendo un 1 en el bit 7.
// El temporizador interrumpira al desbordarse el contador, si hay un 1 en el bit 6.
// Los dos bits de menos peso indican lo siguiente:
//		00 frecuencia 33554432 hz
//		01 frecuencia 33554432/64 hz
//		10 frecuencia 33554432/256 hz
//		11 frecuencia 33554432/1024 hz

#define TIMER0_DAT    (*(vuint16*)0x04000100) //Registro de datos del temporizador
// Se utiliza para indicar a partir de que valor tiene que empezar a contar


// Esta funcion consulta si se ha tocado la pantalla tactil
extern int TactilTocada();

// Para no liarse con los numeros a cada teclas se le ha asignado un nombre
#define A		0 
#define B		1
#define SELECT	2 
#define START	3
#define DCHA	4 
#define IZDA	5
#define ARRIBA	6 
#define ABAJO	7
#define R		8 
#define L		9

// Asignar un nombre a cada estado
#define ESTADO_INICIO	0
#define ESTADO_JUGANDO 1
#define ESTADO_BORRAR_MOSTRAR 2
#define ESTADO_APAGADO 3

// TIPOS TECLA
#define TIPO_ENCUESTA 0
#define TIPO_INTERRUPT 1

// DIFICULTADES
#define DIF_ALTA 3
#define DIF_MEDIA 2
#define DIF_BAJA 1

// VARIABLES JUEGO
#define BILLETE_MAX 4
#define TIEMPO_PARTIDA 20
#define POSICION_Y_SOBRE 172;
#define MAX_PUNTOS 15 

// FLAGS ACTIVACION
#define FLAG_ACTUALIZACION_SOBRE 0x1
#define FLAG_SOBRE 0x2
#define FLAG_CREACION_BILLETE 0x4
#define FLAG_MOVIMIENTO_BILLETE 0x8
#define FLAG_PANTALLA 0x16

// Variables
extern int estado;
extern int v_billete;
extern int puntos;
extern int posicionX_sobre;
extern int flag_principal;


