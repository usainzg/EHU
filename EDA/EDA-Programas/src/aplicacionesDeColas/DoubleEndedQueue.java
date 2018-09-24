package aplicacionesDeColas;

public class DoubleEndedQueue<E> {
	
	private Node<E> first;
	private Node<E> last;
	private int n;
	
	public void addFirst(E e) {
		Node<E> newNode = new Node<>();
		newNode.item = e;
		if (first == null) {
			first = newNode;
			last = newNode;
		} else {
			Node<E> nAux = first;
			first = newNode;
			first.next = nAux;
		}
		n++;
	}
	
	public void addLast(E e) {
		Node<E> newNode = new Node<>();
		newNode.item = e;
		if (first == null) {
			first = newNode;
		} else {
			last.next = newNode;
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
		n--;
		return item;
	}
	
	public E removeLast() {
		assert last != null;
		Node<E> lastNode = last;
		Node<E> currentNode = null;
		while(true) {
			currentNode = removeFirst();
			
		}
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
		
		boolean hasNext() {
			return next != null;
		}
	}
}
