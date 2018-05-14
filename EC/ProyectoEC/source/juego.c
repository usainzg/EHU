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

