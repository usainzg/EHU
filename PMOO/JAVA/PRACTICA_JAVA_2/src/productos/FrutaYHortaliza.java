package productos;

import java.io.PrintWriter;
import java.util.ArrayList;

public class FrutaYHortaliza extends Perecedero implements IEnviable {
    private String origen;

    /**
     * Constructor que setea nombre, fecha caducidad y origen
     *
     * @param nombre nombre de la fruta hortaliza
     * @param fecha  fecha de caducidad
     * @param origen origen de la fruta hortaliza
     */
    public FrutaYHortaliza(String nombre, String fecha, String origen) {
        super(nombre, fecha);
        this.setIVA_PRODUCTO(0.04);
        this.origen = origen;
    }

    /**
     * Constructor que setea todos los atributos
     *
     * @param codigoProducto   codigo de la fruta hortaliza
     * @param nombreProducto   nombre de la fruta hortaliza
     * @param cantidadProducto cantidad de la fruta hortaliza
     * @param precioProducto   precio de la fruta hortaliza
     * @param pesoProducto     peso de la fruta hortaliza
     * @param fecha            fecha caducidad de la fruta hortaliza
     * @param origen           origen de la fruta hortaliza
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
     * @param nombreProducto   nombre de la fruta hortaliza
     * @param cantidadProducto cantidad de la fruta hortaliza
     * @param precioProducto   precio de la fruta hortaliza
     * @param pesoProducto     peso de la fruta hortaliza
     * @param fecha            fecha caducidad de la fruta hortaliza
     * @param origen           origen de la fruta hortaliza
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
    public void imprimirEnviable(PrintWriter printWriter) {
        printWriter.printf(
                IEnviable.FORMATO_IMPRESION,
                getCodigoProducto(), getNombreProducto(),
                getPesoProducto(), getPrecioProducto(),
                tarifaEnvio()
        );
        String fragil = (this.esFragil()) ? "Fragil!" : "";
        printWriter.printf("%16s", fragil);
    }

    @Override
    public ArrayList<String> deProductoAListaString() {
        ArrayList<String> lista = super.deProductoAListaString();
        lista.add("Origen: " + origen);
        return lista;
    }
}
