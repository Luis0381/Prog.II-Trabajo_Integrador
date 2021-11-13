package principal.controladores;


import autores.controladores.ControladorAutores;
import interfaces.IControladorPrincipal;
import principal.vistas.VentanaPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ControladorVentanaPrincipal implements IControladorPrincipal {
    private static ControladorVentanaPrincipal instancia;
    private VentanaPrincipal ventana;

    private ControladorVentanaPrincipal() {
        this.ventana = new VentanaPrincipal(this);
    }

    public static ControladorVentanaPrincipal crear() {
        if (instancia == null)
            instancia = new ControladorVentanaPrincipal();

        return instancia;
    }

    @Override
    public void btnAutoresClic(ActionEvent evt) {
        ControladorAutores autores = ControladorAutores.crear();

        if (ventana == null)
            ventana = new VentanaPrincipal(this);
        else
            ventana.setVisible(true);
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {
        String[] confirmacion = {"Si", "No"};
        int opcion = JOptionPane.showOptionDialog(ventana, CONFIRMACION, "Esta seguro que desea salir?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, confirmacion, confirmacion[1]);

        if (opcion == 0)
            System.exit(0);
    }
}
