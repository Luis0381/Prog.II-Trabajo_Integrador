package publicaciones.modelos;

import java.util.Comparator;

public class ComparatorNombre implements Comparator<Publicacion> {

    @Override
    public int compare(Publicacion p1, Publicacion p2) {
        return p1.getTitulo().compareTo(p2.getTitulo());
    }

}