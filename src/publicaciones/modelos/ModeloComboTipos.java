/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import interfaces.IGestorTipos;
import tipos.modelos.GestorTipos;
import tipos.modelos.Tipo;

import javax.swing.*;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ModeloComboTipos extends DefaultComboBoxModel {
    public ModeloComboTipos() {
        IGestorTipos gesTipos = GestorTipos.crear();
        for (Tipo tipo : gesTipos.verTipos()) {
            this.addElement(tipo);
        }
    }

    public Tipo obtenerTipo() {
        return (Tipo) this.getSelectedItem();
    }

}