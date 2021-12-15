package idiomas.modelos;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ModeloTablaIdiomas extends AbstractTableModel {
    private final List<String> nombresColumnas = new ArrayList<>();
    private List<Idioma> idiomas = new ArrayList<>();

    public ModeloTablaIdiomas() {
        this.nombresColumnas.add("Nombre");

        GestorIdiomas gesIdiomas = GestorIdiomas.crear();
        idiomas = gesIdiomas.verIdiomas();
    }

    public ModeloTablaIdiomas(String buscarIdioma) {
        this.nombresColumnas.add("Nombre");

        GestorIdiomas gestorIdiomas = GestorIdiomas.crear();
        idiomas = gestorIdiomas.buscarIdiomas(buscarIdioma);
    }

    @Override
    public int getRowCount() {
        return this.idiomas.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Idioma a = this.idiomas.get(rowIndex);

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
