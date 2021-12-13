package grupos.controladores;

import grupos.modelos.CeldaRenderer;
import grupos.modelos.Grupo;
import grupos.modelos.ModeloTablaMiembroGrupo;
import grupos.vistas.VentanaModificarMiembros;
import interfaces.IControladorModificarMiembros;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;

public class ControladorModificarMiembros implements IControladorModificarMiembros {
    private static ControladorModificarMiembros instancia;
    private VentanaModificarMiembros ventana;

    private ControladorModificarMiembros(){
        ventana = new VentanaModificarMiembros(this);
    }

    public static ControladorModificarMiembros crear(){
        if(instancia ==  null){
            instancia = new ControladorModificarMiembros();
        }
        return instancia;
    }

    public VentanaModificarMiembros getVentana() {
        return ventana;
    }

    public void mostrar(Grupo g){
        if(ventana == null){
            ventana = new VentanaModificarMiembros(this);
        }

        ModeloTablaMiembroGrupo modeloTabla = new ModeloTablaMiembroGrupo(g);
        JTable tablaMiembros = ventana.getTablaMiembros();
        tablaMiembros.setModel(modeloTabla);

        TableColumn columnaRol = tablaMiembros.getColumnModel().getColumn(1);
        JComboBox combo = new JComboBox();
        combo.addItem("Administrador");
        combo.addItem("Colaborador");

        tablaMiembros.setModel(modeloTabla);

        columnaRol.setCellEditor(new DefaultCellEditor(combo));
        tablaMiembros.setDefaultRenderer(Object.class, new CeldaRenderer(1));

        ventana.setVisible(true);
    }

    public void ocultar(){
        ventana.setVisible(false);
    }

    @Override
    public void btnTodosClic(ActionEvent evt) {
        ModeloTablaMiembroGrupo mtpc = (ModeloTablaMiembroGrupo)ventana.getTablaMiembros().getModel();
        ListSelectionModel modeloSeleccion = ventana.getTablaMiembros().getSelectionModel();
        modeloSeleccion.addSelectionInterval(0, mtpc.getRowCount() - 1);
    }

    @Override
    public void btnNingunoClic(ActionEvent evt) {
        ListSelectionModel modeloSeleccion = ventana.getTablaMiembros().getSelectionModel();
        modeloSeleccion.clearSelection();
    }

    @Override
    public void btnAceptarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ocultar();
    }

}
