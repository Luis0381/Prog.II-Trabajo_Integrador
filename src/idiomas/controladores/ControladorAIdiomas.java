package idiomas.controladores;

import idiomas.vistas.VentanaAIdioma;
import interfaces.IControladorAIdiomas;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ControladorAIdiomas implements IControladorAIdiomas {
    private static ControladorAIdiomas instancia;
    private VentanaAIdioma ventana;

    private ControladorAIdiomas(VentanaAIdioma ventana) {
        this.ventana = new VentanaAIdioma(this);
    }

    public static ControladorAIdiomas crear(){
        if (instancia == null)
            instancia = new ControladorAIdiomas;
        return instancia;
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {

    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {

    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {

    }
}
