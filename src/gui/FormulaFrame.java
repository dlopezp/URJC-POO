package gui;

import gui.adapters.MundialAdapter;
import formula.Mundial;
import gui.models.FormulaTableModel;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * @author Daniel López
 * @version 1.0
 * @since 20-12-2014
 */
public class FormulaFrame extends JFrame {
    
    protected Mundial mundial = null;
    
    protected void cargarDatos() throws ClassNotFoundException, IOException {
        mundial = MundialAdapter.getInstance().leer();
        if (mundial == null) {
            mundial = new Mundial();
        }
    }
    
    protected void guardarDatos() throws IOException, ClassNotFoundException {
        MundialAdapter.getInstance().guardar(mundial);
    }
    
    protected void asignarEventosEnVentana() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                try {
                    guardarDatos();
                } catch (IOException ex) {
                    Logger.getLogger(FrameAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FormulaFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            @Override
            public void windowOpened(WindowEvent evt) {
                comprobarMundialComenzado();
            }
        });
    }
    
    protected void ponerValorEnEtiquetaSlider(JSlider slider, JLabel label) {
        Double valor = slider.getValue() * 0.01;
        DecimalFormat df = new DecimalFormat("#.##");
        label.setText(df.format(valor));
    }
    
    protected void limpiarTabla(JTable tabla) {
        if (tabla.getRowCount() > 0) {
            FormulaTableModel modelo = (FormulaTableModel) tabla.getModel();
            int cantidadFilas = modelo.getRowCount();
            for (int i = cantidadFilas - 1; i >= 0; i--) {
                modelo.removeRow(i);
            }
        }
    }
    
    protected void borrarFilaSeleccionadaDeTabla(JTable tabla) {
        FormulaTableModel modelo = (FormulaTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            modelo.removeRow(filaSeleccionada);
        }
    }
    
    protected void borrarFilaSeleccionadaDeTabla(JTable tabla, ArrayList coleccion) {
        FormulaTableModel modelo = (FormulaTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            coleccion.remove(filaSeleccionada);
        }
    }
    
    protected void marcarComoErroneo(JTextField field) {
        field.setBackground(Color.red);
    }
    
    protected void marcarComoValido(FocusEvent evt) {
        evt.getComponent().setBackground(Color.white);
    }
    
    protected void volverAVentanaPrincipal() {
        try {
            guardarDatos();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(FrameDirector.class.getName()).log(Level.SEVERE, null, ex);
        }
        FrameManager.getInstance().mostrarVentanaPrincipal(this);
    }
    
    protected void mostrarVentanaDeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Datos incorrectos", JOptionPane.ERROR_MESSAGE);
    }
    
    protected void comprobarMundialComenzado() {
        if (mundial.estaComenzado()) {
            mostrarAvisoMundialEmpezado();
            volverAVentanaPrincipal();
        }
    }
    
    protected void mostrarAvisoMundialEmpezado() {
        JOptionPane.showMessageDialog(null, "El Mundial ha comenzado, no se pueden realizar cambios", "Mundial comenzado", JOptionPane.INFORMATION_MESSAGE  );
    }
    
}
