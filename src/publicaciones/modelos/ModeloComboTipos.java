/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import javax.swing.DefaultComboBoxModel;
import tipos.modelos.GestorTipos;
import tipos.modelos.Tipo;

/**
 *
 * @author Usuario
 */
public class ModeloComboTipos extends DefaultComboBoxModel{
    public ModeloComboTipos(){
        GestorTipos tipos = GestorTipos.crear();
        
        for(Tipo t: tipos.verTipos()){
            this.addElement(t.verNombre());
        }
    }
    
    public Tipo obtenerTipo(){
        GestorTipos tipos = GestorTipos.crear();
        String eleccion = (String)this.getSelectedItem();
        
        return tipos.verTipo(eleccion);
    }
}
