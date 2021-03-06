package exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ehu.eda.list.linkedImp.QueueOfT;
import ehu.eda.list.linkedImp.StackOfInt;

/*
* PUEDES INCORPORAR/USAR CUALQUIERA DE LAS CLASES VISTAS EN CLASE
*/

public class JuegoTramposo {
	
	private Jugador[] jugadores;
	
	public JuegoTramposo(int nJugadores) {
		init(nJugadores);
	}
	
	public void init(int nJugadores) {
		jugadores = new Jugador[nJugadores];
		jugadores[0] = new Jugador(true); // true si tramposo
		for(int i = 1; i < nJugadores; i++) {
			jugadores[i] = new Jugador(false); // false no trampos
		}
	}

	// Para apartado (a)
	private void rutinaComun(Payment pay) {
		int pagador = pay.payer;
		int cobrador = pay.winner;
		int cantidad = pay.amount;
		
		for(int i = 0; i < cantidad; i++) {
			jugadores[cobrador].billetes.push(jugadores[pagador].billetes.pop());
		}
	}
	
	// Para apartado (b)
	private void rutinaDelTramposo(Payment pay) { // NO ACABADO
		int pagador = pay.payer;
		int cobrador = pay.winner;
		int cantidad = pay.amount;
		
		if(pagador == 0) {
			StackOfInt stackOfTramposo = new StackOfInt();
			StackOfInt stackAux = new StackOfInt();
			
			while(!jugadores[pagador].billetes.isEmpty()) {
				int billete = jugadores[pagador].billetes.pop();
				if(billete == 0) {
					stackOfTramposo.push(billete);
				} else {
					stackAux.push(billete);
				}
			}
			
			// rellenar billete buenos primero
			while(!stackAux.isEmpty()) {
				jugadores[pagador].billetes.push(stackAux.pop());
			}
			
			// rellenar los malos para darlos
			while(!stackOfTramposo.isEmpty()) {
				jugadores[pagador].billetes.push(stackOfTramposo.pop());
			}
			
			// repartir billetes malos primero
			for(int i = 0; i < cantidad; i++) {
				jugadores[cobrador].billetes.push(jugadores[pagador].billetes.pop());
			}
			
		} else {
			for(int i = 0; i < cantidad; i++) {
				jugadores[cobrador].billetes.push(jugadores[pagador].billetes.pop());
			}
		}
	}
	
	private void sacarDatosFinales() {
		int tFalsos = 0;
		int tVerdaderos = 0;
		StackOfInt stackAux = new StackOfInt();
		
		for(int i = 0; i < jugadores.length; i++) {
			System.out.println("---------------------------------------");
			System.out.println("Jugador: " + i);
			while(!jugadores[i].billetes.isEmpty()) {
				int billete = jugadores[i].billetes.pop();
				stackAux.push(billete);
				if(billete == 0) {
					tFalsos++;
				} else {
					tVerdaderos++;
				}
			}
			
			System.out.println("Total Falsos: " + tFalsos);
			System.out.println("Total Verdaderos: " + tVerdaderos);
			System.out.println("TOTAL BILLETES: " + (tFalsos + tVerdaderos));
			System.out.println("---------------------------------------");
			tFalsos = 0;
			tVerdaderos = 0;
			
			while(!stackAux.isEmpty()) {
				jugadores[i].billetes.push(stackAux.pop());
			}
		}
	}
	
	private static class Jugador {
		StackOfInt billetes;
		Jugador(boolean tramposo) {
			billetes = new StackOfInt();
			setBilletes(tramposo);
		}
		
		void setBilletes(boolean esTramposo) {
			int tipoBillete = (esTramposo ? 0 : 1);
			for(int i = 0; i < 100; i++) {
				billetes.push(tipoBillete);
			}
		}
	}
	
	// Las instancias de esta clase representan pagos de un jugador a otro.
	private static class Payment {
		public final int payer;
		public final int winner;
		public final int amount;

		public Payment(int payer, int winner, int amount) {
			this.payer = payer;
			this.amount = amount;
			this.winner = winner;
		}

		@Override
		public String toString() {
			return "Payment [payer=" + payer + ", winner=" + winner + ", amount=" + amount + "]";
		}
	}

	public static void main(String[] args) {
		JuegoTramposo juego = null;
		QueueOfT<Payment> payments = new QueueOfT<>();
		Scanner input = null;
		
		try {
			input = new Scanner(new File("src/exam/datosPartidaU.txt"));
			
			int nJugadores = input.nextInt();
			juego = new JuegoTramposo(nJugadores);
			
			Payment pay;
			while(input.hasNext()) {
				int[] dataT = new int[3];
				
				dataT[0] = input.nextInt(); // jugador
				dataT[1] = input.nextInt(); // cobrador
				dataT[2] = input.nextInt(); // cantidad
				pay = new Payment(dataT[0], dataT[1], dataT[2]);
				payments.enqueue(pay);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(input != null) input.close();
		}
		
		/******************************************************************************************************/
		Scanner scIn = new Scanner(System.in);
		System.out.println("Options: ");
		System.out.println("0: Rutina Comun");
		System.out.println("1: Rutina Tramposo");

		int op = scIn.nextInt();
		if(op == 0) {
			while(!payments.isEmpty()) {
				juego.rutinaComun(payments.dequeue());
			}
		} else {
			while(!payments.isEmpty()) {
				juego.rutinaDelTramposo(payments.dequeue());
			}
		}
		
		juego.sacarDatosFinales(); 
		/******************************************************************************************************/
		
		scIn.close();
	}
	
}
