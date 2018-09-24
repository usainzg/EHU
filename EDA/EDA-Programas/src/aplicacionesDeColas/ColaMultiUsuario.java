package aplicacionesDeColas;

import ehu.eda.list.linkedImp.QueueOfT;

public class ColaMultiUsuario {
	private final int N;
	private QueueOfT<Mensaje> cola;

	public ColaMultiUsuario(int n) {
		assert n >= 0;
		this.N = n;
		this.cola = new QueueOfT<>();
	}
	
	public void incluye(int usuarioEmisor, String msg, int[] receptores) {
		Mensaje mensaje = new Mensaje(usuarioEmisor, receptores, msg);
		cola.enqueue(mensaje);
	}
	
	public boolean hayMensajesPara(int usuario) {
		assert 0 <= usuario && usuario < N;
		
	}
	
	public void purgar() {
		
	}
	
	public String leer(int usuario) {
		assert 0 <= usuario && usuario < N;
		
	}
	
	
	
	private class Mensaje {
		int emisor;
		int[] receptores;
		String mensaje;
		
		Mensaje(int emisor, int[] receptores, String mensaje) {
			this.emisor = emisor;
			setReceptores(receptores);
			this.mensaje = mensaje;
		}
		
		void setReceptores(int[] receptores) {
			if(receptores.length == 0) {
				this.receptores = todosLosReceptores();
			} else {
				this.receptores = receptores;
			}
		}
		
		int[] todosLosReceptores () {
			int[] n = new int[N];
			for(int i = 0; i < N; i++) {
				n[i] = i;
			}
			return n;
		}
	}
}
