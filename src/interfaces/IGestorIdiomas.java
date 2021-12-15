/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import idiomas.modelos.Idioma;

import java.util.List;

/**
 * @author Luis Medina Raed
 */
public interface IGestorIdiomas {
    String nuevoIdioma(String nombre);

    Idioma verIdioma(String nombre);

    String borrarIdioma(Idioma idioma);

    List<Idioma> buscarIdiomas(String nombre);

    List<Idioma> verIdiomas();

    boolean existeEsteIdioma(Idioma idioma);
}
