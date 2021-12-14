package idiomas.controladores;

import idiomas.modelos.GestorIdiomas;
import idiomas.modelos.ModeloTablaIdiomas;
import idiomas.vistas.VentanaIdiomas;
import interfaces.IControladorIdiomas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ControladorIdiomas implements IControladorIdiomas {
    private static ControladorIdiomas instancia;
    private VentanaIdiomas ventana;

    private ControladorIdiomas() {
        this.ventana = new VentanaIdiomas(this);
    }

    public static ControladorIdiomas crear(){
        if (instancia == null)
            instancia = new ControladorIdiomas();
        return instancia;
    }

    public VentanaIdiomas getVentana() {
        return ventana;
    }

    public void mostrarVentana() {
        this.ventana.setVisible(true);
    }

    public void ocultarVentana() {
        this.ventana.setVisible(false);
    }

    public void actualizarTablaIdiomas(){
        javax.swing.JTable tablaIdiomas = this.ventana.getTablaIdiomas();
        javax.swing.JButton btnBorrarIdioma= this.ventana.getBtnEliminar();
        javax.swing.JButton btnBuscarIdioma= this.ventana.getBtnBuscar();
        
        btnBuscarIdioma.setEnabled(true);
        tablaIdiomas.setModel(new ModeloTablaIdiomas());

        if(tablaIdiomas.getRowCount() == 0){
            btnBorrarIdioma.setEnabled(false);
        }
        else{
            btnBorrarIdioma.setEnabled(true);
        }
    }

    private void filtrarTablaIdiomas(String nombreFiltrar){
        javax.swing.JTable tablaIdiomas = this.ventana.getTablaIdiomas();
        javax.swing.JButton btnBorrarIdioma = this.ventana.getBtnEliminar();
        javax.swing.JButton btnBuscarIdioma= this.ventana.getBtnBuscar();

        tablaIdiomas.setModel(new ModeloTablaIdiomas(nombreFiltrar));
        btnBuscarIdioma.setEnabled(true);

        if(tablaIdiomas.getRowCount() == 0){
            btnBorrarIdioma.setEnabled(false);
        }
        else{
            btnBorrarIdioma.setEnabled(true);
        }
    }


    @Override
    public void btnNuevoClic(ActionEvent evt) {
        ControladorAIdiomas nuevoIdioma = ControladorAIdiomas.crear();
        nuevoIdioma.mostrarVentana();
    }

    @Override
    public void btnEliminarClic(ActionEvent evt) {
        javax.swing.JTable tablaIdiomas = this.ventana.getTablaIdiomas();
        int filaElegida = tablaIdiomas.getSelectedRow();

        if(filaElegida != -1){
            String[] botones = {"Si", "No"};
            int respuesta = JOptionPane.showOptionDialog(ventana, IControladorIdiomas.CONFIRMACION, "Elija Una Opcion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);

            if(respuesta == 0){
                String nombre = tablaIdiomas.getValueAt(filaElegida, 0).toString();

                GestorIdiomas gesIdiomas = GestorIdiomas.crear();
                String resultado = gesIdiomas.borrarIdioma(gesIdiomas.verIdioma(nombre));

                JOptionPane.showMessageDialog(ventana, resultado);
                this.actualizarTablaIdiomas();
            }
        }
        else{
            JOptionPane.showMessageDialog(ventana, "No ha seleccionado ningun idioma");
        }
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        String[] botones = {"Si", "No"};
        int respuesta = JOptionPane.showOptionDialog(ventana, "¿Desea guardar los datos y volver a la pantalla de inicio?", "Elija Una Opcion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);

        if(respuesta == 0){
            GestorIdiomas gesIdiomas = GestorIdiomas.crear();
            String resultado = gesIdiomas.escribirArchivo();

            JOptionPane.showMessageDialog(ventana, resultado);

            if(resultado.equals("Se han guardado todas los idiomas con EXITO!")){
                this.ocultarVentana();
            }
        }
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        javax.swing.JTextField txtNombre = this.ventana.getTxtNombre();
        String nombreBuscar = txtNombre.getText().trim();

        this.filtrarTablaIdiomas(nombreBuscar);
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        javax.swing.JTextField txtNombre = this.ventana.getTxtNombre();

        ventana.requestFocus();
        txtNombre.requestFocus();
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            javax.swing.JTextField txtNombre = this.ventana.getTxtNombre();
            javax.swing.JButton btnBuscar = this.ventana.getBtnBuscar();

            btnBuscar.doClick();
        }
    }
}
