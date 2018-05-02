public abstract class Cantante extends Musico {
    private int SUELDO = 1000;

    public Cantante(String pNombre, String pInstrumento, String pSexo) {
        super(pNombre, pInstrumento, pSexo);
    }

    public int getSUELDO() {
        return SUELDO;
    }
}
