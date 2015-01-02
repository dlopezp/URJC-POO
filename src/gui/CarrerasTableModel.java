package gui;

import formula.Carrera;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author HOME3
 */
public class CarrerasTableModel implements TableModel {
    
    private ArrayList<Carrera> carreras = new ArrayList<>();
    private ArrayList listeners = new ArrayList();
    
    private static String[] COLUMNAS_NOMBRES = {"Nombre"};
    private static Class[] COLUMNAS_CLASES = {String.class};
    
    public CarrerasTableModel(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }

    @Override
    public int getRowCount() {
        return carreras.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNAS_NOMBRES.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return COLUMNAS_NOMBRES[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return COLUMNAS_CLASES[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Carrera carrera = (Carrera)carreras.get(rowIndex);
        switch(columnIndex) {
            case 0: return carrera.getCircuito().getNombre();
            default: return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        listeners.add (l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    }
    
    public Carrera getElement(int index) {
        return carreras.get(index);
    }
    
}
