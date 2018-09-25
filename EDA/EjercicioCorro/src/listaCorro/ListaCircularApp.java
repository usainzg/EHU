package listaCorro;

public class ListaCircularApp {

	public static void main(String[] args) {
		ListaCircular<Integer> listaCorro = new ListaCircular<>();
		int nParticipantes = 10;
		int frecuencia = 3;
		
		for(int i = 0; i <= nParticipantes; i++) {
			listaCorro.add(i);
		}
		System.out.println("Current estara en la posicion 10, por lo tanto imprimira desde esa posicion.");
		listaCorro.imprimeCola();
		
		System.out.println("Contiene 6: " + listaCorro.contains(6));
		System.out.println("------------------------------");
		
		while(listaCorro.size() > 1) {
			listaCorro.removeSiguiente(frecuencia);
		}
		int ganador = listaCorro.remove();
		System.out.println("Ganador: " + ganador);
		System.out.println("------------------------------");
	}

}
