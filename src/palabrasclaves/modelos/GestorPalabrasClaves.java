package palabrasclaves.modelos;

import interfaces.IGestorPalabrasClaves;
import interfaces.IGestorPublicaciones;
import publicaciones.modelos.GestorPublicaciones;
import tipos.modelos.Tipo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorPalabrasClaves implements IGestorPalabrasClaves {
    private static List<PalabraClave> palabrasClaves = new ArrayList<>();
    private static GestorPalabrasClaves gestor;

    private GestorPalabrasClaves() {

    }

    public static GestorPalabrasClaves crear() {
        if (gestor == null)
            gestor = new GestorPalabrasClaves();

        return gestor;
    }


    @Override
    public String nuevaPalabraClave(String nombre) {
        if ((nombre == null) || (nombre.trim().isEmpty()))
            return "Verifique el nombre ingresado";
        PalabraClave palabraClave = new PalabraClave(nombre);
        if (palabrasClaves.contains(palabraClave))
            return "Ya existe esta palabra clave!";
        palabrasClaves.add(palabraClave);
        return "Palabras claves añadidas con EXITO!";
    }

    @Override
    public List<PalabraClave> verPalabrasClaves() {
        Collections.sort(palabrasClaves, new ComparatorNombre());
        return palabrasClaves;
    }

    @Override
    public boolean existeEstaPalabraClave(PalabraClave palabraClave) {
        if (palabraClave == null)
            return false;
        else {
            for (PalabraClave a : palabrasClaves) {
                if (a.equals(palabraClave))
                    return true;
            }
            return false;
        }
    }

    @Override
    public PalabraClave verPalabraClave(String nombre) {
        if ((nombre == null) || (nombre.isEmpty()))
            return null;
        for (PalabraClave a : palabrasClaves) {
            if (a.verNombre().equals(nombre))
                return a;
        }
        return null;
    }

    @Override
    public String borrarPalabraClave(PalabraClave palabraClave) {
        if (!this.existeEstaPalabraClave(palabraClave))
            return "Esta palabra clave es INEXISTENTE!";
        IGestorPublicaciones gesPublicaciones = GestorPublicaciones.crear();
        if (gesPublicaciones.hayPublicacionesConEstaPalabraClave(palabraClave))
            return "Hay al menos una publicacion con esta palabra clave!";
        palabrasClaves.remove(palabraClave);
        return "Palabra Clave removida con EXITO!";
    }

    @Override
    public List<PalabraClave> buscarPalabrasClaves(String nombre) {
        List<PalabraClave> palabrasBuscadas = new ArrayList<>();
        if (nombre.toLowerCase() != null) {
            for (PalabraClave a : palabrasClaves) {
                if (a.verNombre().toLowerCase().contains(nombre.toLowerCase().trim()))
                    palabrasBuscadas.add(a);
            }
        }
        Collections.sort(palabrasClaves, new ComparatorNombre());
        return palabrasBuscadas;
    }
}