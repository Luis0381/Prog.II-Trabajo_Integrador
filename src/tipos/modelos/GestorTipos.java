package tipos.modelos;

import interfaces.IGestorPublicaciones;
import interfaces.IGestorTipos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import publicaciones.modelos.GestorPublicaciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorTipos implements IGestorTipos {
    private List<Tipo> tipos = new ArrayList<>();
    private static GestorTipos gestor;
    
    private static final String NOMBRE_ARCHIVO = "Tipos.txt";

    private GestorTipos() {
        this.leerArchivo();
    }

    public static GestorTipos crear() {
        if (gestor == null)
            gestor = new GestorTipos();

        return gestor;
    }
    
        private String leerArchivo(){
        File file = this.obtenerArchivoIdioma();
        if (file != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String cadena;
                while((cadena = br.readLine()) != null) {
                    Tipo a = new Tipo(cadena);
                    this.verTipos().add(a);
                }
                Collections.sort(tipos, new ComparatorNombre());
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
            if(!this.verTipos().isEmpty()){
                for(Tipo a: this.verTipos()){
                    fw.write(a.verNombre());
                    fw.write("\n");
                }
            }
            fw.close();
            return "Se han guardado todas los tipos con EXITO!";
        }
        catch(IOException e1) {
            return "ERROR al guardar los datos";
        }
    }

    private File obtenerArchivoIdioma(){
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
    public String nuevoTipo(String nombre) {
        if ((nombre == null) || (nombre.trim().isEmpty()))
            return "Verifique el nombre ingresado";
        Tipo tipo = new Tipo(nombre);
        if (this.tipos.contains(tipo))
            return "Este tipo ya existe!";
        this.tipos.add(tipo);
        return "Tipo agregado de forma EXITOSA!";
    }

    @Override
    public List<Tipo> verTipos() {
        Collections.sort(tipos, new ComparatorNombre());
        return tipos;
    }

    @Override
    public Tipo verTipo(String nombre) {
        if ((nombre == null) || (nombre.isEmpty()))
            return null;
        for(Tipo tipo : this.tipos) {
            if (tipo.verNombre().equalsIgnoreCase(nombre.trim()))
                return tipo;
        }
        return null;
    }

    @Override
    public String borrarTipo(Tipo tipo) {
        if (!this.existeEsteTipo(tipo))
            return "Este tipo no existe!";
        IGestorPublicaciones gesPublicaciones= GestorPublicaciones.crear();
        if (gesPublicaciones.hayPublicacionesConEsteTipo(tipo))
            return "Hay al menos una publicacion con este tipo!";
        this.tipos.remove(tipo);
        return "Tipo removido con EXITO!";
    }

    @Override
    public List<Tipo> buscarTipos(String nombre) {
        List<Tipo> tiposBuscados = new ArrayList<>();
        if (nombre == null)
            return tiposBuscados;
        for(Tipo tipo : this.tipos) {
            if (tipo.verNombre().toLowerCase().contains(nombre.toLowerCase().trim()))
                tiposBuscados.add(tipo);
        }
        Collections.sort(tiposBuscados, new tipos.modelos.ComparatorNombre());
        return tiposBuscados;
    }

    @Override
    public boolean existeEsteTipo(Tipo tipo) {
        if (tipo == null)
            return false;
       
        for(Tipo t : this.tipos) {
            if (t.equals(tipo))
                return true;
        }
        return false;
    }
}