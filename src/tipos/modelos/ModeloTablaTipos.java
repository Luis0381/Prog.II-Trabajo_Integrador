package tipos.modelos;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ModeloTablaTipos extends AbstractTableModel {
    private final List<String> nombresColumnas = new ArrayList<>();
    private List<Tipo> tipos = new ArrayList<>();

    public ModeloTablaTipos() {
        this.nombresColumnas.add("Nombre");

        GestorTipos gesTipos = GestorTipos.crear();
        tipos = gesTipos.verTipos();
    }

    public ModeloTablaTipos(String buscarTipo) {
        this.nombresColumnas.add("Nombre");

        GestorTipos gestorTipos = GestorTipos.crear();
        tipos = gestorTipos.buscarTipos(buscarTipo);
    }

    @Override
    public int getRowCount() {
        return this.tipos.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tipo a = this.tipos.get(rowIndex);

        switch (columnIndex) {
            default:
                return a.verNombre();
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }
}
