package grupos.modelos;

import javax.swing.*;

/**
 * @author Medina Raed, Luis Eugenio & Mafut, Thomas
 */
public class ModeloComboRoles extends DefaultComboBoxModel {
    
    public ModeloComboRoles() {  
        for (Rol rol : Rol.values()) {
            this.addElement(rol); 
        }
    }

    public Rol obtenerRol() { 
        return (Rol)this.getSelectedItem();
    }
        
    public void seleccionarRol(Rol rol) {
        this.setSelectedItem(rol);
    }        
}