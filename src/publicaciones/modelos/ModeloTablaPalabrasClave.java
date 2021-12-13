package publicaciones.modelos;

import interfaces.IGestorPalabrasClaves;
import palabrasclaves.modelos.GestorPalabrasClaves;
import palabrasclaves.modelos.PalabraClave;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;
import java.util.List;

public class ModeloTablaPalabrasClave extends AbstractTableModel {
    public static final String COLUMNA_NOMBRE = "Nombre";

    private List<PalabraClave> palabrasClaves;


    private List<String> nombresColumnas = Arrays.asList(new String[] {COLUMNA_NOMBRE});
    private IGestorPalabrasClaves gesPalabrasClaves = GestorPalabrasClaves.crear();

    public ModeloTablaPalabrasClave() {
        this.palabrasClaves = this.gesPalabrasClaves.verPalabrasClaves(); //todas las palabras claves
    }


    @Override
    public Object getValueAt(int fila, int columna) {
        return this.palabrasClaves.get(fila);
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size();
    }

    @Override
    public int getRowCount() {
        return this.palabrasClaves.size();
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }

    public PalabraClave verPalabraClave(int fila) {
        try {
            return this.palabrasClaves.get(fila);
        }
        catch(IndexOutOfBoundsException e) {
            return null;
        }
    }
}