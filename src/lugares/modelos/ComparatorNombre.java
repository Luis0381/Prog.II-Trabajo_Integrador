package lugares.modelos;

import java.util.Comparator;

public class ComparatorNombre implements Comparator<Lugar> {
    @Override
    public int compare(Lugar l1, Lugar l2) {
        return l1.verNombre().compareTo(l2.verNombre());
    }
}