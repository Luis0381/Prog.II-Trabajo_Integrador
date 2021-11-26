package tipos.modelos;

import interfaces.IGestorTipos;

import java.util.ArrayList;
import java.util.List;

public class GestorTipos implements IGestorTipos {
    private static List<Tipo> tipos;
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
        return tipos;
    }

    @Override
    public Tipo verTipo(String nombre) {
        Tipo nuevoTipo = new Tipo(nombre);
        if ((nombre == null) || (nombre.isEmpty()))
            return null;
        for (Tipo a : tipos) {
            if (a.verNombre().equals(nombre.trim())) //Puede ser equalsIgnoreCase
                return nuevoTipo;
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
        ArrayList<Tipo> tiposBuscados = new ArrayList<>();
        if (nombre.toLowerCase() != null) {
            for (Tipo a : tipos) {
                    if (a.verNombre().toLowerCase().contains(nombre.toLowerCase().trim()))
                        tiposBuscados.add(a);
            }
        }
        return tiposBuscados;
    }

    @Override
    public boolean existeEsteTipo(Tipo tipo) {
        if (tipo == null)
            return false;
        else {
            for (Tipo a : tipos) {
                if (a.equals(tipo))
                    return true;
            }
            return false;
        }
    }
}