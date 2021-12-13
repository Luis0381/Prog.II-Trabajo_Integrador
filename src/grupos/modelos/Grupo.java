package grupos.modelos;

import autores.modelos.Autor;

import java.util.*;

/**
 *
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class Grupo {
    // Variables de instancia
    private String nombre;
    private String descripcion;
    // Relacion entre clases
    private ArrayList<MiembroEnGrupo> miembros = new ArrayList<>();
    // Constructor
    public Grupo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    // Metodos
        public boolean tieneMiembros(){
        if (this.miembros == null) {
            return false;
        }
        if (this.miembros.isEmpty()){
            return false;
        }
        else
            return true;
    }
    /**
        Este metodo nos permite mostrar un grupo
    */  
    public void mostrar(){
        System.out.println("Nombre: "+ nombre);
        System.out.println("Descripcion: "+ descripcion);
        System.out.println("Los miembros del grupo son: ");
        if(tieneMiembros()){
            for(MiembroEnGrupo unMiembroEnGrupo : miembros){
            System.out.println(unMiembroEnGrupo.verAutor().verNombres()+ ", "+ unMiembroEnGrupo.verAutor().verApellidos() + " Rol: "+ unMiembroEnGrupo.verRol());
        }
        }
            else
            {
                System.out.println("El grupo no tiene miembros.");       
            }
        }
    public ArrayList <MiembroEnGrupo> verMiembros(){
        return miembros;
    }

public void agregarMiembro(Autor autor, Rol rol) {
    if ((autor != null) && (rol != null)) {
        MiembroEnGrupo meg;
        meg = new MiembroEnGrupo(autor, this, rol);
        if (!this.miembros.contains(meg)) {
            this.miembros.add(meg);
            autor.agregarGrupo(this, rol);
        }
    }
}

    public void quitarMiembro(Autor miembro) {
        if (miembro != null) {
            for (MiembroEnGrupo meg : this.miembros) {
                Autor m = meg.verAutor();
                if (miembro.equals(m)) {
                    this.miembros.remove(meg);
                    miembro.quitarGrupo(this);
                    break;
                }
            }
        }
    }

    public boolean esSuperAdministradores(){
        if(this.nombre.equals("Super Administradores")){
            return true;
        }
        else
            return false;
    }

    // equals() & hashCode()
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nombre);
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
        final Grupo other = (Grupo) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    // Getters & Setters
    public String verNombre() {
        return nombre;
    }
    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }
    public String verDescripcion() {
        return descripcion;
    }
    public void asignarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void agregarMiembros(List<MiembroEnGrupo> miembros) {
        if (miembros != null) {
            for(MiembroEnGrupo meg : miembros) {
                Autor miembro = meg.verAutor();
                Rol rol = meg.verRol();
                this.agregarMiembro(miembro, rol);
            }
        }
    }

    public void quitarMiembros(List<MiembroEnGrupo> miembros) {
        if (miembros != null) {
            for(MiembroEnGrupo meg : miembros) {
                Autor miembro = meg.verAutor();
                this.quitarMiembro(miembro);
            }
        }
    }
}