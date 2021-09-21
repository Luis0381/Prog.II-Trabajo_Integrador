package grupos.modelos;

public class Grupo {
    private String nombre;
    private String descripcion;

    public void mostrar(){
        System.out.printf("\t%s (%s)\n", nombre, descripcion);
    }

    public Grupo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

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
}