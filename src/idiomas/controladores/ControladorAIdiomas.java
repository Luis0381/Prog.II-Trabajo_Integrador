package idiomas.controladores;

import idiomas.modelos.GestorIdiomas;
import idiomas.vistas.VentanaAIdioma;
import interfaces.IControladorAIdiomas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ControladorAIdiomas implements IControladorAIdiomas {
    private static ControladorAIdiomas instancia;
    private VentanaAIdioma ventana;

    private ControladorAIdiomas() {
        this.ventana = new VentanaAIdioma(this);
    }


    public static ControladorAIdiomas crear(){
        if (instancia == null)
            instancia = new ControladorAIdiomas();

        return instancia;
    }

    public void mostrarVentana() {
        this.ventana.setVisible(true);
    }

    public void ocultarVentana() {
        this.ventana.setVisible(false);
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        javax.swing.JTextField txtNombre = ventana.getTxtNombre();

        String nombre = txtNombre.getText().trim();

        GestorIdiomas gesIdiomas = GestorIdiomas.crear();
        String resultado = gesIdiomas.nuevoIdioma(nombre);

        JOptionPane.showMessageDialog(ventana, resultado);
        if(resultado.equals("Idioma agregado de forma EXITOSA!")){
            txtNombre.setText("");
            ControladorIdiomas controlIdioma = ControladorIdiomas.crear();
            controlIdioma.actualizarTablaIdiomas();
            this.ocultarVentana();
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ocultarVentana();
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        javax.swing.JButton btnGuardar = this.ventana.getBtnGuardar();
        javax.swing.JButton btnCancelar = this.ventana.getBtnCancelar();

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnGuardar.doClick();
        }
        else if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            btnCancelar.doClick();
        }
    }
}
