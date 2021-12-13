package grupos.controladores;

import autores.controladores.ControladorAutores;
import grupos.modelos.*;
import grupos.vistas.VentanaAMGrupo;
import interfaces.IControladorAMGrupo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class ControladorAMGrupo implements IControladorAMGrupo {
    private static ControladorAMGrupo instancia;
    private VentanaAMGrupo ventana;
    String nombreGrupo;

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

            javax.swing.JButton btnModificarMiembros = this.ventana.getBtnModificar();
            btnModificarMiembros.setEnabled(false);
        }
        else if(titulo.equals(TITULO_MODIFICAR)){
            if(ventana == null){
                ventana = new VentanaAMGrupo(this);
            }
            this.ventana.setTitle(titulo);
            this.ventana.gettablaMiembros().setModel(new ModeloTablaAutoresGrupos(g));
            this.ventana.setVisible(true);

            javax.swing.JButton btnModificarMiembros = this.ventana.getBtnModificar();
            btnModificarMiembros.setEnabled(true);
        }
        nombreGrupo=g.verNombre();
    }

    public void actualizarTablaMiembros(){
        javax.swing.JTable tablaMiembros = ventana.gettablaMiembros();
        GestorGrupos gesGrupos = GestorGrupos.crear();
        tablaMiembros.setModel(new ModeloTablaAutoresGrupos(gesGrupos.verGrupo(nombreGrupo)));
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
        JOptionPane.showMessageDialog(ventana, "Modificacion Cancelada!");
        this.ocultar();
    }

    @Override
    public void btnModificarMiembrosClic(ActionEvent evt) {
        javax.swing.JTextField txtNombre = ventana.getTxtNombre();
        GestorGrupos gesGrupos = GestorGrupos.crear();
        ControladorModificarMiembros modificarMiembros = ControladorModificarMiembros.crear();
        modificarMiembros.mostrar(gesGrupos.verGrupo(txtNombre.getText().trim()));
        actualizarTablaMiembros();
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isLetter(c)) { //sólo se aceptan letras, Enter, Del, Backspace y espacio
            switch(c) {
                case KeyEvent.VK_ENTER:
                    this.btnGuardarClic(null); //no importa el evento en este caso
                    break;
                case KeyEvent.VK_BACK_SPACE:
                case KeyEvent.VK_DELETE:
                case KeyEvent.VK_SPACE:
                    break;
                default:
                    evt.consume(); //consume el evento para que no sea procesado por la fuente
            }
        }
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isLetter(c)) { //sólo se aceptan letras, Enter, Del, Backspace y espacio
            switch(c) {
                case KeyEvent.VK_ENTER:
                    this.btnGuardarClic(null); //no importa el evento en este caso
                    break;
                case KeyEvent.VK_BACK_SPACE:
                case KeyEvent.VK_DELETE:
                case KeyEvent.VK_SPACE:
                    break;
                default:
                    evt.consume(); //consume el evento para que no sea procesado por la fuente
            }
        }
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}