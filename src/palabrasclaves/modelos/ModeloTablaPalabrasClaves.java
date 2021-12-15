package palabrasclaves.modelos;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ModeloTablaPalabrasClaves extends AbstractTableModel {
    private final List<String> nombresColumnas = new ArrayList<>();
    private List<PalabraClave> palabrasClaves = new ArrayList<>();

    public ModeloTablaPalabrasClaves() {
        this.nombresColumnas.add("Nombre");

        GestorPalabrasClaves gesPalabrasClaves = GestorPalabrasClaves.crear();
        palabrasClaves = gesPalabrasClaves.verPalabrasClaves();
    }

    public ModeloTablaPalabrasClaves(String buscarPalabraClave) {
        this.nombresColumnas.add("Nombre");

        GestorPalabrasClaves gestorPalabrasClaves = GestorPalabrasClaves.crear();
        palabrasClaves = gestorPalabrasClaves.buscarPalabrasClaves(buscarPalabraClave);
    }

    @Override
    public int getRowCount() {
        return this.palabrasClaves.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PalabraClave a = this.palabrasClaves.get(rowIndex);

        switch (columnIndex) {
            default:
                return a.verNombre();
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }

    public PalabraClave verPalabraClave(int fila) {
        GestorPalabrasClaves GPC = GestorPalabrasClaves.crear();

        return GPC.verPalabraClave(getValueAt(fila, 0).toString());
    }
}
