package publicaciones.modelos;

import java.util.Comparator;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ComparatorNombre implements Comparator<Publicacion> {
    @Override
    public int compare(Publicacion p1, Publicacion p2) {
        return p1.getTitulo().compareTo(p2.getTitulo());
    }

}