package lugares.modelos;

import java.util.Objects;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class Lugar {
    // Variables de instancia
    private String nombre;

    // Constructor
    public Lugar(String nombre) {
        this.nombre = nombre;
    }

    // Metodos
    @Override
    public String toString() {
        return nombre;
    }

    public void mostrarLugar() {
        System.out.println(this.nombre);
    }

    // equals() & hashCode()
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.nombre);
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
        final Lugar other = (Lugar) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    // Getters & Setters
    public String verNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }
}
