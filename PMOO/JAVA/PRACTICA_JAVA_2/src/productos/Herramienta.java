package productos;

import java.io.PrintWriter;
import java.util.ArrayList;

public class Herramienta extends NoPerecedero implements IEnviable {

    /**
     * Constructor que setea nombre y categoria
     *
     * @param nombre    nombre de la herramienta
     * @param categoria categoria de la herramienta
     */
    public Herramienta(String nombre, String categoria) {
        super(nombre, categoria);
    }

    /**
     * Constructor que setea todos los atributos
     *
     * @param codigoProducto   codigo de la herramienta
     * @param nombreProducto   nombre de la herramienta
     * @param cantidadProducto cantidad de la herramienta
     * @param precioProducto   precio de la herramienta
     * @param pesoProducto     peso de la herramienta
     * @param categoria        categoria de la herramienta
     */
    public Herramienta(int codigoProducto, String nombreProducto, int cantidadProducto, double precioProducto, double pesoProducto, String categoria) {
        super(codigoProducto, nombreProducto, cantidadProducto, precioProducto, pesoProducto, categoria);
    }

    /**
     * Constructor que setea todos los atributos menos el codigo
     *
     * @param nombreProducto   nombre de la herramienta
     * @param cantidadProducto cantidad de la herramienta
     * @param precioProducto   precio de la herramienta
     * @param pesoProducto     peso de la herramienta
     * @param categoria        categoria de la herramienta
     */
    public Herramienta(String nombreProducto, int cantidadProducto, double precioProducto, double pesoProducto, String categoria) {
        super(nombreProducto, cantidadProducto, precioProducto, pesoProducto, categoria);
    }

    @Override
    public String toString() {
        return this.getCodigoProducto() + " " + this.getNombreProducto()
                + " " + this.getPrecioProducto() + " " + this.getCantidadProducto() + " "
                + this.getPesoProducto() + " " + this.getCategoria() + " " + this.getClass().getSimpleName() + " ";
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
        return 3.71;
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

        // otros
        lista.add("");

        return lista;
    }
}
