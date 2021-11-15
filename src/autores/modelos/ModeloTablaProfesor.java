package autores.modelos;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModeloTablaProfesor extends AbstractTableModel {
    private ArrayList<String> nombresColumnas = new ArrayList<>();
    private ArrayList<Profesor> profesores = new ArrayList<>();

    public ModeloTablaProfesor() {
        this.nombresColumnas.add("DNI");
        this.nombresColumnas.add("Apellidos");
        this.nombresColumnas.add("Nombres");
        this.nombresColumnas.add("Cargo");
        GestorAutores autores = GestorAutores.crear();
        this.profesores = autores.verProfesores();
    }

    public ModeloTablaProfesor(String apellido) {
        this.nombresColumnas.add("DNI");
        this.nombresColumnas.add("Apellidos");
        this.nombresColumnas.add("Nombres");
        this.nombresColumnas.add("Cargo");
        GestorAutores autores = GestorAutores.crear();
        this.profesores = autores.buscarProfesores(apellido);
    }

    @Override
    public int getRowCount() {
        return this.profesores.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size();
    }

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

    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }
}
