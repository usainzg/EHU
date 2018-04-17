public class IdBombillaInexistente extends Exception {
    public IdBombillaInexistente() {
        super();
    }

    public IdBombillaInexistente(String msg) {
        super(msg);
    }

    public void SacarMensajeError() {
        System.out.print("Error");
    }
    
}