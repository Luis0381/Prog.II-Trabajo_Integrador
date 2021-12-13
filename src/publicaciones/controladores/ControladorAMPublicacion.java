/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.controladores;

import autores.modelos.GestorAutores;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.Rol;
import interfaces.IControladorAMPublicacion;
import interfaces.IControladorPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import interfaces.IGestorPublicaciones;
import palabrasclaves.modelos.GestorPalabrasClaves;
import palabrasclaves.modelos.ModeloTablaPalabrasClaves;
import palabrasclaves.modelos.PalabraClave;
import publicaciones.modelos.GestorPublicaciones;
import publicaciones.modelos.ModeloComboGrupos;
import publicaciones.modelos.ModeloComboIdiomas;
import publicaciones.modelos.ModeloComboLugares;
import publicaciones.modelos.ModeloComboTipos;
import publicaciones.modelos.Publicacion;
import publicaciones.vistas.VentanaAMPublicacion;

/**
 *
 * @author Usuario
 */
public class ControladorAMPublicacion implements IControladorAMPublicacion{
    private static ControladorAMPublicacion instancia;
    private VentanaAMPublicacion ventana;

    
    private ControladorAMPublicacion(){
        ventana = new VentanaAMPublicacion(this);
    }
    
    public static ControladorAMPublicacion crear() {
        if(instancia==null){
            instancia = new ControladorAMPublicacion();
        }
        return  instancia;
    }

    public VentanaAMPublicacion getVentana() {
        return ventana;
    }
    
    public void mostrarVentana(String titulo){
        boolean mostrar = true;
        if(titulo.equals(TITULO_NUEVA)){
            this.ventana.getTxtTitulo().setEnabled(true);
        }
        else{
            this.ventana.getTxtTitulo().setEnabled(false);
        }
        GestorPublicaciones gesPublicaciones = GestorPublicaciones.crear();

        this.ventana.getComboGrupo().setModel(new ModeloComboGrupos());
        if(this.ventana.getComboGrupo().getItemCount() == 0 && titulo.equals(TITULO_NUEVA)){
            mostrar = false;
            JOptionPane.showMessageDialog(ventana, "El profesor logueado actualmente no se encuentra en ningun grupo, por lo que no puede crear una publicacion");
        }
        this.ventana.getComboTipo().setModel(new ModeloComboTipos());
        this.ventana.getTablaPalabrasClave().setModel(new ModeloTablaPalabrasClaves());
        this.ventana.getComboIdioma().setModel(new ModeloComboIdiomas());
        this.ventana.getComboLugar().setModel(new ModeloComboLugares());
        
        if(mostrar){
            this.ventana.setTitle(titulo);
            this.ventana.setLocationRelativeTo(null);
            this.ventana.setVisible(true);
        }
    }
    
    public void limpiar(){
        ventana.getTxtTitulo().setText("");
        ventana.getTxtEnlace().setText("");
        ventana.getTxtResumen().setText("");
        ventana.getSelectorFecha().setCalendar(null);
    }    
    
    public void ocultar(){
        this.ventana.setVisible(false);
    }
    
    private void nuevaPublicacion(){
        String titulo = ventana.getTxtTitulo().getText().trim();
        String enlace = ventana.getTxtEnlace().getText().trim();
        ModeloComboTipos modeloTipos = (ModeloComboTipos)ventana.getComboTipo().getModel();
        ModeloComboIdiomas modeloIdiomas = (ModeloComboIdiomas)ventana.getComboIdioma().getModel();
        ModeloComboGrupos modeloGrupos = (ModeloComboGrupos)ventana.getComboGrupo().getModel();
        GestorAutores autores = GestorAutores.crear();
        MiembroEnGrupo autor = new MiembroEnGrupo(autores.verProfesores().get(0), modeloGrupos.obtenerGrupo(), Rol.COLABORADOR);
        ModeloComboLugares modeloLugares = (ModeloComboLugares)ventana.getComboLugar().getModel();
        int[] palabrasClaveElegidas = ventana.getTablaPalabrasClave().getSelectedRows();
        List<PalabraClave> palabrasClave = new ArrayList<>();
        GestorPalabrasClaves gpc = GestorPalabrasClaves.crear();
        for(int filaElegida: palabrasClaveElegidas){
            String palabraClave = ventana.getTablaPalabrasClave().getValueAt(filaElegida, 0).toString();
            palabrasClave.add(gpc.verPalabraClave(palabraClave));
        }

        String resumen = ventana.getTxtResumen().getText().trim();
        Date d = ventana.getSelectorFecha().getCalendar().getTime();
        LocalDate fechaPublicacion = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        GestorPublicaciones gPublicaciones = GestorPublicaciones.crear();
        String resultado = gPublicaciones.nuevaPublicacion(titulo, autor, fechaPublicacion, modeloTipos.obtenerTipo(), modeloIdiomas.obtenerIdioma(), modeloLugares.obtenerLugar(), palabrasClave, enlace, resumen);
        JOptionPane.showMessageDialog(ventana, resultado);
        
        if(resultado.equals(IGestorPublicaciones.EXITO)){
            this.ocultar();
            this.limpiar();
            ControladorPublicaciones publicaciones = ControladorPublicaciones.crear();
            publicaciones.actualizarTablaPublicaciones();
        }
    }
    
