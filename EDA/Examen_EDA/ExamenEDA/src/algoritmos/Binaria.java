package algoritmos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Binaria {
	
	public static int binarySearch(int[] tabla, int target) {
		return binarySearch(0, tabla.length - 1, tabla, target);
	}
	
	private static int binarySearch(int i, int f, int[] tabla, int target) {
		if(i > f) return -1;
		
		int mitad = (f + i) / 2;
		if(tabla[mitad] == target) {
			return mitad;
		} 
		
		if(tabla[mitad] > target) {
			return binarySearch(0, mitad - 1, tabla, target);
		} 
		
		return binarySearch(mitad + 1, f, tabla, target);
	}
	
	
	
	public static void main(String[] args) {
		final int NUM = 10; // elemento que se desea buscar
		try {
			Scanner input = new Scanner(new File(
					"src/algoritmos/datos4ordenado.txt"));
			int n = input.nextInt(); // número de elementos del array V int[]
			int[] V = new int[n];
			for (int i = 0; i < V.length; i++) {
				V[i] = input.nextInt();
			}
			input.close();

			int index = binarySearch(V, NUM);

			if (index > 0) {
				System.out.println(NUM + " está en el índice " + index);
			} else {
				System.out.println(NUM + "no está");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
