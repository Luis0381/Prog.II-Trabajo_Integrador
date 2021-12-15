/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import autores.modelos.Alumno;
import autores.modelos.Autor;
import autores.modelos.Cargo;
import autores.modelos.Profesor;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;

import java.util.List;

public interface IGestorAutores {
    //Constantes para las operaciones de E/S (profesores)
    String LECTURA_PROFESORES_ERROR = "Error al leer los profesores";
    String LECTURA_PROFESORES_OK = "Se pudieron leer los profesores";
    String ESCRITURA_PROFESORES_ERROR = "Error al guardar los profesores";
    String ESCRITURA_PROFESORES_OK = "Se pudieron guardar los profesores";
    String CREACION_PROFESORES_ERROR = "Error al crear el archivo de profesores";
    String CREACION_PROFESORES_OK = "Se pudo crear el archivo de profesores";
    String PROBLEMAS_ES = "No se puede realizar la operación por problemas con el archivo";

    //Constantes para las operaciones de E/S (alumnos)
    String LECTURA_ALUMNOS_ERROR = "Error al leer los alumnos";
    String LECTURA_ALUMNOS_OK = "Se pudieron leer los alumnos";
    String ESCRITURA_ALUMNOS_ERROR = "Error al guardar los alumnos";
    String ESCRITURA_ALUMNOS_OK = "Se pudieron guardar los alumnos";
    String CREACION_ALUMNOS_ERROR = "Error al crear el archivo de alumnos";
    String CREACION_ALUMNOS_OK = "Se pudo crear el archivo de alumnos";

    //Constantes para el ABM de profesores y alumnos    
    String EXITO = "Profesor/alumno creado/modificado/borrado con éxito";
    String ERROR_DNI = "El documento del profesor/alumno es incorrecto";
    String ERROR_APELLIDOS = "Los apellidos del profesor/alumno son incorrectos";
    String ERROR_NOMBRES = "Los nombres del profesor/alumno son incorrectos";
    String ERROR_CARGO = "El cargo del profesor es incorrecto";
    String ERROR_CX = "El cx del alumno es incorrecto";
    String ERROR_CLAVES = "Las claves especificadas no coinciden o son incorrectas";

    String PROFESORES_DUPLICADOS = "Ya existe un profesor/alumno con ese documento";
    String PROFESOR_INEXISTENTE = "No existe el profesor especificado";
    String PUBLICACION_CON_AUTOR = "No se puede borrar el autor porque hay publicaciones en donde participa";

    String ALUMNOS_DUPLICADOS = "Ya existe un alumno/profesor con ese documento/cx";
    String ALUMNO_INEXISTENTE = "No existe el alumno especificado";
    String GRUPO_INVALIDO = "Uno de los grupos a agregar/quitar es incorrecto o no existe";
    String GRUPOS_INEXISTENTES = "No se especificaron grupos a agregar/quitar";
    String AUTOR_INEXISTENTE = "No existe el autor especificado";
    String EXITO_GRUPOS = "Grupos agregados/quitados con éxito";

    String NOMBRE_SUPER_ADMINISTRADOR = "Admin";
    //nombre para el super administrador en caso que no hubiera uno

    String SOY_PROFESOR = "Profesor";
    String SOY_ALUMNO = "Alumno";

    /**
     * Crea un nuevo profesor
     *
     * @param dni           documento del profesor
     * @param apellidos     apellidos del profesor
     * @param nombres       nombres del profesor
     * @param cargo         cargo del profesor
     * @param clave         clave del profesor
     * @param claveRepetida clave (repetida) del profesor
     * @return cadena con el resultado de la operación (EXITO | ESCRITURA_PROFESORES_ERROR | PROBLEMAS_ES | PROFESORES_DUPLICADOS | ERROR_DNI | ERROR_APELLIDOS | ERROR_NOMBRES | ERROR_CARGO | ERROR_CLAVES)
     */
    String nuevoAutor(int dni, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida);

    /**
     * Crea un nuevo alumno
     *
     * @param apellidos     apellidos del alumno
     * @param nombres       nombres del alumno
     * @param dni           documento del alumno
     * @param cx            cx del alumno
     * @param clave         clave del alumno
     * @param claveRepetida clave (repetida) del alumno
     * @return cadena con el resultado de la operación (EXITO | ESCRITURA_ALUMNOS_ERROR | PROBLEMAS_ES | ALUMNOS_DUPLICADOS | ERROR_DNI | ERROR_APELLIDOS | ERROR_NOMBRES | ERROR_CX | ERROR_CLAVES)
     */
    String nuevoAutor(int dni, String apellidos, String nombres, String cx, String clave, String claveRepetida);

    /**
     * Modifica un profesor
     *
     * @param autor         autor a editar
     * @param apellidos     apellidos del profesor
     * @param nombres       nombres del profesor
     * @param cargo         cargo del profesor
     * @param clave         clave del profesor
     * @param claveRepetida clave (repetida) del profesor
     * @return cadena con el resultado de la operación (EXITO | ESCRITURA_PROFESORES_ERROR | PROBLEMAS_ES | PROFESOR_INEXISTENTE | ERROR_APELLIDOS | ERROR_NOMBRES | ERROR_CARGO | ERROR_CLAVES)
     */
    String modificarAutor(Autor autor, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida);

