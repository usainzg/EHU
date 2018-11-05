package main;

import clases.KeyComparator;
import clases.ToyTreeMap;

public class Pruebas {

	public static void main(String[] args) {
		ToyTreeMap<Integer, String> toyTreeMap = new ToyTreeMap<>(new KeyComparator());
		
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

		if (toyTreeMap.isBST()) {
		    System.out.println("Is BST");
        } else {
		    System.out.println("Is not BST");
        }
		
	}

}
