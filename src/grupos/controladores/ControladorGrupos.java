package grupos.controladores;

import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import grupos.modelos.ModeloTablaAutoresGrupos;
import grupos.modelos.ModeloTablaGrupos;
import grupos.vistas.VentanaGrupos;
import interfaces.IControladorGrupos;
import principal.controladores.ControladorVentanaPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class ControladorGrupos implements IControladorGrupos {
    private static ControladorGrupos instancia;
    private VentanaGrupos ventana;

    private ControladorGrupos() {
        ventana = new VentanaGrupos(this);
    }

    public static ControladorGrupos crear(){
        if(instancia == null)
            instancia = new ControladorGrupos();
        return instancia;
    }

    public VentanaGrupos getVentana() {
        return ventana;
    }

    public void mostrar(){
        if(ventana==null){
            ventana = new VentanaGrupos(this);
        }
        else{
            ventana.setVisible(true);
        }
    }

    public void ocultar(){
        ventana.setVisible(false);
    }

    public void actualizarTablaGrupos(){
        javax.swing.JTable tablaGrupos = ventana.getTablaGrupos();
        tablaGrupos.setModel(new ModeloTablaGrupos());

        javax.swing.JButton btnModificar = ventana.getBtnModificar();
        javax.swing.JButton btnBuscar = ventana.getBtnBuscar();
        javax.swing.JButton btnBorrar = ventana.getBtnBorrar();

        if(tablaGrupos.getRowCount() == 0){
            btnModificar.setEnabled(false);
            btnBuscar.setEnabled(false);
            btnBorrar.setEnabled(false);
        }
        else{
            btnModificar.setEnabled(true);
            btnBuscar.setEnabled(true);
            btnBorrar.setEnabled(true);
        }
    }

    public void filtrarTablaGrupos(String nombreFiltrar){
        javax.swing.JTable tablaGrupos = ventana.getTablaGrupos();
        tablaGrupos.setModel(new ModeloTablaGrupos(nombreFiltrar));

        javax.swing.JButton btnModificar = ventana.getBtnModificar();

        if(tablaGrupos.getRowCount() == 0){
            btnModificar.setEnabled(false);
        }
        else{
            btnModificar.setEnabled(true);
        }
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        ControladorAMGrupo nuevoGrupo = ControladorAMGrupo.crear();
        nuevoGrupo.getVentana().gettablaMiembros().setModel(new ModeloTablaAutoresGrupos());
        nuevoGrupo.getVentana().getTxtNombre().setEnabled(true);
        nuevoGrupo.limpiar();
        nuevoGrupo.mostrar(nuevoGrupo.TITULO_NUEVO, null);
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        javax.swing.JTable tablaGrupos = ventana.getTablaGrupos();

        int filaElegida = tablaGrupos.getSelectedRow();

        if(filaElegida != -1){
            ControladorAMGrupo modificarGrupo = ControladorAMGrupo.crear();

            String nombreGrupoElegido = tablaGrupos.getValueAt(filaElegida, 0).toString();

            javax.swing.JTable TablaMiembros = modificarGrupo.getVentana().gettablaMiembros();
            javax.swing.JTextField txtDescripcion = modificarGrupo.getVentana().getTxtDescripcion();
            javax.swing.JTextField txtNombre = modificarGrupo.getVentana().getTxtNombre();

            GestorGrupos gesGrupos = GestorGrupos.crear();
            Grupo g = gesGrupos.verGrupo(nombreGrupoElegido);

            txtNombre.setText(g.verNombre());
            txtNombre.setEnabled(false);

            txtDescripcion.setText(g.verDescripcion());

            modificarGrupo.mostrar(modificarGrupo.TITULO_MODIFICAR, g);
        }
        else{
            JOptionPane.showMessageDialog(ventana, "No ha seleccionado ningun grupo");
        }
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        javax.swing.JTable tablaGrupos = ventana.getTablaGrupos();

        int filaElegida = tablaGrupos.getSelectedRow();

        if(filaElegida != -1){
            String[] botones = {"Si", "No"};
            int respuesta = JOptionPane.showOptionDialog(ventana, "¿Desea eliminar la publicacion elegida?", "Elija Una Opcion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);

            if(respuesta == 0){
                String nombreGrupoElegido = tablaGrupos.getValueAt(filaElegida, 0).toString();

                GestorGrupos gGrupos = GestorGrupos.crear();
                Grupo grupo = gGrupos.verGrupo(nombreGrupoElegido);
                String resultado = gGrupos.borrarGrupo(grupo);

                actualizarTablaGrupos();
                JOptionPane.showMessageDialog(ventana, resultado);
            }
            else{
                JOptionPane.showMessageDialog(ventana, "Se ha cancelado la operacion");
            }
        }
        else{
            JOptionPane.showMessageDialog(ventana, "No ha seleccionado ningun grupo");
        }
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        ocultar();
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        javax.swing.JTextField txtNombre = this.ventana.getTxtNombre();
        String nombreBuscar = txtNombre.getText().trim();

        filtrarTablaGrupos(nombreBuscar);
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            javax.swing.JTextField txtNombre = this.ventana.getTxtNombre();
            javax.swing.JButton btnBuscarGrupo = this.ventana.getBtnBuscar();

            btnBuscarGrupo.requestFocus();
            btnBuscarGrupo.doClick();

            txtNombre.setText("");
            txtNombre.requestFocus();
        }
    }
}