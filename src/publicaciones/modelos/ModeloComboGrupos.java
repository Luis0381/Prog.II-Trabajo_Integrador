/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import autores.modelos.GestorAutores;
import autores.modelos.Profesor;
import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import idiomas.modelos.Idioma;

import javax.swing.DefaultComboBoxModel;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ModeloComboGrupos extends DefaultComboBoxModel{
    public ModeloComboGrupos(){
        GestorGrupos grupos = GestorGrupos.crear();
        GestorAutores autores = GestorAutores.crear();

        Profesor p = autores.verProfesores().get(0);

        for(MiembroEnGrupo mg: p.verGrupos()){
            this.addElement(mg.verGrupo().verNombre());
        }
    }

    public Grupo obtenerGrupo(){
        String eleccion = (String)this.getSelectedItem();

        GestorGrupos grupos = GestorGrupos.crear();
        return grupos.verGrupo(eleccion);
    }

}
