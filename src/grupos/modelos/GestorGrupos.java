package grupos.modelos;

import interfaces.IGestorGrupos;
import tipos.modelos.Tipo;


import java.util.ArrayList;
import java.util.List;

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

        if (!grupos.contains(nuevoGrupo) && (nombre != null) && !nombre.trim().isEmpty()) {
            grupos.add(nuevoGrupo);
            return "Grupo agregado de forma EXITOSA!";
        } else
            return "ERROR al agregar un nuevo grupo!";
    }

    @Override
    public String modificarGrupo(Grupo grupo, String descripcion) {
        if (this.existeEsteGrupo(grupo) && (descripcion != null)){
            if (descripcion.isEmpty()) {
                descripcion = null;
            }
            grupo.asignarDescripcion(descripcion);
            return "Grupo modificado de forma EXITOSA!";
        }
        return "ERROR al modificar la descripcion!";
    }

    @Override
    public List<Grupo> verGrupos() {
        return grupos;
    }

    @Override
    public Grupo verGrupo(String nombre) {
        if ((nombre == null) || (nombre.isEmpty()))
            return null;
        for(Grupo a : grupos)
            if (a.verNombre().equals(nombre))
                return a;
        return null;
    }

    @Override
    public boolean existeEsteGrupo(Grupo grupo) {
        if (grupo == null)
            return false;
        for(Grupo a : grupos) {
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

    @Override
    public String borrarGrupo(Grupo grupo) {
        if (this.existeEsteGrupo(grupo)) {
            grupos.remove(grupo);
            return "Grupo removido con EXITO!";
        }
        return "Grupo Inexistente!";
    }

    @Override
    public List<Grupo> buscarGrupos(String nombre) {
        ArrayList<Grupo> gruposBuscados = new ArrayList<>();
        if (nombre.toLowerCase() != null) {
            for (Grupo a : grupos) {
                if (a.verNombre().toLowerCase().contains(nombre.toLowerCase().trim()))
                    gruposBuscados.add(a);
            }
        }
        return gruposBuscados;
    }
}
