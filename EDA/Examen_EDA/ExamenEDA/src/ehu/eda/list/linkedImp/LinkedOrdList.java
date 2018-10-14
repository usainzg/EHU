package ehu.eda.list.linkedImp;

import java.util.Random;

public class LinkedOrdList<T extends Comparable<T>> {
	private int cardinal; // número de elementos en contenido
	private LinearNode<T> contenido;

	private static Random rand = new Random();

	private static class LinearNode<T> {
		LinearNode<T> next;
		T element;

		public LinearNode(T elem) {
			next = null;
			element = elem;
		}
	}

	public LinkedOrdList() {
		cardinal = 0;
		contenido = null;
	}

	public boolean isEmpty() {
		return cardinal == 0;
	}

	public void add(T elem) {
		LinearNode<T> newElem = new LinearNode<T>(elem);
		LinearNode<T> previo = null;
		LinearNode<T> sigPrevio = contenido;
		while (sigPrevio != null && sigPrevio.element.compareTo(elem) < 0) {
			previo = sigPrevio;
			sigPrevio = sigPrevio.next;
		}
		if (sigPrevio == null) {
			if (previo == null) {// se añade como primero
				contenido = newElem;
			} else { // se añade como último
				previo.next = newElem;
			}
		} else {
			if (previo == null) {// se añade como primero
				newElem.next = sigPrevio;
				contenido = newElem;
			} else { // se inserta donde corresponde
				newElem.next = sigPrevio;
				previo.next = newElem;
			}
		}
		cardinal++;
	}

	public void addAll(LinkedOrdList<T> mset) {// INEFICIENTE
		LinearNode<T> scanMset = mset.contenido;
		while (scanMset != null) {
			this.add(scanMset.element);
			scanMset = scanMset.next;
		}
	}

	public boolean contains(T target) {
		LinearNode<T> scan = this.contenido;
		while (scan != null && scan.element.compareTo(target) < 0) {
			scan = scan.next;
		}
		if (scan == null || scan.element.compareTo(target) > 0) {
			return false;
		} else {
			return true;
		}
	}

	// Precondición: Hay algún elemento en el conjunto
	public T removeRandom() {
		assert !this.isEmpty(); // cardinal != 0

		T result = null;

		int choice = rand.nextInt(cardinal) + 1; // entero entre 1 y cardinal

		if (choice == 1) { // retira el primer elemento
			result = contenido.element;
			contenido = contenido.next;
		} else {
			LinearNode<T> previo = contenido;
			for (int i = 2; i < choice; i++) {
				previo = previo.next;
			}
			LinearNode<T> sigPrevio = previo.next;
			result = sigPrevio.element;
			previo.next = sigPrevio.next;
		}
		cardinal--;

		return result;
	}

	// Precondición: Hay algún elemento en el conjunto
	public T removeFirst() {
		assert !this.isEmpty(); // cardinal != 0

		T result = contenido.element;
		contenido = contenido.next;
		cardinal--;
		return result;
	}

	// Retira y devuelve una aparición de elem en contenido.
	// Si tal elem no aparece en contenido, devuelve null.
	public T remove(T elem) {
		LinearNode<T> previo = null;
		LinearNode<T> sigPrevio = contenido;
		while (sigPrevio != null && sigPrevio.element.compareTo(elem) < 0) {
			previo = sigPrevio;
			sigPrevio = sigPrevio.next;
		}
		if (sigPrevio == null || sigPrevio.element.compareTo(elem) > 0) {
			return null;
		} else {
			if (previo == null) { // retira el primero
				contenido = contenido.next;
			} else {
				previo.next = sigPrevio.next;
			}

			cardinal--;
			return sigPrevio.element;
		}
	}

	/*
	 * Devuelve true si this y mset tienen la misma colección de elementos y cada
	 * elemento repetido el mismo número de veces. En caso contrario, devuelve
	 * false.
	 */
	public boolean equals(LinkedOrdList<T> set) {
		LinearNode<T> scanSet = set.contenido;
		LinearNode<T> scanThis = this.contenido;
		while (scanThis != null && scanSet != null) {
			if (!scanThis.element.equals(scanSet.element)) {
				return false;
			} else {
				scanThis = scanThis.next;
				scanSet = scanSet.next;
			}
		}
		if (scanThis == null && scanSet == null) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		return cardinal;
	}

	@Override
	public String toString() {
		String result = "";
		LinearNode<T> scanThis = this.contenido;
		while (scanThis != null) {
			result = result + scanThis.element.toString() + "\n";
			scanThis = scanThis.next;
		}
		return result;
	}
}
