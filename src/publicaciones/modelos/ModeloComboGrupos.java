/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import autores.modelos.Autor;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Usuario
 */
public class ModeloComboGrupos extends DefaultComboBoxModel {

    public ModeloComboGrupos() {
        for(MiembroEnGrupo meg : obtenerGrupo().verMiembros())
            this.addElement(meg.verGrupo());
    }

    public Grupo obtenerGrupo() {
        return (Grupo)this.getSelectedItem();
    }

    public void seleccionarGrupo(Grupo grupo) {
        this.setSelectedItem(grupo);
    }
}
