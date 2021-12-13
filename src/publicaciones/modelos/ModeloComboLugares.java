/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import javax.swing.DefaultComboBoxModel;
import lugares.modelos.GestorLugares;
import lugares.modelos.Lugar;

/**
 *
 * @author Usuario
 */
public class ModeloComboLugares extends DefaultComboBoxModel{
    public ModeloComboLugares(){
        GestorLugares lugares = GestorLugares.crear();
        
        for(Lugar l: lugares.verLugares()){
            this.addElement(l.verNombre());
        }
    }
    
    public Lugar obtenerLugar(){
        GestorLugares lugares = GestorLugares.crear();
        String eleccion = (String)this.getSelectedItem();
        
        return lugares.verLugar(eleccion);
    }
}
