package super4;

import excepciones.ProductoInexistenteException;
import productos.*;
import utilidades.SortedArrayList;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Inventario {

    private static final String NOM_FICHERO_INFORME = "informe.txt";
    private static final String NOM_FICHERO_INVENTARIO_D = "productos.txt";
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
     *
     * @return Inventario
     */
    public static Inventario getInstance() {
        if (instance == null) instance = new Inventario();
        return instance;
    }

    /**
     * Devuelve si el fichero esta cargado o no
     *
     * @return cargado
     */
    public boolean estaCargado() {
        return cargado;
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

                String tipo = lineaPartes[lineaPartes.length - 1];

                Producto producto = crearProductoConDatos(tipo, lineaPartes);

                listaProductos.insertarOrdenado(producto);

                ultimoCodigo = (ultimoCodigo < producto.getCodigoProducto()) ? producto.getCodigoProducto() : ultimoCodigo;

            }
            cargado = true;
            System.out.println("... se han cargado los productos del fichero.");
        } catch (FileNotFoundException | ProductoInexistenteException e) {
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
     *
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

    private Producto crearProductoConDatos(String tipo, String[] lineaPartes) throws ProductoInexistenteException {

        int codigoP = Integer.parseInt(lineaPartes[0]);
        String nombreP = lineaPartes[1];
        double precioP = Double.parseDouble(lineaPartes[2]);
        int cantidadP = Integer.parseInt(lineaPartes[3]);
        double pesoP = Double.parseDouble(lineaPartes[4]);

        Producto producto = null;

        switch (tipo) {
            case "Lacteo":
                producto = new Lacteo(codigoP, nombreP, cantidadP, precioP, pesoP, lineaPartes[5], lineaPartes[6]);
                break;
            case "Bebida":
                producto = new Bebida(codigoP, nombreP, cantidadP, precioP, pesoP, lineaPartes[5], Integer.parseInt(lineaPartes[6]));
                break;
            case "FrutaYHortaliza":
                producto = new FrutaYHortaliza(codigoP, nombreP, cantidadP, precioP, pesoP, lineaPartes[5], lineaPartes[6]);
                break;
            case "Herramienta":
                producto = new Herramienta(codigoP, nombreP, cantidadP, precioP, pesoP, lineaPartes[5]);
                break;
            case "Otro":
                producto = new Otro(codigoP, nombreP, cantidadP, precioP, pesoP, lineaPartes[5]);
                break;
            default:
                break;
        }
        if (producto != null) return producto;
        throw new ProductoInexistenteException();
    }

    /**
     * Guarda los productos de la lista en el fichero NOM_FICHERO_INVENTARIO
     */
    public void guardarProductosEnFichero() {

        System.out.println("Guardando el inventario ...");
        FileWriter fw;

        try {
            fw = new FileWriter(NOM_FICHERO_INVENTARIO_D);

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
     *
     * @param codigo        de producto a actualizar
     * @param nuevaCantidad int
     * @return true: si ha ido bien, false: en caso contrario
     */
    public boolean actualizarCantidadProductoPorCodigo(int codigo, int nuevaCantidad) throws ProductoInexistenteException, CantidadNoPositivaException {
        if (nuevaCantidad < 1) {
            throw new CantidadNoPositivaException();
        }
        int existeProductoEnInventario = existeProductoDevuelvePosPorCodigo(codigo);
        if (existeProductoEnInventario != -1) {
            listaProductos.get(existeProductoEnInventario).setCantidadProducto(nuevaCantidad);
            return true;
        }
        throw new ProductoInexistenteException();
    }

    /**
     * Metodo auxiliar para saber si un producto existe
     *
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

    private int existeProductoDevuelvePosPorCodigo(int codigo) {
        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getCodigoProducto() == codigo) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Incluye un nuevo producto en el inventario
     *
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
     *
     * @return codigoProducto nuevo
     */
    public int getCodigoParaNuevoProducto() {
        ultimoCodigo += 1;
        return ultimoCodigo;
    }

    /**
     * Devuelve todos los productos del inventario en forma de arraylist
     *
     * @return inventarioEnArrayList
     */
    public ArrayList<ArrayList<String>> inventarioAListaString() {
        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
        if (listaProductos.size() == 0) return arrayList;
        for (int i = 0; i < listaProductos.size(); i++) {
            ArrayList<String> productoEnLista = listaProductos.get(i).deProductoAListaString();
            arrayList.add(productoEnLista);
        }

        return arrayList;
    }

    /**
     * Devuelve cuantos productos hay en el inventario
     *
     * @return int cont
     */
    private int cuantosProductos() {
        return listaProductos.size();
    }


    public void crearInformeProductosEnviables() {
        String cabecera = "-----------------------------------------------------------------------------------------------\n" +
                "----------------- Super Online: Lista de productos enviables del Inventario -------------------\n" +
                "-----------------------------------------------------------------------------------------------\n" +
                " Codigo             Nombre               Peso      Precio con IVA    Tarifa-envio      Fragil   \n" +
                "--------   -----------------------    --------- ----------------- --------------- -------------";
        SortedArrayList<Producto> listaInforme = crearListaInforme();
        File file = new File(NOM_FICHERO_INFORME);
        FileWriter fileWriter;
        PrintWriter printWriter = null;
        try {
            fileWriter = new FileWriter(file, false);
            printWriter = new PrintWriter(fileWriter);

            printWriter.println(cabecera);

            for (Producto producto : listaInforme) {
                switch (producto.getClass().getSimpleName()) {
                    case "Bebida":
                        Bebida bebida = (Bebida) producto;
                        bebida.imprimirEnviable(printWriter);
                        break;
                    case "Lacteo":
                        Lacteo lacteo = (Lacteo) producto;
                        lacteo.imprimirEnviable(printWriter);
                        break;
                    case "FrutaYHortaliza":
                        FrutaYHortaliza frutaYHortaliza = (FrutaYHortaliza) producto;
                        frutaYHortaliza.imprimirEnviable(printWriter);
                        break;
                    case "Herramienta":
                        Herramienta herramienta = (Herramienta) producto;
                        herramienta.imprimirEnviable(printWriter);
                        break;
                    default:
                        break;

                }
                printWriter.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }

    }

    private SortedArrayList<Producto> crearListaInforme() {
        SortedArrayList<Producto> listaInforme = new SortedArrayList<>();

        for (Producto producto : listaProductos) {
            if (producto instanceof IEnviable) {
                listaInforme.insertarOrdenado(producto);
            }

        }
        return listaInforme;
    }

    public void eliminarProducto(int codigo) throws ProductoInexistenteException {

        if (existeProductoDevuelvePosPorCodigo(codigo) == -1) throw new ProductoInexistenteException();

        SortedArrayList<Producto> nuevaLista = new SortedArrayList<>();

        for (Producto producto : listaProductos) {
            if (producto.getCodigoProducto() != codigo) {
                nuevaLista.add(producto);
            }
        }

        listaProductos = nuevaLista;
    }

    public class CantidadNoPositivaException extends Exception {
        private CantidadNoPositivaException() {

        }

        public void SacarError() {
            System.out.println("ERROR: La cantidad no es positiva.");
        }
    }

}
