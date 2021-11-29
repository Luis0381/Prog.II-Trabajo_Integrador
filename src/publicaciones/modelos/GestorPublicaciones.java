package publicaciones.modelos;

import autores.modelos.Alumno;
import autores.modelos.Autor;
import grupos.modelos.MiembroEnGrupo;
import idiomas.modelos.Idioma;
import interfaces.IGestorPublicaciones;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.PalabraClave;
import tipos.modelos.Tipo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorPublicaciones implements IGestorPublicaciones {
    private static List<Publicacion> publicaciones = new ArrayList<>();
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
    public List<Publicacion> verPublicaciones() {
        Collections.sort(publicaciones, new ComparatorNombre());
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

    @Override
    public String nuevaPublicacion(String titulo, MiembroEnGrupo miembroEnGrupo, LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar, List<PalabraClave> palabrasClaves, String enlace, String resumen) {
        Publicacion nuevaPublicacion = new Publicacion(titulo, miembroEnGrupo, fechaPublicacion, tipo, idioma, lugar, palabrasClaves, enlace, resumen);

        if (publicaciones.contains(nuevaPublicacion)) {
            return "\n\tEsta Publicacion ya EXISTE!";
        }
        if (titulo == null) {
            return "\n\tIngrese un Titulo.";
        }
        if (miembroEnGrupo == null) {
            return "\n\tEsta publicacion no tiene un grupo ingresado";
        }
        if (fechaPublicacion == null) {
            return "\n\tFecha incorrecta";
        }
        if (tipo == null) {
            return "\n\tIngrese un tipo.";
        }
        if (idioma == null) {
            return "\n\tIngrese un idioma.";
        }
        if (lugar == null) {
            return "\n\tIngrese un Lugar.";
        }
        if (palabrasClaves == null) {
            return "\n\tIngrese al menos una palabra clave.";
        }
        if (enlace == null) {
            return "\n\tIngrese un enlace.";
        }
        if (resumen == null) {
            return "\n\tIngrese el resumen.";
        } else {
            publicaciones.add(nuevaPublicacion);
            return "\n\tPublicacion agregada de forma EXITOSA!";
        }
    }

    @Override
    public String modificarPublicacion(Publicacion publicacion, MiembroEnGrupo miembroEnGrupo, LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar, List<PalabraClave> palabrasClaves, String enlace, String resumen) {
        if (existeEstaPublicacion(publicacion))
            for (Publicacion a : publicaciones) {
                if (a.equals(publicacion)) {
                    if (miembroEnGrupo == null) {
                        return "\n\tEsta publicacion no tiene un grupo ingresado";
                    }
                    if (fechaPublicacion == null) {
                        return "\n\tFecha incorrecta";
                    }
                    if (tipo == null) {
                        return "\n\tIngrese un tipo.";
                    }
                    if (idioma == null) {
                        return "\n\tIngrese un idioma.";
                    }
                    if (lugar == null) {
                        return "\n\tIngrese un Lugar.";
                    }
                    if (palabrasClaves == null) {
                        return "\n\tIngrese al menos una palabra clave.";
                    }
                    if (enlace == null) {
                        return "\n\tIngrese un enlace.";
                    }
                    if (resumen == null) {
                        return "\n\tIngrese el resumen.";
                    } else {
                        a.setUnMiembroEnGrupo(miembroEnGrupo);
                        a.setFechaPublicacion(fechaPublicacion);
                        a.setUnTipo(tipo);
                        a.setUnIdioma(idioma);
                        a.setUnLugar(lugar);
                        a.setPalabrasClaves(palabrasClaves);
                        a.setEnlace(enlace);
                        a.setResumen(resumen);
                    }
                }
            }
        return "\n\tPublicacion agregada de forma EXITOSA!";
    }

    @Override
    public String borrarPublicacion(Publicacion publicacion) {
        if (this.existeEstaPublicacion(publicacion)) {
            publicaciones.remove(publicacion);
            return "Publicacion removida con EXITO!";
        }
        return "Publicacion Inexistente!";
    }

    @Override
    public List<Publicacion> buscarPublicaciones(String titulo) {
        List<Publicacion> publicacionesBuscadas = new ArrayList<>();
        for(Publicacion p: publicaciones){
            if(p.getTitulo().contains(titulo)){
                if(p.getTitulo().compareTo(titulo) >= 0){
                    publicacionesBuscadas.add(p);
                }
            }
        }
        Collections.sort(publicaciones, new ComparatorNombre());
        return publicacionesBuscadas;
    }
}


