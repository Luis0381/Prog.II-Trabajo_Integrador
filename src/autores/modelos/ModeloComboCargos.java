package autores.modelos;

import javax.swing.*;

/**
 * @author Thomas Mafut & Luis Medina Raed
 */
public class ModeloComboCargos extends DefaultComboBoxModel {
    /**
     * Constructor
     */
    public ModeloComboCargos() {
        for (Cargo cargo : Cargo.values()) {
            this.addElement(cargo);
        }

    }

    /**
     * Devuelve el cargo
     *
     * @return Cargo cargo seleccionado
     */
    public Cargo obtenerCargo() {
        return (Cargo) this.getSelectedItem();
    }
}