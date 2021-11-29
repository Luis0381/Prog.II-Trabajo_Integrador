package idiomas.controladores;

import idiomas.vistas.VentanaAIdioma;
import idiomas.vistas.VentanaIdiomas;
import interfaces.IControladorIdiomas;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class ControladorIdiomas implements IControladorIdiomas {
    private static ControladorIdiomas instancia;
    private VentanaIdiomas ventana;

    private ControladorIdiomas(VentanaIdiomas ventana) {
        this.ventana = new VentanaIdiomas(this);
    }

    public static ControladorIdiomas crear(){
        if (instancia == null)
            instancia = new ControladorIdiomas();
        return instancia;
    }

    @Override
    public void btnNuevaClic(ActionEvent evt) {

    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {

    }

    @Override
    public void btnVolverClic(ActionEvent evt) {

    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {

    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {

    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {

    }
}
