package tipos.controladores;

import interfaces.IControladorATipos;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import tipos.modelos.GestorTipos;
import tipos.vistas.VentanaATipo;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ControladorATipos implements IControladorATipos {
    private static ControladorATipos instancia;
    private VentanaATipo ventana;

    private ControladorATipos() {
        this.ventana = new VentanaATipo(this);
    }


    public static ControladorATipos crear(){
        if (instancia == null)
            instancia = new ControladorATipos();

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

        GestorTipos gesTipos = GestorTipos.crear();
        String resultado = gesTipos.nuevoTipo(nombre);

        JOptionPane.showMessageDialog(ventana, resultado);
        if(resultado.equals("Tipo agregado de forma EXITOSA!")){
            txtNombre.setText("");
            ControladorTipos controlTipo = ControladorTipos.crear();
            controlTipo.actualizarTablaTipos();
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