    private void modificarPublicacion(){
        String titulo = ventana.getTxtTitulo().getText().trim();
        String enlace = ventana.getTxtEnlace().getText().trim();
        ModeloComboTipos modeloTipos = (ModeloComboTipos)ventana.getComboTipo().getModel();
        ModeloComboIdiomas modeloIdiomas = (ModeloComboIdiomas)ventana.getComboIdioma().getModel();
        ModeloComboGrupos modeloGrupos = (ModeloComboGrupos)ventana.getComboGrupo().getModel();
        ModeloComboLugares modeloLugares = (ModeloComboLugares)ventana.getComboLugar().getModel();
        int[] palabrasClaveElegidas = ventana.getTablaPalabrasClave().getSelectedRows();
        List<PalabraClave> palabrasClave = new ArrayList<>();
        GestorPalabrasClaves gpc = GestorPalabrasClaves.crear();
        for(int filaElegida: palabrasClaveElegidas){
            String palabraClave = ventana.getTablaPalabrasClave().getValueAt(filaElegida, 0).toString();
            palabrasClave.add(gpc.verPalabraClave(palabraClave));
        }

        String resumen = ventana.getTxtResumen().getText().trim();
        Date d = ventana.getSelectorFecha().getCalendar().getTime();
        LocalDate fechaPublicacion = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        GestorPublicaciones gPublicaciones = GestorPublicaciones.crear();
        Publicacion publicacion = gPublicaciones.verPublicacion(titulo);
        MiembroEnGrupo autor = publicacion.getAutor();
        autor.asignarGrupo(modeloGrupos.obtenerGrupo());
        String resultado = gPublicaciones.modificarPublicacion(publicacion, autor, fechaPublicacion, modeloTipos.obtenerTipo(), modeloIdiomas.obtenerIdioma(), modeloLugares.obtenerLugar(), palabrasClave, enlace, resumen);

        JOptionPane.showMessageDialog(ventana, resultado);
        
        if(resultado.equals(IGestorPublicaciones.EXITO)){
            this.ocultar();
            ControladorPublicaciones publicaciones = ControladorPublicaciones.crear();
            publicaciones.actualizarTablaPublicaciones();
        }
    }
    
    @Override
    public void btnGuardarClic(ActionEvent evt) {
        if(ventana.getTitle().equals(TITULO_NUEVA)){
            nuevaPublicacion();
        }
        else{
            modificarPublicacion();
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        JOptionPane.showMessageDialog(ventana, "Se ha cancelado la operación");
        this.ocultar();
    }

    @Override
    public void txtTituloPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isLetter(c)) {
            switch(c) {
                case KeyEvent.VK_ENTER:
                    this.btnGuardarClic(null);
                    break;
                case KeyEvent.VK_BACK_SPACE:
                case KeyEvent.VK_DELETE:
                case KeyEvent.VK_SPACE:
                    break;
                default:
                    evt.consume();
            }
        }
    }

    @Override
    public void btnTodasLasPalabrasClavesClic(ActionEvent evt) {
        javax.swing.JTable tabla = ventana.getTablaPalabrasClave();
        ModeloTablaPalabrasClaves modeloTablaPalabrasClaves = (ModeloTablaPalabrasClaves)tabla.getModel();
        ListSelectionModel modeloSeleccion = tabla.getSelectionModel();
        modeloSeleccion.addSelectionInterval(0, modeloTablaPalabrasClaves.getRowCount() - 1);
    }

    @Override
    public void btnNingunaPalabraClaveClic(ActionEvent evt) {
        javax.swing.JTable tabla = ventana.getTablaPalabrasClave();
        ListSelectionModel modeloSeleccion = tabla.getSelectionModel();
        modeloSeleccion.clearSelection();
    }

    @Override
    public void btnAbrirClic(ActionEvent evt) {
        //Se ponen en español los nombres de los botones de la ventana de diálogo
        UIManager.put("FileChooser.openButtonText","Abrir");
        UIManager.put("FileChooser.openButtonToolTipText", "Abrir");
        UIManager.put("FileChooser.cancelButtonText","Cancelar");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar");
        UIManager.put("FileChooser.lookInLabelText", "Buscar en:");
        UIManager.put("FileChooser.fileNameLabelText", "Archivo:");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Archivos del tipo:");
        UIManager.put("FileChooser.upFolderToolTipText", "Subir un nivel");
        UIManager.put("FileChooser.homeFolderToolTipText", "Inicio");
        UIManager.put("FileChooser.newFolderToolTipText", "Carpeta nueva");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalles");
        
        JFileChooser selector = new JFileChooser();
        selector.setCurrentDirectory(new File(System.getProperty("user.home")));
        //se establece la carpeta personal del usuario para empezar la búsqueda
        selector.setDialogTitle(IControladorPrincipal.TITULO);
        selector.setAcceptAllFileFilterUsed(false); //no se muestra el filtro de todos los archivos
        
        int resultado = selector.showOpenDialog(null);
        
        if (resultado == JFileChooser.APPROVE_OPTION) { //se selecciona un archivo
            File selectedFile = selector.getSelectedFile();
            this.ventana.getTxtEnlace().setText(selectedFile.getAbsolutePath());
        }        
    }
    
    
}
