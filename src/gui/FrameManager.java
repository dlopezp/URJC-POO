/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author HOME3
 */
public class FrameManager {
    
    private static FrameManager instance = null;
    
    private FrameManager() {}
    
    public static FrameManager getInstance() {
        if (instance == null) {
            instance = new FrameManager();
        }
        return instance;
    }
    
    public void mostrarVentanaPrincipal(JFrame ventanaActual) {
        ocultarVentana(ventanaActual);
        mostrarVentana(new FrameSeleccionUsuario());
    }
    
    public void mostrarVentanaAdministrador(JFrame ventanaActual) throws ClassNotFoundException, IOException {
        ocultarVentana(ventanaActual);
        mostrarVentana(new FrameAdministrador());
    }
    
    public void mostrarVentanaEscuderia(JFrame ventanaActual) {
        ocultarVentana(ventanaActual);
        try {
            mostrarVentana(new FrameEscuderia());
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(FrameManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarVentanaDirector(JFrame ventanaActual) throws ClassNotFoundException, IOException {
        ocultarVentana(ventanaActual);
        mostrarVentana(new FrameDirector());
    }
    
    private void mostrarVentana(JFrame ventana) {
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
    
    private void ocultarVentana(JFrame ventana) {
        ventana.setVisible(false);
    }
}
