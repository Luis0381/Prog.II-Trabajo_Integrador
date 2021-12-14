/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipos.modelos;

import java.util.Comparator;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ComparatorNombre implements Comparator<Tipo> {

    @Override
    public int compare(Tipo o1, Tipo o2) {
        return o1.verNombre().compareTo(o2.verNombre());
    }
}
