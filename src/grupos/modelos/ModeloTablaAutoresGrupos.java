package grupos.modelos;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

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
        this.nombresColumnas.add("Nombre");
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
        MiembroEnGrupo Meg = this.miembros.get(rowIndex);
        switch(columnIndex) {
            case 0: return Meg.verAutor().verNombres();
            case 1: return Meg.verRol();
            default: return Meg.verAutor().verNombres();
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }
}
