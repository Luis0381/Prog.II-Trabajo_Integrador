package autores.modelos;

import grupos.modelos.MiembroEnGrupo;

import java.util.ArrayList;

public class Profesor {
    private int dni;
    private String apellidos;
    private String nombres;
    private String clave;
    private Cargo cargo;

    private ArrayList<MiembroEnGrupo> miembroengrupos;


    public void mostrar(){
       System.out.printf("\t%s, %s - %d - %s - %s \n", apellidos, nombres, dni, clave, cargo);
   }

    public Profesor(int dni, String apellidos, String nombres, String clave, Cargo cargo) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.clave = clave;
        this.cargo = cargo;
    }

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

    public String verCargo() {
        return cargo.toString();
    }

    public void asignarCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
