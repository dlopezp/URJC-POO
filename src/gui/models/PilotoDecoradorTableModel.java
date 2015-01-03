package gui.models;

import formula.PilotoDecorador;
import java.util.ArrayList;

/**
 *
 * @author riki
 */
public class PilotoDecoradorTableModel<T> extends FormulaTableModel {
    
    protected String[] COLUMNAS_NOMBRES = {"Nombre", "Valoración"};
    protected Class[] COLUMNAS_CLASES = {String.class, Double.class};
    
    public PilotoDecoradorTableModel(ArrayList<T> pilotos) {
        items = pilotos;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PilotoDecorador piloto = (PilotoDecorador) getElement(rowIndex);
        switch(columnIndex) {
            case 0: return piloto.getNombreCompleto();
            case 1: return piloto.getValoraciónGlobal();
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
