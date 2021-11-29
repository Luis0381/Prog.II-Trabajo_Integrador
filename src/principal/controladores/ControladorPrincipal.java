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

import lugares.modelos.GestorLugares;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.GestorPalabrasClaves;
import palabrasclaves.modelos.PalabraClave;
import publicaciones.modelos.GestorPublicaciones;
import publicaciones.modelos.Publicacion;
import tipos.modelos.GestorTipos;
import tipos.modelos.Tipo;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ControladorPrincipal {
    public static void main(String[] args) {
        //<editor-fold defaultstate="collapsed" desc="Sin intefaz gráfica">

        GestorGrupos GesGrupos = GestorGrupos.crear();
        System.out.println("\n\n\tAl agregar un grupo correcto: \n\n");
        System.out.println(GesGrupos.nuevoGrupo("Grupo 1", "Descripción 1"));
        System.out.println("\n\n\tAl agregar un grupo repetido: \n\n");
        System.out.println(GesGrupos.nuevoGrupo("Grupo 1", "Descripción 1")); //nombre repetido
        System.out.println("\n\n\tAl agregar un grupo correcto: \n\n");
        System.out.println(GesGrupos.nuevoGrupo("Grupo 3", "Descripción 3"));
        System.out.println("\n\n\tAl agregar un grupo correcto: \n\n");
        System.out.println(GesGrupos.nuevoGrupo("Grupo 2", "Descripción 2"));

        System.out.println("\n\n\tGrupos creados: \n\n");
        GesGrupos.mostrarGrupos();

        System.out.println("");
        GestorAutores GesAutores = GestorAutores.crear();
        System.out.println("\n\n\tAl agregar un alumno: \n\n");
        System.out.println(GesAutores.nuevoAutor(1, "Medina", "Luis", "1", "1", "1"));
        System.out.println("\n\n\tAl agregar un alumno con mismo DNI y distinto CX: \n\n");
        System.out.println(GesAutores.nuevoAutor(1, "A", "B", "2", "1", "1")); //NO AGREGA
        System.out.println("\n\n\tAl agregar un alumno con mismo CX y distinto DNI: \n\n");
        System.out.println(GesAutores.nuevoAutor(2, "A", "B", "1", "1", "1")); //NO AGREGA
        System.out.println("\n\n\tAl agregar un alumno sin poner correctamente la clave repetida: \n\n");
        System.out.println(GesAutores.nuevoAutor(3, "A", "B", "3", "1", "2")); //NO AGREGA
        System.out.println("\n\n\tAl agregar otro alumno normalmente \n\n");
        System.out.println(GesAutores.nuevoAutor(4, "Medina", "Abel", "4", "4", "4"));
        System.out.println("\n\n\tAl agregar un alumno con DNI negativo \n\n");
        System.out.println(GesAutores.nuevoAutor(-5, "A", "B", "5", "4", "4")); //NO AGREGA
        System.out.println("\n\n\tAl agregar un alumno con clave vacia \n\n");
        System.out.println(GesAutores.nuevoAutor(11, "Rodriguez", "Juan", "6", "", ""));
        System.out.println("\n\n\tAl agregar un alumno con nombre vacio \n\n");
        System.out.println(GesAutores.nuevoAutor(12, "A", "", "7", "1", "1")); //NO AGREGA
        System.out.println("\n\n\tAl agregar un alumno con apellido vacio \n\n");
        System.out.println(GesAutores.nuevoAutor(13, "A", "", "8", "1", "1")); //NO AGREGA
        System.out.println("\n\n\tAl agregar un alumno con CX vacio \n\n");
        System.out.println(GesAutores.nuevoAutor(14, "A", "B", "", "1", "1")); //NO AGREGA

        System.out.println("");
        System.out.println("\n\n\tAl agregar un profesor: \n\n");
        System.out.println(GesAutores.nuevoAutor(10, "Mafut", "Thomas", Cargo.TITULAR, "Clave10", "Clave10"));
        System.out.println("\n\n\tAl agregar un profesor repetido: \n\n");
        System.out.println(GesAutores.nuevoAutor(10, "Apellido10", "Nombre10", Cargo.TITULAR, "Clave10", "Clave10"));
        System.out.println("\n\n\tAl agregar un profesor con igual DNI a un alumno: \n\n");
        System.out.println(GesAutores.nuevoAutor(1, "Apellido10", "Nombre10", Cargo.TITULAR, "Clave10", "Clave10"));
        System.out.println("\n\n\tAl agregar un profesor con DNI negativo: \n\n");
        System.out.println(GesAutores.nuevoAutor(-5, "Apellido10", "Nombre10", Cargo.TITULAR, "Clave10", "Clave10"));
        System.out.println("\n\n\tAl agregar un profesor con apellido vacio: \n\n");
        System.out.println(GesAutores.nuevoAutor(11, "", "Nombre10", Cargo.TITULAR, "Clave10", "Clave10"));
        System.out.println("\n\n\tAl agregar un profesor con nombre vacio: \n\n");
        System.out.println(GesAutores.nuevoAutor(12, "Apellido10", "", Cargo.TITULAR, "Clave10", "Clave10"));
        System.out.println("\n\n\tAl agregar un profesor con clave vacio: \n\n");
        System.out.println(GesAutores.nuevoAutor(14, "Mafut", "Lucas", Cargo.TITULAR, "", ""));

        System.out.println("\n\n\tAutores: \n\n");
        GesAutores.mostrarAutores();

        GestorTipos GesTipos = GestorTipos.crear();
        System.out.println("\n\n\tAl agregar un tipo: \n\n");
        System.out.println(GesTipos.nuevoTipo("Tipo 1"));;
        System.out.println("\n\n\tAl agregar un tipo repetido: \n\n");
        System.out.println(GesTipos.nuevoTipo("Tipo 1"));;
        System.out.println("\n\n\tAl agregar un tipo vacio: \n\n");
        System.out.println(GesTipos.nuevoTipo(""));;

        System.out.println("\n\n\tAl agregar otro tipo correcto: \n\n");
        System.out.println(GesTipos.nuevoTipo("Tipo 3"));;
        System.out.println("\n\n\tAl agregar otro tipo correcto: \n\n");
        System.out.println(GesTipos.nuevoTipo("Tipo 2"));;

        System.out.println("\n\n\tTipos creados: \n\n");
        System.out.println(GesTipos.verTipos());

        GestorLugares GesLugares = GestorLugares.crear();
        System.out.println("\n\n\tAl agregar un lugar: \n\n");
        System.out.println(GesLugares.nuevoLugar("Lugar 1"));
        System.out.println("\n\n\tAl agregar un lugar repetido: \n\n");
        System.out.println(GesLugares.nuevoLugar("Lugar 1"));//nombre repetido
        System.out.println("\n\n\tAl agregar un lugar vacio: \n\n");
        System.out.println(GesLugares.nuevoLugar(""));//nombre repetido

        System.out.println("\n\n\tAl agregar otro lugar correcto: \n\n");
        System.out.println(GesLugares.nuevoLugar("Lugar 3"));
        System.out.println("\n\n\tAl agregar otro lugar correcto: \n\n");
        System.out.println(GesLugares.nuevoLugar("Lugar 2"));

        System.out.println("\n\n\tLugares creados: \n\n");
        System.out.println(GesLugares.verLugares());

        GestorIdiomas GesIdiomas = GestorIdiomas.crear();
        System.out.println("\n\n\tAl agregar un idioma: \n\n");
        System.out.println(GesIdiomas.nuevoIdioma("Idioma 1"));
        System.out.println("\n\n\tAl agregar un idioma repetido: \n\n");
        System.out.println(GesIdiomas.nuevoIdioma("Idioma 1"));//nombre repetido
        System.out.println("\n\n\tAl agregar un idioma vacio: \n\n");
        System.out.println(GesIdiomas.nuevoIdioma(""));//nombre repetido

        System.out.println("\n\n\tAl agregar otro idioma correcto: \n\n");
        System.out.println(GesIdiomas.nuevoIdioma("Idioma 3"));
        System.out.println("\n\n\tAl agregar otro idioma correcto: \n\n");
        System.out.println(GesIdiomas.nuevoIdioma("Idioma 2"));

        System.out.println("\n\n\tIdiomas creados: \n\n");
        System.out.println(GesIdiomas.verIdiomas());

        GestorPalabrasClaves GesPalabraClave = GestorPalabrasClaves.crear();
        System.out.println("\n\n\tAl agregar una palabra clave: \n\n");
        System.out.println(GesPalabraClave.nuevaPalabraClave("PalabraClave1"));
        System.out.println("\n\n\tAl agregar una palabra clave repetida: \n\n");
        System.out.println(GesPalabraClave.nuevaPalabraClave("PalabraClave1")); //nombre repetido
        System.out.println("\n\n\tAl agregar una palabra clave vacia: \n\n");
        System.out.println(GesPalabraClave.nuevaPalabraClave("")); //nombre repetido

        System.out.println("\n\n\tAl agregar otra palabra clave correcta: \n\n");
        System.out.println(GesPalabraClave.nuevaPalabraClave("PalabraClave3"));
        System.out.println("\n\n\tAl agregar otra palabra clave correcta: \n\n");
        System.out.println(GesPalabraClave.nuevaPalabraClave("PalabraClave2"));

        System.out.println("\n\n\tPalabras Claves creadas: \n\n");
        System.out.println(GesPalabraClave.verPalabrasClaves());

        //GENERADO OBJETOS
        Grupo grupo1 = new Grupo("Grupo 1", "Descripción 1");
        Autor profesor1 = new Profesor(10, "profesor1", "Nombre10", "Clave10", Cargo.TITULAR);
        Tipo tipo1= new Tipo("Monografia");
        Idioma idioma1= new Idioma("Español");
        Lugar lugar1 = new Lugar ("Argentina");
        ArrayList<PalabraClave> palabrasClaves = new ArrayList<>();
        PalabraClave palabraClave1 = new PalabraClave("PalabraClave1");
        palabrasClaves.add(palabraClave1);

        GestorPublicaciones GesPublicaciones = GestorPublicaciones.crear();
        System.out.println("\n\n\tAl agregar una publicacion: \n\n");
        System.out.println(GesPublicaciones.nuevaPublicacion("Título 1", new MiembroEnGrupo(profesor1, grupo1, Rol.ADMINISTRADOR), LocalDate.of(2020, 06, 24), tipo1 , idioma1 , lugar1 , palabrasClaves , "http" , "hola"));
        System.out.println("\n\n\tAl agregar una publicacion repetida; \n\n");
        System.out.println(GesPublicaciones.nuevaPublicacion("Título 1", new MiembroEnGrupo(profesor1, grupo1, Rol.ADMINISTRADOR), LocalDate.of(2020, 06, 24), tipo1 , idioma1 , lugar1 , palabrasClaves , "http" , "hola"));

        System.out.println("\n\n\tPublicaciones creadas: \n\n");
        GesPublicaciones.mostrarPublicaciones();

        //</editor-fold>

        //     //<editor-fold defaultstate="collapsed" desc="Intefaz gráfica">
//         VentanaAMGrupo ventanaGrupo = new VentanaAMGrupo(null); //se instancia la ventana
///*
////        ventanaGrupo.setLocationRelativeTo(null); //se centra la ventana
////        ventanaGrupo.setVisible(true); //se hace visible la ventana
//        
////        VentanaAMAlumno ventanaAlumno = new VentanaAMAlumno(null); //se instancia la ventana
////        ventanaAlumno.setLocationRelativeTo(null); //se centra la ventana
////        ventanaAlumno.setVisible(true); //se hace visible la ventana
//*/        
//        VentanaAMProfesor ventanaProfesor = new VentanaAMProfesor(null); //se instancia la ventana
//        ventanaProfesor.setLocationRelativeTo(null); //se centra la ventana
//        ventanaProfesor.setVisible(true); //se hace visible la ventana        
///*        
////        VentanaAIdioma ventanaIdioma = new VentanaAIdioma(null); //se instancia la ventana
////        ventanaIdioma.setLocationRelativeTo(null); //se centra la ventana
////        ventanaIdioma.setVisible(true); //se hace visible la ventana                
//        
////        VentanaALugar ventanaLugar = new VentanaALugar(null); //se instancia la ventana
////        ventanaLugar.setLocationRelativeTo(null); //se centra la ventana
////        ventanaLugar.setVisible(true); //se hace visible la ventana                        
//        
////        VentanaAPalabraClave ventanaPalabraClave = new VentanaAPalabraClave(null); //se instancia la ventana
////        ventanaPalabraClave.setLocationRelativeTo(null); //se centra la ventana
////        ventanaPalabraClave.setVisible(true); //se hace visible la ventana                                
//        
////        VentanaATipo ventanaTipo = new VentanaATipo(null); //se instancia la ventana
////        ventanaTipo.setLocationRelativeTo(null); //se centra la ventana
////        ventanaTipo.setVisible(true); //se hace visible la ventana   
//*/
//
//     //</editor-fold>
    }
}