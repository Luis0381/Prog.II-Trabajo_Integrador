/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import tipos.modelos.Tipo;

import java.util.List;

/**
 * @author Luis Medina Raed
 */
public interface IGestorTipos {
    String nuevoTipo(String nombre);

    List<Tipo> verTipos();

    Tipo verTipo(String nombre);

    String borrarTipo(Tipo tipo);

    List<Tipo> buscarTipos(String nombre);

    boolean existeEsteTipo(Tipo tipo);
}
