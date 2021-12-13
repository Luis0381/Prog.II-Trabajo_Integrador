package autores.controladores;

import autores.modelos.*;
import autores.vistas.VentanaAutores;
import interfaces.IControladorAutores;
import principal.controladores.ControladorVentanaPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

/**
 * @author Thomas Mafut & Luis Medina Raed
 */
public class ControladorAutores implements IControladorAutores {
    private static ControladorAutores instancia;
    private VentanaAutores ventana;

    /**
     * Constructor
     */
    public ControladorAutores() {
        this.ventana = new VentanaAutores(this);
    }

    /**
     * Crea una instancia de ControladorAutores
     */
    public static ControladorAutores crear() {
        if (instancia == null)
            instancia = new ControladorAutores();

        return instancia;
    }

    /**
     * Muestra la ventana
     */
    public void mostrarVentana() {
        if (ventana == null)
            ventana = new VentanaAutores(this);
        else
            ventana.setVisible(true);
    }

    /**
     * Oculta la ventana
     */
    public void ocultarVentana() {
        ventana.setVisible(false);
    }

    /**
     * Se encarga de actualizar los datos de la tabla de profesores
     */
    public void actualizarTablaProfesores() {
        javax.swing.JTable TablaProfesor = ventana.getTablaProfesores();
        TablaProfesor.setModel(new ModeloTablaProfesor());

        javax.swing.JButton btnBorrarProfesor = ventana.getBtnBorrarProfesor();
        javax.swing.JButton btnModificarProfesor = ventana.getBtnModificarProfesor();

        if (TablaProfesor.getRowCount() == 0) {
            btnBorrarProfesor.setEnabled(false);
            btnModificarProfesor.setEnabled(false);
        } else {
            btnBorrarProfesor.setEnabled(true);
            btnModificarProfesor.setEnabled(true);
        }
    }

    /**
     * Se encarga de filtrar la tabla de profesores segun un apellido ingresado por el usuario
     *
     * @param filtrarApellido Apellido ingresado por el usuario con el cual se filtrara la base de datos
     */
    public void filtrarTablaProfesores(String filtrarApellido) {
        javax.swing.JTable TablaProfesor = ventana.getTablaProfesores();
        TablaProfesor.setModel(new ModeloTablaProfesor(filtrarApellido));

        javax.swing.JButton btnBorrarProfesor = ventana.getBtnBorrarProfesor();
        javax.swing.JButton btnModificarProfesor = ventana.getBtnModificarProfesor();

        if (TablaProfesor.getRowCount() == 0) {
            btnBorrarProfesor.setEnabled(false);
            btnModificarProfesor.setEnabled(false);
        } else {
            btnBorrarProfesor.setEnabled(true);
            btnModificarProfesor.setEnabled(true);
        }
    }

    /**
     * Se encarga de actualizar los datos de la tabla de profesores
     */
    public void actualizarTablaAlumnos() {
        javax.swing.JTable TablaAlumnos = ventana.getTablaAlumnos();
        TablaAlumnos.setModel(new ModeloTablaAlumnos());

        javax.swing.JButton btnBorrarAlumno = ventana.getBtnBorrarAlumno();
        javax.swing.JButton btnModificarAlumno = ventana.getBtnModificarAlumno();

        if (TablaAlumnos.getRowCount() == 0) {
            btnBorrarAlumno.setEnabled(false);
            btnModificarAlumno.setEnabled(false);
        } else {
            btnBorrarAlumno.setEnabled(true);
            btnModificarAlumno.setEnabled(true);
        }
    }

    /**
     * Se encarga de filtrar la tabla de profesores segun un apellido ingresado por el usuario
     *
     * @param filtrarApellido Apellido ingresado por el usuario con el cual se filtrara la base de datos
     */
    public void filtrarTablaAlumnos(String filtrarApellido) {
        javax.swing.JTable TablaAlumnos = ventana.getTablaAlumnos();
        TablaAlumnos.setModel(new ModeloTablaAlumnos(filtrarApellido));

        javax.swing.JButton btnBorrarAlumno = ventana.getBtnBorrarAlumno();
        javax.swing.JButton btnModificarAlumno = ventana.getBtnModificarAlumno();

        if (TablaAlumnos.getRowCount() == 0) {
            btnBorrarAlumno.setEnabled(false);
            btnModificarAlumno.setEnabled(false);
        } else {
            btnBorrarAlumno.setEnabled(true);
            btnModificarAlumno.setEnabled(true);
        }
    }


