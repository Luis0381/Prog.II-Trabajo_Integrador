package autores.modelos;

import java.util.Comparator;

public class ComparatorApellido implements Comparator<Autor> {
    @Override
    public int compare(Autor a1, Autor a2) {
        return a1.verApellidos().compareTo(a2.verApellidos());
    }
}
