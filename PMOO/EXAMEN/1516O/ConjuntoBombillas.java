import java.util.ArrayList;

public class ConjuntoBombillas {

    public static ConjuntoBombillas instance;

    private ArrayList<Bombilla> bombillas;

    public static ConjuntoBombillas getInstance() {
        if (instance == null) {
            instance = new ConjuntoBombillas ();
        }
        return instance;
    }

    private ConjuntoBombillas () {
        bombillas = new ArrayList<>();
    }

    public void EncenderBombilla (String id) throws IdBombillaInexistente, BombillaYaEncendida {
        for(Bombilla b: bombillas) {
            if (b.getId().equals(id)) {
                if (b.estaEncendida()) throw new BombillaYaEncendida();
                b.encender();
            }
            throw new IdBombillaInexistente();
        }

    }

    public Double consumoTotalMaximo () {

    }

    public void AnadirBombilla (Bombilla bombilla) {

    }
}