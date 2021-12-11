package tipos.modelos;

import idiomas.modelos.*;
import idiomas.modelos.GestorIdiomas;
import idiomas.modelos.Idioma;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModeloTablaTipos extends AbstractTableModel {
    private List<String> nombresColumnas = new ArrayList<>();
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
