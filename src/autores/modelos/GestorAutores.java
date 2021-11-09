package autores.modelos;


import grupos.modelos.Grupo;
import interfaces.IGestorAutores;


import java.util.ArrayList;

public class GestorAutores implements IGestorAutores {
    private static ArrayList<Autor> autores = new ArrayList<>();
    private static GestorAutores gestor;

    private GestorAutores() {

    }

    public static GestorAutores crear() {
        if (gestor == null)
            gestor = new GestorAutores();

        return gestor;
    }

    // PROFESOR

    @Override
    public String nuevoAutor(int dni, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida) {
        Autor nuevoProfesor = new Profesor(dni, apellidos, nombres, clave, cargo);

        if (autores.contains(nuevoProfesor) || dni == 0 || apellidos.isEmpty() || nombres.isEmpty() || cargo == null || !clave.equals(claveRepetida)) {
            return "\n\tERROR al agregar un nuevo Profesor!";
        } else {
            autores.add(nuevoProfesor);
            return "\n\tProfesor agregado de forma EXITOSA!";
        }
    }

    @Override
    public String modificarAutor(Autor autor, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida) {
        Autor nuevoProfesor = new Profesor(0, apellidos, nombres, clave, cargo);

        for (Autor a : autores) {
            if (a instanceof Profesor)
                if (a.equals(nuevoProfesor)) {
                    Profesor profesor = (Profesor) autor;
                    profesor.asignarApellidos(apellidos);
                    profesor.asignarNombres(nombres);
                    profesor.asignarCargo(cargo);
                    profesor.asignarClave(clave);
                    return "Datos de Profesor modificados de forma EXITOSA!";
                }
        }
        return "ERROR al modificar los datos de su Profesor!";
    }

    @Override
    public ArrayList<Profesor> verProfesores() {
        ArrayList<Profesor> profesores = new ArrayList<>();

        for (Autor a : autores) {
            if (a instanceof Profesor)
                profesores.add((Profesor) a);
        }

        return profesores;
    }

    // ALUMNO

    @Override
    public String nuevoAutor(int dni, String apellidos, String nombres, String cx, String clave, String claveRepetida) {
        Autor nuevoAlumno = new Alumno(dni, apellidos, nombres, clave, cx);

        if (autores.contains(nuevoAlumno) || dni == 0 || apellidos.isEmpty() || nombres.isEmpty() || cx == null || !clave.equals(claveRepetida)) {
            return "\n\tERROR al agregar un nuevo Alumno!";
        } else {
            autores.add(nuevoAlumno);
            return "\n\tAlumno agregado de forma EXITOSA!";
        }
    }

    @Override
    public String modificarAutor(Autor autor, String apellidos, String nombres, String cx, String clave, String claveRepetida) {

        for (Autor a : autores) {
            if (a instanceof Alumno)
                if (a.equals(autor)) {
                    Alumno alumno = (Alumno) autor;
                    alumno.asignarApellidos(apellidos);
                    alumno.asignarNombres(nombres);
                    alumno.asignarCx(cx);
                    alumno.asignarClave(clave);
                    return "Datos de Alumno modificados de forma EXITOSA!";
                }
        }
        return "ERROR al modificar los datos de su Alumno!";
    }

    @Override
    public ArrayList<Alumno> verAlumnos() {
        ArrayList<Alumno> alumnos = new ArrayList<>();

        for (Autor a : autores) {
            if (a instanceof Alumno)
                alumnos.add((Alumno) a);
        }

        return alumnos;
    }

    @Override
    public boolean existeEsteAutor(Autor autor) {
        for (Autor a : autores) {
            if (a.equals(autor))
                return true;
        }
        return false;
    }
    // preguntar si sirve tambien autores.contains(autor)

    @Override
    public ArrayList<Autor> verAutores() {
        return autores;
    }

    @Override
    public Autor verAutor(int dni) {
        for (Autor a : autores) {
            if (a.verDni() == dni)
                return a;
        }
        return null;
    }

    @Override
    public void mostrarAlumnos() {
        if (!verAlumnos().isEmpty()) {
            for (Alumno a : verAlumnos())
                a.mostrar();
        }
    }

    @Override
    public void mostrarProfesores() {
        if (!verProfesores().isEmpty()) {
            for (Profesor a : verProfesores())
                a.mostrar();
        }
    }

    @Override
    public void mostrarAutores() {
        if (!verAutores().isEmpty())
            for (Autor a : autores)
                a.mostrar();
    }
}

