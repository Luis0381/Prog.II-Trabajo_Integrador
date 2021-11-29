package palabrasclaves.modelos;

import java.util.Comparator;

public class ComparatorNombre implements Comparator<PalabraClave> {

    @Override
    public int compare(PalabraClave p1, PalabraClave p2) {
        return p1.verNombre().compareTo(p2.verNombre());
    }

}
