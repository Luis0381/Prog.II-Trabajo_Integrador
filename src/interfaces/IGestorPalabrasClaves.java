/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import java.util.List;

import palabrasclaves.modelos.PalabraClave;

/**
 * @author Luis Medina Raed
 */
public interface IGestorPalabrasClaves {
    public String nuevaPalabraClave(String nombre);

    public PalabraClave verPalabraClave(String nombre);

    public String borrarPalabraClave(PalabraClave palabraClave);

    public List<PalabraClave> buscarPalabrasClaves(String nombre);

    public List<PalabraClave> verPalabrasClaves();

    public boolean existeEstaPalabraClave(PalabraClave palabraClave);
}
