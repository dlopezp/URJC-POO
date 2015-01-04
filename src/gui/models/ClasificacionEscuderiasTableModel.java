package gui.models;

import formula.Escuderia;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Daniel López
 * @version 1.0
 * @since 20-12-2014
 */

public class ClasificacionEscuderiasTableModel extends FormulaTableModel {
    
    protected String[] COLUMNAS_NOMBRES = {"Nombre", "Puntos", "Presupuesto"};
    protected Class[] COLUMNAS_CLASES = {String.class, Integer.class, Integer.class};

    public ClasificacionEscuderiasTableModel(ArrayList<Escuderia> escuderias) {
        Collections.sort(escuderias);
        items = escuderias;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Escuderia escuderia = (Escuderia) getElement(rowIndex);
        switch(columnIndex) {
            case 0: return escuderia.getNombre();
            case 1: return escuderia.getPuntos();
            case 2: return escuderia.getPresupuesto();
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
