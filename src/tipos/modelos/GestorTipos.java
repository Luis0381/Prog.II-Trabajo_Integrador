package tipos.modelos;

import interfaces.IGestorTipos;

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
        Tipo nuevoTipo = new Tipo(nombre);
        if (!tipos.contains(nuevoTipo) && (nombre != null) && !nombre.isEmpty()) {
            tipos.add(nuevoTipo);
            return "Tipo agregado de forma EXITOSA!";
        } else
            return "ERROR al agregar un nuevo tipo!";
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
        if (this.existeEsteTipo(tipo)) {
            tipos.remove(tipo);
            return "Tipo removido con EXITO!";
        }
        return "Tipo Inexistente!";
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