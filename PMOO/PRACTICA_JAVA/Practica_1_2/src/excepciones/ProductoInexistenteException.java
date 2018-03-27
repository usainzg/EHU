package excepciones;

public class ProductoInexistenteException extends Exception {

    public ProductoInexistenteException() {
    }

    public void SacarError() {
        System.out.println("ERROR: Producto inexistente.");
    }
}
