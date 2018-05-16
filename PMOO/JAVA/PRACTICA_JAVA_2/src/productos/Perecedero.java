package productos;

import java.util.ArrayList;

public abstract class Perecedero extends Producto implements IEnviable {
    private String fechaCaducidad;

    public Perecedero() {

    }

    /**
     * Constructor que setea solo el nombre
     * @param nombre string
     * @param fecha String
     */
    Perecedero(String nombre, String fecha) {
        super(nombre);
        this.fechaCaducidad = fecha;
    }

    /**
     * Constructor que setea todos los atributos
     * @param codigoProducto int
     * @param nombreProducto string
     * @param cantidadProducto int
     * @param precioProducto double
     * @param pesoProducto double
     * @param fecha String
     */
    Perecedero(int codigoProducto, String nombreProducto, int cantidadProducto, double precioProducto,
                    double pesoProducto, String fecha) {
        super(codigoProducto, nombreProducto, cantidadProducto, precioProducto, pesoProducto);
        this.fechaCaducidad = fecha;
    }

    /**
     * Constructor que setea todos los atributos menos el codigo
     * @param nombreProducto string
     * @param cantidadProducto int
     * @param precioProducto double
     * @param pesoProducto double
     * @param fecha String
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
