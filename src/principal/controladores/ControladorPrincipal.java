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
        asignarLookAndFeel("Nimbus");
        IControladorPrincipal principal = ControladorVentanaPrincipal.crear();
        //<editor-fold defaultstate="collapsed" desc="Sin intefaz gráfica">
//        ArrayList<Grupo> grupos = new ArrayList<>();
//        ArrayList<Alumno> alumnos = new ArrayList<>();
//        ArrayList<Profesor> profesores = new ArrayList<>();
//        ArrayList<Autor> autores = new ArrayList<>();
//        ArrayList<Tipo> tipos = new ArrayList<>();
//        ArrayList<Lugar> lugares = new ArrayList<>();
//        ArrayList<Idioma> idiomas = new ArrayList<>();
//        ArrayList<PalabraClave> palabrasClaves = new ArrayList<>();
//        ArrayList<Publicacion> publicaciones = new ArrayList<>();

//        GestorGrupos GesGrupos = GestorGrupos.crear();
//        GesGrupos.nuevoGrupo("Grupo 1", "Descripción 1");
//        GesGrupos.nuevoGrupo("Grupo 1", "Descripción 1"); //nombre repetido
//        if (!grupos.contains(grupo1))
//            grupos.add(grupo1);
//        if (!grupos.contains(grupo2))
//            grupos.add(grupo2);
//        if (!grupos.contains(grupo3))
//            grupos.add(grupo3);
//        if (!grupos.contains(grupo4))
//            grupos.add(grupo4);
//        if (!grupos.contains(grupo5))
//            grupos.add(grupo5);
//        if (!grupos.contains(grupo6))
//            grupos.add(grupo6);
//
//        System.out.println("\n\n\tGrupos creados: \n\n");
//        GesGrupos.mostrarGrupos();
//
//        System.out.println("");
//        GestorAutores GesAutores = GestorAutores.crear();
//        System.out.println("\n\n\tAl agregar un alumno: \n\n");
//        System.out.println(GesAutores.nuevoAutor(1, "A", "B", "1", "1", "1"));
//        System.out.println("\n\n\tAl agregar un alumno con mismo DNI y distinto CX: \n\n");
//        System.out.println(GesAutores.nuevoAutor(1, "A", "B", "2", "1", "1")); //NO AGREGA
//        System.out.println("\n\n\tAl agregar un alumno con mismo CX y distinto DNI: \n\n");
//        System.out.println(GesAutores.nuevoAutor(2, "A", "B", "1", "1", "1")); //NO AGREGA
//        System.out.println("\n\n\tAl agregar un alumno sin poner correctamente la clave repetida: \n\n");
//        System.out.println(GesAutores.nuevoAutor(3, "A", "B", "3", "1", "2")); //NO AGREGA
//        System.out.println("\n\n\tAl agregar otro alumno normalmente \n\n");
//        System.out.println(GesAutores.nuevoAutor(4, "A", "B", "4", "4", "4"));
//        System.out.println("\n\n\tAl agregar un alumno con DNI negativo \n\n");
//        System.out.println(GesAutores.nuevoAutor(-5, "A", "B", "5", "4", "4")); //NO AGREGA
//        System.out.println("\n\n\tAl agregar un alumno con clave vacia \n\n");
//        System.out.println(GesAutores.nuevoAutor(11, "A", "B", "6", "", ""));
//        System.out.println("\n\n\tAl agregar un alumno con nombre vacio \n\n");
//        System.out.println(GesAutores.nuevoAutor(12, "A", "", "7", "1", "1")); //NO AGREGA
//        System.out.println("\n\n\tAl agregar un alumno con apellido vacio \n\n");
//        System.out.println(GesAutores.nuevoAutor(13, "A", "", "8", "1", "1")); //NO AGREGA
//        System.out.println("\n\n\tAl agregar un alumno con CX vacio \n\n");
//        System.out.println(GesAutores.nuevoAutor(14, "A", "B", "", "1", "1")); //NO AGREGA


//        if (!autores.contains(alumno1))
//            autores.add(alumno1);
//        if (!autores.contains(alumno2))
//            autores.add(alumno2);
//        if (!autores.contains(alumno3))
//            autores.add(alumno3);
//        if (!autores.contains(alumno4))
//            autores.add(alumno4);
//        if (!autores.contains(alumno5))
//            autores.add(alumno5);
//        if (!autores.contains(alumno6))
//            autores.add(alumno6);

