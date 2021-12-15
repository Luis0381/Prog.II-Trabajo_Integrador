/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import grupos.modelos.ComparatorNombre;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ModeloTablaGrupos extends AbstractTableModel {
    private final List<String> nombresColumnas = new ArrayList<>();
    private final List<Grupo> Grupos = new ArrayList<>();

    public ModeloTablaGrupos(Autor a) {
        this.nombresColumnas.add("Nombre");
        this.nombresColumnas.add("Rol");
        for (MiembroEnGrupo mG : a.verGrupos()) {
            Grupos.add(mG.verGrupo());
        }
        Collections.sort(Grupos, new ComparatorNombre());
    }

    @Override
    public int getRowCount() {
        return this.Grupos.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Grupo g = this.Grupos.get(rowIndex);
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
        return this.nombresColumnas.get(columna);
    }
}
