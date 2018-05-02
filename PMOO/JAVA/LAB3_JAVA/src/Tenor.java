public class Tenor extends Cantante {

    public Tenor(String pNombre, String pSexo) {
        super(pNombre, "", pSexo);
    }

    @Override
    public void interpretar() {
        System.out.println("La-la-la-laaaaa");
    }
}
