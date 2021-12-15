package publicaciones.modelos;

import interfaces.IGestorPublicaciones;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;
import java.util.List;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ModeloTablaPublicaciones extends AbstractTableModel {
    public static final String COLUMNA_TITULO = "Título";
    public static final String COLUMNA_AUTOR = "Autor";
    public static final String COLUMNA_ANIO = "Año";
    //constantes para los nombres de las columnas 

    private final List<Publicacion> publicaciones;
    //los datos los saca de GestorPublicaciones

    private final List<String> nombresColumnas = Arrays.asList(COLUMNA_TITULO, COLUMNA_AUTOR, COLUMNA_ANIO);
    //colección para guardar los nombres de las columnas

    private final IGestorPublicaciones gesPublicaciones = GestorPublicaciones.crear();

    public ModeloTablaPublicaciones(String titulo) {
        this.publicaciones = this.gesPublicaciones.buscarPublicaciones(titulo);
    }

    public ModeloTablaPublicaciones() {
        this.publicaciones = this.gesPublicaciones.verPublicaciones();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Publicacion publicacion = this.publicaciones.get(fila);
        switch (columna) {
            case 0:
                return publicacion.getTitulo();
            case 1:
                return publicacion.getAutor().verAutor().verNombreCompleto();
            case 2:
                return publicacion.getFechaPublicacion().getYear();
            default:
                return publicacion.getTitulo();
        }
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size();
    }

    @Override
    public int getRowCount() {
        return this.publicaciones.size();
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }

    public Publicacion verPublicacion(int fila) {
        try {
            return this.publicaciones.get(fila);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}