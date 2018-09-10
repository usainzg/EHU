package problema01;

import utilidades.Temporizador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IndiceMenor {
    public static void main(String [] args) {

        Temporizador temporizador = new Temporizador();

        try {
            Scanner input = new Scanner(new File("src/buscaPares/datosOrd5.txt"));
            int n = input.nextInt();
            int[] V = new int[n];
            for (int i = 0; i < V.length; i++) {
                V[i] = input.nextInt();
            }
            input.close();

            temporizador.startTimer();
            int indiceMenor = DevuelveIndiceMenorDeArray(V);
            temporizador.stopTimer();

            temporizador.showTime();

            System.out.println("El indice del menor dentro del array es: " + indiceMenor);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static int DevuelveIndiceMenorDeArray(int[] arr) {
        int indice = -1;
        if (arr.length > 0) indice = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[indice]) indice = i;
        }

        return indice;
    }

    private static int[] AlgoritmoOrdenacionPropuesto(int[] arr, int indiceMinimo) {
        int arrLength = arr.length;
        int temp = arr[0];
        arr[0] = arr[indiceMinimo];
        arr[indiceMinimo] = temp;

        return arr;
    }
}
