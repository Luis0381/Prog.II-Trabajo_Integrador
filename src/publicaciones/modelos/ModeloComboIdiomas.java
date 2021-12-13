/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import idiomas.modelos.GestorIdiomas;
import idiomas.modelos.Idioma;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Usuario
 */
public class ModeloComboIdiomas extends DefaultComboBoxModel{
    public ModeloComboIdiomas() {
        GestorIdiomas idiomas = GestorIdiomas.crear();
        
        for(Idioma i: idiomas.verIdiomas()){
            this.addElement(i.verNombre());
        }
    }
    
    public Idioma obtenerIdioma(){
        GestorIdiomas idiomas = GestorIdiomas.crear();
        String eleccion = (String)this.getSelectedItem();
        
        return idiomas.verIdioma(eleccion);
    }
}
