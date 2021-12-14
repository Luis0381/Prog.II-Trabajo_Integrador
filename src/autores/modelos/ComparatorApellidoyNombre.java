package autores.modelos;

import java.util.Comparator;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ComparatorApellidoyNombre implements Comparator<Autor> {
    @Override
    public int compare(Autor a1, Autor a2) {
        String fn1 = ((Autor) a1).verApellidos();
        String fn2 = ((Autor) a2).verApellidos();

        int res = fn1.compareTo(fn2);
        if (res != 0) {
            return res;
        } else {
            String ln1 = ((Autor) a1).verNombres();
            String ln2 = ((Autor) a2).verNombres();
            return ln1.compareTo(ln2);
        }
    }
}
