package aplicacionesDePilas;

public class PilaDeCajasApp {

	public static void main(String[] args) {

		PilaDeCajas pilaDeCajas = new PilaDeCajas();
		pilaDeCajas.addCaja(0, 1);
		pilaDeCajas.addCaja(1, 2);
		pilaDeCajas.addCaja(2, 3);
		pilaDeCajas.addCaja(3, 1);
		pilaDeCajas.addCaja(4, 3);
		pilaDeCajas.addCaja(5, 2);
		pilaDeCajas.addCaja(6, 7);
		pilaDeCajas.addCaja(7, 7);
		
		
		pilaDeCajas.imprimePilaDeCajas();
		
		System.out.println("Cajas eliminadas: " + pilaDeCajas.rmv(1));
		
		pilaDeCajas.imprimePilaDeCajas();
	}

}
