package listaCorro;

public class ListaCircular<T> {
	
	private Node<T> current;
	private int n;
	
	public ListaCircular() {
		this.current = null;
		this.n = 0;
	}
	
	public void add(T elem) {
		Node<T> newNode = new Node<T>(elem);
		if (isEmpty()) {
			current = newNode;
			current.next = current;
		} else {
			newNode.next = current.next;
			current.next = newNode;
			current = newNode;
		}
		
		n++;
	}
	
	public T remove() {
		if(isEmpty()) return null;
		
		Node<T> elemReturn = current.next;
		T res = elemReturn.elem;
		
		if(n == 1) {
			current = null;
		} else {
			current.next = elemReturn.next;
		}
		n--;
		
		return res;
	}
	
	public T removeSiguiente(int numConteo) {
		if (isEmpty()) return null;
		
		for(int i = 1; i < numConteo; i++) {
			current = current.next;
		}
		
		T elem = remove();
		
		return elem;
	}
	
	public boolean contains(T elem) {
		for(int i = 0; i < n; i++) {
			if(current.elem == elem) {
				return true;
			} else {
				current = current.next;
			}
		}
		return false;
	}
	
	public boolean isEmpty() {
		return current == null;
	}
	
	public int size() {
		return n;
	}
	
	public void imprimeCola() {
		Node<T> currentC = current;
		
		System.out.println("------------------------------");
		for(int i = 0; i < n; i++) {
			System.out.println(currentC.elem);
			currentC = currentC.next;
		}
		System.out.println("------------------------------");
	}
	
	
	private static class Node<T> {
		Node<T> next;
		T elem;
		
		public Node(T elem) {
			this.elem = elem;
		}
	}
}
