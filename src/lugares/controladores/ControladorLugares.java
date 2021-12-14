package lugares.controladores;

import interfaces.IControladorLugares;
import lugares.modelos.GestorLugares;
import lugares.modelos.ModeloTablaLugares;
import lugares.vistas.VentanaLugares;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ControladorLugares implements IControladorLugares {
    private static ControladorLugares instancia;
    private VentanaLugares ventana;

    private ControladorLugares() {
        this.ventana = new VentanaLugares(this);
    }

    public static ControladorLugares crear(){
        if (instancia == null)
            instancia = new ControladorLugares();
        return instancia;
    }

    public VentanaLugares getVentana() {
        return ventana;
    }

    public void mostrarVentana() {
        this.ventana.setVisible(true);
    }

    public void ocultarVentana() {
        this.ventana.setVisible(false);
    }

    public void actualizarTablaLugares(){
        javax.swing.JTable tablaLugares = this.ventana.getTablaLugares();
        javax.swing.JButton btnBorrarLugar= this.ventana.getBtnEliminar();
        javax.swing.JButton btnBuscarLugar = this.ventana.getBtnBuscar();

        btnBuscarLugar.setEnabled(true);
        tablaLugares.setModel(new ModeloTablaLugares());

        if(tablaLugares.getRowCount() == 0){
            btnBorrarLugar.setEnabled(false);
        }
        else{
            btnBorrarLugar.setEnabled(true);
        }
    }

    private void filtrarTablaLugares(String nombreFiltrar){
        javax.swing.JTable tablaLugares = this.ventana.getTablaLugares();
        javax.swing.JButton btnBorrarLugar= this.ventana.getBtnEliminar();
        javax.swing.JButton btnBuscarLugar = this.ventana.getBtnBuscar();

        tablaLugares.setModel(new ModeloTablaLugares(nombreFiltrar));
        btnBuscarLugar.setEnabled(true);

        if(tablaLugares.getRowCount() == 0){
            btnBorrarLugar.setEnabled(false);
        }
        else{
            btnBorrarLugar.setEnabled(true);
        }
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        ControladorALugares nuevoLugar = ControladorALugares.crear();
        nuevoLugar.mostrarVentana();
    }

    @Override
    public void btnEliminarClic(ActionEvent evt) {
        javax.swing.JTable tablaLugares = this.ventana.getTablaLugares();
        int filaElegida = tablaLugares.getSelectedRow();

        if(filaElegida != -1){
            String[] botones = {"Si", "No"};
            int respuesta = JOptionPane.showOptionDialog(ventana, IControladorLugares.CONFIRMACION, "Elija Una Opcion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);

            if(respuesta == 0){
                String nombre = tablaLugares.getValueAt(filaElegida, 0).toString();

                GestorLugares gesLugares = GestorLugares.crear();
                String resultado = gesLugares.borrarLugar(gesLugares.verLugar(nombre));

                JOptionPane.showMessageDialog(ventana, resultado);
                this.actualizarTablaLugares();
            }
        }
        else{
            JOptionPane.showMessageDialog(ventana, "No ha seleccionado ningun Lugar");
        }
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        String[] botones = {"Si", "No"};
        int respuesta = JOptionPane.showOptionDialog(ventana, "¿Desea guardar los datos y volver a la pantalla de inicio?", "Elija Una Opcion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);

        if(respuesta == 0){
            GestorLugares gesLugares = GestorLugares.crear();
            String resultado = gesLugares.escribirArchivo();

            JOptionPane.showMessageDialog(ventana, resultado);

            if(resultado.equals("Se han guardado todos los lugares con EXITO!")){
                this.ocultarVentana();
            }
        }
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        javax.swing.JTextField txtNombre = this.ventana.getTxtNombre();
        String nombreBuscar = txtNombre.getText().trim();

        this.filtrarTablaLugares(nombreBuscar);
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
