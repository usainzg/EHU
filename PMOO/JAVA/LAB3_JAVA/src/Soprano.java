public class Soprano extends Cantante {

    private int SUELDO = 1000;
    private boolean esTallaInternacional;

    public Soprano(String pNombre, String pSexo, boolean esTallaInternacional) {
        super(pNombre, "", pSexo);
        this.esTallaInternacional = esTallaInternacional;
        setSUELDO();
    }

    private void setSUELDO() {
        if (esTallaInternacional) {
            SUELDO = (int) (SUELDO + (SUELDO * 0.3));
        }
    }

    public int getSUELDO() {
        return SUELDO;
    }

    @Override
    public void interpretar() {
        System.out.println("Li-li-li-liiiiii");
    }
}
