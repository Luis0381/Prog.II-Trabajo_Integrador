package lugares.modelos;

import interfaces.IGestorLugares;
import interfaces.IGestorPublicaciones;
import publicaciones.modelos.GestorPublicaciones;
import tipos.modelos.Tipo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorLugares implements IGestorLugares {
    private static List<Lugar> lugares = new ArrayList<>();
    private static GestorLugares gestor;

    private GestorLugares() {

    }

    public static GestorLugares crear() {
        if (gestor == null)
            gestor = new GestorLugares();

        return gestor;
    }

    @Override
    public String nuevoLugar(String nombre) {
        Lugar nuevoLugar = new Lugar(nombre);

        if (!lugares.contains(nuevoLugar) && (nombre != null) && (!nombre.trim().isEmpty())) {
            lugares.add(nuevoLugar);
            return "Lugar agregado de forma EXITOSA!";
        } else
            return "ERROR al agregar un nuevo lugar!";
    }

    @Override
    public List<Lugar> verLugares() {
        Collections.sort(lugares, new ComparatorNombre());
        return lugares;
    }

    @Override
    public boolean existeEsteLugar(Lugar lugar) {
        if (lugar == null)
            return false;
        else {
            for (Lugar a : lugares) {
                if (a.equals(lugar))
                    return true;
            }
            return false;
        }
    }

    @Override
    public Lugar verLugar(String nombre) {
        Lugar nuevoLugar = new Lugar(nombre);
        if ((nombre == null) || (nombre.isEmpty()))
            return null;
        for (Lugar a : lugares) {
            if (a.verNombre().equals(nombre))
                return a;
        }
        return null;
    }

    @Override
    public String borrarLugar(Lugar lugar) {
        if (!this.existeEsteLugar(lugar))
            return "Este lugar es INEXISTENTE!";
        IGestorPublicaciones gesPublicaciones = GestorPublicaciones.crear();
        if (gesPublicaciones.hayPublicacionesConEsteLugar(lugar))
            return "Hay al menos una publicacion con este lugar!!";

        lugares.remove(lugar);
        return "Lugar removido con EXITO!";
    }

    @Override
    public List<Lugar> buscarLugares(String nombre) {
        ArrayList<Lugar> lugaresBuscados = new ArrayList<>();
        if (nombre.toLowerCase() != null) {
            for (Lugar a : lugares) {
                if (a.verNombre().toLowerCase().contains(nombre.toLowerCase().trim()))
                    lugaresBuscados.add(a);
            }
        }
        Collections.sort(lugares, new ComparatorNombre());
        return lugaresBuscados;
    }
}