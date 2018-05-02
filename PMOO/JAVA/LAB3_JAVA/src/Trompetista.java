public class Trompetista extends Instrumentista {

    private static final String INSTRUMENTO = "trompeta";

    private final int SUELDO = 900;

    public Trompetista(String pNombre, String pSexo) {
        super(pNombre, INSTRUMENTO, pSexo);
    }

    @Override
    public void interpretar() {
        System.out.println("Tu-ru-ru-tu-ru-ru");
    }

    @Override
    public int getSUELDO() {
        return SUELDO;
    }
}
