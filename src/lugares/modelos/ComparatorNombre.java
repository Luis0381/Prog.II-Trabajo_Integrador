package lugares.modelos;

import java.util.Comparator;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ComparatorNombre implements Comparator<Lugar> {

    @Override
    public int compare(Lugar i1, Lugar i2) {
        return i1.verNombre().compareTo(i2.verNombre());
    }

}
