package algoritmos;

public class Insercion {
	
	private static void insertaEnOrden(int[] A, int k) {
		int last = A[k];
		int pivote = k - 1;
		
		while(pivote >= 0 && last < A[pivote]) {
			A[pivote + 1] = A[pivote];
			pivote--;
		}
		A[pivote + 1] = last;
	}
	
	private static void ordenaInsercion(int[] A) {
		for(int i = 1; i < A.length; i++) {
			insertaEnOrden(A, i);
		}
	}

}
