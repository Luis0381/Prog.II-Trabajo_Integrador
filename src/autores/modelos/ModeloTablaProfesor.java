package autores.modelos;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ModeloTablaProfesor extends AbstractTableModel {
    private final ArrayList<String> nombresColumnas = new ArrayList<>();
    private ArrayList<Profesor> profesores = new ArrayList<>();

    /**
     * Constructor
     */
    public ModeloTablaProfesor() {
        this.nombresColumnas.add("DNI");
        this.nombresColumnas.add("Apellidos");
        this.nombresColumnas.add("Nombres");
        this.nombresColumnas.add("Cargo");
        GestorAutores autores = GestorAutores.crear();
        this.profesores = autores.verProfesores();
    }

    /**
     * Constructor
     */
    public ModeloTablaProfesor(String apellido) {
        this.nombresColumnas.add("DNI");
        this.nombresColumnas.add("Apellidos");
        this.nombresColumnas.add("Nombres");
        this.nombresColumnas.add("Cargo");
        GestorAutores autores = GestorAutores.crear();
        this.profesores = autores.buscarProfesores(apellido);
    }

    /**
     * Obtiene la cantidad de filas de la tabla
     *
     * @return int numero de filas en la tabla
     */
    @Override
    public int getRowCount() {
        return this.profesores.size();
    }

    /**
     * Obtiene la cantidad de columnas de la tabla
     *
     * @return int numero de columnas en la tabla
     */
    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size();
    }

    /**
     * Obtiene el valor de la celda
     *
     * @param fila    fila de la celda
     * @param columna columna de la celda
     * @return Object valor de la celda
     */
    @Override
    public Object getValueAt(int fila, int columna) {
        Profesor profesor = this.profesores.get(fila);
        return switch (columna) {
            case 0 -> profesor.verDni();
            case 1 -> profesor.verApellidos();
            case 2 -> profesor.verNombres();
            case 3 -> profesor.verCargo();
            default -> null;
        };
    }

    /**
     * Obtiene el nombre de una columna
     *
     * @param columna columna sobre la que se quiere obtener el nombre
     * @return String nombre de la columna especificada
     */
    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }
}
