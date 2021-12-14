package tipos.controladores;

import interfaces.IControladorTipos;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import tipos.modelos.GestorTipos;
import tipos.modelos.ModeloTablaTipos;
import tipos.vistas.VentanaTipos;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ControladorTipos implements IControladorTipos {
    private static ControladorTipos instancia;
    private VentanaTipos ventana;

    private ControladorTipos() {
        this.ventana = new VentanaTipos(this);
    }

    public static ControladorTipos crear(){
        if (instancia == null)
            instancia = new ControladorTipos();
        return instancia;
    }

    public VentanaTipos getVentana() {
        return ventana;
    }

    public void mostrarVentana() {
        this.ventana.setVisible(true);
    }

    public void ocultarVentana() {
        this.ventana.setVisible(false);
    }

    public void actualizarTablaTipos(){
        javax.swing.JTable tablaTipos= this.ventana.getTablaTipos();
        javax.swing.JButton btnBorrarTipo= this.ventana.getBtnEliminar();
        javax.swing.JButton btnBuscarTipo= this.ventana.getBtnBuscar();
        
         btnBuscarTipo.setEnabled(true);
        tablaTipos.setModel(new ModeloTablaTipos());

        if(tablaTipos.getRowCount() == 0){
            btnBorrarTipo.setEnabled(false);
        }
        else{
            btnBorrarTipo.setEnabled(true);
        }
    }

    private void filtrarTablaTipos(String nombreFiltrar){
        javax.swing.JTable tablaTipos = this.ventana.getTablaTipos();
        javax.swing.JButton btnBorrarTipo = this.ventana.getBtnEliminar();
        javax.swing.JButton btnBuscarTipo= this.ventana.getBtnBuscar();

        tablaTipos.setModel(new ModeloTablaTipos(nombreFiltrar));
        btnBuscarTipo.setEnabled(true);

        if(tablaTipos.getRowCount() == 0){
            btnBorrarTipo.setEnabled(false);
        }
        else{
            btnBorrarTipo.setEnabled(true);
        }
    }


    @Override
    public void btnNuevoClic(ActionEvent evt) {
        ControladorATipos nuevoTipo = ControladorATipos.crear();
        nuevoTipo.mostrarVentana();
    }

    @Override
    public void btnEliminarClic(ActionEvent evt) {
        javax.swing.JTable tablaTipos = this.ventana.getTablaTipos();
        int filaElegida = tablaTipos.getSelectedRow();

        if(filaElegida != -1){
            String[] botones = {"Si", "No"};
            int respuesta = JOptionPane.showOptionDialog(ventana, IControladorTipos.CONFIRMACION, "Elija Una Opcion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);

            if(respuesta == 0){
                String nombre = tablaTipos.getValueAt(filaElegida, 0).toString();

                GestorTipos gesTipos = GestorTipos.crear();
                String resultado = gesTipos.borrarTipo(gesTipos.verTipo(nombre));

                JOptionPane.showMessageDialog(ventana, resultado);
                this.actualizarTablaTipos();
            }
        }
        else{
            JOptionPane.showMessageDialog(ventana, "No ha seleccionado ningun Tipo");
        }
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        String[] botones = {"Si", "No"};
        int respuesta = JOptionPane.showOptionDialog(ventana, "¿Desea guardar los datos y volver a la pantalla de inicio?", "Elija Una Opcion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);

        if(respuesta == 0){
            GestorTipos gesTipos = GestorTipos.crear();
            String resultado = gesTipos.escribirArchivo();

            JOptionPane.showMessageDialog(ventana, resultado);

            if(resultado.equals("Se han guardado todas los tipos con EXITO!")){
                this.ocultarVentana();
            }
        }
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        javax.swing.JTextField txtNombre = this.ventana.getTxtNombre();
        String nombreBuscar = txtNombre.getText().trim();

        this.filtrarTablaTipos(nombreBuscar);
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
