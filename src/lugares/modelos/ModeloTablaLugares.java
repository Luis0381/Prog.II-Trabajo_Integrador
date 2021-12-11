package lugares.modelos;


import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModeloTablaLugares extends AbstractTableModel {
    private List<String> nombresColumnas = new ArrayList<>();
    private List<Lugar> lugares = new ArrayList<>();

    public ModeloTablaLugares() {
        this.nombresColumnas.add("Nombre");

        GestorLugares gesLugares = GestorLugares.crear();
        lugares = gesLugares.verLugares();
    }

    public ModeloTablaLugares(String buscarLugar) {
        this.nombresColumnas.add("Nombre");

        GestorLugares gesLugares = GestorLugares.crear();
        lugares = gesLugares.buscarLugares(buscarLugar);
    }

    @Override
    public int getRowCount() {
        return this.lugares.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Lugar a = this.lugares.get(rowIndex);

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
