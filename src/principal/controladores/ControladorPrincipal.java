package principal.controladores;

import autores.modelos.Cargo;
import autores.modelos.GestorAutores;
import autores.modelos.Profesor;
import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.Rol;
import idiomas.modelos.GestorIdiomas;
import idiomas.modelos.Idioma;
import interfaces.IControladorPrincipal;
import interfaces.IGestorPublicaciones;
import lugares.modelos.GestorLugares;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.GestorPalabrasClaves;
import palabrasclaves.modelos.PalabraClave;
import publicaciones.modelos.GestorPublicaciones;
import tipos.modelos.GestorTipos;
import tipos.modelos.Tipo;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ControladorPrincipal {
    public static void main(String[] args) {
        //<editor-fold defaultstate="collapsed" desc="Creación de grupos, autores, tipos , lugares, idiomas, palabras claves y publicaciones">
        GestorGrupos GesGrupos = GestorGrupos.crear();
        GesGrupos.nuevoGrupo("Grupo 1", "Descripción 1");
        GesGrupos.nuevoGrupo("Grupo 2", "Descripción 2");
        GesGrupos.nuevoGrupo("Grupo 3", "Descripción 3");
        GesGrupos.nuevoGrupo("Grupo 4", "Descripción 4");
        GesGrupos.nuevoGrupo("Grupo 5", "Descripción 5");

        GestorAutores GesAutores = GestorAutores.crear();
        GesAutores.nuevoAutor(1, "Medina Raed", "Luis", "1", "1", "1");
        GesAutores.nuevoAutor(2, "Mafut", "Thomas", "2", "1", "1");
        GesAutores.nuevoAutor(3, "Ruiz", "Ramiro", "3", "1", "1");
        GesAutores.nuevoAutor(4, "Aguirre", "Pedro", "4", "1", "1");
        GesAutores.nuevoAutor(5, "Rodriguez", "Juan", "5", "1", "1");
        GesAutores.nuevoAutor(6, "Gonzalez", "Gaston", "6", "1", "1");
        GesAutores.nuevoAutor(7, "Argañaraz", "Lucas", "7", "1", "1");


        GesAutores.nuevoAutor(10, "Nieto", "Luis", Cargo.TITULAR, "Clave10", "Clave10");
        GesAutores.nuevoAutor(11, "Sanchez", "Mariana", Cargo.TITULAR, "Clave10", "Clave10");
        GesAutores.nuevoAutor(12, "Cardozo", "Teresa", Cargo.TITULAR, "Clave10", "Clave10");
        GesAutores.nuevoAutor(13, "Tuquina", "Fernando", Cargo.ADG, "Clave10", "Clave10");

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

        Grupo G1 = GesGrupos.verGrupo("Grupo 1");
        Tipo T1 = GesTipos.verTipo("Tipo 1");
        Idioma I1 = GesIdiomas.verIdioma("Idioma 1");
        Lugar L1 = GesLugares.verLugar("Lugar 1");
        List<PalabraClave> palabrasClavesP1 = new ArrayList();
        palabrasClavesP1.add(GesPalabraClave.verPalabraClave("PalabraClave1"));
        Profesor profesor = GesAutores.verProfesores().get(0);
        profesor.agregarGrupo(G1, Rol.ADMINISTRADOR);
        G1.agregarMiembro(GesAutores.verProfesores().get(1), Rol.COLABORADOR);
        G1.agregarMiembro(GesAutores.verProfesores().get(2), Rol.COLABORADOR);

        IGestorPublicaciones GesPublicaciones = GestorPublicaciones.crear();
        GesPublicaciones.nuevaPublicacion("Título 1", new MiembroEnGrupo(profesor, G1, Rol.COLABORADOR), LocalDate.of(2020, 06, 24), T1, I1, L1, palabrasClavesP1, "-", "-");

        //</editor-fold>
        asignarLookAndFeel("Nimbus");
        IControladorPrincipal principal = ControladorVentanaPrincipal.crear();
    }
    //<editor-fold defaultstate="collapsed" desc="Look and Feel">

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

    //</editor-fold>
}