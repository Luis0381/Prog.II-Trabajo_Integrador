/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import palabrasclaves.modelos.PalabraClave;

import java.util.List;

/**
 * @author Luis Medina Raed
 */
public interface IGestorPalabrasClaves {
    String nuevaPalabraClave(String nombre);

    PalabraClave verPalabraClave(String nombre);

    String borrarPalabraClave(PalabraClave palabraClave);

    List<PalabraClave> buscarPalabrasClaves(String nombre);

    List<PalabraClave> verPalabrasClaves();

    boolean existeEstaPalabraClave(PalabraClave palabraClave);
}
