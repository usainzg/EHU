public class Saxo extends Instrumentista {
    private static final String INSTRUMENTO = "saxo";

    public Saxo(String pNombre, String pSexo) {
        super(pNombre, INSTRUMENTO, pSexo);
    }

    @Override
    public void interpretar() {
        System.out.println("Piribiiii-piriiii");
    }
}
