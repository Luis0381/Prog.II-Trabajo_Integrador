package autores.modelos;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModeloTablaAlumnos extends AbstractTableModel {
    private ArrayList<String> nombresColumnas = new ArrayList<>();
    private ArrayList<Alumno> alumnos = new ArrayList<>();

    public ModeloTablaAlumnos() {
        this.nombresColumnas.add("DNI");
        this.nombresColumnas.add("Apellidos");
        this.nombresColumnas.add("Nombres");
        this.nombresColumnas.add("CX");
        GestorAutores autores = GestorAutores.crear();
        this.alumnos = autores.verAlumnos();
    }

    public ModeloTablaAlumnos(String apellido) {
        this.nombresColumnas.add("DNI");
        this.nombresColumnas.add("Apellidos");
        this.nombresColumnas.add("Nombres");
        this.nombresColumnas.add("CX");
        GestorAutores autores = GestorAutores.crear();

        this.alumnos = autores.buscarAlumnos(apellido);
    }

    @Override
    public int getRowCount() {
        return this.alumnos.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size();
    }

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

    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }
}
