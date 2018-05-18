package productos;

import java.util.ArrayList;

public abstract class Perecedero extends Producto implements IEnviable {
    private String fechaCaducidad;

    /**
     * Constructor vacio
     */
    public Perecedero() {

    }

    /**
     * Constructor que setea el nombre y la fecha
     *
     * @param nombre    nombre producto
     * @param fecha     fecha producto
     */
    Perecedero(String nombre, String fecha) {
        super(nombre);
        this.fechaCaducidad = fecha;
    }

    /**
     * Constructor que setea todos los atributos
     *
     * @param codigoProducto   codigo producto
     * @param nombreProducto   nombre producto
     * @param cantidadProducto cantidad producto
     * @param precioProducto   precio procucto
     * @param pesoProducto     peso producto
     * @param fecha            fecha producto
     */
    Perecedero(int codigoProducto, String nombreProducto, int cantidadProducto, double precioProducto,
               double pesoProducto, String fecha) {
        super(codigoProducto, nombreProducto, cantidadProducto, precioProducto, pesoProducto);
        this.fechaCaducidad = fecha;
    }

    /**
     * Constructor que setea todos los atributos menos el codigo
     *
     * @param nombreProducto   nombre producto
     * @param cantidadProducto cantidad producto
     * @param precioProducto   precio procucto
     * @param pesoProducto     peso producto
     * @param fecha            fecha producto
     */
    Perecedero(String nombreProducto, int cantidadProducto, double precioProducto, double pesoProducto, String fecha) {
        super(nombreProducto, cantidadProducto, precioProducto, pesoProducto);
        this.fechaCaducidad = fecha;
    }

    String getFechaCaducidad() {
        return fechaCaducidad;
    }

    @Override
    public ArrayList<String> deProductoAListaString() {
        ArrayList<String> lista = super.deProductoAListaString();
        lista.add(fechaCaducidad);
        return lista;
    }

    @Override
    public double tarifaEnvio() {
        return 2.15;
    }
}
