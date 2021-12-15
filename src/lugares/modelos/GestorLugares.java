package lugares.modelos;

import interfaces.IGestorLugares;
import interfaces.IGestorPublicaciones;
import publicaciones.modelos.GestorPublicaciones;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class GestorLugares implements IGestorLugares {
    private static final List<Lugar> lugares = new ArrayList<>();
    private static final String NOMBRE_ARCHIVO = "Lugares.txt";
    private static GestorLugares gestor;

    private GestorLugares() {
        this.leerArchivo();
    }

    public static GestorLugares crear() {
        if (gestor == null)
            gestor = new GestorLugares();

        return gestor;
    }

    private String leerArchivo() {
        File file = this.obtenerArchivoLugar();
        if (file != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String cadena;
                while ((cadena = br.readLine()) != null) {
                    Lugar a = new Lugar(cadena);
                    this.verLugares().add(a);
                }
                Collections.sort(lugares, new lugares.modelos.ComparatorNombre());
                return "Se leyo  el archivo correctamente";
            } catch (NullPointerException | IOException ioe) {
                return "No se pudo leer el archivo";
            }
        } else
            return "No se pudo crear el archivo";
    }

    public String escribirArchivo() {
        try {
            FileWriter fw = new FileWriter(NOMBRE_ARCHIVO);
            if (!this.verLugares().isEmpty()) {
                for (Lugar a : this.verLugares()) {
                    fw.write(a.verNombre());
                    fw.write("\n");
                }
            }
            fw.close();
            return "Se han guardado todos los lugares con EXITO!";
        } catch (IOException e1) {
            return "ERROR al guardar los datos";
        }
    }

    private File obtenerArchivoLugar() {
        File file = new File(NOMBRE_ARCHIVO);
        try {
            if (!file.exists())
                file.createNewFile();
            return file;
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public String nuevoLugar(String nombre) {
        Lugar nuevoLugar = new Lugar(nombre);

        if (lugares.contains(nuevoLugar) || nombre == null || nombre.trim().isEmpty()) {
            return "ERROR al agregar un nuevo lugar!";
        } else
            lugares.add(nuevoLugar);
        return "Lugar agregado de forma EXITOSA!";
    }

    @Override
    public List<Lugar> verLugares() {
        Collections.sort(lugares, new ComparatorNombre());
        return lugares;
    }

    @Override
    public boolean existeEsteLugar(Lugar lugar) {
        if (lugar == null)
            return false;
        else {
            for (Lugar a : lugares) {
                if (a.equals(lugar))
                    return true;
            }
            return false;
        }
    }

    @Override
    public Lugar verLugar(String nombre) {
        Lugar nuevoLugar = new Lugar(nombre);
        if ((nombre == null) || (nombre.isEmpty()))
            return null;
        for (Lugar a : lugares) {
            if (a.verNombre().equals(nombre))
                return nuevoLugar;
        }
        return null;
    }

    @Override
    public String borrarLugar(Lugar lugar) {
        if (!this.existeEsteLugar(lugar))
            return "Este lugar es INEXISTENTE!";
        IGestorPublicaciones gesPublicaciones = GestorPublicaciones.crear();
        if (gesPublicaciones.hayPublicacionesConEsteLugar(lugar))
            return "Hay al menos una publicacion con este lugar!!";
        lugares.remove(lugar);
        return "Lugar removido con EXITO!";
    }

    @Override
    public List<Lugar> buscarLugares(String nombre) {
        List<Lugar> lugaresBuscados = new ArrayList<>();
        if (nombre == null)
            return lugaresBuscados;
        for (Lugar lugar : lugares) {
            if (lugar.verNombre().toLowerCase().contains(nombre.toLowerCase().trim()))
                lugaresBuscados.add(lugar);
        }
        Collections.sort(lugaresBuscados, new lugares.modelos.ComparatorNombre());
        return lugaresBuscados;
    }
}