//        System.out.println("");
//        System.out.println("\n\n\tAl agregar un profesor: \n\n");
//        System.out.println(GesAutores.nuevoAutor(10, "Apellido10", "Nombre10", Cargo.TITULAR, "Clave10", "Clave10"));
//        System.out.println("\n\n\tAl agregar un profesor repetido: \n\n");
//        System.out.println(GesAutores.nuevoAutor(10, "Apellido10", "Nombre10", Cargo.TITULAR, "Clave10", "Clave10"));
//        System.out.println("\n\n\tAl agregar un profesor con igual DNI a un alumno: \n\n");
//        System.out.println(GesAutores.nuevoAutor(1, "Apellido10", "Nombre10", Cargo.TITULAR, "Clave10", "Clave10"));
//        System.out.println("\n\n\tAl agregar un profesor con DNI negativo: \n\n");
//        System.out.println(GesAutores.nuevoAutor(-5, "Apellido10", "Nombre10", Cargo.TITULAR, "Clave10", "Clave10"));
//        System.out.println("\n\n\tAl agregar un profesor con apellido vacio: \n\n");
//        System.out.println(GesAutores.nuevoAutor(11, "", "Nombre10", Cargo.TITULAR, "Clave10", "Clave10"));
//        System.out.println("\n\n\tAl agregar un profesor con nombre vacio: \n\n");
//        System.out.println(GesAutores.nuevoAutor(12, "Apellido10", "", Cargo.TITULAR, "Clave10", "Clave10"));
//        System.out.println("\n\n\tAl agregar un profesor con clave vacio: \n\n");
//        System.out.println(GesAutores.nuevoAutor(14, "Apellido10", "Nombre10", Cargo.TITULAR, "", ""));
//        if (!autores.contains(profesor1))
//            autores.add(profesor1);
//        if (!autores.contains(profesor2))
//            autores.add(profesor2);
//        if (!autores.contains(profesor3))
//            autores.add(profesor3);
//        if (!autores.contains(profesor4))
//            autores.add(profesor4);
//        if (!autores.contains(profesor5))
//            autores.add(profesor5);
//        if (!autores.contains(profesor6))
//            autores.add(profesor6);
//
//        if (!autores.contains(profesor7))
//            autores.add(profesor7);
//        if (!autores.contains(alumno7))
//            autores.add(alumno7);
//        if (!autores.contains(alumno8))
//            autores.add(alumno8);

//        System.out.println("\n\n\tAutores: \n\n");
//        GesAutores.mostrarAutores();


        /*Main parte 3*/
//        /*
//        1) Luego de crear grupos y autores, tomar 1 grupo y agregarle 2 autores
//        como miembros. Mostrar el grupo verificando que tenga los miembros
//        asignados. Verificar también que no se pueda agregar
//        un mismo autor más de una vez, por más que sean en roles distintos.
//        */
//        System.out.println("\n\t\tPARTE 1\n");
//        grupo1.agregarMiembro(profesor1, Rol.ADMINISTRADOR);
//        grupo1.agregarMiembro(profesor1, Rol.COLABORADOR); //autor repetido
//        grupo1.agregarMiembro(alumno1, Rol.COLABORADOR);
//        System.out.println("\n\tGrupo Nº1: \n");
//        grupo1.mostrar();
//
//        /*
//        2) Tomar 1 de los 2 autores que se asignó al grupo anterior y
//        agregarlo a otro grupo distinto.
//        Mostrar los 2 autores verificando que pertenezcan a los grupos
//        a los que fueron asignados.
//        Verificar también que no se pueda agregarle a un autor
//        un mismo grupo más de una vez, por más que sean roles distintos.
//        */
//
//        System.out.println("\n\t\tPARTE 2\n");
//        profesor1.agregarGrupo(grupo2, Rol.COLABORADOR);
//        profesor1.agregarGrupo(grupo2, Rol.ADMINISTRADOR); //grupo repetido
//        System.out.println("\n\tProfesor Nº1: \n");
//        profesor1.mostrar();
//        System.out.println("\n\tAlumno Nº1: \n");
//        alumno1.mostrar();
//
//        /*
//        3) Tomar el grupo al que se le agregaron los 2 autores como miembros,
//        quitarle 1 y mostrarlo, verificando que el autor
//        ya no es miembro del grupo.
//        */
//
//        System.out.println("");
//        System.out.println("\n\t\tPARTE 3\n");
//        System.out.println("\n\tAntes de quitar el grupo\n");
//        grupo1.mostrar();
//        grupo1.quitarMiembro(profesor1);
//        System.out.println("\n\tDespués de quitar el grupo\n");
//        grupo1.mostrar();
//
//        /*
//        4) Crear un nuevo grupo para los super administradores.
//        Este grupo DEBE llevar por nombre "Super Administradores".
//        Intentar asignarle como miembro un autor cualquiera
//        con el rol de colaborador, verificando que se lo
//        agrega pero con el rol de administrador.
//        */
//
//        System.out.println("");
//        System.out.println("PARTE 4");
//        Grupo grupo7 = new Grupo("Super Administradores", "Grupo para los super administradores"); //grupo para los super administradores
//        if (!grupos.contains(grupo7))
//            grupos.add(grupo7);
//        grupo7.agregarMiembro(profesor1, Rol.COLABORADOR);
//        grupo7.mostrar();
//
//        /*
//        5) Verificar que el último grupo creado es de super administradores
//        y cualquiera de los otros grupos no
//        (usar el método esSuperAdministradores() definido en la clase Grupo).
//        */
//
//        System.out.println("");
//        System.out.println("PARTE 5");
//        System.out.println(grupo7.esSuperAdministradores());
//        System.out.println(grupo1.esSuperAdministradores());
//
//        /*
//        6) Tomar el autor que se agregó al grupo de super administradores,
//        verificar que el mismo es super administrador
//        y los otros autores no (usar el método esSuperAdministrador()
//        definido en la clase Autor).
//        */
//        System.out.println("");
//        System.out.println("PARTE 6");
//        System.out.println(profesor1.esSuperAdministrador());
//        System.out.println(alumno1.esSuperAdministrador());
//
//        /*Main parte 3*/

