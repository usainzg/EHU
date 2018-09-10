package sorting;

import utilidades.Temporizador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class OrdenaPorSeleccion {

	/*
	 * Devuelve un índice m del array A, 0<=desde<= m <= hasta<A.length, tal que
	 * A[m] es el valor mínimo del segmento de array A[desde...hasta]
	 */
	private static int indiceMin(int[] A, int desde, int hasta) {
		int indice = desde;

		for (int i = desde + 1; i < hasta; i++) {
			if (A[i] < A[indice]) indice = i;
		}

		return indice;
	}

	/*
	 * Ordena el array A[0...A.length-1] de menor a mayor valor, usando el método
	 * indiceMin.
	 */
	private static void OrdenPorSeleccion(int[] A) {

	    for (int i = 0; i < A.length - 1; i++) {
            int indiceMenor = indiceMin(A, i, A.length);
            int temp =  A[i];
            A[i] = A[indiceMenor];
            A[indiceMenor] = temp;
        }
	}

	private static void shuffleArray(int[] array) {
		int index, temp;
		Random random = new Random();
		for (int i = array.length - 1; i > 0; i--) {
			index = random.nextInt(i + 1);
			temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
	}

	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(new File("src/sorting/datosOrd9.txt"));
			int n = input.nextInt(); // número de elementos del array V int[]
			int[] V = new int[n];
			for (int i = 0; i < V.length; i++) {
				V[i] = input.nextInt();
			}
			input.close();

			shuffleArray(V);

			int index = indiceMin(V, 0, V.length);

			System.out.println("Indice: " + index);

            Temporizador temporizador = new Temporizador();
            temporizador.startTimer();

			OrdenPorSeleccion(V);

			temporizador.stopTimer();
			temporizador.showTime();

			PrintWriter output = new PrintWriter(new File("src/sorting/datos4ordenado.txt"));
			output.println(V.length);
			// El primer número es el número de datos a considerar
			for (int i = 0; i < V.length; i++) {
				output.println(V[i]);
			}
			output.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}