package idiomas.modelos;

import java.util.Comparator;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ComparatorNombre implements Comparator<Idioma> {

    @Override
    public int compare(Idioma i1, Idioma i2) {
        return i1.verNombre().compareTo(i2.verNombre());
    }

}
