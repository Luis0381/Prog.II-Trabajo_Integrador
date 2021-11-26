package idiomas.modelos;

import interfaces.IGestorIdiomas;
import tipos.modelos.Tipo;


import java.util.ArrayList;
import java.util.List;

public class GestorIdiomas implements IGestorIdiomas {
    private static ArrayList<Idioma> idiomas = new ArrayList<>();
    private static GestorIdiomas gestor;

    private GestorIdiomas() {

    }

    public static GestorIdiomas crear() {
        if (gestor == null)
            gestor = new GestorIdiomas();

        return gestor;
    }

    @Override
    public String nuevoIdioma(String nombre) {
        Idioma nuevoIdioma = new Idioma(nombre);

        if (idiomas.contains(nuevoIdioma) || nombre == null || nombre.trim().isEmpty()) {
            return "ERROR al agregar un nuevo idioma!";
        } else
            idiomas.add(nuevoIdioma);
            return "Idioma agregado de forma EXITOSA!";

    }

    @Override
    public ArrayList<Idioma> verIdiomas() {
        return idiomas;
    }

    @Override
    public boolean existeEsteIdioma(Idioma idioma) {
        if (idioma == null)
            return false;
        else {
            for (Idioma a : idiomas) {
                if (a.equals(idioma))
                    return true;
            }
            return false;
        }
    }

    @Override
    public Idioma verIdioma(String nombre) {
        Idioma nuevoIdioma = new Idioma(nombre);

        if ((nombre==null) || (nombre.isEmpty()))
            return null;
        for (Idioma a : idiomas) {
            if (a.verNombre().equals(nombre))
                return nuevoIdioma;
        }
        return null;
    }

    @Override
    public String borrarIdioma(Idioma idioma) {
        if (this.existeEsteIdioma(idioma)) {
            idiomas.remove(idioma);
            return "Idioma removido con EXITO!";
        }
        return "Idioma Inexistente!";
    }

    @Override
    public List<Idioma> buscarIdiomas(String nombre) {
        ArrayList<Idioma> idiomasBuscados = new ArrayList<>();
        if (nombre.toLowerCase() != null) {
            for (Idioma a : idiomas) {
                if (a.verNombre().toLowerCase().contains(nombre.toLowerCase().trim()))
                    idiomasBuscados.add(a);
            }
        }
        return idiomasBuscados;
    }
}