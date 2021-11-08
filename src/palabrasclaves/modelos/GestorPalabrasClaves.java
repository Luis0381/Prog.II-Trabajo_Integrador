package palabrasclaves.modelos;

import interfaces.IGestorPalabrasClaves;


import java.util.ArrayList;

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

        if (!palabrasClaves.contains(nuevaPalabraClave) || !nombre.isEmpty()) {
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
        PalabraClave nuevaPalabraClave = new PalabraClave(nombre);

        for (PalabraClave a : palabrasClaves) {
            if (a.equals(nuevaPalabraClave))
                return nuevaPalabraClave;
        }
        return null;
    }
}

// agregar metodos para printear todos los tipos y controlar