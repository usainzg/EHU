package aplicacionesDeColas;

public class DoubleEndedQueueApp {

	public static void main(String[] args) {
		DoubleEndedQueue<Integer> doubleEndedQueue = new DoubleEndedQueue<>();
		doubleEndedQueue.addFirst(1);
		System.out.println(doubleEndedQueue.getFirst());
		
		doubleEndedQueue.addFirst(2);
		System.out.println(doubleEndedQueue.getFirst());
		System.out.println(doubleEndedQueue.getLast());
	}

}
