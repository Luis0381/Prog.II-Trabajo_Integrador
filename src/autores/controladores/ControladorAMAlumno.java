package autores.controladores;

import autores.modelos.*;
import autores.vistas.VentanaAMAlumno;
import interfaces.IControladorAMAlumno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ControladorAMAlumno implements IControladorAMAlumno {
    private static ControladorAMAlumno instancia;
    private VentanaAMAlumno ventana;

    private ControladorAMAlumno() {
        this.ventana = new VentanaAMAlumno(this);
    }

    public static ControladorAMAlumno crear() {
        if (instancia == null)
            instancia = new ControladorAMAlumno();

        return instancia;
    }


    public void mostrarVentana(String titulo) {
        if (ventana == null) {
            ventana = new VentanaAMAlumno(this);
            ventana.setTitle(titulo);
        } else {
            ventana.setTitle(titulo);
            ventana.setVisible(true);
        }
    }

    public void ocultarVentana() {
        ventana.setVisible(false);
    }

    private static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

    public void nuevoAlumno(){
        javax.swing.JTextField txtApellido = ventana.getTxtApellidos();
        javax.swing.JTextField txtNombre = ventana.getTxtNombres();
        javax.swing.JTextField txtCX = ventana.getTxtCX();
        javax.swing.JPasswordField passClave = ventana.getPassClave();
        javax.swing.JPasswordField passClaveRepetida = ventana.getPassClaveRepetida();
        javax.swing.JTextField txtDNI = ventana.getTxtDNI();

        String apellidos, nombres, clave, claveRepetida,cx;

        int dni = 0;
        if (!txtDNI.getText().trim().isEmpty()) {
            if (isNumeric(txtDNI.getText().trim()))
                dni = Integer.parseInt(txtDNI.getText().trim());
        }

        apellidos = txtApellido.getText().trim();
        nombres = txtNombre.getText().trim();
        clave = new String(passClave.getPassword());
        claveRepetida = new String(passClaveRepetida.getPassword());
        cx = txtCX.getText().trim();
        GestorAutores gestorAutor = GestorAutores.crear();
        String resultado = gestorAutor.nuevoAutor(dni, apellidos, nombres, cx, clave, claveRepetida);
        JOptionPane.showMessageDialog(ventana, resultado);

        if (resultado.equals("\n\tAlumno agregado de forma EXITOSA!")) {
            ocultarVentana();
            limpiarCeldas();
        }

        ControladorAutores controlAutor = ControladorAutores.crear();
        controlAutor.actualizarTablaAlumnos();
    }

    public void modificarAlumno(){
        javax.swing.JTextField txtApellido = ventana.getTxtApellidos();
        javax.swing.JTextField txtNombre = ventana.getTxtNombres();
        javax.swing.JTextField txtCX = ventana.getTxtCX();
        javax.swing.JPasswordField passClave = ventana.getPassClave();
        javax.swing.JPasswordField passClaveRepetida = ventana.getPassClaveRepetida();
        javax.swing.JTextField txtDNI = ventana.getTxtDNI();

        int dni = 0;
        if (!txtDNI.getText().trim().isEmpty()) {
            if (isNumeric(txtDNI.getText().trim()))
                dni = Integer.parseInt(txtDNI.getText().trim());
        }
        String apellidos = txtApellido.getText().trim();
        String nombres = txtNombre.getText().trim();
        String clave = new String(passClave.getPassword());
        String claveRepetida = new String(passClaveRepetida.getPassword());
        String cx = txtCX.getText().trim();

        GestorAutores gestorAutor = GestorAutores.crear();

        String resultado = gestorAutor.modificarAutor(new Alumno(dni, apellidos, nombres, clave, cx), apellidos, nombres, cx, clave, claveRepetida);
        JOptionPane.showMessageDialog(ventana, resultado);

        if(resultado.equals("Datos del Alumno modificados de forma EXITOSA!")){
            ocultarVentana();
            limpiarCeldas();
        }

        ControladorAutores controlAutor = ControladorAutores.crear();
        controlAutor.actualizarTablaAlumnos();
    }

    public VentanaAMAlumno getVentana() {
        return ventana;
    }

    public void setVentana(VentanaAMAlumno ventana) {
        this.ventana = ventana;
    }

    public void limpiarCeldas(){
        javax.swing.JPasswordField passClave = ventana.getPassClave();
        javax.swing.JPasswordField passClaveRepetida = ventana.getPassClaveRepetida();
        javax.swing.JTextField txtApellidos = ventana.getTxtApellidos();
        javax.swing.JTextField txtCX = ventana.getTxtCX();
        javax.swing.JTextField txtDNI = ventana.getTxtDNI();
        javax.swing.JTextField txtNombres = ventana.getTxtNombres();
        txtDNI.setText("");
        txtCX.setText("");
        txtApellidos.setText("");
        txtNombres.setText("");
        passClave.setText("");
        passClaveRepetida.setText("");
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        if(ventana.getTitle().equals(IControladorAMAlumno.TITULO_NUEVO))
            this.nuevoAlumno();

        else if(ventana.getTitle().equals(IControladorAMAlumno.TITULO_MODIFICAR))
            this.modificarAlumno();
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ocultarVentana();
    }

    @Override
    public void txtApellidosPresionarTecla(KeyEvent evt) {
        javax.swing.JTextField txtApellido = this.ventana.getTxtApellidos();
        javax.swing.JTextField txtNombre = this.ventana.getTxtNombres();

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(txtApellido.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(ventana, "Ingrese un apellido");
            }
            else{
                txtNombre.requestFocus();
            }
        }
    }

    @Override
    public void txtNombresPresionarTecla(KeyEvent evt) {
        javax.swing.JTextField txtNombre = this.ventana.getTxtNombres();
        javax.swing.JTextField txtCx = this.ventana.getTxtCX();

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(txtNombre.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(ventana, "Ingrese un nombre");
            }
            else{
                txtCx.requestFocus();
            }
        }
    }

    @Override
    public void txtDocumentoPresionarTecla(KeyEvent evt) {
        javax.swing.JTextField txtDni = this.ventana.getTxtDNI();
        javax.swing.JTextField txtApellido = this.ventana.getTxtApellidos();

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(txtDni.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(ventana, "Ingrese un DNI");
            }
            else{
                txtApellido.requestFocus();
            }
        }
    }

    @Override
    public void txtCXPresionarTecla(KeyEvent evt) {
        javax.swing.JTextField txtCx = this.ventana.getTxtCX();
        javax.swing.JPasswordField passClave = this.ventana.getPassClave();

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(txtCx.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(ventana, "Ingrese un CX");
            }
            else{
                passClave.requestFocus();
            }
        }
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
        javax.swing.JPasswordField passClave = this.ventana.getPassClave();
        javax.swing.JPasswordField passClaveRepetida = this.ventana.getPassClaveRepetida();

        String claveGuardar = new String(passClave.getPassword());

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            passClaveRepetida.requestFocus();
        }
    }

    @Override
    public void passRepetirClavePresionarTecla(KeyEvent evt) {
        javax.swing.JPasswordField passClaveRepetida = this.ventana.getPassClaveRepetida();
        javax.swing.JButton btnGuardar = this.ventana.getBtnGuardar();

        String claveRepetida = new String(passClaveRepetida.getPassword());

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnGuardar.requestFocus();
            btnGuardar.doClick();
        }
    }
}
