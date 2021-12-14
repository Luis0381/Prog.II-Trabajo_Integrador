package grupos.modelos;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ModeloTablaAutoresGrupos extends AbstractTableModel {
    private List<String> nombresColumnas = new ArrayList<>();
    private List<MiembroEnGrupo> miembros = new ArrayList<>();

    public ModeloTablaAutoresGrupos(Grupo g) {
        this.nombresColumnas.add("Nombre");
        this.nombresColumnas.add("Rol");

        if(g.verMiembros() != null){
            this.miembros = g.verMiembros() ;
        }
    }

    public ModeloTablaAutoresGrupos() {
        this.nombresColumnas.add("Apellido");
        this.nombresColumnas.add("Rol");
    }

    @Override
    public int getRowCount() {
        return this.miembros.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MiembroEnGrupo meg = this.miembros.get(rowIndex);
        switch(columnIndex) {
            case 0: return meg.verAutor().verApellidos()  + ", " + meg.verAutor().verNombres() + " (" + meg.verAutor().verDni() + ")";
            case 1: return meg.verRol();
            default: return meg.verAutor().verApellidos()  + ", " + meg.verAutor().verNombres() + " (" + meg.verAutor().verDni() + ")";
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }
}
