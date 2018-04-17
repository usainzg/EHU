import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException {
        Bombilla b1 = new Bombilla("sa-10", 300);
        ConjuntoBombillas conjuntoBombillas = ConjuntoBombillas.getInstance();
        conjuntoBombillas.AnadirBombilla(bombilla);

        try {
            conjuntoBombillas.EncenderBombilla(id);
        } catch (IdBombillaInexistente e) {
            e.SacarMensajeError();
        } catch (BombillaYaEncendida ex) { }
    
    }
}