    @Override
    public void btnNuevoProfesorClic(ActionEvent evt) {
        ControladorAProfesor instancia = ControladorAProfesor.crear();

        javax.swing.JTextField txtDNi = instancia.getVentana().getTxtDNI();
        txtDNi.setEnabled(true);
        instancia.mostrarVentana(instancia.TITULO_NUEVO);
    }

    @Override
    public void btnNuevoAlumnoClic(ActionEvent evt) {
        ControladorAAlumno instancia = ControladorAAlumno.crear();

        javax.swing.JTextField txtDNi = instancia.getVentana().getTxtDNI();
        txtDNi.setEnabled(true);
        instancia.mostrarVentana(instancia.TITULO_NUEVO);
    }

    @Override
    public void btnModificarProfesorClic(ActionEvent evt) {
        javax.swing.JTable TablaProfesor = ventana.getTablaProfesores();

        int filaElegida = TablaProfesor.getSelectedRow();

        if(filaElegida != -1){
            ControladorMProfesor controlModificarProfe = ControladorMProfesor.crear();

            javax.swing.JTable TablaGruposProfesor = controlModificarProfe.getVentana().getTablaGruposProfesor();
            javax.swing.JTextField txtApellido = controlModificarProfe.getVentana().getTxtApellidos();
            javax.swing.JTextField txtNombre = controlModificarProfe.getVentana().getTxtNombres();
            javax.swing.JPasswordField passClave = controlModificarProfe.getVentana().getPassClave();
            javax.swing.JComboBox comboCargos = controlModificarProfe.getVentana().getComboCargos();
            javax.swing.JPasswordField passClaveRepetida = controlModificarProfe.getVentana().getPassClaveRepetida();
            javax.swing.JTextField txtDNI = controlModificarProfe.getVentana().getTxtDNI();

            GestorAutores autores = GestorAutores.crear();
            Profesor p = (Profesor)autores.verAutor(Integer.parseInt(TablaProfesor.getValueAt(filaElegida, 0).toString()));

            TablaGruposProfesor.setModel(new ModeloTablaGrupos(p));
            txtDNI.setText(TablaProfesor.getValueAt(filaElegida, 0).toString());
            txtApellido.setText(p.verApellidos());
            txtNombre.setText(p.verNombres());
            comboCargos.setSelectedItem(p.verCargo());
            passClave.setText(p.verClave());
            passClaveRepetida.setText(p.verClave());

            txtDNI.setEnabled(false);

            controlModificarProfe.mostrarVentana(controlModificarProfe.TITULO_MODIFICAR);
        }

        else{
            JOptionPane.showMessageDialog(ventana, "No ha seleccionado ningun profesor");
        }
    }

