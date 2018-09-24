package aplicacionesDePilas;

import ehu.eda.list.linkedImp.StackOfT;

public class PilaDeCajas {

	private StackOfT<Caja> pila;

	public PilaDeCajas() {
		pila = new StackOfT<>();
	}

	public StackOfT<Caja> getPila() {
		return this.pila;
	}

	/**
	 * Esta operacion tiene O(n), dado que como mucho va a 
	 * tener que recorrer la pila entera para añadir
	 * la caja que pasamos por parametro.
	 */
	public void addCaja(int id, int talla) {
		boolean added = false;
		Caja c = new Caja(id, talla);

		StackOfT<Caja> newPila = new StackOfT<>();
	
		if (pila.isEmpty()) {
			newPila.push(c);
		} else {
			while (!pila.isEmpty()) {
				Caja cAux = pila.pop();
				if (cAux.talla == c.talla) {
					newPila.push(c);
					added = true;
				}
				newPila.push(cAux);
			}
			if (!added) newPila.push(c);
		}

		while (!newPila.isEmpty()) {
			Caja cAux = newPila.pop();
			pila.push(cAux);
		}
	}

	/**
	 * O(1), orden constante.
	 */
	public int rmv() {
		Caja c = pila.pop();
		return c.id;
	}

	/**
	 * O(n), va a recorrer la pila entera y por lo tanto hacer 
	 * tantas comparaciones como grande sea la pila.
	 */
	public int rmv(int talla) {
		StackOfT<Caja> newPila = new StackOfT<>();
		int n = 0;
		
		while (!pila.isEmpty()) {
			Caja cAux = pila.pop();
			if (cAux.talla != talla) {
				newPila.push(cAux);
			} else {
				n++;
			}
		}

		while (!newPila.isEmpty()) {
			Caja c = newPila.pop();
			pila.push(c);
		}
		return n;
	}

	/**
	 * O(n), va a recorrer la pila entera.
	 */
	public void imprimePilaDeCajas() {
		System.out.println("----------------");
		StackOfT<Caja> newPila = new StackOfT<>();
		while (!pila.isEmpty()) {
			Caja cAux = pila.pop();
			newPila.push(cAux);
		}

		while (!newPila.isEmpty()) {
			Caja c = newPila.pop();
			pila.push(c);
			System.out.println("Id: " + c.id + " Talla:" + c.talla);
		}
		System.out.println("----------------");
	}

	private static class Caja {
		private int id;
		private int talla;

		public Caja(int id, int talla) {
			this.id = id;
			this.talla = talla;
		}
	}

}