    /**
     * Modifica un alumno
     *
     * @param autor         a editar
     * @param apellidos     apellidos del alumno
     * @param nombres       nombres del alumno
     * @param cx            cx del alumno
     * @param clave         clave del alumno
     * @param claveRepetida clave (repetida) del alumno
     * @return cadena con el resultado de la operación (EXITO | ESCRITURA_ALUMNOS_ERROR | PROBLEMAS_ES | ALUMNO_INEXISTENTE | ERROR_APELLIDOS | ERROR_NOMBRES | ERROR_CX | ERROR_CLAVES)
     */
    String modificarAutor(Autor autor, String apellidos, String nombres, String cx, String clave, String claveRepetida);

    /**
     * Borra un autor siempre y cuando no figure en alguna publicación
     *
     * @param autor autor a borrar
     * @return String  - cadena con el resultado de la operación (EXITO | ESCRITURA_PROFESORES_ERROR | ESCRITURA_ALUMNOS_ERROR | PROBLEMAS_ES | AUTOR_INEXISTENTE | PUBLICACION_CON_AUTOR)
     */
    String borrarAutor(Autor autor);

    /**
     * Agrega los grupos especificados al autor, siempre y cuando no esté en los mismos
     *
     * @param autor  autor al cual se le agregarán los grupos
     * @param grupos grupos a agregar
     * @return String  - cadena con el resultado de la operación (EXITO_GRUPOS | ESCRITURA_ERROR | AUTOR_INEXISTENTE | GRUPOS_INEXISTENTES)
     */
//    public String agregarGrupos(Autor autor, List<Grupo> grupos);
    String agregarGrupos(Autor autor, List<MiembroEnGrupo> grupos);

    /**
     * Quita los grupos especificados del autor
     *
     * @param autor  autor al cual se le quitarán los grupos
     * @param grupos grupos a quitar
     * @return String  - cadena con el resultado de la operación (EXITO_GRUPOS | ESCRITURA_ERROR | AUTOR_INEXISTENTE | GRUPOS_INEXISTENTES)
     */
//    public String quitarGrupos(Autor autor, List<Grupo> grupos);   
    String quitarGrupos(Autor autor, List<MiembroEnGrupo> grupos);

    /**
     * Devuelve true si existe el autor especificado, false en caso contrario
     *
     * @param autor autor a buscar
     * @return boolean  - true si existe el autor especificado, false en caso contrario
     */
    boolean existeEsteAutor(Autor autor);

    /**
     * Busca si existen profesores con el apellido especificado (total o parcialmente)
     * Este método es usado por las clases ModeloTablaProfesores y ModeloComboProfesores
     *
     * @param apellidos apellidos del profesor a buscar
     * @return List<Profesor>  - lista de profesores, ordenados por apellidos y nombres, cuyos apellidos coincidan con el especificado
     */
    List<Profesor> buscarProfesores(String apellidos);

    /**
     * Busca si existen alumnos con el apellido especificado (total o parcialmente)
     * Este método es usado por las clases ModeloTablaAlumnos y ModeloListaAlumnos
     *
     * @param apellidos apellidos del alumno a buscar
     * @return List<Alumno>  - lista de alumnos, ordenados por apellidos y nombres, cuyos apellidos coincidan con el especificado
     */
    List<Alumno> buscarAlumnos(String apellidos);

    /**
     * Devuelve todos los autores ordenados por apellido,nombre
     * Este método es necesario para las clases ModeloTablaMiembros y ModeloComboPalabrasClaves
     *
     * @return List<Autor>  - lista de autores ordenados por apellido,nombre
     */
    List<Autor> verAutores();

    /**
     * Devuelve todos los profesores ordenados por apellido,nombre
     * Este método es necesario para las clases ModeloTablaProfesores y ModeloComboPalabrasClaves
     *
     * @return List<Profesor>  - lista de profesores ordenados por apellido,nombre
     */
    List<Profesor> verProfesores();

    /**
     * Devuelve todos los alumnos ordenados por apellido,nombre
     * Este método es necesario para las clases ModeloTablaAlumnos y ModeloComboPalabrasClaves
     *
     * @return List<Alumno>  - lista de alumnos ordenados por apellido,nombre
     */
    List<Alumno> verAlumnos();

    /**
     * Busca si existe un autor cuyo documento coincida con el especificado
     * Si existe un autor con el documento especificado, lo devuelve
     * Si no hay un autor con el documento especicado, devuelve null
     * A este método lo usa la clase GestorGrupos
     *
     * @param dni dni del autor a buscar
     * @return Autor  - autor cuyo documento coincida con el especificado, o null
     */
    Autor verAutor(int dni);

    /**
     * Busca si hay al menos un autor que pertenezca al grupo especificado
     * A este método lo usa la clase GestorGrupos
     *
     * @param grupo grupo a buscar
     * @return boolean  - true si hay al menos un autor que pertenezca al grupo especificado
     */
    boolean hayAutoresConEsteGrupo(Grupo grupo);
}
