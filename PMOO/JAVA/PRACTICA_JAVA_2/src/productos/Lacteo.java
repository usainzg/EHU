package productos;

import java.io.PrintWriter;
import java.util.ArrayList;

public class Lacteo extends Perecedero implements IEnviable {
    private String lote;

    /**
     * Constructor que setea solo el nombre
     * @param nombre string
     */
    public Lacteo(String nombre, String fecha, String lote) {
        super(nombre, fecha);
        this.setIVA_PRODUCTO(0.04);
        this.lote = lote;
    }

    /**
     * Constructor que setea todos los atributos
     * @param codigoProducto int
     * @param nombreProducto string
     * @param cantidadProducto int
     * @param precioProducto double
     * @param pesoProducto double
     */
    public Lacteo(int codigoProducto, String nombreProducto, int cantidadProducto, double precioProducto,
                    double pesoProducto, String fecha, String lote) {
        super(codigoProducto, nombreProducto, cantidadProducto, precioProducto, pesoProducto, fecha);
        this.setIVA_PRODUCTO(0.04);
        this.lote = lote;
    }

    /**
     * Constructor que setea todos los atributos menos el codigo
     * @param nombreProducto string
     * @param cantidadProducto int
     * @param precioProducto double
     * @param pesoProducto double
     */
    public Lacteo(String nombreProducto, int cantidadProducto, double precioProducto, double pesoProducto, String fecha, String lote) {
        super(nombreProducto, cantidadProducto, precioProducto, pesoProducto, fecha);
        this.setIVA_PRODUCTO(0.04);
        this.lote = lote;
    }

    @Override
    public String toString() {
        return this.getCodigoProducto() + " " + this.getNombreProducto()
                + " " + this.getPrecioProducto() + " " + this.getCantidadProducto() + " "
                + this.getPesoProducto() + " " + this.getFechaCaducidad() + " " + this.lote + " "
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
        lista.add("Lote: " + lote);
        return lista;
    }
}
