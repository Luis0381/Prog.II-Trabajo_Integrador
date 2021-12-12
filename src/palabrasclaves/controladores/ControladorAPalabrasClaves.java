package palabrasclaves.controladores;

import interfaces.IControladorAPalabrasClaves;
import palabrasclaves.modelos.GestorPalabrasClaves;
import palabrasclaves.vistas.VentanaAPalabrasClaves;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ControladorAPalabrasClaves implements IControladorAPalabrasClaves {
    private static ControladorAPalabrasClaves instancia;
    private VentanaAPalabrasClaves ventana;

    private ControladorAPalabrasClaves() {
        this.ventana = new VentanaAPalabrasClaves(this);
    }


    public static ControladorAPalabrasClaves crear(){
        if (instancia == null)
            instancia = new ControladorAPalabrasClaves();

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
        JTextField txtNombre = ventana.getTxtNombre();

        String nombre = txtNombre.getText().trim();

        GestorPalabrasClaves gestorPalabrasClaves = GestorPalabrasClaves.crear();
        String resultado = gestorPalabrasClaves.nuevaPalabraClave(nombre);

        JOptionPane.showMessageDialog(ventana, resultado);
        if(resultado.equals("Palabras claves añadidas con EXITO!")){
            txtNombre.setText("");
            ControladorPalabrasClaves controlPalabrasClaves = ControladorPalabrasClaves.crear();
            controlPalabrasClaves.actualizarTablaPalabrasClaves();
            this.ocultarVentana();
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ocultarVentana();
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        JButton btnGuardar = this.ventana.getBtnGuardar();
        JButton btnCancelar = this.ventana.getBtnCancelar();

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnGuardar.doClick();
        }
        else if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            btnCancelar.doClick();
        }
    }
}
