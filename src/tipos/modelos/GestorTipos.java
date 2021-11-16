package tipos.modelos;

import interfaces.IGestorTipos;

import java.util.ArrayList;

/**
 * @author Thomas Mafut & Luis Medina Raed
 */
public class GestorTipos implements IGestorTipos {
    private static ArrayList<Tipo> tipos = new ArrayList<>();
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
    public ArrayList<Tipo> verTipos() {
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
}