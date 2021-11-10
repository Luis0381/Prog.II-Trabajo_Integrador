package lugares.modelos;

import interfaces.IGestorLugares;

import java.util.ArrayList;

public class GestorLugares implements IGestorLugares {
    private static ArrayList<Lugar> lugares = new ArrayList<>();
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
    public ArrayList<Lugar> verLugares() {
        return lugares;
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
}