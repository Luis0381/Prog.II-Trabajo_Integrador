package autores.controladores;

import autores.modelos.Cargo;
import autores.modelos.GestorAutores;
import autores.modelos.ModeloComboCargos;
import autores.modelos.Profesor;
import autores.vistas.VentanaAProfesor;
import interfaces.IControladorAMProfesor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ControladorAProfesor implements IControladorAMProfesor {
    private static ControladorAProfesor instancia;
    private VentanaAProfesor ventana;

    /**
     * Constructor
     */
    private ControladorAProfesor() {
        this.ventana = new VentanaAProfesor(this);
    }

    /**
     * Crea una instancia de ControladorAMProfesor
     */
    public static ControladorAProfesor crear() {
        if (instancia == null)
            instancia = new ControladorAProfesor();

        return instancia;
    }

    /**
     * Verifica si una string es numerica
     *
     * @param cadena String que queremos verificar si es numerica
     */
    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    /**
     * Muestra la ventana asignandole un titulo
     *
     * @param titulo Titulo de la ventana
     */
    public void mostrarVentana(String titulo) {
        if (ventana == null) {
            ventana = new VentanaAProfesor(this);
            ventana.setTitle(titulo);
        } else {
            ventana.setTitle(titulo);
            ventana.setVisible(true);
        }
    }

    /**
     * Oculta la ventana
     */
    public void ocultarVentana() {
        ventana.setVisible(false);
    }

    public VentanaAProfesor getVentana() {
        return ventana;
    }

    public void setVentana(VentanaAProfesor ventana) {
        this.ventana = ventana;
    }

    /**
     * Se encarga de limpiar los datos ingresados de las celdas presentadas en la ventana
     */
    public void limpiarCeldas() {
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

    /**
     * Se encarga de la creación de un profesor
     */
    public void nuevoProfesor() {
        javax.swing.JTextField txtApellido = ventana.getTxtApellidos();
        javax.swing.JTextField txtNombre = ventana.getTxtNombres();
        javax.swing.JComboBox<String> comboCargos = ventana.getComboCargos();
        javax.swing.JPasswordField passClave = ventana.getPassClave();
        javax.swing.JPasswordField passClaveRepetida = ventana.getPassClaveRepetida();
        javax.swing.JTextField txtDNI = ventana.getTxtDNI();

        String apellidos, nombres, clave, claveRepetida;
        Cargo cargo;

        int dni = 0;
        if (!txtDNI.getText().trim().isEmpty()) {
            if (isNumeric(txtDNI.getText().trim()))
                dni = Integer.parseInt(txtDNI.getText().trim());
        }

        apellidos = txtApellido.getText().trim();
        nombres = txtNombre.getText().trim();
        clave = new String(passClave.getPassword());
        claveRepetida = new String(passClaveRepetida.getPassword());
        cargo = ((ModeloComboCargos) comboCargos.getModel()).obtenerCargo();

        GestorAutores gestorAutor = GestorAutores.crear();
        String resultado = gestorAutor.nuevoAutor(dni, apellidos, nombres, cargo, clave, claveRepetida);
        JOptionPane.showMessageDialog(ventana, resultado);

        if (resultado.equals("\n\tProfesor agregado de forma EXITOSA!")) {
            ocultarVentana();
            limpiarCeldas();
        }

        ControladorAutores controlAutor = ControladorAutores.crear();
        controlAutor.actualizarTablaProfesores();
    }

    /**
     * Se encarga de la modificacion de un profesor
     */
    public void modificarProfesor() {
        javax.swing.JTextField txtApellido = ventana.getTxtApellidos();
        javax.swing.JTextField txtNombre = ventana.getTxtNombres();
        javax.swing.JComboBox<String> comboCargos = ventana.getComboCargos();
        javax.swing.JPasswordField passClave = ventana.getPassClave();
        javax.swing.JPasswordField passClaveRepetida = ventana.getPassClaveRepetida();

        String apellidos = txtApellido.getText().trim();
        String nombres = txtNombre.getText().trim();
        String clave = new String(passClave.getPassword());
        String claveRepetida = new String(passClaveRepetida.getPassword());
        Cargo cargo = ((ModeloComboCargos) comboCargos.getModel()).obtenerCargo();

        GestorAutores gestorAutor = GestorAutores.crear();

        String resultado = gestorAutor.modificarAutor(new Profesor(Integer.parseInt(ventana.getTxtDNI().getText().trim()), null, null, null, null), apellidos, nombres, cargo, clave, claveRepetida);
        JOptionPane.showMessageDialog(ventana, resultado);

        if (resultado.equals("Datos de Profesor modificados de forma EXITOSA!")) {
            ocultarVentana();
            limpiarCeldas();
        }
        ControladorAutores controlAutor = ControladorAutores.crear();
        controlAutor.actualizarTablaProfesores();
    }


    @Override
    public void btnGuardarClic(ActionEvent evt) {

        if (ventana.getTitle().equals(IControladorAMProfesor.TITULO_NUEVO)) {
            this.nuevoProfesor();
        } else if (ventana.getTitle().equals(IControladorAMProfesor.TITULO_MODIFICAR))
            this.modificarProfesor();
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ocultarVentana();
    }

    @Override
    public void txtApellidosPresionarTecla(KeyEvent evt) {
        javax.swing.JTextField txtApellido = this.ventana.getTxtApellidos();
        javax.swing.JTextField txtNombre = this.ventana.getTxtNombres();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtApellido.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(ventana, "Ingrese un apellido");
            } else {
                txtNombre.requestFocus();
            }
        }
    }

    @Override
    public void txtNombresPresionarTecla(KeyEvent evt) {
        javax.swing.JTextField txtNombre = this.ventana.getTxtNombres();
        javax.swing.JComboBox comboBox = this.ventana.getComboCargos();

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtNombre.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(ventana, "Ingrese un nombre");
            } else {
                comboBox.requestFocus();
                comboBox.showPopup();
            }
        }
    }

    @Override
    public void txtDocumentoPresionarTecla(KeyEvent evt) {
        javax.swing.JTextField txtDni = this.ventana.getTxtDNI();
        javax.swing.JTextField txtApellido = this.ventana.getTxtApellidos();

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtDni.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(ventana, "Ingrese un DNI");
            } else {
                txtApellido.requestFocus();
            }
        }
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
        javax.swing.JPasswordField passClave = this.ventana.getPassClave();
        javax.swing.JPasswordField passClaveRepetida = this.ventana.getPassClaveRepetida();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JOptionPane.showMessageDialog(ventana, "Ingrese una clave");
            passClaveRepetida.requestFocus();
        }
    }

    @Override
    public void passRepetirClavePresionarTecla(KeyEvent evt) {
        javax.swing.JPasswordField passClaveRepetida = this.ventana.getPassClaveRepetida();
        javax.swing.JButton btnGuardar = this.ventana.getBtnGuardar();

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JOptionPane.showMessageDialog(ventana, "Ingrese nuevamente la clave");
            btnGuardar.requestFocus();
            btnGuardar.doClick();
        }
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {

    }
}
