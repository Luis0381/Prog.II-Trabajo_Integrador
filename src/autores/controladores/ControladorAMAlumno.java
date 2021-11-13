package autores.controladores;

import autores.vistas.VentanaAMAlumno;
import interfaces.IControladorAMAlumno;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ControladorAMAlumno implements IControladorAMAlumno {
    private static ControladorAMAlumno instancia;
    private VentanaAMAlumno ventana;

    private ControladorAMAlumno() {
        this.ventana = new VentanaAMAlumno(this);
    }

    public static ControladorAMAlumno crear (){
        if (instancia == null)
            instancia = new ControladorAMAlumno();

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
    public void txtCXPresionarTecla(KeyEvent evt) {

    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {

    }

    @Override
    public void passRepetirClavePresionarTecla(KeyEvent evt) {

    }
}
