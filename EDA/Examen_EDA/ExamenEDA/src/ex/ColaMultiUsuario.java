package ex;

public class ColaMultiUsuario {
	
	private final int nUsuarios;
	private Node[] usuarios;
	
	private Node first;
	private Node last;
	private int numMensajes;
	
	public ColaMultiUsuario(int nUsuarios) {
		this.nUsuarios = nUsuarios;
		this.first = null;
		this.last = null;
		this.numMensajes = 0;
		usuarios =  new Node[nUsuarios];
		for (int i = 0; i < nUsuarios; i++) {
			usuarios[i] = null;
		}
	}
	
	public void incluye(String msg) {
		Node n = new Node();
		n.mensaje = msg;
		n.numLecturas = 0;
		if (first == null) {
			first = n;
			for (int i = 0; i < nUsuarios; i++) {
				usuarios[i] = first;
			}
		} else {
			last.next = n;
			for (int i = 0; i < nUsuarios; i++) {
				if(usuarios[i] == null) {
					usuarios[i] = n;
				}
			}
		}
		last = n;
		numMensajes++;
	}
	
	public boolean hayMensajesPara(int usuario) {
		return usuarios[usuario]  != null;
	}
	
	public void purgar() {
		int nPurgados = 0;
		while (first != null && first.numLecturas == nUsuarios) {
			first = first.next;
			nPurgados++;
		}
		numMensajes = numMensajes - nPurgados;
	}
	
	public String leer(int usuario) {
		String msg = usuarios[usuario].mensaje;
		usuarios[usuario].numLecturas++;
		usuarios[usuario] = usuarios[usuario].next;
		return msg;
	}
	
	public int size() {
		return numMensajes;
	}

	private static class Node {
		String mensaje;
		int numLecturas;
		Node next;
	}
}
