package palabrasclaves.controladores;

import interfaces.IControladorPalabrasClaves;
import palabrasclaves.modelos.GestorPalabrasClaves;
import palabrasclaves.modelos.ModeloTablaPalabrasClaves;
import palabrasclaves.vistas.VentanaAPalabrasClaves;
import palabrasclaves.vistas.VentanaPalabrasClaves;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class ControladorPalabrasClaves implements IControladorPalabrasClaves {
    private static ControladorPalabrasClaves instancia;
    private VentanaPalabrasClaves ventana;

    private ControladorPalabrasClaves() {
        this.ventana = new VentanaPalabrasClaves(this);
    }

    public static ControladorPalabrasClaves crear(){
        if (instancia == null)
            instancia = new ControladorPalabrasClaves();
        return instancia;
    }

    public VentanaPalabrasClaves getVentana() {
        return ventana;
    }

    public void mostrarVentana() {
        this.ventana.setVisible(true);
    }

    public void ocultarVentana() {
        this.ventana.setVisible(false);
    }

    public void actualizarTablaPalabrasClaves(){
        JTable tablaPalabrasClaves= this.ventana.getTablaPalabrasClaves();
        JButton btnBorrarPalabrasClaves= this.ventana.getBtnEliminar();
        JButton btnBuscarPalabrasClaves= this.ventana.getBtnBuscar();
        
         btnBuscarPalabrasClaves.setEnabled(true);
        tablaPalabrasClaves.setModel(new ModeloTablaPalabrasClaves());

        if(tablaPalabrasClaves.getRowCount() == 0){
            btnBorrarPalabrasClaves.setEnabled(false);
        }
        else{
            btnBorrarPalabrasClaves.setEnabled(true);
        }
    }

    private void filtrarTablaPalabrasClaves(String nombreFiltrar){
        JTable tablaPalabrasClaves = this.ventana.getTablaPalabrasClaves();
        JButton btnBorrarPalabrasClaves = this.ventana.getBtnEliminar();
        JButton btnBuscarPalabrasClaves= this.ventana.getBtnBuscar();

        tablaPalabrasClaves.setModel(new ModeloTablaPalabrasClaves(nombreFiltrar));
        btnBuscarPalabrasClaves.setEnabled(true);

        if(tablaPalabrasClaves.getRowCount() == 0){
            btnBorrarPalabrasClaves.setEnabled(false);
        }
        else{
            btnBorrarPalabrasClaves.setEnabled(true);
        }
    }


    @Override
    public void btnNuevoClic(ActionEvent evt) {
        ControladorAPalabrasClaves nuevoPalabrasClaves = ControladorAPalabrasClaves.crear();
        nuevoPalabrasClaves.mostrarVentana();
    }

    @Override
    public void btnEliminarClic(ActionEvent evt) {
        JTable tablaPalabrasClaves = this.ventana.getTablaPalabrasClaves();
        int filaElegida = tablaPalabrasClaves.getSelectedRow();

        if(filaElegida != -1){
            String[] botones = {"Si", "No"};
            int respuesta = JOptionPane.showOptionDialog(ventana, IControladorPalabrasClaves.CONFIRMACION, "Elija Una Opcion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);

            if(respuesta == 0){
                String nombre = tablaPalabrasClaves.getValueAt(filaElegida, 0).toString();

                GestorPalabrasClaves gesPalabrasClaves = GestorPalabrasClaves.crear();
                String resultado = gesPalabrasClaves.borrarPalabraClave(gesPalabrasClaves.verPalabraClave(nombre));

                JOptionPane.showMessageDialog(ventana, resultado);
                this.actualizarTablaPalabrasClaves();
            }
        }
        else{
            JOptionPane.showMessageDialog(ventana, "No ha seleccionado ninguna Palabra Clave!");
        }
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        String[] botones = {"Si", "No"};
        int respuesta = JOptionPane.showOptionDialog(ventana, "¿Desea guardar los datos y volver a la pantalla de inicio?", "Elija Una Opcion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);
        if(respuesta == 0){
            GestorPalabrasClaves gesPalabrasClaves = GestorPalabrasClaves.crear();
            String resultado = gesPalabrasClaves.escribirArchivo();

            JOptionPane.showMessageDialog(ventana, resultado);

            if(resultado.equals("Se han guardado todas las palabras claves con EXITO!")){
            this.ocultarVentana();
        }
    }
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        JTextField txtNombre = this.ventana.getTxtNombre();
        String nombreBuscar = txtNombre.getText().trim();

        this.filtrarTablaPalabrasClaves(nombreBuscar);
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        JTextField txtNombre = this.ventana.getTxtNombre();

        ventana.requestFocus();
        txtNombre.requestFocus();
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            JTextField txtNombre = this.ventana.getTxtNombre();
            JButton btnBuscar = this.ventana.getBtnBuscar();

            btnBuscar.doClick();
        }
    }
}
