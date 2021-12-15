/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public interface IControladorAMPublicacion {
    String TITULO_NUEVA = "Nueva publicación";
    String TITULO_MODIFICAR = "Modificar publicación";

    /**
     * Acción a ejecutar cuando se selecciona el botón Guardar
     *
     * @param evt evento
     */
    void btnGuardarClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Cancelar
     *
     * @param evt evento
     */
    void btnCancelarClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtTitulo
     *
     * @param evt evento
     */
    void txtTituloPresionarTecla(KeyEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Todas Las Palabras Claves
     *
     * @param evt evento
     */
    void btnTodasLasPalabrasClavesClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Ninguna Palabra Clave
     *
     * @param evt evento
     */
    void btnNingunaPalabraClaveClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Abrir
     *
     * @param evt evento
     */
    void btnAbrirClic(ActionEvent evt);

}
