package autores.modelos;


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
        Autor nuevoProfesor = new Profesor(dni, apellidos, nombres, cargo, clave, claveRepetida);

        if (!autores.contains(nuevoProfesor) && dni =/=null && !apellidos.isEmpty() && !nombres.isEmpty() && cargo =/=
        null && clave.equals(claveRepetida)){
            autores.add(nuevoProfesor);
            return "Profesor agregado de forma EXITOSA!";
        } else
        return "ERROR al agregar un nuevo Profesor!";
    }

    @Override
    public String modificarAutor(Autor autor, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida) {
        Autor nuevoProfesor = new Profesor(apellidos, nombres, cargo, clave, claveRepetida);

        for (Profesor a : autores) {
            if (a.equals(nuevoProfesor)) {
                a.asignarApellidos(apellidos);
                a.asignarNombres(nombres);
                a.asignarCargo(cargo);
                a.asignarClave(clave);
                return "Datos de Profesor modificados de forma EXITOSA!";
            } else
                return "ERROR al modificar los datos de su Profesor!";
        }
    }

    @Override
    public ArrayList<Profesor> verProfesores() {
        private ArrayList<Profesor> profesores = new ArrayList<>();

        for (Profesor a : autores) {
            profesores.add(a);
        }

        return profesores;
    }

    // ALUMNO

    @Override
    public String nuevoAutor(int dni, String apellidos, String nombres, String cx, String clave, String claveRepetida) {
        Autor nuevoAlumno = new Alumno(dni, apellidos, nombres, cx, clave, claveRepetida);

        if (!autores.contains(nuevoAlumno) && dni =/=null && !apellidos.isEmpty() && !nombres.isEmpty() && cx =/=
        null && clave.equals(claveRepetida)){
            autores.add(nuevoAlumno);
            return "Alumno agregado de forma EXITOSA!";
        } else
        return "ERROR al agregar un nuevo Alumno!";
    }

    @Override
    public String modificarAutor(Autor autor, String apellidos, String nombres, String cx, String clave, String claveRepetida) {
        Autor nuevoAlumno = new Alumno(apellidos, nombres, cx, clave, claveRepetida);

        for (Alumno a : autores) {
            if (a.equals(nuevoAlumno)) {
                a.asignarApellidos(apellidos);
                a.asignarNombres(nombres);
                a.asignarCx(cx);
                a.asignarClave(clave);
                return "Datos de Alumno modificados de forma EXITOSA!";
            } else
                return "ERROR al modificar los datos de su Alumno!";
        }
    }

    @Override
    public ArrayList<Alumno> verAlumnos() {
        private ArrayList<Alumno> alumnos = new ArrayList<>();

        for (Alumno a : autores) {
            alumnos.add(a);
        }

        return alumnos;
    }

    @Override
    public boolean existeEsteAutor(Autor autor) {
        for (Autor a : autores) {
            if (a.equals(autor))
                return true;
            else
                return false;
        }
    }
    // preguntar si sirve tambien autores.contains(autor)

    @Override
    public ArrayList<Autor> verAutores() {
        return autores;
    }

    @Override
    public Autor verAutor(int dni) {
        for (Autor a : autores)
            if (a.verDni()==dni)
                return a;
            else
                return null;
    }
}

