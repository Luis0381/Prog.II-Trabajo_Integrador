package palabrasclaves.modelos;

import interfaces.IGestorPalabrasClaves;
import interfaces.IGestorPublicaciones;
import publicaciones.modelos.GestorPublicaciones;
import tipos.modelos.Tipo;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class GestorPalabrasClaves implements IGestorPalabrasClaves {
    private static List<PalabraClave> palabrasClaves = new ArrayList<>();
    private static GestorPalabrasClaves gestor;

    private static final String NOMBRE_ARCHIVO = "PalabrasClaves.txt";

    private GestorPalabrasClaves() {
        this.leerArchivo();
    }

    public static GestorPalabrasClaves crear() {
        if (gestor == null)
            gestor = new GestorPalabrasClaves();

        return gestor;
    }

    private File obtenerArchivoPalabrasClaves(){
        File file = new File(NOMBRE_ARCHIVO);
        try {
            if (!file.exists())
                file.createNewFile();
            return file;
        }
        catch(IOException e) {
            return null;
        }
    }

    private String leerArchivo(){
        File file = this.obtenerArchivoPalabrasClaves();
        if (file != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String cadena;
                while((cadena = br.readLine()) != null) {
                    PalabraClave a = new PalabraClave(cadena);
                    this.verPalabrasClaves().add(a);
                }
                Collections.sort(palabrasClaves, new palabrasclaves.modelos.ComparatorNombre());
                return "Se leyo  el archivo correctamente";
            }
            catch(NullPointerException | IOException ioe) {
                return "No se pudo leer el archivo";
            }
        }
        else
            return "No se pudo crear el archivo";
    }

    public String escribirArchivo(){
        try {
            FileWriter fw = new FileWriter(NOMBRE_ARCHIVO);
            if(!this.verPalabrasClaves().isEmpty()){
                for(PalabraClave a: this.verPalabrasClaves()){
                    fw.write(a.verNombre());
                    fw.write("\n");
                }
            }
            fw.close();
            return "Se han guardado todas las palabras claves con EXITO!";
        }
        catch(IOException e1) {
            return "ERROR al guardar los datos";
        }
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