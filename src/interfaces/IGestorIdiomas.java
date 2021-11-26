/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import idiomas.modelos.Idioma;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luis Medina Raed
 */
public interface IGestorIdiomas {
    public String nuevoIdioma(String nombre);

    public Idioma verIdioma(String nombre);

    public String borrarIdioma(Idioma idioma);

    public List<Idioma> buscarIdiomas(String nombre);

    public List<Idioma> verIdiomas();

    public boolean existeEsteIdioma(Idioma idioma);
}
