package ehu.eda.list.linkedImp;

public class StackOfT<T> {
	private Node<T> first;
	private int n;	
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public T peek() {
		return first.item;
	}
	
	public T pop() {
		T item = first.item;
		first = first.next;
		n--;
		return item;
	}
	
	public void push(T item) {
		Node<T> old = first;
		first = new Node<T>();
		first.item = item;
		first.next = old;
		n++;
	}
	
	public int size() {
		return n;
	}
	
	private static class Node<T> {
		T item;
		Node<T> next;
	}
}
