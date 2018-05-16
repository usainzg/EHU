package productos;

import java.util.ArrayList;

public class Otro extends NoPerecedero {

    public Otro() {

    }

    /**
     * Constructor que setea solo el nombre
     *
     * @param nombre    string
     * @param categoria String
     */
    public Otro(String nombre, String categoria) {
        super(nombre, categoria);
    }

    /**
     * Constructor que setea todos los atributos
     *
     * @param codigoProducto   int
     * @param nombreProducto   string
     * @param cantidadProducto int
     * @param precioProducto   double
     * @param pesoProducto     double
     * @param categoria        String
     */
    public Otro(int codigoProducto, String nombreProducto, int cantidadProducto, double precioProducto, double pesoProducto, String categoria) {
        super(codigoProducto, nombreProducto, cantidadProducto, precioProducto, pesoProducto, categoria);
    }

    /**
     * Constructor que setea todos los atributos menos el codigo
     *
     * @param nombreProducto   string
     * @param cantidadProducto int
     * @param precioProducto   double
     * @param pesoProducto     double
     * @param categoria        String
     */
    public Otro(String nombreProducto, int cantidadProducto, double precioProducto, double pesoProducto, String categoria) {
        super(nombreProducto, cantidadProducto, precioProducto, pesoProducto, categoria);
    }

    @Override
    public String toString() {
        return this.getCodigoProducto() + " " + this.getNombreProducto()
                + " " + this.getPrecioProducto() + " " + this.getCantidadProducto() + " "
                + this.getPesoProducto() + " " + this.getCategoria() + " " + this.getClass().getSimpleName() + " ";
    }

    @Override
    public ArrayList<String> deProductoAListaString() {
        ArrayList<String> lista = super.deProductoAListaString();
        lista.add(getCategoria());
        return lista;
    }
}
