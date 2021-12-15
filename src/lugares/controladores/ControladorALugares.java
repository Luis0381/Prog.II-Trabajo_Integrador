package lugares.controladores;


import interfaces.IControladorALugares;
import lugares.modelos.GestorLugares;
import lugares.vistas.VentanaALugar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ControladorALugares implements IControladorALugares {
    private static ControladorALugares instancia;
    private final VentanaALugar ventana;

    private ControladorALugares() {
        this.ventana = new VentanaALugar(this);
    }


    public static ControladorALugares crear() {
        if (instancia == null)
            instancia = new ControladorALugares();

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

        GestorLugares gesLugares = GestorLugares.crear();
        String resultado = gesLugares.nuevoLugar(nombre);

        JOptionPane.showMessageDialog(ventana, resultado);
        if (resultado.equals("Lugar agregado de forma EXITOSA!")) {
            txtNombre.setText("");
            ControladorLugares controlLugar = ControladorLugares.crear();
            controlLugar.actualizarTablaLugares();
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

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnGuardar.doClick();
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            btnCancelar.doClick();
        }
    }
}
