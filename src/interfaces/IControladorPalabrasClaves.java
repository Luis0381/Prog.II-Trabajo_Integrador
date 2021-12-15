package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public interface IControladorPalabrasClaves {
    String TITULO = "Palabras Claves";
    String CONFIRMACION = "¿Desea borrar la palabra clave especificada?";

    /**
     * Acción a ejecutar cuando se selecciona el botón Nueva
     *
     * @param evt evento
     */
    void btnNuevoClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Borrar
     *
     * @param evt evento
     */
    void btnEliminarClic(ActionEvent evt);

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