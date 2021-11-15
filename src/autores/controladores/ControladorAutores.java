package autores.controladores;

import autores.modelos.*;
import autores.vistas.VentanaAutores;
import interfaces.IControladorAutores;
import principal.controladores.ControladorVentanaPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class ControladorAutores implements IControladorAutores {
    private static ControladorAutores instancia;
    private VentanaAutores ventana;

    public ControladorAutores() {
        this.ventana = new VentanaAutores(this);
    }

    public static ControladorAutores crear() {
        if (instancia == null)
            instancia = new ControladorAutores();

        return instancia;
    }

    public void mostrarVentana() {
        if (ventana == null)
            ventana = new VentanaAutores(this);
        else
            ventana.setVisible(true);
    }

    public void ocultarVentana() {
        ventana.setVisible(false);
    }

    public void actualizarTablaProfesores(){
        javax.swing.JTable TablaProfesor = ventana.getTablaProfesores();
        TablaProfesor.setModel(new ModeloTablaProfesor());

        javax.swing.JButton btnBorrarProfesor = ventana.getBtnBorrarProfesor();
        javax.swing.JButton btnModificarProfesor = ventana.getBtnModificarProfesor();

        if(TablaProfesor.getRowCount() == 0){
            btnBorrarProfesor.setEnabled(false);
            btnModificarProfesor.setEnabled(false);
        }
        else{
            btnBorrarProfesor.setEnabled(true);
            btnModificarProfesor.setEnabled(true);
        }
    }

    public void filtrarTablaProfesores(String filtrarApellido){
        javax.swing.JTable TablaProfesor = ventana.getTablaProfesores();
        TablaProfesor.setModel(new ModeloTablaProfesor(filtrarApellido));

        javax.swing.JButton btnBorrarProfesor = ventana.getBtnBorrarProfesor();
        javax.swing.JButton btnModificarProfesor = ventana.getBtnModificarProfesor();

        if(TablaProfesor.getRowCount() == 0){
            btnBorrarProfesor.setEnabled(false);
            btnModificarProfesor.setEnabled(false);
        }
        else{
            btnBorrarProfesor.setEnabled(true);
            btnModificarProfesor.setEnabled(true);
        }
    }

    public void actualizarTablaAlumnos(){
        javax.swing.JTable TablaAlumnos = ventana.getTablaAlumnos();
        TablaAlumnos.setModel(new ModeloTablaAlumnos());

        javax.swing.JButton btnBorrarAlumno = ventana.getBtnBorrarAlumno();
        javax.swing.JButton btnModificarAlumno = ventana.getBtnModificarAlumno();

        if(TablaAlumnos.getRowCount() == 0){
            btnBorrarAlumno.setEnabled(false);
            btnModificarAlumno.setEnabled(false);
        }
        else{
            btnBorrarAlumno.setEnabled(true);
            btnModificarAlumno.setEnabled(true);
        }
    }

    public void filtrarTablaAlumnos(String filtrarApellido){
        javax.swing.JTable TablaAlumnos = ventana.getTablaAlumnos();
        TablaAlumnos.setModel(new ModeloTablaAlumnos(filtrarApellido));

        javax.swing.JButton btnBorrarAlumno = ventana.getBtnBorrarAlumno();
        javax.swing.JButton btnModificarAlumno = ventana.getBtnModificarAlumno();

        if(TablaAlumnos.getRowCount() == 0){
            btnBorrarAlumno.setEnabled(false);
            btnModificarAlumno.setEnabled(false);
        }
        else{
            btnBorrarAlumno.setEnabled(true);
            btnModificarAlumno.setEnabled(true);
        }
    }

    @Override
    public void btnNuevoProfesorClic(ActionEvent evt) {
        ControladorAMProfesor instancia = ControladorAMProfesor.crear();

        javax.swing.JTextField txtDNi = instancia.getVentana().getTxtDNI();
        txtDNi.setEnabled(true);
        instancia.mostrarVentana(instancia.TITULO_NUEVO);
    }

    @Override
    public void btnNuevoAlumnoClic(ActionEvent evt) {
        ControladorAMAlumno instancia = ControladorAMAlumno.crear();

        javax.swing.JTextField txtDNi = instancia.getVentana().getTxtDNI();
        txtDNi.setEnabled(true);
        instancia.mostrarVentana(instancia.TITULO_NUEVO);
    }

    @Override
    public void btnModificarProfesorClic(ActionEvent evt) {
        ControladorAMProfesor instancia = ControladorAMProfesor.crear();

        javax.swing.JTable TablaProfesores = ventana.getTablaProfesores();

        int profesorElegido = TablaProfesores.getSelectedRow();

        if (profesorElegido != -1) {
            ControladorAMProfesor controlInstancia = ControladorAMProfesor.crear();

            javax.swing.JTextField txtApellido = controlInstancia.getVentana().getTxtApellidos();
            javax.swing.JTextField txtNombre = controlInstancia.getVentana().getTxtNombres();
            javax.swing.JPasswordField passClave = controlInstancia.getVentana().getPassClave();
            javax.swing.JComboBox comboCargos = controlInstancia.getVentana().getComboCargos();
            javax.swing.JPasswordField passClaveRepetida = controlInstancia.getVentana().getPassClaveRepetida();
            javax.swing.JTextField txtDNI = controlInstancia.getVentana().getTxtDNI();

            GestorAutores autores = GestorAutores.crear();
            Profesor profesor = (Profesor) autores.verAutor(Integer.parseInt(TablaProfesores.getValueAt(profesorElegido, 0).toString()));

            txtDNI.setText(TablaProfesores.getValueAt(profesorElegido, 0).toString());
            txtApellido.setText(profesor.verApellidos());
            txtNombre.setText(profesor.verNombres());
            comboCargos.setSelectedItem(profesor.verCargo());
            passClave.setText(profesor.verClave());
            passClaveRepetida.setText(profesor.verClave());

            txtDNI.setEnabled(false);

            instancia.mostrarVentana(instancia.TITULO_MODIFICAR);
        } else {
            JOptionPane.showMessageDialog(ventana, "No ha seleccionado ningun profesor");
        }
    }

    @Override
    public void btnModificarAlumnoClic(ActionEvent evt) {
        ControladorAMAlumno instancia = ControladorAMAlumno.crear();

        javax.swing.JTable TablaAlumnos = ventana.getTablaAlumnos();

        int alumnoElegido = TablaAlumnos.getSelectedRow();

        if (alumnoElegido != -1) {
            ControladorAMAlumno controlInstancia = ControladorAMAlumno.crear();

            javax.swing.JTextField txtApellido = controlInstancia.getVentana().getTxtApellidos();
            javax.swing.JTextField txtNombre = controlInstancia.getVentana().getTxtNombres();
            javax.swing.JPasswordField passClave = controlInstancia.getVentana().getPassClave();
            javax.swing.JTextField txtCX = controlInstancia.getVentana().getTxtCX();
            javax.swing.JPasswordField passClaveRepetida = controlInstancia.getVentana().getPassClaveRepetida();
            javax.swing.JTextField txtDNI = controlInstancia.getVentana().getTxtDNI();

            GestorAutores autores = GestorAutores.crear();
            Alumno alumno = (Alumno) autores.verAutor(Integer.parseInt(TablaAlumnos.getValueAt(alumnoElegido, 0).toString()));

            txtDNI.setText(TablaAlumnos.getValueAt(alumnoElegido, 0).toString());
            txtApellido.setText(alumno.verApellidos());
            txtNombre.setText(alumno.verNombres());
            txtCX.setText(alumno.verCx());
            passClave.setText(alumno.verClave());
            passClaveRepetida.setText(alumno.verClave());
            txtDNI.setEnabled(false);

            instancia.mostrarVentana(instancia.TITULO_MODIFICAR);
        } else {
            JOptionPane.showMessageDialog(ventana, "No ha seleccionado ningun profesor");
        }
    }

    @Override
    public void btnBorrarProfesorClic(ActionEvent evt) {
        javax.swing.JTable TablaProfesores = ventana.getTablaProfesores();
        int alumnoElegido = TablaProfesores.getSelectedRow();

        if(alumnoElegido != -1){
            String[] botones = {"Si", "No"};
            int respuesta = JOptionPane.showOptionDialog(ventana, "¿Desea eliminar el profesor seleccionado?", "Elija Una Opcion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);

            if(respuesta == 0){
                int DNI = Integer.parseInt(TablaProfesores.getValueAt(alumnoElegido, 0).toString());

                GestorAutores GesAutores = GestorAutores.crear();
                String resultado = GesAutores.borrarAutor(new Profesor(DNI, null, null, null, Cargo.ADJUNTO));

                actualizarTablaProfesores();
                JOptionPane.showMessageDialog(ventana, resultado);
            }
            else{
                JOptionPane.showMessageDialog(ventana, "Se ha cancelado la operación");
            }
        }
        else
            JOptionPane.showMessageDialog(ventana, "No ha seleccionado ningun profesor");

        actualizarTablaProfesores();
    }

    @Override
    public void btnBorrarAlumnoClic(ActionEvent evt) {
        javax.swing.JTable TablaAlumnos = ventana.getTablaAlumnos();
        int alumnoElegido = TablaAlumnos.getSelectedRow();

        if(alumnoElegido != -1){
            String[] botones = {"Si", "No"};
            int respuesta = JOptionPane.showOptionDialog(ventana, "¿Desea eliminar el alumno seleccionado?", "Elija Una Opcion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);
            if(respuesta == 0){
                int DNI = Integer.parseInt(TablaAlumnos.getValueAt(alumnoElegido, 0).toString());
                String CX = TablaAlumnos.getValueAt(alumnoElegido, 3).toString();

                GestorAutores GesAutores = GestorAutores.crear();
                String resultado = GesAutores.borrarAutor(new Alumno(DNI, null, null, null, CX));

                actualizarTablaAlumnos();
                JOptionPane.showMessageDialog(ventana, resultado);
            }
            else
                JOptionPane.showMessageDialog(ventana, "Se ha cancelado la operación");
        }
        else
            JOptionPane.showMessageDialog(ventana, "No ha seleccionado ningun alumno");

        actualizarTablaAlumnos();
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        ocultarVentana();

        ControladorVentanaPrincipal ventanaPrincipal = ControladorVentanaPrincipal.crear();
        ventanaPrincipal.mostrarVentana();
    }

    @Override
    public void btnBuscarProfesorClic(ActionEvent evt) {
        javax.swing.JTextField txtApellido = this.ventana.getTxtApellidosProfesor();
        String apellidoBuscar = txtApellido.getText().trim();

        this.filtrarTablaProfesores(apellidoBuscar);
    }

    @Override
    public void btnBuscarAlumnoClic(ActionEvent evt) {
        javax.swing.JTextField txtApellido = this.ventana.getTxtApellidosAlumno();
        String apellidoBuscar = txtApellido.getText().trim();

        this.filtrarTablaAlumnos(apellidoBuscar);
        txtApellido.setText("");
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void txtApellidosProfesorPresionarTecla(KeyEvent evt) {
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            javax.swing.JTextField txtApellido = this.ventana.getTxtApellidosProfesor();
            javax.swing.JButton btnBuscarProfesor = this.ventana.getBtnBuscarProfesor();

            btnBuscarProfesor.requestFocus();
            btnBuscarProfesor.doClick();

            txtApellido.setText("");
        }
    }

    @Override
    public void txtApellidosAlumnoPresionarTecla(KeyEvent evt) {
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            javax.swing.JTextField txtApellido = this.ventana.getTxtApellidosAlumno();
            javax.swing.JButton btnBuscarAlumno = this.ventana.getBtnBuscarAlumno();

            btnBuscarAlumno.requestFocus();
            btnBuscarAlumno.doClick();

            txtApellido.setText("");
        }
    }
}
