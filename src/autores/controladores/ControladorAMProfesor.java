package autores.controladores;

import autores.vistas.VentanaAMProfesor;
import interfaces.IControladorAMProfesor;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ControladorAMProfesor implements IControladorAMProfesor {
    private static ControladorAMProfesor instancia;
    private VentanaAMProfesor ventana;

    private ControladorAMProfesor(){
        this.ventana = new VentanaAMProfesor(this);
    }

    public static ControladorAMProfesor crear(){
        if (instancia == null)
            instancia = new ControladorAMProfesor();

        return instancia;
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {

    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {

    }

    @Override
    public void txtApellidosPresionarTecla(KeyEvent evt) {

    }

    @Override
    public void txtNombresPresionarTecla(KeyEvent evt) {

    }

    @Override
    public void txtDocumentoPresionarTecla(KeyEvent evt) {

    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {

    }

    @Override
    public void passRepetirClavePresionarTecla(KeyEvent evt) {

    }
}
