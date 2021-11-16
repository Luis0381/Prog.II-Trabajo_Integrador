package palabrasclaves.modelos;

import interfaces.IGestorPalabrasClaves;


import java.util.ArrayList;

/**
 * @author Thomas Mafut & Luis Medina Raed
 */
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
    public ArrayList<PalabraClave> verPalabrasClaves() {
        return palabrasClaves;
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
}