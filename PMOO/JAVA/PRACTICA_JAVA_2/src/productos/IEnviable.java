package productos;

import java.io.PrintWriter;

public interface IEnviable {
    String FORMATO_IMPRESION = "%5d %26s %12.2f %14.2f %15.2f";

    double peso();

    boolean esFragil();

    double tarifaEnvio();

    void imprimirEnviable(PrintWriter printWriter);
}