//        GestorTipos GesTipos = GestorTipos.crear();
//        System.out.println("\n\n\tAl agregar un tipo: \n\n");
//        System.out.println(GesTipos.nuevoTipo("Tipo 1"));;
//        System.out.println("\n\n\tAl agregar un tipo repetido: \n\n");
//        System.out.println(GesTipos.nuevoTipo("Tipo 1"));;
//        System.out.println("\n\n\tAl agregar un tipo vacio: \n\n");
//        System.out.println(GesTipos.nuevoTipo(""));;
//
//        System.out.println("\n\n\tTipos creados: \n\n");
//        System.out.println(GesTipos.verTipos());
//        if (!tipos.contains(tipo1))
//            tipos.add(tipo1);
//        if (!tipos.contains(tipo2))
//            tipos.add(tipo2);
//        if (!tipos.contains(tipo3))
//            tipos.add(tipo3);
//        if (!tipos.contains(tipo4))
//            tipos.add(tipo4);
//        if (!tipos.contains(tipo5))
//            tipos.add(tipo5);
//        if (!tipos.contains(tipo6))
//            tipos.add(tipo6);

//        GestorLugares GesLugares = GestorLugares.crear();
//        System.out.println("\n\n\tAl agregar un lugar: \n\n");
//        System.out.println(GesLugares.nuevoLugar("Lugar 1"));
//        System.out.println("\n\n\tAl agregar un lugar repetido: \n\n");
//        System.out.println(GesLugares.nuevoLugar("Lugar 1"));//nombre repetido
//        System.out.println("\n\n\tAl agregar un lugar vacio: \n\n");
//        System.out.println(GesLugares.nuevoLugar(""));//nombre repetido
//
//        System.out.println("\n\n\tLugares creados: \n\n");
//        System.out.println(GesLugares.verLugares());

//        if (!lugares.contains(lugar1))
//            lugares.add(lugar1);
//        if (!lugares.contains(lugar2))
//            lugares.add(lugar2);
//        if (!lugares.contains(lugar3))
//            lugares.add(lugar3);
//        if (!lugares.contains(lugar4))
//            lugares.add(lugar4);
//        if (!lugares.contains(lugar5))
//            lugares.add(lugar5);
//        if (!lugares.contains(lugar6))
//            lugares.add(lugar6);

