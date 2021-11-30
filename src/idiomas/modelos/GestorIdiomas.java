package idiomas.modelos;

import interfaces.IGestorIdiomas;
import interfaces.IGestorPublicaciones;
import publicaciones.modelos.GestorPublicaciones;
import tipos.modelos.Tipo;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorIdiomas implements IGestorIdiomas {
    private static List<Idioma> idiomas = new ArrayList<>();
    private static GestorIdiomas gestor;

    private static final String NOMBRE_ARCHIVO = "Idiomas.txt";

    private GestorIdiomas() {

    }

    public static GestorIdiomas crear() {
        if (gestor == null)
            gestor = new GestorIdiomas();

        return gestor;
    }

    private String leerArchivo(){
        File file = this.obtenerArchivoPalabrasClave();
        if (file != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String cadena;
                while((cadena = br.readLine()) != null) {
                    Idioma a = new Idioma(cadena);
                    this.verIdiomas().add(a);
                }
                Collections.sort(idiomas, new ComparatorNombre());
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
            if(!this.verIdiomas().isEmpty()){
                for(Idioma a: this.verIdiomas()){
                    fw.write(a.verNombre());
                    fw.write("\n");
                }
            }
            fw.close();
            return "Se han guardado todas las palabras claves con exito";
        }
        catch(IOException e1) {
            return "Ha ocurrido un error al guardar los datos";
        }
    }

    private File obtenerArchivoPalabrasClave(){
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
    public List<Idioma> verIdiomas() {
        Collections.sort(idiomas, new ComparatorNombre());
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
        if (!this.existeEsteIdioma(idioma))
            return "Este idioma es INEXISTENTE!";
        IGestorPublicaciones gesPublicaciones = GestorPublicaciones.crear();
        if (gesPublicaciones.hayPublicacionesConEsteIdioma(idioma))
            return "Hay al menos una publicacion con este idioma!";
        this.idiomas.remove(idioma);
        return "Idioma removido con EXITO!";
    }

    @Override
    public List<Idioma> buscarIdiomas(String nombre) {
        List<Idioma> idiomasBuscados = new ArrayList<>();
        if (nombre == null)
            return idiomasBuscados;
        for(Idioma idioma : idiomas) {
            if (idioma.verNombre().toLowerCase().contains(nombre.toLowerCase().trim()))
                idiomasBuscados.add(idioma);
        }
        Collections.sort(idiomasBuscados, new ComparatorNombre());
        return idiomasBuscados;
    }
}