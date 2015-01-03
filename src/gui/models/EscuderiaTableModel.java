package gui.models;

import formula.Escuderia;
import java.util.ArrayList;

/**
 *
 * @author riki
 */
public class EscuderiaTableModel extends FormulaTableModel {

    protected String[] COLUMNAS_NOMBRES = {"Nombre", "País", "Año", "Presupuesto"};
    protected Class[] COLUMNAS_CLASES = {String.class, String.class, String.class, String.class};
    
    public EscuderiaTableModel(ArrayList<Escuderia> escuderias) {
        items = escuderias;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Escuderia escuderia = (Escuderia) getElement(rowIndex);
        switch(columnIndex) {
            case 0: return escuderia.getNombre();
            case 1: return escuderia.getPais();
            case 2: return escuderia.getAño();
            case 3: return escuderia.getPresupuesto() + " €";
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
