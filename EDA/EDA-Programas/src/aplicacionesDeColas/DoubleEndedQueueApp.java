package aplicacionesDeColas;

public class DoubleEndedQueueApp {

	public static void main(String[] args) {
		DoubleEndedQueue<Integer> doubleEndedQueue = new DoubleEndedQueue<>();
		
		doubleEndedQueue.addFirst(1);
		doubleEndedQueue.addFirst(2);
		System.out.println("First after add 2 to first pos: " + doubleEndedQueue.getFirst());
		System.out.println("Last after add 2 to first: " + doubleEndedQueue.getLast());
		System.out.println("----------------------------------");
		
		doubleEndedQueue.addFirst(5);
		doubleEndedQueue.addLast(8);
		System.out.println("First after add 5 to first pos: " + doubleEndedQueue.getFirst());
		System.out.println("Last after add 8 to last pos: " + doubleEndedQueue.getLast());
		System.out.println("----------------------------------");
		
		System.out.println("Last before removing... " + doubleEndedQueue.getLast());
		int last = doubleEndedQueue.removeLast();
		System.out.println("Last removed: " + last + " and the last now is: " + doubleEndedQueue.getLast());
		System.out.println("----------------------------------");
		
		System.out.println("First before removing... " + doubleEndedQueue.getFirst());
		int first = doubleEndedQueue.removeFirst();
		System.out.println("First removed: " + first + " and the last now is: " + doubleEndedQueue.getFirst());
		System.out.println("----------------------------------");
	}

}
