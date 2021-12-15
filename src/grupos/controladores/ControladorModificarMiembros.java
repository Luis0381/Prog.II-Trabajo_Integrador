package grupos.controladores;

import grupos.modelos.*;
import grupos.vistas.VentanaModificarMiembros;
import interfaces.IControladorModificarMiembros;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ControladorModificarMiembros implements IControladorModificarMiembros {
    private static ControladorModificarMiembros instancia;
    private VentanaModificarMiembros ventana;
    private String nombreGrupo;

    private ControladorModificarMiembros() {
        ventana = new VentanaModificarMiembros(this);
    }

    public static ControladorModificarMiembros crear() {
        if (instancia == null) {
            instancia = new ControladorModificarMiembros();
        }
        return instancia;
    }

    public VentanaModificarMiembros getVentana() {
        return ventana;
    }

    public void mostrar(Grupo g) {
        if (ventana == null) {
            ventana = new VentanaModificarMiembros(this);
        }

        ModeloTablaMiembroGrupo mtm = new ModeloTablaMiembroGrupo();

        JTable tablaMiembros = this.ventana.getTablaMiembros();
        tablaMiembros.setModel(mtm);
        tablaMiembros.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        ListSelectionModel modeloSeleccion = tablaMiembros.getSelectionModel();

        for (MiembroEnGrupo miembroEnGrupo : g.verMiembros()) {
            for (int fila = 0; fila < mtm.getRowCount(); fila++) {
                MiembroEnGrupo meg = mtm.verMiembroEnGrupo(fila);
                if (miembroEnGrupo.verAutor().equals(meg.verAutor())) {
                    meg.asignarRol(miembroEnGrupo.verRol());
                    modeloSeleccion.addSelectionInterval(fila, fila);
                    break;
                }
            }
        }

        this.nombreGrupo = g.verNombre();

        TableColumn columnaRol = tablaMiembros.getColumnModel().getColumn(1);
        JComboBox combo = new JComboBox();
        combo.setModel(new ModeloComboRoles());
        columnaRol.setCellEditor(new DefaultCellEditor(combo));

        ventana.setVisible(true);
    }

    public void ocultar() {
        ventana.setVisible(false);
    }

    @Override
    public void btnTodosClic(ActionEvent evt) {
        ModeloTablaMiembroGrupo mtpc = (ModeloTablaMiembroGrupo) ventana.getTablaMiembros().getModel();
        ListSelectionModel modeloSeleccion = ventana.getTablaMiembros().getSelectionModel();
        modeloSeleccion.addSelectionInterval(0, mtpc.getRowCount() - 1);
    }

    @Override
    public void btnNingunoClic(ActionEvent evt) {
        JTable tablaMiembrosColaboradores = this.ventana.getTablaMiembros();
        ListSelectionModel modeloSeleccion = tablaMiembrosColaboradores.getSelectionModel();
        modeloSeleccion.clearSelection();
    }

    @Override
    public void btnAceptarClic(ActionEvent evt) {
        GestorGrupos gesGrupos = GestorGrupos.crear();
        int opcion = JOptionPane.showOptionDialog(null, CONFIRMACION, TITULO, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, this);

        if (opcion == JOptionPane.YES_OPTION) {
            List<MiembroEnGrupo> miembrosViejos = new ArrayList<>(gesGrupos.verGrupo(nombreGrupo).verMiembros());
            JTable tablaMiembros = this.ventana.getTablaMiembros();
            ModeloTablaMiembroGrupo modelo = (ModeloTablaMiembroGrupo) tablaMiembros.getModel();
            List<MiembroEnGrupo> miembrosNuevos = new ArrayList<>();
            int[] filasSeleccionadas = tablaMiembros.getSelectedRows();
            for (int filasSeleccionada : filasSeleccionadas) {
                MiembroEnGrupo meg = modelo.verMiembroEnGrupo(filasSeleccionada);
                miembrosNuevos.add(meg);
            }

            String resultado = gesGrupos.quitarMiembros(gesGrupos.verGrupo(nombreGrupo), miembrosViejos);

            if (resultado.equals("Miembros removidos con EXITO!")) {
                resultado = gesGrupos.agregarMiembros(gesGrupos.verGrupo(nombreGrupo), miembrosNuevos);
                if (resultado.equals("Miembros Agregados con EXITO!")) {
                    ocultar();
                } else
                    JOptionPane.showMessageDialog(null, resultado, nombreGrupo + " - " + TITULO, JOptionPane.ERROR_MESSAGE);
            } else
                JOptionPane.showMessageDialog(null, resultado, nombreGrupo + " - " + TITULO, JOptionPane.ERROR_MESSAGE);
        }
        ControladorAMGrupo controlGrupo = ControladorAMGrupo.crear();
        controlGrupo.actualizarTablaMiembros();
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ocultar();
    }

}
