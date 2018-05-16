package productos;

import java.util.ArrayList;

public abstract class NoPerecedero extends Producto {
    private String categoria;

    public NoPerecedero() {

    }

    /**
     * Constructor que setea solo el nombre
     * @param nombre string
     * @param categoria String
     */
    public NoPerecedero(String nombre, String categoria) {
        super(nombre);
        this.categoria = categoria;
    }

    /**
     * Constructor que setea todos los atributos
     * @param codigoProducto int
     * @param nombreProducto string
     * @param cantidadProducto int
     * @param precioProducto double
     * @param pesoProducto double
     * @param categoria String
     */
    public NoPerecedero(int codigoProducto, String nombreProducto, int cantidadProducto, double precioProducto,
                      double pesoProducto, String categoria) {
        super(codigoProducto, nombreProducto, cantidadProducto, precioProducto, pesoProducto);
        this.categoria = categoria;
    }

    /**
     * Constructor que setea todos los atributos menos el codigo
     * @param nombreProducto string
     * @param cantidadProducto int
     * @param precioProducto double
     * @param pesoProducto double
     * @param categoria String
     */
    public NoPerecedero(String nombreProducto, int cantidadProducto, double precioProducto, double pesoProducto, String categoria) {
        super(nombreProducto, cantidadProducto, precioProducto, pesoProducto);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public ArrayList<String> deProductoAListaString() {
        ArrayList<String> lista = super.deProductoAListaString();

        //fecha caducidad
        lista.add("");

        return lista;
    }
}
