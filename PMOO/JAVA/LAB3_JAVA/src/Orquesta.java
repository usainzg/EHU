import java.util.ArrayList;

public class Orquesta {
    private static Orquesta instancia;

    private String nombre;
    private ArrayList<Musico> musicosArr;

    private Orquesta(String nombre) {
        this.nombre = nombre;
        musicosArr = new ArrayList<>();
    }

    public static Orquesta getInstance(String nombre) {
        if (instancia == null) {
            instancia = new Orquesta(nombre);
        }
        return instancia;
    }

    public void contratar(Musico musico) {
        try {
            musico.contratar();
            musico.firmarContrato();
            musicosArr.add(musico);
        } catch (Musico.MusicoYaContratado musicoYaContratado) {
            musicoYaContratado.sacarMensaje(musico.getNombre(), musico.esHombre());
        }

    }

    public void actuar() {
        System.out.println("Esta es la actuación de la orquesta: " + nombre);
        for (Musico musico : musicosArr) {
            System.out.println("- " + musico.getNombre() + ": ");
            musico.interpretar();
        }
    }


    public int getHombres() {
        int cont = 0;
        for (Musico musico : musicosArr) {
            if (musico.esHombre())
                cont++;
        }
        return cont;
    }

    public int getMujeres() {
        int cont = 0;
        for (Musico musico : musicosArr) {
            if (!musico.esHombre())
                cont++;
        }
        return cont;
    }

    public int getPresupuestoContratacion() {
        int cantidad = 0;
        for (Musico musico : musicosArr) {
            cantidad += musico.getSUELDO();
        }
        return cantidad;
    }
}
