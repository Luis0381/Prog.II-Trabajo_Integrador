package grupos.modelos;

import autores.modelos.GestorAutores;
import interfaces.IGestorGrupos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class GestorGrupos implements IGestorGrupos {
    private static List<Grupo> grupos = new ArrayList<>();
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
        Collections.sort(grupos, new ComparatorNombre());
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
        GestorAutores gesAutores = GestorAutores.crear();
        if (!this.existeEsteGrupo(grupo))
            return "Este grupo no existe!";
        if (gesAutores.hayAutoresConEsteGrupo(grupo))
            return "Hay autores que pertenecen a este grupo!";
        grupos.remove(grupo);
        return "Autor removido con EXITO!";
    }

    @Override
    public List<Grupo> buscarGrupos(String nombre) {
        List<Grupo> gruposBuscados = new ArrayList<>();
        if (nombre == null)
            return gruposBuscados;

        for(Grupo grupo : grupos) {
            if (grupo.verNombre().toLowerCase().contains(nombre.toLowerCase().trim()))
                gruposBuscados.add(grupo);
        }
        Collections.sort(gruposBuscados, new ComparatorNombre());
        return gruposBuscados;
    }
}
