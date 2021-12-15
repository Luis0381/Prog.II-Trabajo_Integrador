/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public interface IControladorPublicaciones {
    String PUBLICACION_NUEVA = "Nueva Publicación";
    String PUBLICACION_MODIFICAR = "Modificar Publicación";
    String TITULO = "Publicaciones";
    String CONFIRMACION = "¿Desea borrar la publicación especificada?";

    /**
     * Acción a ejecutar cuando se selecciona el botón Nueva
     *
     * @param evt evento
     */
    void btnNuevaClic(ActionEvent evt);

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
     * Acción a ejecutar cuando la ventana obtenga el foco
     *
     * @param evt evento
     */
    void ventanaObtenerFoco(WindowEvent evt);

    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtTitulo
     *
     * @param evt evento
     */
    void txtTituloPresionarTecla(KeyEvent evt);
}
