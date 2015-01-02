package gui;

import formula.Carrera;
import java.util.ArrayList;

/**
 *
 * @author HOME3
 */
public class CarrerasTableModel extends FormulaTableModel {
    
    protected String[] COLUMNAS_NOMBRES = {"Nombre"};
    protected Class[] COLUMNAS_CLASES = {String.class};
    
    public CarrerasTableModel(ArrayList<Carrera> carreras) {
        items = carreras;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Carrera carrera = (Carrera) getElement(rowIndex);
        switch(columnIndex) {
            case 0: return carrera.getCircuito().getNombre();
            default: return null;
        }
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

}
