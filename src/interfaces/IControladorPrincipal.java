/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.event.ActionEvent;


public interface IControladorPrincipal {
    String CONFIRMACION = "¿Desea terminar la sesión?";
    String TITULO = "Repositorios";

    /**
     * Acción a ejecutar cuando se selecciona el botón Palabras claves
     *
     * @param evt evento
     */
    void btnPalabrasClavesClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Lugares
     *
     * @param evt evento
     */
    void btnLugaresClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Idiomas
     *
     * @param evt evento
     */
    void btnIdiomasClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Tipos
     *
     * @param evt evento
     */
    void btnTiposClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Grupos
     *
     * @param evt evento
     */
    void btnGruposClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Autores
     *
     * @param evt evento
     */
    void btnAutoresClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Publicaciones
     *
     * @param evt evento
     */
    void btnPublicacionesClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Salir
     *
     * @param evt evento
     */
    void btnSalirClic(ActionEvent evt);
}
