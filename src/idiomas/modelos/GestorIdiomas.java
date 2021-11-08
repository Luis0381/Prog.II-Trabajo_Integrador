package idiomas.modelos;

import interfaces.IGestorIdiomas;
import interfaces.IGestorTipos;
import tipos.modelos.GestorTipos;
import tipos.modelos.Tipo;

import java.util.ArrayList;

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

        if (!idiomas.contains(nuevoIdioma) || !nombre.isEmpty()) {
            idiomas.add(nuevoIdioma);
            return "Idioma agregado de forma EXITOSA!";
        } else
            return "ERROR al agregar un nuevo idioma!";
    }

    @Override
    public ArrayList<Idioma> verIdiomas() {
        return idiomas;
    }

    @Override
    public Idioma verIdioma(String nombre) {
        Idioma nuevoIdioma = new Idioma(nombre);

        for (Idioma a : idiomas) {
            if (a.equals(nuevoIdioma))
                return nuevoIdioma;
            else
                return null;
        }
    }
}

// agregar metodos para printear todos los tipos y controlar