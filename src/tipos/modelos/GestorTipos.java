package tipos.modelos;

import interfaces.IGestorPublicaciones;
import interfaces.IGestorTipos;
import publicaciones.modelos.GestorPublicaciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorTipos implements IGestorTipos {
    private List<Tipo> tipos = new ArrayList<>();
    private static GestorTipos gestor;

    private GestorTipos() {

    }

    public static GestorTipos crear() {
        if (gestor == null)
            gestor = new GestorTipos();

        return gestor;
    }

    @Override
    public String nuevoTipo(String nombre) {
        if ((nombre == null) || (nombre.trim().isEmpty()))
            return "Verifique el nombre ingresado";
        Tipo tipo = new Tipo(nombre);
        if (this.tipos.contains(tipo))
            return "Este tipo ya existe!";
        this.tipos.add(tipo);
        return "Tipo agregado de forma EXITOSA!";
    }

    @Override
    public List<Tipo> verTipos() {
        Collections.sort(tipos, new ComparatorNombre());
        return tipos;
    }

    @Override
    public Tipo verTipo(String nombre) {
        if ((nombre == null) || (nombre.isEmpty()))
            return null;
        for(Tipo tipo : this.tipos) {
            if (tipo.verNombre().equalsIgnoreCase(nombre.trim()))
                return tipo;
        }
        return null;
    }

    @Override
    public String borrarTipo(Tipo tipo) {
        if (!this.existeEsteTipo(tipo))
            return "Este tipo no existe!";
        IGestorPublicaciones gesPublicaciones= GestorPublicaciones.crear();
        if (gesPublicaciones.hayPublicacionesConEsteTipo(tipo))
            return "Hay al menos una publicacion con este tipo!";
        this.tipos.remove(tipo);
        return "Tipo removido con EXITO!";
    }

    @Override
    public List<Tipo> buscarTipos(String nombre) {
        List<Tipo> tiposBuscados = new ArrayList<>();
        if (nombre == null)
            return tiposBuscados;
        for(Tipo tipo : this.tipos) {
            if (tipo.verNombre().toLowerCase().contains(nombre.toLowerCase().trim()))
                tiposBuscados.add(tipo);
        }
        Collections.sort(tiposBuscados, new ComparatorNombre());
        return tiposBuscados;
    }

    @Override
    public boolean existeEsteTipo(Tipo tipo) {
        if (tipo == null)
            return false;
       
        for(Tipo t : this.tipos) {
            if (t.equals(tipo))
                return true;
        }
        return false;
    }
}