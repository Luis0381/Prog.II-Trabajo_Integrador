/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import grupos.modelos.MiembroEnGrupo;
import idiomas.modelos.Idioma;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.PalabraClave;
import tipos.modelos.Tipo;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class Publicacion {
    private String titulo;
    private LocalDate fechaPublicacion;
    private String enlace;
    private String resumen;
    private List<PalabraClave> palabrasClaves;

    public List<PalabraClave> getPalabrasClaves() {
        return palabrasClaves;
    }

    public void setPalabrasClaves(List<PalabraClave> palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }
    private MiembroEnGrupo autor;
    private Lugar lugarPublicacion;
    private Idioma idiomaPublicacion;
    private Tipo tipoPublicacion;

    protected Publicacion(String titulo, MiembroEnGrupo autor, LocalDate fechaPublicacion,Tipo tipoPublicacion, Idioma idiomaPublicacion,Lugar lugarPublicacion, List<PalabraClave> palabrasClaves, String enlace, String resumen) {
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.enlace = enlace;
        this.resumen = resumen;
        this.palabrasClaves = palabrasClaves;
        this.autor = autor;
        this.lugarPublicacion = lugarPublicacion;
        this.idiomaPublicacion = idiomaPublicacion;
        this.tipoPublicacion = tipoPublicacion;
    }

    public MiembroEnGrupo getAutor() {
        return autor;
    }

    public void setAutor(MiembroEnGrupo autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public Lugar getLugarPublicacion() {
        return lugarPublicacion;
    }

    public void setLugarPublicacion(Lugar lugarPublicacion) {
        this.lugarPublicacion = lugarPublicacion;
    }

    public Idioma getIdiomaPublicacion() {
        return idiomaPublicacion;
    }

    public void setIdiomaPublicacion(Idioma idiomaPublicacion) {
        this.idiomaPublicacion = idiomaPublicacion;
    }

    public Tipo getTipoPublicacion() {
        return tipoPublicacion;
    }

    public void setTipoPublicacion(Tipo tipoPublicacion) {
        this.tipoPublicacion = tipoPublicacion;
    }
    
    public void verPalabrasClaves(){
        System.out.println("Palabras Claves");
        System.out.println("---------------");
        for(PalabraClave pc: palabrasClaves){
            System.out.println("\t" + pc.toString());
        }
    }
    
    public void mostrar(){
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Autor: " + this.autor.verAutor().verApellidos() +", " + this.autor.verAutor().verNombres());
        System.out.println("Grupo: " + this.autor.verAutor().verNombres());
        System.out.println("Rol: " + this.autor.verRol().toString());
        System.out.println("Fecha de Publicacion: "+ this.fechaPublicacion.getDayOfMonth()+"/"+this.fechaPublicacion.getMonthValue()+"/"+this.fechaPublicacion.getYear());
        System.out.println("Tipo: "+this.tipoPublicacion.toString());
        System.out.println("Idioma: "+this.idiomaPublicacion.toString());
        System.out.println("Lugar: "+this.lugarPublicacion.toString());
        verPalabrasClaves();
        System.out.println("Enlace: "+this.enlace);
        System.out.println("Enlace: "+this.resumen);
    }   

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.titulo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Publicacion other = (Publicacion) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return true;
    }
}
