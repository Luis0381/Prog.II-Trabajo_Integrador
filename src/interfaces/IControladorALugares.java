package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public interface IControladorALugares {
    String TITULO = "Nuevo Lugar";

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
     * Acción a ejecutar cuando se presiona una tecla en el campo txtNombre
     *
     * @param evt evento
     */
    void txtNombrePresionarTecla(KeyEvent evt);
}