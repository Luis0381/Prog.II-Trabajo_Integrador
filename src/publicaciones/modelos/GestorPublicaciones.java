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
        return null;
    }

    @Override
    public String modificarPublicacion(Publicacion publicacion, MiembroEnGrupo miembroEnGrupo, LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar, ArrayList<PalabraClave> palabrasClaves, String enlace, String resumen) {
        return null;
    }

    @Override
    public boolean hayPublicacionesConEstaPalabraClave(PalabraClave palabraClave) {
        return false;
    }

    @Override
    public boolean hayPublicacionesConEsteLugar(Lugar lugar) {
        return false;
    }

    @Override
    public boolean hayPublicacionesConEsteIdioma(Idioma idioma) {
        return false;
    }

    @Override
    public boolean hayPublicacionesConEsteTipo(Tipo tipo) {
        return false;
    }

    @Override
    public boolean hayPublicacionesConEsteAutor(Autor autor) {
        return false;
    }

    @Override
    public boolean existeEstaPublicacion(Publicacion publicacion) {
        return false;
    }

    @Override
    public ArrayList<Publicacion> verPublicaciones() {
        return null;
    }

    @Override
    public Publicacion verPublicacion(String titulo) {
        return null;
    }
}
