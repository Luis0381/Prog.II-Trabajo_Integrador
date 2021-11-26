package palabrasclaves.modelos;

import interfaces.IGestorPalabrasClaves;
import tipos.modelos.Tipo;


import java.util.ArrayList;
import java.util.List;

public class GestorPalabrasClaves implements IGestorPalabrasClaves {
    private static ArrayList<PalabraClave> palabrasClaves = new ArrayList<>();
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
        PalabraClave nuevaPalabraClave = new PalabraClave(nombre);
        if (!palabrasClaves.contains(nuevaPalabraClave) && nombre != null && (!nombre.trim().isEmpty())) {
            palabrasClaves.add(nuevaPalabraClave);
            return "Palabra Clave agregada de forma EXITOSA!";
        } else
            return "ERROR al agregar una nueva palabra clave!";
    }

    @Override
    public List<PalabraClave> verPalabrasClaves() {
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
        if (this.existeEstaPalabraClave(palabraClave)) {
            palabrasClaves.remove(palabraClave);
            return "Palabra clave removida con EXITO!";
        }
        return "Palabra clave Inexistente!";
    }

    @Override
    public List<PalabraClave> buscarPalabrasClaves(String nombre) {
        ArrayList<PalabraClave> palabrasBuscadas = new ArrayList<>();
        if (nombre.toLowerCase() != null) {
            for (PalabraClave a : palabrasClaves) {
                if (a.verNombre().toLowerCase().contains(nombre.toLowerCase().trim()))
                    palabrasBuscadas.add(a);
            }
        }
        return palabrasBuscadas;
    }
}