package autores.modelos;

import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.Rol;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Thomas Mafut & Luis Medina Raed
 */
public abstract class Autor {
    // Variables de instancia 
    private int dni;
    private String apellidos;
    private String nombres;
    private String clave;
    // Relacion entre clases
    private ArrayList<MiembroEnGrupo> miembrosEnGrupo = new ArrayList<>();

    // Constructor
    public Autor(int dni, String apellidos, String nombres, String clave) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.clave = clave;
    }
    // Metodos

    /**
     * Este metodo permite mostrar Autor
     */
    public void mostrar() {
        System.out.println("Nombre y apellido: " + this.nombres + ", " + this.apellidos + ".");
        System.out.println("DNI: " + dni);
        System.out.println("Clave: " + clave);
        System.out.println("Pertenece a los siguientes grupos: ");
        if (this.tieneGrupos()) {
            for (MiembroEnGrupo unGrupo : this.miembrosEnGrupo) {
                System.out.println(unGrupo.verGrupo().verNombre() + "\nSu Rol es: " + unGrupo.verRol().toString() + ".");
            }
        } else {
            System.out.println("Este autor no pertenece a ningun grupo.");
        }
    }


    public ArrayList<MiembroEnGrupo> verGrupos() {
        return miembrosEnGrupo;
    }

    public void asignarGrupos(ArrayList<MiembroEnGrupo> miembroEnGrupo) {
        this.miembrosEnGrupo = miembroEnGrupo;
    }

    /**
     * Agrega el grupo
     *
     * @param grupo grupo a agregar
     * @param rol   rol del autor en el grupo
     */
    public void agregarGrupo(Grupo grupo, Rol rol) {
        MiembroEnGrupo miembro = new MiembroEnGrupo(this, grupo, rol);
        if (!this.contieneGrupo(grupo) && grupo != null && rol != null) {
            miembrosEnGrupo.add(miembro);
            grupo.agregarMiembro(this, rol);
        }
    }

    public boolean contieneGrupo(Grupo grupo) {
        for (MiembroEnGrupo a : miembrosEnGrupo) {
            if (a.verGrupo().equals(grupo)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Quita el grupo al cual pertenece el autor
     *
     * @param grupo grupo a quitar
     */
    public void quitarGrupo(Grupo grupo) {
        for (MiembroEnGrupo unGrupo : miembrosEnGrupo) {
            if (unGrupo.verGrupo().equals(grupo)) {
                miembrosEnGrupo.remove(unGrupo);
                grupo.quitarMiembro(this);
            }
        }
    }

    /**
     * Este metodo nos permite saber si un autor es superadministrador
     */
    public boolean esSuperAdministrador() {
        for (MiembroEnGrupo unGrupo : miembrosEnGrupo) {
            if (unGrupo.verGrupo().esSuperAdministradores()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Este metodo nos permite saber si un autor tiene grupos
     */
    public boolean tieneGrupos() {
        if (this.miembrosEnGrupo == null)
            return false;
        else if (this.miembrosEnGrupo.isEmpty())
            return false;
        else
            return true;
    }

    // equals() & hashCode()
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.dni;
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
        if (getClass().getSuperclass() != obj.getClass().getSuperclass()) {
            return false;
        }
        final Autor other = (Autor) obj;
        return this.dni == other.dni;
    }

    // Getters & Setters
    public int verDni() {
        return dni;
    }

    public void asignarDni(int dni) {
        this.dni = dni;
    }

    public String verApellidos() {
        return apellidos;
    }

    public void asignarApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String verNombres() {
        return nombres;
    }

    public void asignarNombres(String nombres) {
        this.nombres = nombres;
    }

    public String verClave() {
        return clave;
    }

    public void asignarClave(String clave) {
        this.clave = clave;
    }
}