//        GestorIdiomas GesIdiomas = GestorIdiomas.crear();
//        System.out.println("\n\n\tAl agregar un idioma: \n\n");
//        System.out.println(GesIdiomas.nuevoIdioma("Idioma 1"));
//        System.out.println("\n\n\tAl agregar un idioma repetido: \n\n");
//        System.out.println(GesIdiomas.nuevoIdioma("Idioma 1"));//nombre repetido
//        System.out.println("\n\n\tAl agregar un idioma vacio: \n\n");
//        System.out.println(GesIdiomas.nuevoIdioma(""));//nombre repetido
//
//        System.out.println("\n\n\tIdiomas creados: \n\n");
//        System.out.println(GesIdiomas.verIdiomas());
//        if (!idiomas.contains(idioma1))
//            idiomas.add(idioma1);
//        if (!idiomas.contains(idioma2))
//            idiomas.add(idioma2);
//        if (!idiomas.contains(idioma3))
//            idiomas.add(idioma3);
//        if (!idiomas.contains(idioma4))
//            idiomas.add(idioma4);
//        if (!idiomas.contains(idioma5))
//            idiomas.add(idioma5);
//        if (!idiomas.contains(idioma6))
//            idiomas.add(idioma6);


//        GestorPalabrasClaves GesPalabraClave = GestorPalabrasClaves.crear();
//        System.out.println("\n\n\tAl agregar una palabra clave: \n\n");
//        System.out.println(GesPalabraClave.nuevaPalabraClave("PalabraClave1"));
//        System.out.println("\n\n\tAl agregar una palabra clave repetida: \n\n");
//        System.out.println(GesPalabraClave.nuevaPalabraClave("PalabraClave1")); //nombre repetido
//        System.out.println("\n\n\tAl agregar una palabra clave vacia: \n\n");
//        System.out.println(GesPalabraClave.nuevaPalabraClave("")); //nombre repetido
//
//        System.out.println("\n\n\tPalabras Claves creadas: \n\n");
//        System.out.println(GesPalabraClave.verPalabrasClaves());

//        if (!palabrasClaves.contains(palabraClave1))
//            palabrasClaves.add(palabraClave1);
//        if (!palabrasClaves.contains(palabraClave2))
//            palabrasClaves.add(palabraClave2);
//        if (!palabrasClaves.contains(palabraClave3))
//            palabrasClaves.add(palabraClave3);
//        if (!palabrasClaves.contains(palabraClave4))
//            palabrasClaves.add(palabraClave4);
//        if (!palabrasClaves.contains(palabraClave5))
//            palabrasClaves.add(palabraClave5);
//        if (!palabrasClaves.contains(palabraClave6))
//            palabrasClaves.add(palabraClave6);


//        //GENERADO OBJETOS
//        Grupo grupo1 = new Grupo("Grupo 1", "Descripción 1");
//        Autor profesor1 = new Profesor(10, "profesor1", "Nombre10", "Clave10", Cargo.TITULAR);
//        Tipo tipo1= new Tipo("Monografia");
//        Idioma idioma1= new Idioma("Español");
//        Lugar lugar1 = new Lugar ("Argentina");
//        ArrayList<PalabraClave> palabrasClaves = new ArrayList<>();
//        PalabraClave palabraClave1 = new PalabraClave("PalabraClave1");
//        palabrasClaves.add(palabraClave1);
//
//        GestorPublicaciones GesPublicaciones = GestorPublicaciones.crear();
//        System.out.println("\n\n\tAl agregar una publicacion: \n\n");
//        System.out.println(GesPublicaciones.nuevaPublicacion("Título 1", new MiembroEnGrupo(profesor1, grupo1, Rol.ADMINISTRADOR), LocalDate.of(2020, 06, 24), tipo1 , idioma1 , lugar1 , palabrasClaves , "http" , "hola"));
//        System.out.println("\n\n\tAl agregar una publicacion repetida; \n\n");
//        System.out.println(GesPublicaciones.nuevaPublicacion("Título 1", new MiembroEnGrupo(profesor1, grupo1, Rol.ADMINISTRADOR), LocalDate.of(2020, 06, 24), tipo1 , idioma1 , lugar1 , palabrasClaves , "http" , "hola"));
//
//        System.out.println("\n\n\tPublicaciones creadas: \n\n");
//        GesPublicaciones.mostrarPublicaciones();

//        if (!publicaciones.contains(publicacion1))
//            publicaciones.add(publicacion1);
//        if (!publicaciones.contains(publicacion2))
//            publicaciones.add(publicacion2);
//        if (!publicaciones.contains(publicacion3))
//            publicaciones.add(publicacion3);
//        if (!publicaciones.contains(publicacion4))
//            publicaciones.add(publicacion4);
//        if (!publicaciones.contains(publicacion5))
//            publicaciones.add(publicacion5);
//        if (!publicaciones.contains(publicacion6))
//            publicaciones.add(publicacion6);
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
            }
            catch (Exception e2) {
            }
        }
    }
}