package ds;

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
        Node<T> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public int size() {
        return n;
    }

    private class Node<T> {
        private T item;
        private Node<T> next;
    }
}
