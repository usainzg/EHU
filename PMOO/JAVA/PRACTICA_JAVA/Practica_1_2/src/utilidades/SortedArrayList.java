package utilidades;

import java.util.ArrayList;
import java.util.Collections;

public class SortedArrayList<Producto> extends ArrayList<Producto> {

    /**
     * Metodo auxiliar para insertar los productos ordenados
     * @param obj producto
     */
    @SuppressWarnings("unchecked")
    public void insertarOrdenado(Producto obj) {
        add(obj);
        Comparable<Producto> cmp = (Comparable<Producto>) obj;
        for (int i = size()-1; i > 0 && cmp.compareTo(get(i-1)) < 0; i--) {
            Collections.swap(this, i, i-1);
        }
    }
}
