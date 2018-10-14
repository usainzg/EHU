package ex;

import java.util.Iterator;

import ehu.eda.list.linkedImp.QueueOfT;

public class OficinaVirtual {
	private QueueOfT<Integer> cola;
	private int pos;
	private int prior;
	
	public OficinaVirtual(int[] solicitudes, int pos, int prior) {
		cola = new QueueOfT<>();
		for(int i = 0; i < solicitudes.length; i++) {
			cola.enqueue(solicitudes[i]);
		}
		this.pos = pos;
		this.prior = prior;
	}
	
	private boolean hayMasPrioridad(int prior) {
		Iterator<Integer> it = cola.queueIterator();
		while(it.hasNext()) {
			if(it.next() > prior) {
				return true;
			}
		}
		return false;
	}
	
	public int atendidasAntesQue(int pos, int prior) {
		int primera = 0;
		int contador = 0;
		
		while (hayMasPrioridad(prior)) {
			primera = cola.dequeue();
			if (pos == 1) {
				pos = cola.size() + 1;
			} else {
				pos--;
			}
			
			if (hayMasPrioridad(primera)) {
				cola.enqueue(primera);
			} else {
				contador++;
			}
		}
		
		while (pos > 1) {
			primera = cola.dequeue();
			pos--;
			if (hayMasPrioridad(primera)) {
				cola.enqueue(primera);
			} else {
				contador++;
			}
		}
		return contador;
	}
	
	
}
