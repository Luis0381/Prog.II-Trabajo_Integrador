package grupos.modelos;

import autores.modelos.Autor;
import autores.modelos.GestorAutores;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModeloTablaMiembroGrupo extends AbstractTableModel {
    private List<String> nombreColumnas = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<MiembroEnGrupo> miembros = new ArrayList<>();

    public ModeloTablaMiembroGrupo(Grupo g){
        nombreColumnas.add("Nombre");
        nombreColumnas.add("Rol");

        GestorAutores gesAutor = GestorAutores.crear();
        autores = gesAutor.verAutores();

        if(g.verMiembros() != null)
            miembros = g.verMiembros();
    }

    @Override
    public int getRowCount() {
        return autores.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Autor autor = this.autores.get(rowIndex);
        MiembroEnGrupo miembro = null;
        for(MiembroEnGrupo mg: this.miembros){
            if(mg.verAutor().equals(autor)){
                miembro = mg;
                break;
            }
        }
        switch(columnIndex){
            case 0: return autor.verApellidos() + "," + autor.verNombres();
            case 1:
                if(miembro == null){
                    return "---";
                }
                else{
                    return miembro.verRol();
                }
            default: return "";
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombreColumnas.get(columna);
    }
}
