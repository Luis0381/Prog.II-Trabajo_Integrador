package grupos.modelos;

import java.util.Comparator;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ComparatorNombre implements Comparator<Grupo> {

    @Override
    public int compare(Grupo g1, Grupo g2) {
        return g1.verNombre().compareTo(g2.verNombre());
    }
}
