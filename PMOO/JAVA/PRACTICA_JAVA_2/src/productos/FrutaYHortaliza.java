package productos;

import java.util.ArrayList;

public class FrutaYHortaliza extends Perecedero {
    private String origen;
    /**
     * Constructor que setea solo el nombre
     *
     * @param nombre string
     * @param fecha  String
     */
    public FrutaYHortaliza(String nombre, String fecha, String origen) {
        super(nombre, fecha);
        this.setIVA_PRODUCTO(0.04);
        this.origen = origen;
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
    public FrutaYHortaliza(int codigoProducto, String nombreProducto, int cantidadProducto, double precioProducto,
                           double pesoProducto, String fecha, String origen) {
        super(codigoProducto, nombreProducto, cantidadProducto, precioProducto, pesoProducto, fecha);
        this.setIVA_PRODUCTO(0.04);
        this.origen = origen;
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
    public FrutaYHortaliza(String nombreProducto, int cantidadProducto, double precioProducto,
                           double pesoProducto, String fecha, String origen) {
        super(nombreProducto, cantidadProducto, precioProducto, pesoProducto, fecha);
        this.setIVA_PRODUCTO(0.04);
        this.origen = origen;
    }

    @Override
    public String toString() {
        return this.getCodigoProducto() + " " + this.getNombreProducto()
                + " " + this.getPrecioProducto() + " " + this.getCantidadProducto() + " "
                + this.getPesoProducto() + " " + this.getFechaCaducidad() + " " + this.origen + " "
                + this.getClass().getSimpleName() + " ";
    }

    @Override
    public double peso() {
        return this.getPesoProducto();
    }

    @Override
    public boolean esFragil() {
        return false;
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
        lista.add("Origen: " + origen);
        return lista;
    }
}
