package publicaciones.modelos;

import idiomas.modelos.GestorIdiomas;
import idiomas.modelos.Idioma;
import interfaces.IGestorIdiomas;

import javax.swing.*;

public class ModeloComboIdiomas extends DefaultComboBoxModel {

    public ModeloComboIdiomas() {
        IGestorIdiomas gesIdiomas = GestorIdiomas.crear();
        for (Idioma idioma : gesIdiomas.verIdiomas())
            this.addElement(idioma);

    }

    public Idioma obtenerIdioma() {
        return (Idioma) this.getSelectedItem();
    }

    public void seleccionarIdioma(Idioma idioma) {
        this.setSelectedItem(idioma);
    }
}