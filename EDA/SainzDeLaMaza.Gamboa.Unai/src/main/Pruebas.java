package main;

import clases.KeyComparator;
import clases.TreeMap;
import clases.Tuple;
import clases.TupleV;

import java.util.List;

public class Pruebas {

	public static void main(String[] args) {
		TreeMap<Integer, String> toyTreeMap = new TreeMap<>(new KeyComparator());
		
		toyTreeMap.put(1, "Unai");
		
		String str = toyTreeMap.get(1);
		
		System.out.println(str);
		
		toyTreeMap.put(1, "Unai1");
		toyTreeMap.put(2, "Unai2");
		toyTreeMap.put(3, "Unai3");
		toyTreeMap.put(4, "Unai4");
		
		System.out.println(toyTreeMap.size());
		
		if(toyTreeMap.get(10) == null) System.out.println("NULL");
		
		int size = toyTreeMap.clear();
		
		System.out.println("Tamaño antes: " + size);
		
		if(toyTreeMap.get(1) == null) System.out.println("VACIO");

        System.out.println(toyTreeMap.size());

        toyTreeMap.put(1, "Unai1");
        toyTreeMap.put(2, "Unai2");
        toyTreeMap.put(3, "Unai3");
        toyTreeMap.put(4, "Unai4");

        System.out.println(toyTreeMap.size());

        toyTreeMap.printLexicographically();

		if (toyTreeMap.isBST()) {
		    System.out.println("Is BST");
        } else {
		    System.out.println("Is not BST");
        }


        Tuple<Integer> tupla = toyTreeMap.findMinMax();

		System.out.println("Min Key: " + tupla.getMinKey());
		System.out.println("Max Key: " + tupla.getMaxKey());

		toyTreeMap.printLexicographically();
		
		
		toyTreeMap.get(2);
		
		toyTreeMap.printByLevel();

		//System.out.println(toyTreeMap.remove(2));


        List<TupleV<Integer, String>> list = toyTreeMap.toList();
        System.out.println("NODES: ");
        for (TupleV<Integer, String> t: list) {
            System.out.println(t);
        }

        System.out.println("LEAVES: ");
        List<TupleV<Integer, String>> leaves = toyTreeMap.leavesRec();

        for (TupleV<Integer, String> t: leaves) {
            System.out.println(t);
        }

        System.out.println("LEAVES ITER: ");
        List<TupleV<Integer, String>> leavesIter = toyTreeMap.leavesIter();

        for (TupleV<Integer, String> t: leavesIter) {
            System.out.println(t);
        }

        System.out.println("C: " + toyTreeMap.getFloor(4));

        System.out.println("SELECT REC: ");
        List<TupleV<Integer, String>> select = toyTreeMap.selecRec(2, 4);

        for (TupleV<Integer, String> t: select) {
            System.out.println(t);
        }

        System.out.println("SELECT ITER: ");
        List<TupleV<Integer, String>> selectIter = toyTreeMap.selectJDK(2, 4);

        for (TupleV<Integer, String> t: selectIter) {
            System.out.println(t);
        }
	}

}
