package ehu.eda.list.linkedImp;

public class ParDeListasOrd {
	
	LinkedOrdList<Integer> pares;
	LinkedOrdList<Integer> impares;
	
	public ParDeListasOrd(LinkedOrdList<Integer> listaInit) {
		this.pares = new LinkedOrdList<>();
		this.impares = new LinkedOrdList<>();
		dividirLista(listaInit);
	}
	
	private void dividirLista(LinkedOrdList<Integer> lista) {
		LinkedOrdList<Integer> copiaLista = lista;
		while(!copiaLista.isEmpty()) {
			int n = copiaLista.removeFirst();
			if (n % 2 == 0) {
				this.pares.add(n);
			} else {
				this.impares.add(n);
			}
		}
	}
	
	public int numeroDePares() {
		return pares.size();
	}
	
	public int numeroDeImpares() {
		return impares.size();
	}
}
