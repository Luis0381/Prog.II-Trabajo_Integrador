/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import javax.swing.DefaultComboBoxModel;

import interfaces.IGestorLugares;
import lugares.modelos.GestorLugares;
import lugares.modelos.Lugar;

public class ModeloComboLugares extends DefaultComboBoxModel {

    public ModeloComboLugares() {
        IGestorLugares gesLugares = GestorLugares.crear();
        for (Lugar lugar : gesLugares.verLugares()) {
            this.addElement(lugar);
        }
    }

    public Lugar obtenerLugar() {
        return (Lugar) this.getSelectedItem();
    }

    public void seleccionarLugar(Lugar lugar) {
        this.setSelectedItem(lugar);
    }
}
