package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class OrdenaPorInsercion {

	/*
	 * PRECONDICIÓN: El segmento de array A[0...k-1] está ordenado.
	 * 1<=k<=A.length-1 POSTCONDICIÓN: El segmento de array A[0...k] está
	 * ordenado, incluyendo los elementos que al inicio estaban en A[0...k].
	 */
	private static void insertaEnOrden(int[] A, int k) {
		// HACER
		int last = A[k];
		int index = k - 1;
		while((index >= 0) && A[index] > last) {
			A[index + 1] = A[index];
			index--;
		}
		A[index + 1] = last;
	}

	/*
	 * Ordena el array A[0...A.length-1] de menor a mayor valor, usando el
	 * método insertaEnOrden.
	 */
	public static void OrdenPorInsercion(int[] A) {
		// HACER
		for(int j = 1; j < A.length; j++) {
			insertaEnOrden(A, j);
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
			Scanner input = new Scanner(new File("src/sorting/datos4.txt"));
			int n = input.nextInt(); // número de elementos del array V int[]
			int[] V = new int[n];
			for (int i = 0; i < V.length; i++) {
				V[i] = input.nextInt();
			}
			input.close();

			shuffleArray(V);

			OrdenPorInsercion(V);

			PrintWriter output = new PrintWriter(new File(
					"src/sorting/datos4ordenado.txt"));
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
