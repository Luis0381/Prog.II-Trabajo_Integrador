package grupos.controladores;

import autores.controladores.ControladorAutores;
import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import grupos.modelos.ModeloTablaAutoresGrupos;
import grupos.vistas.VentanaAMGrupo;
import interfaces.IControladorAMGrupo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class ControladorAMGrupo implements IControladorAMGrupo {
    private static ControladorAMGrupo instancia;
    private VentanaAMGrupo ventana;

    private ControladorAMGrupo(){
        ventana = new VentanaAMGrupo(this);
    }

    public static ControladorAMGrupo crear(){
        if(instancia == null){
            instancia = new ControladorAMGrupo();
        }
        return instancia;
    }

    public void mostrar(String titulo, Grupo g){
        if(titulo.equals(TITULO_NUEVO)){
            if(ventana == null){
                ventana = new VentanaAMGrupo(this);
            }
            this.ventana.setTitle(titulo);
            this.ventana.setVisible(true);

            javax.swing.JButton btnModficarMiembros = this.ventana.getBtnModificar();
            btnModficarMiembros.setEnabled(false);
        }
        else if(titulo.equals(TITULO_MODIFICAR)){
            if(ventana == null){
                ventana = new VentanaAMGrupo(this);
            }
            this.ventana.setTitle(titulo);
            this.ventana.gettablaMiembros().setModel(new ModeloTablaAutoresGrupos(g));
            this.ventana.setVisible(true);

            javax.swing.JButton btnModficarMiembros = this.ventana.getBtnModificar();
            btnModficarMiembros.setEnabled(true);
        }
    }

    public void ocultar(){
        this.ventana.setVisible(false);
    }

    public void limpiar(){
        javax.swing.JTextField txtNombre = this.ventana.getTxtNombre();
        javax.swing.JTextField txtDescripcion = this.ventana.getTxtDescripcion();

        txtNombre.setText("");
        txtDescripcion.setText("");
    }

    public VentanaAMGrupo getVentana() {
        return ventana;
    }

    private void nuevoGrupo(){
        javax.swing.JTextField txtDescripcion = ventana.getTxtDescripcion();
        javax.swing.JTextField txtNombre = ventana.getTxtNombre();

        String nombre = txtNombre.getText().trim();
        String descripcion = txtDescripcion.getText().trim();

        GestorGrupos gesGrupos = GestorGrupos.crear();
        String resultado = gesGrupos.nuevoGrupo(nombre, descripcion);

        JOptionPane.showMessageDialog(ventana, resultado);
        if(resultado.equals("Grupo agregado de forma EXITOSA!")){
            limpiar();
            ocultar();
        }

        ControladorGrupos controlGrupos = ControladorGrupos.crear();
        controlGrupos.actualizarTablaGrupos();
    }

    private void modificarGrupo(){
        javax.swing.JTextField txtDescripcion = ventana.getTxtDescripcion();
        javax.swing.JTextField txtNombre = ventana.getTxtNombre();

        String nombre = txtNombre.getText().trim();
        String descripcion = txtDescripcion.getText().trim();

        GestorGrupos gesGrupos = GestorGrupos.crear();
        String resultado = gesGrupos.modificarGrupo(gesGrupos.verGrupo(nombre), descripcion);

        JOptionPane.showMessageDialog(ventana, resultado);
        if(resultado.equals("Grupo modificado de forma EXITOSA!")){
            limpiar();
            ocultar();
        }

        ControladorGrupos controlGrupos = ControladorGrupos.crear();
        controlGrupos.actualizarTablaGrupos();
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        if(ventana.getTitle().equals(TITULO_NUEVO)){
            nuevoGrupo();
        }
        else{
            modificarGrupo();
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        JOptionPane.showMessageDialog(ventana, "Se ha cancelado la operación");
        this.ocultar();
    }

    @Override
    public void btnModificarMiembrosClic(ActionEvent evt) {
        javax.swing.JTextField txtNombre = ventana.getTxtNombre();

        GestorGrupos gesGrupos = GestorGrupos.crear();
        ControladorModificarMiembros modificarMiembros = ControladorModificarMiembros.crear();
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}