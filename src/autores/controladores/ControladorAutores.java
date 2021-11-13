package autores.controladores;

import autores.vistas.VentanaAutores;
import interfaces.IControladorAutores;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class ControladorAutores implements IControladorAutores {
    private static ControladorAutores instancia;
    private VentanaAutores ventana;

    public ControladorAutores() {
        this.ventana = new VentanaAutores(this);
    }

    public static ControladorAutores crear() {
        if (instancia == null)
            instancia = new ControladorAutores();

        return instancia;
    }

    @Override
    public void btnNuevoProfesorClic(ActionEvent evt) {

    }

    @Override
    public void btnNuevoAlumnoClic(ActionEvent evt) {

    }

    @Override
    public void btnModificarProfesorClic(ActionEvent evt) {

    }

    @Override
    public void btnModificarAlumnoClic(ActionEvent evt) {

    }

    @Override
    public void btnBorrarProfesorClic(ActionEvent evt) {

    }

    @Override
    public void btnBorrarAlumnoClic(ActionEvent evt) {

    }

    @Override
    public void btnVolverClic(ActionEvent evt) {

    }

    @Override
    public void btnBuscarProfesorClic(ActionEvent evt) {

    }

    @Override
    public void btnBuscarAlumnoClic(ActionEvent evt) {

    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {

    }

    @Override
    public void txtApellidosProfesorPresionarTecla(KeyEvent evt) {

    }

    @Override
    public void txtApellidosAlumnoPresionarTecla(KeyEvent evt) {

    }
}
