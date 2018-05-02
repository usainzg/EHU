public class Bajo extends Instrumentista {

    private static final String INSTRUMENTO = "bajo";
    private int SUELDO = 1000;

    public Bajo(String pNombre, String pSexo) {
        super(pNombre, INSTRUMENTO, pSexo);
    }

    @Override
    public void interpretar() {
        System.out.println("Blooom-bloooom");
    }

    public int getSUELDO() {
        return SUELDO;
    }
}
