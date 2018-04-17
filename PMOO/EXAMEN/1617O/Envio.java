import java.util.ArrayList;
import java.util.Date;

public class Envio {
    private String id;
    private Date fechaEnvio;
    private String localidadOrigen;
    private String localidadDestino;
    private GeoLoc localizacionActual;
    private ArrayList<GeoLoc> trayecto;

    public Envio (String id, Date fecha, String origen, String destino) {

    }

    public String getId () {

    }

    public void setTrayecto (ArrayList<GeoLoc> trayecto) throws ListaIlegalException, GeoLocDuplicadaException {
        if (trayecto.size() < 2) throw new ListaIlegalException();
        for (int i = 0; i < trayecto.size() - 2; i++) {
            for (int j = 0; i < trayecto.size() - 1; j++) {
                if (trayecto.get(i) == trayecto.get(j)) throw new GeoLocDuplicadaException();
            }
        }
        this.trayecto = trayecto;
        this.localizacionActual = trayecto.get(0);
    }

}