package autores.modelos;

import java.util.Comparator;

public class ComparatorNombre implements Comparator<Autor> {

    @Override
    public int compare(Autor a1, Autor a2) {
        return a1.verNombres().compareTo(a2.verNombres());
    }
}