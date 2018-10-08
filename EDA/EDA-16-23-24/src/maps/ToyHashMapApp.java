package maps;

public class ToyHashMapApp {

	public static void main(String[] args) {
		ToyHashMap<Integer, Integer> toyHashMap = new ToyHashMap<>(10);
		toyHashMap.put(0, 10);
		toyHashMap.put(1, 20);
		toyHashMap.put(2, 25);
		toyHashMap.put(3, 30);
		toyHashMap.put(4, 35);
		
		System.out.println("Size antes de borrar: " + toyHashMap.size());
		System.out.println("Clave: " + 0 + " -> Valor: " + toyHashMap.get(0));
		System.out.println("Contiene la C/V antes de borrar? " + (toyHashMap.containsKey(0) ? "Si" : "No"));
		
		System.out.println("Clave a borrar: " + 0 + " -> Valor: " + toyHashMap.remove(0));
		
		System.out.println("Size despues de borrar: " + toyHashMap.size());
		
		System.out.println("Contiene la C/V despues de borrar? " + (toyHashMap.containsKey(0) ? "Si" : "No"));
		
		Object[] arrKeys = toyHashMap.getAllKeys();
		
		for (Object obj: arrKeys) {
			System.out.println("Key: " + obj);
		}

	}

}
