package super4;

import productos.Producto;
import excepciones.ProductoInexistenteException;
import utilidades.SortedArrayList;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Inventario {
	
	private static final String NOM_FICHERO_INVENTARIO = "productosP.txt";
	private static final String NOM_FICHERO_INVENTARIO_D = "productosPD.txt";
	private static final int MAX_PRODUCTOS = 100;
	
	private static Inventario instance;
	
	private SortedArrayList<Producto> listaProductos;
	private int ultimoCodigo = -1;
	private Scanner es;

	private boolean cargado;

	/**
	 * Contructor privado para el singleton
	 */
	private Inventario() {
	    cargado = false;
		listaProductos = new SortedArrayList<>();
	}

	/**
	 * Singleton
	 * @return Inventario
	 */
	public static Inventario getInstance() {
		if (instance == null) instance = new Inventario();
		return instance;
	}

	/**
	 * cargarProductosDelFichero: Carga de productos desde el fichero Nota: (1) la
	 * constante NOM_FICHERO_INVENTARIO contiene el nombre externo del fichero de
	 * productos (2) el inventario se guarda en un array de Productos (3) se debe
	 * idear una forma de obtener el valor del maximo codigo de los productos que se
	 * cargan
	 */
	public void cargarProductosDelFichero() {

		System.out.println("Cargando productos del inventario ...");

		try {
			es = new Scanner(new FileReader(NOM_FICHERO_INVENTARIO_D));
			String linea;

			while (es.hasNextLine()) {

				linea = es.nextLine();
				System.out.println(linea);
				String[] lineaPartes = linea.split(" ");

				int codigoP = Integer.parseInt(lineaPartes[0]);
				String nombreP = lineaPartes[1];
				int cantidadP = Integer.parseInt(lineaPartes[2]);
				double precioP = Double.parseDouble(lineaPartes[3]);
				double pesoP = Double.parseDouble(lineaPartes[4]);

				Producto producto = crearProductoConDatos(codigoP, nombreP, precioP, cantidadP, pesoP);

				listaProductos.insertarOrdenado(producto);

				ultimoCodigo = (ultimoCodigo < codigoP) ? codigoP : ultimoCodigo;

			}
			System.out.println("... se han cargado los productos del fichero.");
		} catch (FileNotFoundException e) {
			System.err.println("... no se han podido cargar los productos del inventario.");
			System.out.println();
			System.out.println("¿Quieres intentar situar el archivo? Si / No");
			Scanner sc = new Scanner(System.in);
			String respuesta = sc.nextLine();
			segundaOportunidadArchivo(respuesta);
			sc.close();
			ultimoCodigo = -1;
			e.printStackTrace();
		} finally {
			es.close();
		}
		System.out.println();
	}

	/**
	 * Metodo para dejar colocar el archivo al usuario
	 * @param s respuesta
	 */
	private void segundaOportunidadArchivo(String s) {
		s = s.toLowerCase();
		if (s.equals("si")) {
			cargarProductosDelFichero();
		} else {
			System.out.println("De acuerdo, adios.");
			System.exit(1);
		}

	}

	/**
	 * Devuelve el producto seteado apartir de atributos
	 * @param cod int
	 * @param nb string
	 * @param precio double
	 * @param cantidad int
	 * @param peso double
	 * @return producto
	 */
	private Producto crearProductoConDatos(int cod, String nb, double precio, int cantidad, double peso) {
		return new Producto(cod, nb, cantidad, precio, peso);
	}

	/**
	 * Guarda los productos de la lista en el fichero NOM_FICHERO_INVENTARIO
	 */
	public void guardarProductosEnFichero() {

		System.out.println("Guardando el inventario ...");
		FileWriter fw;

		try {
			fw = new FileWriter(NOM_FICHERO_INVENTARIO);

			for (int i = 0; i < cuantosProductos(); i++) {
				System.out.println(i);
				String line = listaProductos.get(i).toString();
				fw.write(line + "\r\n");
			}
			fw.close();
			System.out.println("... se han guardado los productos del inventario.");
			System.out.println();
		} catch (IOException e) {
			System.err.println("... no se han podido guardar los productos del inventario.");
			System.out.println();
			e.printStackTrace();
		}
	}

	/**
	 * Actualiza la cantidad de un producto si existe
	 * @param producto producto
	 * @param nuevaCantidad int
	 * @return true: si ha ido bien, false: en caso contrario
	 */
	public boolean actualizarCantidadProducto(Producto producto, int nuevaCantidad) throws ProductoInexistenteException, CantidadNoPositivaException {
		if (nuevaCantidad < 1) {
			throw new CantidadNoPositivaException();
		}
		int existeProductoEnInventario = existeProductoDevuelvePos(producto);
		if (existeProductoEnInventario != -1) {
			listaProductos.get(existeProductoEnInventario).setCantidadProducto(nuevaCantidad);
			return true;
		}
		throw new ProductoInexistenteException();
	}

	/**
	 * Metodo auxiliar para saber si un producto existe
	 * @param producto producto con nombre seteado
	 * @return -1: no existe, indice: si existe
	 */
	private int existeProductoDevuelvePos(Producto producto) {
		String nombreNormalizado = producto.getNombreProducto().replace(" ", "-");
		for (int i = 0; i < listaProductos.size(); i++) {
			if (listaProductos.get(i).getNombreProducto().equals(nombreNormalizado)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Incluye un nuevo producto en el inventario
	 * @param producto producto a anadir
	 * @return true: correcto, false: caso contrario
	 */
	public boolean incluirNuevoProducto(Producto producto) throws CantidadNoPositivaException {
		if (listaProductos.size() >= MAX_PRODUCTOS) return false;
		if (producto.getCantidadProducto() < 1) throw new CantidadNoPositivaException();
		listaProductos.add(producto);
		return true;
	}

	/**
	 * Obtiene un nuevo codigo para un nuevo producto
	 * @return codigoProducto nuevo
	 */
	public int getCodigoParaNuevoProducto() {
		ultimoCodigo += 1;
		return ultimoCodigo;
	}

	/**
	 * Muestra los productos del inventario
	 */
	public void mostrarProductos() {
		if (listaProductos.size() == 0) return;
		for (int i = 0; i < listaProductos.size(); i++)
			System.out.println(listaProductos.get(i));
	}

	/**
	 * Devuelve cuantos productos hay en el inventario
	 * @return int cont
	 */
	private int cuantosProductos() {
		return listaProductos.size();
	}

	/**
	 * Devuelve un producto si existe
	 * @param producto producto
	 * @return producto seteado (si existe), vacio (si no existe)
	 */
	public Producto getProducto(Producto producto) throws CantidadNoPositivaException, ProductoInexistenteException {
		int posProductoSiExiste = existeProductoDevuelvePos(producto);
		if (posProductoSiExiste != -1) {

			if (listaProductos.get(posProductoSiExiste).getCantidadProducto() < 1) {
				throw new CantidadNoPositivaException();
			}
			return listaProductos.get(posProductoSiExiste);
		}
		throw new ProductoInexistenteException();
	}

	public class CantidadNoPositivaException extends Exception {
		private CantidadNoPositivaException() {

		}

		public void SacarError() {
			System.out.println("ERROR: La cantidad no es positiva.");
		}
	}

}
