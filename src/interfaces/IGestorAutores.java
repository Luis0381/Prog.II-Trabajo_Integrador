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

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luis Medina Raed
 */
public interface IGestorAutores {
    public String nuevoAutor(int dni, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida);

    public String nuevoAutor(int dni, String apellidos, String nombres, String cx, String clave, String claveRepetida);

    public String modificarAutor(Autor autor, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida);

    public String modificarAutor(Autor autor, String apellidos, String nombres, String cx, String clave, String claveRepetida);

    public boolean existeEsteAutor(Autor autor);

    public List<Profesor> verProfesores();

    public List<Alumno> verAlumnos();

    public List<Autor> verAutores();

    public Autor verAutor(int dni);

    public String borrarAutor(Autor dni);

    public void mostrarAlumnos();

    public void mostrarProfesores();

    public void mostrarAutores();

    public List<Alumno> buscarAlumnos(String apellidos);

    public List<Profesor> buscarProfesores(String apellidos);

    public boolean hayAutoresConEsteGrupo(Grupo grupo);
}