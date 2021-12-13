/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import javax.swing.DefaultComboBoxModel;

import interfaces.IGestorTipos;
import tipos.modelos.GestorTipos;
import tipos.modelos.Tipo;

/**
 * @author Usuario
 */
public class ModeloComboTipos extends DefaultComboBoxModel {
    public ModeloComboTipos() {
        IGestorTipos gesTipos = GestorTipos.crear();
        for (Tipo tipo : gesTipos.verTipos()) { //todos los tipos
            this.addElement(tipo);
        }
    }

    public Tipo obtenerTipo() {
        return (Tipo) this.getSelectedItem();
    }

    public void seleccionarTipo(Tipo tipo) {
        this.setSelectedItem(tipo);
    }
}