/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public interface IControladorAutores {
    String PROFESOR_NUEVO = "Nuevo Profesor";
    String PROFESOR_MODIFICAR = "Modificar Profesor";
    String ALUMNO_NUEVO = "Nuevo Alumno";
    String ALUMNO_MODIFICAR = "Modificar Alumno";
    String TITULO = "Autores";
    String CONFIRMACION_PROFESOR = "¿Desea borrar el profesor especificado?";
    String CONFIRMACION_ALUMNO = "¿Desea borrar el alumno especificado?";

    /**
     * Acción a ejecutar cuando se selecciona el botón Nuevo Profesor
     *
     * @param evt evento
     */
    void btnNuevoProfesorClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Nuevo Alumno
     *
     * @param evt evento
     */
    void btnNuevoAlumnoClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Modificar Profesor
     *
     * @param evt evento
     */
    void btnModificarProfesorClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Modificar Alumno
     *
     * @param evt evento
     */
    void btnModificarAlumnoClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Borrar Profesor
     *
     * @param evt evento
     */
    void btnBorrarProfesorClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Borrar Alumno
     *
     * @param evt evento
     */
    void btnBorrarAlumnoClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Volver
     *
     * @param evt evento
     */
    void btnVolverClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Buscar Profesor
     *
     * @param evt evento
     */
    void btnBuscarProfesorClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Buscar Alumno
     *
     * @param evt evento
     */
    void btnBuscarAlumnoClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando la ventana obtenga el foco
     *
     * @param evt evento
     */
    void ventanaObtenerFoco(WindowEvent evt);

    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtApellidosProfesor
     *
     * @param evt evento
     */
    void txtApellidosProfesorPresionarTecla(KeyEvent evt);

    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtApellidosAlumno
     *
     * @param evt evento
     */
    void txtApellidosAlumnoPresionarTecla(KeyEvent evt);
}
