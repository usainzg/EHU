package aplicacionesDeListas;

import ehu.eda.list.linkedImp.LinkedOrdList;
import ehu.eda.list.linkedImp.ParDeListasOrd;

public class ParDeListasOrdApp {

	public static void main(String[] args) {
		LinkedOrdList<Integer> linkedOrdList = new LinkedOrdList<>();
		linkedOrdList.add(0);
		linkedOrdList.add(1);
		linkedOrdList.add(2);
		linkedOrdList.add(3);
		linkedOrdList.add(4);
		linkedOrdList.add(5);
		linkedOrdList.add(6);
		
		System.out.println("Hay 4 pares y 3 impares...");
		
		System.out.println(linkedOrdList.size() + " -> Tamaño de la lista inicial.");
		
		ParDeListasOrd parDeListasOrd = new ParDeListasOrd(linkedOrdList);
		
		System.out.println("Pares en la lista: " + parDeListasOrd.numeroDePares());
		System.out.println("Impares en la lista: " + parDeListasOrd.numeroDeImpares());
		

	}

}
