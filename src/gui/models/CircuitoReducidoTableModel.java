package gui.models;

import formula.Circuito;
import java.util.ArrayList;

/**
 *
 * @author riki
 */
public class CircuitoReducidoTableModel extends FormulaTableModel {
    
    protected String[] COLUMNAS_NOMBRES = {"Nombre", "Canon"};
    protected Class[] COLUMNAS_CLASES = {String.class, String.class};
    
    public CircuitoReducidoTableModel(ArrayList<Circuito> circuitos) {
        items = circuitos;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Circuito circuito = (Circuito) getElement(rowIndex);
        switch(columnIndex) {
            case 0: return circuito.getNombre();
            case 1: return circuito.getCanon() + " €";
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
