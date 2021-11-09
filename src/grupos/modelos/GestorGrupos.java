package grupos.modelos;

import interfaces.IGestorGrupos;


import java.util.ArrayList;

public class GestorGrupos implements IGestorGrupos {
    private static ArrayList<Grupo> grupos = new ArrayList<>();
    private static GestorGrupos gestor;

    private GestorGrupos() {

    }

    public static GestorGrupos crear() {
        if (gestor == null)
            gestor = new GestorGrupos();

        return gestor;
    }

    @Override
    public String nuevoGrupo(String nombre, String descripcion) {
        Grupo nuevoGrupo = new Grupo(nombre, descripcion);

        if (!grupos.contains(nuevoGrupo) || !nombre.isEmpty()) {
            grupos.add(nuevoGrupo);
            return "Grupo agregado de forma EXITOSA!";
        } else
            return "ERROR al agregar un nuevo grupo!";
    }

    @Override
    public String modificarGrupo(Grupo grupo, String descripcion) {
        for (Grupo a : grupos) {
            if (a.equals(grupo)) {
                a.asignarDescripcion(descripcion);
                return "Descripcion modificada de forma EXITOSA!";
            }
        }
        return "ERROR al modificar la descripcion!";
    }

    @Override
    public ArrayList<Grupo> verGrupos() {
        return grupos;
    }

    @Override
    public Grupo verGrupo(String nombre) {
        Grupo nuevoGrupo = new Grupo(nombre, null);

        for (Grupo a : grupos) {
            if (a.equals(nuevoGrupo))
                return nuevoGrupo;
        }
        return null;
    }

    @Override
    public boolean existeEsteGrupo(Grupo grupo) {
        for (Grupo a : grupos) {
            if (a.equals(grupo))
                return true;
        }
        return false;
    }

    @Override
    public void mostrarGrupos() {
        if (!grupos.isEmpty()) {
            for (Grupo g : grupos)
                g.mostrar();
        }
    }
}
