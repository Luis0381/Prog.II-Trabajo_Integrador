package publicaciones.modelos;

import autores.modelos.Autor;
import grupos.modelos.MiembroEnGrupo;
import idiomas.modelos.Idioma;
import interfaces.IGestorPublicaciones;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.PalabraClave;
import tipos.modelos.Tipo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Thomas Mafut & Luis Medina Raed
 */
public class GestorPublicaciones implements IGestorPublicaciones {
    private static ArrayList<Publicacion> publicaciones = new ArrayList<>();
    private static GestorPublicaciones gestor;

    private GestorPublicaciones() {

    }

    public static GestorPublicaciones crear() {
        if (gestor == null)
            gestor = new GestorPublicaciones();

        return gestor;
    }

    @Override
    public String nuevaPublicacion(String titulo, MiembroEnGrupo miembroEnGrupo, LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar, ArrayList<PalabraClave> palabrasClaves, String enlace, String resumen) {
        Publicacion nuevaPublicacion = new Publicacion(titulo, miembroEnGrupo, fechaPublicacion, tipo, idioma, lugar, palabrasClaves, enlace, resumen);

        if (publicaciones.contains(nuevaPublicacion) || titulo == null || titulo.trim().isEmpty() || miembroEnGrupo == null || miembroEnGrupo.verGrupo() == null || miembroEnGrupo.verAutor() == null || miembroEnGrupo.verRol() == null || fechaPublicacion == null || tipo == null || idioma == null || lugar == null || palabrasClaves == null || palabrasClaves.isEmpty() || enlace == null || enlace.trim().isEmpty() || resumen == null || resumen.trim().isEmpty())
            return "ERROR al agregar una nueva publicacion!";
        else {
            publicaciones.add(nuevaPublicacion);
            return "Publicacion agregada de forma EXITOSA!";
        }
    }

    @Override
    public String modificarPublicacion(Publicacion publicacion, MiembroEnGrupo miembroEnGrupo, LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar, ArrayList<PalabraClave> palabrasClaves, String enlace, String resumen) {
        if (existeEstaPublicacion(publicacion) && miembroEnGrupo != null && miembroEnGrupo.verGrupo() != null && miembroEnGrupo.verAutor() != null && miembroEnGrupo.verRol() != null && fechaPublicacion != null && tipo != null && idioma != null && lugar != null && palabrasClaves != null && !palabrasClaves.isEmpty() && enlace != null && !enlace.trim().isEmpty() && resumen != null && !resumen.trim().isEmpty()) {
            publicacion.setUnMiembroEnGrupo(miembroEnGrupo);
            publicacion.setFechaPublicacion(fechaPublicacion);
            publicacion.setUnTipo(tipo);
            publicacion.setUnIdioma(idioma);
            publicacion.setUnLugar(lugar);
            publicacion.setPalabrasClaves(palabrasClaves);
            publicacion.setEnlace(enlace);
            publicacion.setResumen(resumen);
            return "Datos de la publicacion modificados de forma EXITOSA!";
        }
        return "ERROR al modificar los datos de la publicacion!";
    }

    @Override
    public boolean hayPublicacionesConEstaPalabraClave(PalabraClave palabraClave) {
        for (Publicacion publicacion : publicaciones) {
            for (PalabraClave palabraclave : publicacion.getPalabrasClaves()) {
                if (palabraClave.equals(palabraclave))
                    return true;
            }
        }
        return false;
    }

    @Override
    public boolean hayPublicacionesConEsteLugar(Lugar lugar) {
        for (Publicacion a : publicaciones) {
            if (a.getUnLugar().equals(lugar))
                return true;
        }
        return false;
    }

    @Override
    public boolean hayPublicacionesConEsteIdioma(Idioma idioma) {
        for (Publicacion a : publicaciones)
            if (a.getUnIdioma().equals(idioma)) {
                return true;
            }
        return false;
    }

    @Override
    public boolean hayPublicacionesConEsteTipo(Tipo tipo) {
        for (Publicacion a : publicaciones) {
            if (a.getUnTipo().equals(tipo))
                return true;
        }
        return false;
    }

    @Override
    public boolean hayPublicacionesConEsteAutor(Autor autor) {
        for (Publicacion publicacion : publicaciones) {
            MiembroEnGrupo miembroengrupo = publicacion.getUnMiembroEnGrupo();
            if (autor.equals(miembroengrupo.verAutor()))
                return true;
        }
        return false;
    }

    @Override
    public boolean existeEstaPublicacion(Publicacion publicacion) {
        if (publicacion == null)
            return false;
        else {
            for (Publicacion a : publicaciones) {
                if (a.equals(publicacion))
                    return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Publicacion> verPublicaciones() {
        return publicaciones;
    }

    @Override
    public Publicacion verPublicacion(String titulo) {
        for (Publicacion a : publicaciones) {
            if (a.getTitulo().equals(titulo))
                return a;
        }
        return null;
    }

    @Override
    public void mostrarPublicaciones() {
        if (!verPublicaciones().isEmpty())
            for (Publicacion a : publicaciones)
                a.mostrar();
    }
}
