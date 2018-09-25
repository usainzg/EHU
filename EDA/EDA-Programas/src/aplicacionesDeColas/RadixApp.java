package aplicacionesDeColas;

import ehu.eda.list.linkedImp.QueueOfT;

public class RadixApp {

	public static void main(String[] args) {
		
		int[] numeros = { 1, 2, 4, 9, 10, 112, 100 };
		QueueOfT<Integer> sorted = Radix.radixSort(3, numeros);
		while(!sorted.isEmpty()) {
			System.out.println(sorted.dequeue());
		}

	}

}
