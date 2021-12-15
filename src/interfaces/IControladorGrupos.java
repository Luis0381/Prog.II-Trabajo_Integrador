/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;


public interface IControladorGrupos {
    String TITULO = "Grupos";
    String CONFIRMACION = "¿Desea borrar el grupo?";
    String TOOL_TIP_TEXT_SUPER_ADMINISTRADOR = "Todos los grupos definidos";
    String TOOL_TIP_TEXT_AUTOR = "Sólo los grupos del autor";

    /**
     * Acción a ejecutar cuando se selecciona el botón Nuevo
     *
     * @param evt evento
     */
    void btnNuevoClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Modificar
     *
     * @param evt evento
     */
    void btnModificarClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Borrar
     *
     * @param evt evento
     */
    void btnBorrarClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Volver
     *
     * @param evt evento
     */
    void btnVolverClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Buscar
     *
     * @param evt evento
     */
    void btnBuscarClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando la ventana obtiene el foco
     *
     * @param evt evento
     */
    void ventanaObtenerFoco(WindowEvent evt);

    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtNombre
     *
     * @param evt evento
     */
    void txtNombrePresionarTecla(KeyEvent evt);
}
