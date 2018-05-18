package productos;

import java.util.ArrayList;

public abstract class NoPerecedero extends Producto {
    private String categoria;

    /**
     * Constructor vacio
     */
    public NoPerecedero() {
    }

    /**
     * Constructor que setea el nombre y la categoria
     *
     * @param nombre    nombre producto
     * @param categoria categoria producto
     */
    public NoPerecedero(String nombre, String categoria) {
        super(nombre);
        this.categoria = categoria;
    }

    /**
     * Constructor que setea todos los atributos
     *
     * @param codigoProducto   codigo producto
     * @param nombreProducto   nombre producto
     * @param cantidadProducto cantidad producto
     * @param precioProducto   precio procucto
     * @param pesoProducto     peso producto
     * @param categoria        categoria producto
     */
    public NoPerecedero(int codigoProducto, String nombreProducto, int cantidadProducto, double precioProducto,
                        double pesoProducto, String categoria) {
        super(codigoProducto, nombreProducto, cantidadProducto, precioProducto, pesoProducto);
        this.categoria = categoria;
    }

    /**
     * Constructor que setea todos los atributos menos el codigo
     *
     * @param nombreProducto   nombre producto
     * @param cantidadProducto cantidad producto
     * @param precioProducto   precio procucto
     * @param pesoProducto     peso producto
     * @param categoria        categoria producto
     */
    public NoPerecedero(String nombreProducto, int cantidadProducto, double precioProducto, double pesoProducto, String categoria) {
        super(nombreProducto, cantidadProducto, precioProducto, pesoProducto);
        this.categoria = categoria;
    }

    /**
     * Metodo que devuele la categoria del producto no-perecedero
     * @return categoria
     */
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
