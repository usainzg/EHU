package listas;

public class ListaOrd {
	
	

	private static class Node {
		Node next;
		int item;
		
		Node (int item) {
			this.item = item;
			this.next = null;
		}
	}
}
