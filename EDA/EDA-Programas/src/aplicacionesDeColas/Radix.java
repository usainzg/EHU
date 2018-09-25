package aplicacionesDeColas;

import ehu.eda.list.linkedImp.QueueOfT;

public class Radix {
	
	public static QueueOfT<Integer> radixSort(int entrada, int[] numeros) {
		QueueOfT<Integer> colaReturn = new QueueOfT<>();
		QueueOfT<Integer>[] colas = (QueueOfT<Integer>[]) new QueueOfT[10];
		for(int i = 0; i < 10; i++) {
			colas[i] = new QueueOfT<>();
		}
		for(int exp = 0; exp < entrada; exp++) {
			
			for(int i = 0; i < numeros.length; i++) {
				int digito = devuelveDigito(numeros[i], exp);
				colas[digito].enqueue(numeros[i]);
			}
		}
		for(int i = 0; i < colas.length; i++) {
			while(colas[i].size() > 0) {
				colaReturn.enqueue(colas[i].dequeue());
			}
		}
		return colaReturn;
	}
	
	private static int devuelveDigito(int numero, int exp) {
		int div = 10^exp;
		return ((numero/div) % 10);
	}
}
