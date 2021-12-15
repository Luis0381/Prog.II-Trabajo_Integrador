package grupos.modelos;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ModeloTablaGrupos extends AbstractTableModel {
    List<String> nombreColumnas = new ArrayList<>();
    List<Grupo> grupos = new ArrayList<Grupo>();

    public ModeloTablaGrupos() {
        this.nombreColumnas.add("Nombre");
        this.nombreColumnas.add("Descripcion");

        GestorGrupos gesGrupos = GestorGrupos.crear();

        this.grupos = gesGrupos.verGrupos();
    }

    public ModeloTablaGrupos(String nombreBuscar) {
        this.nombreColumnas.add("Nombre");
        this.nombreColumnas.add("Descripcion");

        GestorGrupos gGrupos = GestorGrupos.crear();

        this.grupos = gGrupos.buscarGrupos(nombreBuscar);
    }

    @Override
    public int getRowCount() {
        return this.grupos.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Grupo g = this.grupos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return g.verNombre();
            case 1:
                return g.verDescripcion();
            default:
                return g.verNombre();
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombreColumnas.get(columna);
    }
}
