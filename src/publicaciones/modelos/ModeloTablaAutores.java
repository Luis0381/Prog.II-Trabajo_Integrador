package publicaciones.modelos;

import autores.modelos.Autor;
import autores.modelos.GestorAutores;
import interfaces.IGestorAutores;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;
import java.util.List;

public class ModeloTablaAutores extends AbstractTableModel {
    public static final String COLUMNA_NOMBRE = "Nombre";

    private List<Autor> autores;

    private List<String> nombresColumnas = Arrays.asList(new String[] {COLUMNA_NOMBRE});

    private IGestorAutores gesAutores = GestorAutores.crear();

    public ModeloTablaAutores() {
        this.autores = this.gesAutores.verAutores(); //todos los autores
    }


    @Override
    public Object getValueAt(int fila, int columna) {
        Autor autor = this.autores.get(fila);
        return autor.verApellidos() + ", " + autor.verNombres() + " (" + autor.verDni() + ")";
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size();
    }

    @Override
    public int getRowCount() {
        return this.autores.size();
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }

    public Autor verAutor(int fila) {
        try {
            return this.autores.get(fila);
        }
        catch(IndexOutOfBoundsException e) {
            return null;
        }
    }
}