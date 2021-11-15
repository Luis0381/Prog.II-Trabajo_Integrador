package autores.controladores;

import autores.modelos.Cargo;
import autores.modelos.GestorAutores;
import autores.modelos.ModeloComboCargos;
import autores.modelos.Profesor;
import autores.vistas.VentanaAMAlumno;
import autores.vistas.VentanaAMProfesor;
import interfaces.IControladorAMProfesor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ControladorAMProfesor implements IControladorAMProfesor {
    private static ControladorAMProfesor instancia;
    private VentanaAMProfesor ventana;

    private ControladorAMProfesor() {
        this.ventana = new VentanaAMProfesor(this);
    }

    public static ControladorAMProfesor crear() {
        if (instancia == null)
            instancia = new ControladorAMProfesor();

        return instancia;
    }

    public void mostrarVentana(String titulo) {
        if (ventana == null) {
            ventana = new VentanaAMProfesor(this);
            ventana.setTitle(titulo);
        } else {
            ventana.setTitle(titulo);
            ventana.setVisible(true);
        }
    }

    public void ocultarVentana() {
        ventana.setVisible(false);
    }

    public VentanaAMProfesor getVentana() {
        return ventana;
    }

    public void setVentana(VentanaAMProfesor ventana) {
        this.ventana = ventana;
    }

    public void limpiarCeldas(){
        javax.swing.JTextField txtApellido = ventana.getTxtApellidos();
        javax.swing.JTextField txtNombre = ventana.getTxtNombres();
        javax.swing.JComboBox<String> comboCargos = ventana.getComboCargos();
        javax.swing.JPasswordField passClave = ventana.getPassClave();
        javax.swing.JPasswordField passClaveRepetida = ventana.getPassClaveRepetida();
        javax.swing.JTextField txtDNI = ventana.getTxtDNI();
        txtDNI.setText("");
        txtApellido.setText("");
        txtNombre.setText("");
        passClave.setText("");
        passClaveRepetida.setText("");
        comboCargos.setSelectedItem(Cargo.ASOCIADO);
    }

    public void nuevoProfesor(){
        javax.swing.JTextField txtApellido = ventana.getTxtApellidos();
        javax.swing.JTextField txtNombre = ventana.getTxtNombres();
        javax.swing.JComboBox<String> comboCargos = ventana.getComboCargos();
        javax.swing.JPasswordField passClave = ventana.getPassClave();
        javax.swing.JPasswordField passClaveRepetida = ventana.getPassClaveRepetida();
        javax.swing.JTextField txtDNI = ventana.getTxtDNI();

        int dni = 0;
        if (!txtDNI.getText().trim().isEmpty())
            dni = Integer.parseInt(txtDNI.getText().trim());
        String apellidos = txtApellido.getText().trim();
        String nombres = txtNombre.getText().trim();
        String clave = new String(passClave.getPassword());
        String claveRepetida = new String(passClaveRepetida.getPassword());
        Cargo cargo = ((ModeloComboCargos) comboCargos.getModel()).obtenerCargo();

        GestorAutores gestorAutor = GestorAutores.crear();

        String resultado = gestorAutor.nuevoAutor(dni, apellidos, nombres, cargo, clave, claveRepetida);
        JOptionPane.showMessageDialog(ventana, resultado);
        if(resultado.equals("\n\tProfesor agregado de forma EXITOSA!"))
            limpiarCeldas();
        ControladorAutores controlAutor = ControladorAutores.crear();
        controlAutor.actualizarTablaProfesores();
    }

    public void modificarProfesor(){
        javax.swing.JTextField txtApellido = ventana.getTxtApellidos();
        javax.swing.JTextField txtNombre = ventana.getTxtNombres();
        javax.swing.JComboBox<String> comboCargos = ventana.getComboCargos();
        javax.swing.JPasswordField passClave = ventana.getPassClave();
        javax.swing.JPasswordField passClaveRepetida = ventana.getPassClaveRepetida();
        javax.swing.JTextField txtDNI = ventana.getTxtDNI();


        int dni = 0;
        if (!txtDNI.getText().trim().isEmpty())
            dni = Integer.parseInt(txtDNI.getText().trim());
        String apellidos = txtApellido.getText().trim();
        String nombres = txtNombre.getText().trim();
        String clave = new String(passClave.getPassword());
        String claveRepetida = new String(passClaveRepetida.getPassword());
        Cargo cargo = ((ModeloComboCargos) comboCargos.getModel()).obtenerCargo();

        GestorAutores gestorAutor = GestorAutores.crear();

        String resultado = gestorAutor.modificarAutor(new Profesor(dni, apellidos, nombres, clave, cargo), apellidos, nombres, cargo, clave, claveRepetida);
        JOptionPane.showMessageDialog(ventana, resultado);

        if(resultado.equals("Datos de Profesor modificados de forma EXITOSA!")){
            ocultarVentana();
            limpiarCeldas();
        }
        ControladorAutores controlAutor = ControladorAutores.crear();
        controlAutor.actualizarTablaProfesores();
    }


    @Override
    public void btnGuardarClic(ActionEvent evt) {

        if(ventana.getTitle().equals(IControladorAMProfesor.TITULO_NUEVO))
            this.nuevoProfesor();

        else if(ventana.getTitle().equals(IControladorAMProfesor.TITULO_MODIFICAR))
            this.modificarProfesor();
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ocultarVentana();
    }

    @Override
    public void txtApellidosPresionarTecla(KeyEvent evt) {
        javax.swing.JTextField txtApellido = this.ventana.getTxtApellidos();
        javax.swing.JTextField txtDni = this.ventana.getTxtDNI();

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(txtApellido.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(ventana, "Ingrese un apellido");
            }
            else{
                txtDni.requestFocus();
            }
        }
    }

    @Override
    public void txtNombresPresionarTecla(KeyEvent evt) {
        javax.swing.JTextField txtApellido = this.ventana.getTxtApellidos();
        javax.swing.JTextField txtNombre = this.ventana.getTxtNombres();

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(txtNombre.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(ventana, "Ingrese un nombre");
            }
            else{
                txtApellido.requestFocus();
            }
        }
    }

    @Override
    public void txtDocumentoPresionarTecla(KeyEvent evt) {
        javax.swing.JTextField txtDni = this.ventana.getTxtDNI();
        javax.swing.JComboBox comboBox = this.ventana.getComboCargos();

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(txtDni.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(ventana, "Ingrese un DNI");
            }
            else{
                comboBox.requestFocus();
                comboBox.showPopup();
            }
        }
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
        javax.swing.JPasswordField passClave = this.ventana.getPassClave();
        javax.swing.JPasswordField passClaveRepetida = this.ventana.getPassClaveRepetida();
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            JOptionPane.showMessageDialog(ventana, "Ingrese una clave");
            passClaveRepetida.requestFocus();
        }
    }

    @Override
    public void passRepetirClavePresionarTecla(KeyEvent evt) {
        javax.swing.JPasswordField passClaveRepetida = this.ventana.getPassClaveRepetida();
        javax.swing.JButton btnGuardar = this.ventana.getBtnGuardar();

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            JOptionPane.showMessageDialog(ventana, "Ingrese nuevamente la clave");
            btnGuardar.requestFocus();
            btnGuardar.doClick();
        }
    }
}