    @Override
    public void btnModificarAlumnoClic(ActionEvent evt) {
        javax.swing.JTable TablaAlumno = ventana.getTablaAlumnos();

        int filaElegida = TablaAlumno.getSelectedRow();

        if(filaElegida != -1){
            ControladorMAlumno controlAlumno = ControladorMAlumno.crear();

            javax.swing.JTable TablaGruposAlumno = controlAlumno.getVentana().getTablaGruposAlumno();
            javax.swing.JTextField txtApellido = controlAlumno.getVentana().getTxtApellidos();
            javax.swing.JTextField txtNombre = controlAlumno.getVentana().getTxtNombres();
            javax.swing.JPasswordField passClave = controlAlumno.getVentana().getPassClave();
            javax.swing.JPasswordField passClaveRepetida = controlAlumno.getVentana().getPassClaveRepetida();
            javax.swing.JTextField txtDNI = controlAlumno.getVentana().getTxtDNI();
            javax.swing.JTextField txtCX = controlAlumno.getVentana().getTxtCX();

            GestorAutores autores = GestorAutores.crear();
            Alumno a = (Alumno)autores.verAutor(Integer.parseInt(TablaAlumno.getValueAt(filaElegida, 0).toString()));

            TablaGruposAlumno.setModel(new ModeloTablaGrupos(a));
            txtDNI.setText(TablaAlumno.getValueAt(filaElegida, 0).toString());
            txtApellido.setText(a.verApellidos());
            txtNombre.setText(a.verNombres());
            txtCX.setText(a.verCx());
            passClave.setText(a.verClave());
            passClaveRepetida.setText(a.verClave());

            txtDNI.setEnabled(false);

            controlAlumno.mostrarVentana(controlAlumno.TITULO_MODIFICAR);
        }

        else{
            JOptionPane.showMessageDialog(ventana, "No ha seleccionado ningun alumno");
        }
    }

    @Override
    public void btnBorrarProfesorClic(ActionEvent evt) {
        javax.swing.JTable TablaProfesores = ventana.getTablaProfesores();
        int alumnoElegido = TablaProfesores.getSelectedRow();

        if (alumnoElegido != -1) {
            String[] botones = {"Si", "No"};
            int respuesta = JOptionPane.showOptionDialog(ventana, "¿Desea eliminar el profesor seleccionado?", "Eliminar Profesor", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);

            if (respuesta == 0) {
                int DNI = Integer.parseInt(TablaProfesores.getValueAt(alumnoElegido, 0).toString());

                GestorAutores GesAutores = GestorAutores.crear();
                String resultado = GesAutores.borrarAutor(new Profesor(DNI, null, null, null, Cargo.ADJUNTO));

                actualizarTablaProfesores();
                JOptionPane.showMessageDialog(ventana, resultado);
            } else {
                JOptionPane.showMessageDialog(ventana, "Operacion cancelada con EXITO");
            }
        } else
            JOptionPane.showMessageDialog(ventana, "Seleccione un profesor");

        actualizarTablaProfesores();
    }

    @Override
    public void btnBorrarAlumnoClic(ActionEvent evt) {
        javax.swing.JTable TablaAlumnos = ventana.getTablaAlumnos();
        int alumnoElegido = TablaAlumnos.getSelectedRow();

        if (alumnoElegido != -1) {
            String[] botones = {"Si", "No"};
            int respuesta = JOptionPane.showOptionDialog(ventana, "¿Desea eliminar el alumno seleccionado?", "Eliminar Alumno", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);
            if (respuesta == 0) {
                int DNI = Integer.parseInt(TablaAlumnos.getValueAt(alumnoElegido, 0).toString());
                String CX = TablaAlumnos.getValueAt(alumnoElegido, 3).toString();

                GestorAutores GesAutores = GestorAutores.crear();
                String resultado = GesAutores.borrarAutor(new Alumno(DNI, null, null, null, CX));

                actualizarTablaAlumnos();
                JOptionPane.showMessageDialog(ventana, resultado);
            } else
                JOptionPane.showMessageDialog(ventana, "Operacion cancelada con EXITO");
        } else
            JOptionPane.showMessageDialog(ventana, "Seleccione un alumno");

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
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void txtApellidosProfesorPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            javax.swing.JTextField txtApellido = this.ventana.getTxtApellidosProfesor();
            javax.swing.JButton btnBuscarProfesor = this.ventana.getBtnBuscarProfesor();

            btnBuscarProfesor.requestFocus();
            btnBuscarProfesor.doClick();
        }
    }

    @Override
    public void txtApellidosAlumnoPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            javax.swing.JTextField txtApellido = this.ventana.getTxtApellidosAlumno();
            javax.swing.JButton btnBuscarAlumno = this.ventana.getBtnBuscarAlumno();

            btnBuscarAlumno.requestFocus();
            btnBuscarAlumno.doClick();
        }
    }
}
