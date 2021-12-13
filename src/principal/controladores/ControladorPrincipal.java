/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import autores.modelos.*;
import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.Rol;
import idiomas.modelos.GestorIdiomas;
import idiomas.modelos.Idioma;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import interfaces.IControladorPrincipal;
import lugares.modelos.GestorLugares;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.GestorPalabrasClaves;
import palabrasclaves.modelos.PalabraClave;
import publicaciones.modelos.GestorPublicaciones;
import publicaciones.modelos.Publicacion;
import tipos.modelos.GestorTipos;
import tipos.modelos.Tipo;

import javax.swing.*;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ControladorPrincipal {
    public static void main(String[] args) {

        GestorGrupos GesGrupos = GestorGrupos.crear();
        System.out.println(GesGrupos.nuevoGrupo("Grupo 1", "Descripción 1"));
        System.out.println(GesGrupos.nuevoGrupo("Grupo 2", "Descripción 2"));
        System.out.println(GesGrupos.nuevoGrupo("Grupo 3", "Descripción 3"));

        GestorAutores GesAutores = GestorAutores.crear();
        GesAutores.nuevoAutor(1, "Medina Raed", "Luis", "1", "1", "1");
        GesAutores.nuevoAutor(2, "Mafut", "Thomas", "2", "1", "1");
        GesAutores.nuevoAutor(3, "Molina", "Patricio", "3", "1", "1");
        GesAutores.nuevoAutor(4, "Medina", "Francisco", "4", "1", "1");
        GesAutores.nuevoAutor(5, "Colombo", "Mariano", "5", "1", "1");
        GesAutores.nuevoAutor(6, "Lavarra", "Gaston", "6", "1", "1");
        GesAutores.nuevoAutor(7, "Naranjo", "Rodrigo", "7", "1", "1");


        GesAutores.nuevoAutor(10, "Burgos", "Fernando", Cargo.TITULAR, "Clave10", "Clave10");
        GesAutores.nuevoAutor(11, "d´Hiriart", "Sebastian", Cargo.TITULAR, "Clave10", "Clave10");
        GesAutores.nuevoAutor(12, "Medina Raed", "Horacio", Cargo.TITULAR, "Clave10", "Clave10");
        GesAutores.nuevoAutor(13, "Raed", "Guillermo", Cargo.TITULAR, "Clave10", "Clave10");
        GesAutores.nuevoAutor(14, "Maradona", "Diego", Cargo.TITULAR, "Clave10", "Clave10");

        GestorTipos GesTipos = GestorTipos.crear();
        GesTipos.nuevoTipo("Tipo 1");
        GesTipos.nuevoTipo("Tipo 2");
        GesTipos.nuevoTipo("Tipo 3");
        GesTipos.nuevoTipo("Tipo 4");

        GestorLugares GesLugares = GestorLugares.crear();
        GesLugares.nuevoLugar("Lugar 1");
        GesLugares.nuevoLugar("Lugar 2");
        GesLugares.nuevoLugar("Lugar 3");
        GesLugares.nuevoLugar("Lugar 4");
        GesLugares.nuevoLugar("Lugar 5");

        GestorIdiomas GesIdiomas = GestorIdiomas.crear();
        GesIdiomas.nuevoIdioma("Idioma 1");
        GesIdiomas.nuevoIdioma("Idioma 2");
        GesIdiomas.nuevoIdioma("Idioma 3");
        GesIdiomas.nuevoIdioma("Idioma 4");

        GestorPalabrasClaves GesPalabraClave = GestorPalabrasClaves.crear();
        GesPalabraClave.nuevaPalabraClave("PalabraClave1");
        GesPalabraClave.nuevaPalabraClave("PalabraClave2");
        GesPalabraClave.nuevaPalabraClave("PalabraClave3");
        GesPalabraClave.nuevaPalabraClave("PalabraClave4");

        //GENERADO OBJETOS
        Grupo grupo1 = new Grupo("Grupo 1", "Descripción 1");
        Autor profesor1 = new Profesor(10, "profesor1", "Nombre10", "Clave10", Cargo.TITULAR);
        Tipo tipo1= new Tipo("Monografia");
        Idioma idioma1= new Idioma("Español");
        Lugar lugar1 = new Lugar ("Argentina");
        ArrayList<PalabraClave> palabrasClaves = new ArrayList<>();
        PalabraClave palabraClave1 = new PalabraClave("PalabraClave1");
        palabrasClaves.add(palabraClave1);


        Grupo G1 = GesGrupos.verGrupo("Grupo 1");
        Profesor profesor = GesAutores.verProfesores().get(0);
        profesor.agregarGrupo(G1, Rol.ADMINISTRADOR);
        G1.agregarMiembro(GesAutores.verProfesores().get(1), Rol.COLABORADOR);
        G1.agregarMiembro(GesAutores.verProfesores().get(2), Rol.COLABORADOR);

        GestorPublicaciones GesPublicaciones = GestorPublicaciones.crear();
        System.out.println(GesPublicaciones.nuevaPublicacion("Título 1", new MiembroEnGrupo(profesor1, grupo1, Rol.ADMINISTRADOR), LocalDate.of(2020, 06, 24), tipo1 , idioma1 , lugar1 , palabrasClaves , "http" , "hola"));


        asignarLookAndFeel("Nimbus");
        IControladorPrincipal principal = ControladorVentanaPrincipal.crear();
    }

    /**
     * Asigna el look and feel dando el nombre
     *
     * @param laf cadena con el nombre del look and feel
     */
    public static void asignarLookAndFeel(String laf) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (laf.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                }
            }
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e2) {
            }
        }
    }
}