public class Director extends Musico {

    public Director(String pNombre, String pSexo) {
        super(pNombre, "Batuta", pSexo);
    }

    public void interpretar() {
        System.out.println("Tok tok tok: (se hace el silencio)");
    }

    public int getSUELDO() {
        return super.getSUELDO() + 1400;
    }
}
