/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import lugares.modelos.Lugar;

import java.util.List;

/**
 * @author Luis Medina Raed
 */
public interface IGestorLugares {
    String nuevoLugar(String nombre);

    Lugar verLugar(String nombre);

    String borrarLugar(Lugar lugar);

    List<Lugar> buscarLugares(String nombre);

    List<Lugar> verLugares();

    boolean existeEsteLugar(Lugar lugar);
}
