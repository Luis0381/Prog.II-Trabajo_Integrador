package publicaciones.modelos;

import grupos.modelos.MiembroEnGrupo;
import idiomas.modelos.Idioma;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.PalabraClave;
import tipos.modelos.Tipo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Thomas Mafut & Luis Medina Raed
 */
public class Publicacion {
    // Variables de instancia
    private String titulo;
    private LocalDate fechaPublicacion;
    private String enlace;
    private String resumen;
    // Relacion entre clases
    private Tipo unTipo;
    private Idioma unIdioma;
    private Lugar unLugar;
    private ArrayList<PalabraClave> palabrasClaves;
    private MiembroEnGrupo unMiembroEnGrupo;

    DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/MM/uuuu");
    
    // Constructor
    public Publicacion(String titulo, MiembroEnGrupo unMiembroEnGrupo, LocalDate fechaPublicacion, Tipo unTipo, Idioma unIdioma, Lugar unLugar, List<PalabraClave> palabrasClaves, String enlace, String resumen) {
        this.titulo = titulo;
        this.unMiembroEnGrupo = unMiembroEnGrupo;
        this.fechaPublicacion = fechaPublicacion;
        this.unTipo = unTipo;
        this.unIdioma = unIdioma;
        this.unLugar = unLugar;
        this.palabrasClaves = palabrasClaves;
        this.enlace = enlace;
        this.resumen = resumen;
    }
    // Metodos
    public void mostrar(){
        System.out.println("------------------------------");
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Autor: " + this.unMiembroEnGrupo.verAutor().verApellidos() + ", " + this.unMiembroEnGrupo.verAutor().verNombres());
        System.out.println("Grupo: " + this.unMiembroEnGrupo.verGrupo().verNombre());
        System.out.println("Fecha de Publicacion: " + fechaPublicacion.format(formato));;
        System.out.println("Tipo: " + this.unTipo);
        System.out.println("Idioma: " + this.unIdioma);
        System.out.println("Lugar: " + this.unLugar);
        System.out.println("");
        System.out.println("Sus palabras claves son: ");
        for (PalabraClave palabraClave : palabrasClaves){
            System.out.println(palabraClave);
        }
        System.out.println("");
        System.out.println("Enlace: " + this.enlace);
        System.out.println("Resumen: " + this.resumen);
    }
    // equals() & hashCode()
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
    // Getters & Setters

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

    public Tipo getUnTipo() {
        return unTipo;
    }

    public void setUnTipo(Tipo unTipo) {
        this.unTipo = unTipo;
    }

    public Idioma getUnIdioma() {
        return unIdioma;
    }

    public void setUnIdioma(Idioma unIdioma) {
        this.unIdioma = unIdioma;
    }

    public Lugar getUnLugar() {
        return unLugar;
    }

    public void setUnLugar(Lugar unLugar) {
        this.unLugar = unLugar;
    }

    public ArrayList<PalabraClave> getPalabrasClaves() {
        return palabrasClaves;
    }

    public void setPalabrasClaves(List<PalabraClave> palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }

    public MiembroEnGrupo getUnMiembroEnGrupo() {
        return unMiembroEnGrupo;
    }

    public void setUnMiembroEnGrupo(MiembroEnGrupo unMiembroEnGrupo) {
        this.unMiembroEnGrupo = unMiembroEnGrupo;
    }
}
