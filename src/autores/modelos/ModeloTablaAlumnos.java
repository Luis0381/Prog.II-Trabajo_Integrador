package autores.modelos;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ModeloTablaAlumnos extends AbstractTableModel {
    private final ArrayList<String> nombresColumnas = new ArrayList<>();
    private ArrayList<Alumno> alumnos = new ArrayList<>();

    /**
     * Constructor
     */
    public ModeloTablaAlumnos() {
        this.nombresColumnas.add("DNI");
        this.nombresColumnas.add("Apellidos");
        this.nombresColumnas.add("Nombres");
        this.nombresColumnas.add("CX");
        GestorAutores autores = GestorAutores.crear();
        this.alumnos = autores.verAlumnos();
    }

    /**
     * Constructor
     */
    public ModeloTablaAlumnos(String apellido) {
        this.nombresColumnas.add("DNI");
        this.nombresColumnas.add("Apellidos");
        this.nombresColumnas.add("Nombres");
        this.nombresColumnas.add("CX");
        GestorAutores autores = GestorAutores.crear();

        this.alumnos = autores.buscarAlumnos(apellido);
    }

    /**
     * Obtiene la cantidad de filas de la tabla
     *
     * @return int numero de filas en la tabla
     */
    @Override
    public int getRowCount() {
        return this.alumnos.size();
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
        Alumno alumno = this.alumnos.get(fila);
        return switch (columna) {
            case 0 -> alumno.verDni();
            case 1 -> alumno.verApellidos();
            case 2 -> alumno.verNombres();
            case 3 -> alumno.verCx();
            default -> null;
        };
    }

    /**
     * Obtiene el nombre de una columna
     *
     * @param columna columna de la que obtenes el nombre
     * @return String nombre de la columna
     */
    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }
}
