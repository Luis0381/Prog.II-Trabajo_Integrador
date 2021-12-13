/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import java.util.Comparator;

/**
 *
 * @author ALFRED
 */
public class ComparadorNombrePublicacion implements Comparator<Publicacion>{

    @Override
    public int compare(Publicacion p1, Publicacion p2) {
       return p1.getTitulo().compareTo(p2.getTitulo()); 
    }
  
}
