package aplicacionesDeColas;

/**
 * Todas las operaciones que se realizan en esta clase son
 * de orden constante -> O(1). Por lo tanto por mucho que
 * aumente la entrada, el coste no crecerá.
 * 
 * @author Unai Sainz de la Maza Gamboa
 */
public class DoubleEndedQueue<E> {
	
	private Node<E> first;
	private Node<E> last;
	private int n;
	
	public void addFirst(E e) {
		assert e != null;
		
		Node<E> newNode = new Node<>();
		newNode.item = e;
		if (first == null) {
			first = newNode;
			last = newNode;
		} else {
			Node<E> nAux = first;
			first = newNode;
			first.next = nAux;
			last = nAux;
			last.previous = first;
		}
		n++;
	}
	
	public void addLast(E e) {
		assert e != null;
		
		Node<E> newNode = new Node<>();
		newNode.item = e;
		if (first == null) {
			first = newNode;
		} else {
			last.next = newNode;
			newNode.previous = last;
		}
		last = newNode;
		n++;
	}
	
	public E getFirst() {
		assert first != null;
		
		return first.item;
	}
	
	public E getLast() {
		assert last != null;
		
		return last.item;
	}

	
	public E removeFirst() {
		assert first != null; 
		
		E item = first.item;
		first = first.next;
		first.previous = null;
		n--;
		return item;
	}
	
	public E removeLast() {
		assert last != null;
		
		E lastItem = last.item;
		last = last.previous;
		last.next = null;
		return lastItem;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return n;
	}
	
	private static class Node<E> {
		E item;
		Node<E> next;
		Node<E> previous;
	}
}
