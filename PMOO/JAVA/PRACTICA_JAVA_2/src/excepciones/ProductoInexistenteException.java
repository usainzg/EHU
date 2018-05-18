package excepciones;

public class ProductoInexistenteException extends Exception {

    public ProductoInexistenteException() {
    }

    /**
     * Metodo para sacar mensaje de error
     */
    public void SacarError() {
        System.out.println("ERROR: Producto inexistente.");
    }
}
