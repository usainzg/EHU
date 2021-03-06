package productos;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * @author PMOO 2018:
 */

public abstract class Producto implements Comparable<Producto> {

    private double IVA_PRODUCTO;

    private int codigoProducto;
    private String nombreProducto;
    private int cantidadProducto;
    private double precioProducto;
    private double pesoProducto;

    /**
     * Constructor por defecto, no inicializa
     */
    public Producto() {
    }

    /**
     * Constructor que setea solo el nombre y el IVA a 0.21
     *
     * @param nombre nombre del producto
     */
    public Producto(String nombre) {
        this.nombreProducto = nombre;
        IVA_PRODUCTO = 0.21;
    }

    /**
     * Constructor que setea todos los atributos
     *
     * @param codigoProducto   codigo producto
     * @param nombreProducto   nombre del producto
     * @param cantidadProducto cantidad del producto
     * @param precioProducto   precio producto
     * @param pesoProducto     peso producto
     */
    public Producto(int codigoProducto, String nombreProducto, int cantidadProducto, double precioProducto,
                    double pesoProducto) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioProducto = precioProducto;
        this.pesoProducto = pesoProducto;
        IVA_PRODUCTO = 0.21;
    }

    /**
     * Constructor que setea todos los atributos menos el codigo
     *
     * @param nombreProducto   nombre del producto
     * @param cantidadProducto cantidad del producto
     * @param precioProducto   precio del producto
     * @param pesoProducto     peso del producto
     */
    public Producto(String nombreProducto, int cantidadProducto, double precioProducto, double pesoProducto) {
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioProducto = precioProducto;
        this.pesoProducto = pesoProducto;
        IVA_PRODUCTO = 0.21;
    }

    /**
     * Devuelve los atributos en forma de lista
     *
     * @return lista
     */
    public ArrayList<String> deProductoAListaString() {
        ArrayList<String> lista = new ArrayList<>();
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        lista.add(Integer.toString(codigoProducto));
        lista.add(nombreProducto);
        lista.add(decimalFormat.format(precioProducto));
        lista.add(decimalFormat.format(precioConIva()));
        lista.add(Integer.toString(cantidadProducto));
        return lista;
    }


    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }


    public String getNombreProducto() {
        return nombreProducto;
    }


    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }


    public int getCantidadProducto() {
        return cantidadProducto;
    }


    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }


    public double getPrecioProducto() {
        return precioProducto;
    }


    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }


    public double getPesoProducto() {
        return pesoProducto;
    }


    public void setPesoProducto(double pesoProducto) {
        this.pesoProducto = pesoProducto;
    }

    public double getIVA() {
        return this.IVA_PRODUCTO;
    }

    public void setIVA_PRODUCTO(double iva) {
        this.IVA_PRODUCTO = iva;
    }

    /**
     * Devuelve el precio con el iva anadido
     *
     * @return double
     */
    private double precioConIva() {
        return this.precioProducto * (1 + IVA_PRODUCTO);
    }

    @Override
    public String toString() {
        return codigoProducto + " " + nombreProducto
                + " " + cantidadProducto + " " + precioProducto + " "
                + pesoProducto + " ";
    }

    @Override
    public int compareTo(Producto o) {
        return (o.getCodigoProducto() < codigoProducto) ? 1 : -1;
    }
}
