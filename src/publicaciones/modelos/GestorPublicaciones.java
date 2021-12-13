/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import autores.modelos.Autor;
import grupos.modelos.MiembroEnGrupo;
import idiomas.modelos.Idioma;
import interfaces.IGestorPublicaciones;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.GestorPalabrasClaves;
import palabrasclaves.modelos.PalabraClave;
import tipos.modelos.ComparatorNombre;
import tipos.modelos.Tipo;

/**
 *
 * @author Usuario
 */
public class GestorPublicaciones implements IGestorPublicaciones{
    private List<Publicacion> publicaciones = new ArrayList<>();
    private static GestorPublicaciones instancia;
    

    public static GestorPublicaciones crear(){
        if(instancia == null)
            instancia = new GestorPublicaciones();
        return instancia;
    }

    @Override
    public String nuevaPublicacion(String titulo, MiembroEnGrupo miembroEnGrupo, LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar, List<PalabraClave> palabrasClaves, String enlace, String resumen) {
        if(titulo == null || titulo.trim().isEmpty())
            return ERROR_TITULO;

        if (miembroEnGrupo == null || miembroEnGrupo.verGrupo() == null || miembroEnGrupo.verAutor() == null || miembroEnGrupo.verRol() == null)
            return ERROR_MIEMBRO_EN_GRUPO;

        if(fechaPublicacion == null)
            return ERROR_FECHA;

        if (tipo == null)
            return ERROR_TIPO;

        if (idioma== null)
            return ERROR_IDIOMA;

        if (lugar == null)
            return ERROR_LUGAR;

        if (palabrasClaves == null || palabrasClaves.isEmpty())
            return ERROR_PALABRAS_CLAVES;

        if (enlace == null || enlace.trim().isEmpty())
            return ERROR_ENLACE;

        if (resumen == null || resumen.trim().isEmpty())
            return ERROR_RESUMEN;
        else {
            Publicacion publicacion = new Publicacion(titulo, miembroEnGrupo, fechaPublicacion, tipo, idioma, lugar, palabrasClaves, enlace, resumen);
            if (this.publicaciones.contains(publicacion))
                return PUBLICACIONES_DUPLICADAS;

            this.publicaciones.add(publicacion);
            return EXITO;
        }
    }

    @Override
    public String modificarPublicacion(Publicacion publicacion, MiembroEnGrupo miembroEnGrupo, LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar, List<PalabraClave> palabrasClaves, String enlace, String resumen) {
        if (!this.existeEstaPublicacion(publicacion))
            return PUBLICACION_INEXISTENTE;

        if (miembroEnGrupo == null || miembroEnGrupo.verGrupo() == null || miembroEnGrupo.verAutor() == null || miembroEnGrupo.verRol() == null)
            return ERROR_MIEMBRO_EN_GRUPO;

        if(fechaPublicacion == null)
            return ERROR_FECHA;

        if (tipo == null)
            return ERROR_TIPO;

        if (idioma== null)
            return ERROR_IDIOMA;

        if (lugar == null)
            return ERROR_LUGAR;

        if (palabrasClaves == null || palabrasClaves.isEmpty())
            return ERROR_PALABRAS_CLAVES;

        if (enlace == null || enlace.trim().isEmpty())
            return ERROR_ENLACE;

        if (resumen == null || resumen.trim().isEmpty())
            return ERROR_RESUMEN;

        publicacion.setAutor(miembroEnGrupo);
        publicacion.setFechaPublicacion(fechaPublicacion);
        publicacion.setTipoPublicacion(tipo);
        publicacion.setIdiomaPublicacion(idioma);
        publicacion.setLugarPublicacion(lugar);
        publicacion.setPalabrasClaves(palabrasClaves);
        publicacion.setEnlace(enlace);
        publicacion.setResumen(resumen);
        return EXITO;
    }

    @Override
    public boolean hayPublicacionesConEsteLugar(Lugar lugar) {
        for(Publicacion p: publicaciones){
            if(p.getLugarPublicacion().equals(lugar))
                return true;
        }
        return false;
    }

    @Override
    public boolean hayPublicacionesConEsteIdioma(Idioma idioma) {
        for(Publicacion p: publicaciones){
            if(p.getIdiomaPublicacion().equals(idioma))
                return true;
        }
        return false;
    }

    @Override
    public boolean hayPublicacionesConEsteTipo(Tipo tipo) {
        for(Publicacion p: publicaciones){
            if(p.getTipoPublicacion().equals(tipo))
                return true;
        }
        return false;
    }

    @Override
    public boolean hayPublicacionesConEsteAutor(Autor autor) {
        for(Publicacion p: publicaciones){
            if(p.getAutor().equals(autor))
                return true;
        }
        return false;
    }

    @Override
    public boolean existeEstaPublicacion(Publicacion publicacion) {
        for(Publicacion p: publicaciones){
            if(p.equals(publicacion))
                return true;
        }
        return false;
    }

    @Override
    public List<Publicacion> verPublicaciones() {
        if(this.publicaciones == null){
            this.publicaciones = new ArrayList<>();
        }
        Collections.sort(publicaciones, new ComparadorNombrePublicacion());
        return this.publicaciones;
    }

    public Publicacion verPublicacion(String titulo) {
        for(Publicacion p: publicaciones){
            if(p.getTitulo().equals(titulo))
                return p;
        }
        return null;
    }
    
    @Override
    public String borrarPublicacion(Publicacion publicacion) {
        if(this.existeEstaPublicacion(publicacion)){
            for(Publicacion p: this.publicaciones){
                if(p.equals(publicacion)){
                    this.publicaciones.remove(p);
                    return "Se ha eliminado la publicacion buscada";
                }
            }
        }
        return "No existe esa publicaion";
    }

    @Override
    public List<Publicacion> buscarPublicaciones(String titulo) {
        List<Publicacion> publicacionBuscar = new ArrayList<>();
        
        for(Publicacion p: this.publicaciones){
            if(p.getTitulo().contains(titulo)){
                if(p.getTitulo().compareTo(titulo) >= 0){
                    publicacionBuscar.add(p);
                }
            }
        }
        
        return publicacionBuscar;
    }

    @Override
    public boolean hayPublicacionesConEstaPalabraClave(PalabraClave palabraClave) {
        for(Publicacion p: publicaciones){
            if(p.getPalabrasClaves().equals(palabraClave))
                return true;
        }
        return false;
    }
}
