/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */
public class ModeloTablaPublicaciones extends AbstractTableModel{
    private List<String> nombreColumnas = new ArrayList<>();
    private List<Publicacion> publicaciones = new ArrayList<>();
    
    public ModeloTablaPublicaciones(){
        this.nombreColumnas.add("Titulo");
        this.nombreColumnas.add("Autor");
        this.nombreColumnas.add("Año");
        
        GestorPublicaciones gp = GestorPublicaciones.crear();
        
        this.publicaciones = gp.verPublicaciones();
    }
    
    public ModeloTablaPublicaciones(String buscarTitulo){
        this.nombreColumnas.add("Titulo");
        this.nombreColumnas.add("Autor");
        this.nombreColumnas.add("Año");
        
        GestorPublicaciones gp = GestorPublicaciones.crear();
        
        this.publicaciones = gp.buscarPublicaciones(buscarTitulo);
    }
    
    @Override
    public int getRowCount() {
        return this.publicaciones.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Publicacion P = this.publicaciones.get(rowIndex);
        switch(columnIndex){
            case 0: return P.getTitulo();
            case 1: return P.getAutor().verAutor().verApellidos() + ", " + P.getAutor().verAutor().verNombres();
            case 2: return P.getFechaPublicacion().getYear();
            default: return P.getTitulo();
        }
    }
    
    @Override
    public String getColumnName(int columna) {
        return this.nombreColumnas.get(columna);
    }  
}
