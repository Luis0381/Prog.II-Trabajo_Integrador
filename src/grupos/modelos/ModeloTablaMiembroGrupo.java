package grupos.modelos;

import autores.modelos.Autor;
import autores.modelos.GestorAutores;
import interfaces.IGestorAutores;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModeloTablaMiembroGrupo extends AbstractTableModel {
    public static final String COLUMNA_NOMBRE = "Nombre";
    public static final String COLUMNA_ROL = "Rol";
    private final String VALORES_NULOS = "-";
    private List<MiembroEnGrupo> miembros = new ArrayList<>();
    private List<String> nombresColumnas = Arrays.asList(new String[] {COLUMNA_NOMBRE, COLUMNA_ROL});
    private IGestorAutores ga = GestorAutores.crear();

    public ModeloTablaMiembroGrupo() {
        List<Autor> autores = this.ga.verAutores();
        for(Autor autor : autores) {
            MiembroEnGrupo meg = new MiembroEnGrupo(autor,null,null);
            this.miembros.add(meg);
        }
    }

    public ModeloTablaMiembroGrupo(Grupo grupo) {
        if (grupo != null)
            this.miembros = grupo.verMiembros();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        MiembroEnGrupo meg = this.miembros.get(fila);
        switch(columna) {
            case 0: return meg.verAutor().verApellidos()  + ", " + meg.verAutor().verNombres() + " (" + meg.verAutor().verDni() + ")";
            case 1: return (meg.verRol() == null ? this.VALORES_NULOS : meg.verRol());
            default: return meg.verAutor().verApellidos()  + ", " + meg.verAutor().verNombres() + " (" + meg.verAutor().verDni() + ")";
        }

    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size();
    }

    @Override
    public int getRowCount() {
        return this.miembros.size();
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }

    public MiembroEnGrupo verMiembroEnGrupo(int fila) {
        try {
            return this.miembros.get(fila);
        }
        catch(IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public Class getColumnClass(int columna) {
        return (columna == 0 ? String.class : Rol.class);
    }

    @Override
    public boolean isCellEditable(int fila, int columna) {
        return (columna != 0);
    }

    @Override
    public void setValueAt(Object unValor, int fila, int columna) {
        if (columna == 1) {
            MiembroEnGrupo meg = this.miembros.get(fila);
            meg.asignarRol((Rol)unValor);
            fireTableCellUpdated(fila, columna);
        }
    }
}
