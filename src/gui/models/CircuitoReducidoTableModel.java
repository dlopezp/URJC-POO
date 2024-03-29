package gui.models;

import formula.Circuito;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * @author Daniel López
 * @version 1.0
 * @since 20-12-2014
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
        NumberFormat formato = NumberFormat.getCurrencyInstance(new Locale("es", "ES"));
        switch(columnIndex) {
            case 0: return circuito.getNombre();
            case 1: return formato.format(circuito.getCanon());
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
