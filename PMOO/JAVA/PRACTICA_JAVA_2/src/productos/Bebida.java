package productos;

import java.util.ArrayList;

public class Bebida extends Perecedero {
    private int graduacion;

    /**
     * Constructor que setea solo el nombre
     *
     * @param nombre string
     * @param fecha  String
     */
    public Bebida(String nombre, String fecha, int graduacion) {
        super(nombre, fecha);
        this.setIVA_PRODUCTO(0.10);
        this.graduacion = graduacion;
    }

    /**
     * Constructor que setea todos los atributos
     *
     * @param codigoProducto   int
     * @param nombreProducto   string
     * @param cantidadProducto int
     * @param precioProducto   double
     * @param pesoProducto     double
     * @param fecha            String
     */
    public Bebida(int codigoProducto, String nombreProducto, int cantidadProducto, double precioProducto,
                  double pesoProducto, String fecha, int graduacion) {
        super(codigoProducto, nombreProducto, cantidadProducto, precioProducto, pesoProducto, fecha);
        this.setIVA_PRODUCTO(0.10);
        this.graduacion = graduacion;
    }

    /**
     * Constructor que setea todos los atributos menos el codigo
     *
     * @param nombreProducto   string
     * @param cantidadProducto int
     * @param precioProducto   double
     * @param pesoProducto     double
     * @param fecha            String
     */
    public Bebida(String nombreProducto, int cantidadProducto, double precioProducto,
                  double pesoProducto, String fecha, int graduacion) {
        super(nombreProducto, cantidadProducto, precioProducto, pesoProducto, fecha);
        this.setIVA_PRODUCTO(0.10);
        this.graduacion = graduacion;
    }


    @Override
    public String toString() {
        return this.getCodigoProducto() + " " + this.getNombreProducto()
                + " " + this.getPrecioProducto() + " " + this.getCantidadProducto() + " "
                + this.getPesoProducto() + " " + this.getFechaCaducidad() + " " + this.graduacion + " "
                + this.getClass().getSimpleName() + " ";
    }

    @Override
    public double peso() {
        return this.getPesoProducto();
    }

    @Override
    public boolean esFragil() {
        return true;
    }

    @Override
    public double tarifaEnvio() {
        return super.tarifaEnvio();
    }

    @Override
    public void imprimirEnviable() {

    }

    @Override
    public ArrayList<String> deProductoAListaString() {
        ArrayList<String> lista = super.deProductoAListaString();
        lista.add("Graduacion: " + graduacion);
        return lista;
    }
}
