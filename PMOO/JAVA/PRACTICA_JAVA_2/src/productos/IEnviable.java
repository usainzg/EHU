package productos;

import java.io.PrintWriter;

public interface IEnviable {

    // Formato que se utiliza para escribir en el informe de enviables
    String FORMATO_IMPRESION = "%5d %26s %12.2f %14.2f %15.2f";

    /**
     * Devuelve el peso del enviable
     * @return peso
     */
    double peso();

    /**
     * Devuelve si el enviable es fragil o no
     * @return booleano dependiendo si es fragil o no
     */
    boolean esFragil();

    /**
     * Devuelve la tarifa de envio del enviable
     * @return tarifa
     */
    double tarifaEnvio();

    /**
     * Escribe mediante un PrintWriter el enviable (en el formato elegido)
     * @param printWriter printWriter asociado a un archivo de texto
     */
    void imprimirEnviable(PrintWriter printWriter);
}
