package gui;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HOME3
 */
public class FormulaFrame extends JFrame {
    
    public void ponerValorEnEtiquetaSlider(JSlider slider, JLabel label) {
        Double valor = slider.getValue() * 0.01;
        DecimalFormat df = new DecimalFormat("#.##");
        label.setText(df.format(valor));
    }
    
    public void limpiarTabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int cantidadFilas = modelo.getRowCount();
        for (int i = cantidadFilas - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
    
    public void borrarFilaSeleccionadaDeTabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            modelo.removeRow(filaSeleccionada);
        }
    }
    
    public void borrarFilaSeleccionadaDeTabla(JTable tabla, ArrayList coleccion) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            modelo.removeRow(filaSeleccionada);
            coleccion.remove(filaSeleccionada);
        }
    }
    
    public void marcarComoErroneo(JTextField field) {
        field.setBackground(Color.red);
    }
    
    public void marcarComoValido(FocusEvent evt) {
        evt.getComponent().setBackground(Color.white);
    }
    
}
