package autores.modelos;

import java.util.Objects;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class Alumno extends Autor {
    // Variables de instancia  
    private String cx;

    // Constructor
    public Alumno(int dni, String apellidos, String nombres, String clave, String cx) {
        super(dni, apellidos, nombres, clave);
        this.cx = cx;
    }
    // Metodos

    /**
     * Este metodo permite mostrar Alumno
     */
    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("CX: " + this.cx);
    }

    // equals() & hashCode()
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + super.hashCode() + Objects.hashCode(this.cx);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Alumno other = (Alumno) obj;
            return Objects.equals(this.cx, other.cx);
        } else
            return true;
    }

    // Getters & Setters
    public String verCx() {
        return cx;
    }

    public void asignarCx(String cx) {
        this.cx = cx;
    }
}
