package gui.models;

import formula.Coche;
import java.util.ArrayList;

/**
 * @author Daniel López
 * @version 1.0
 * @since 20-12-2014
 */

public class CocheTableModel extends FormulaTableModel {
    
    protected String[] COLUMNAS_NOMBRES = {"Modelo", "Potencia", "Aerodinámica", "Neumáticos", "Velocidad en Recta", "Velocidad en Curva"};
    protected Class[] COLUMNAS_CLASES = {String.class, Double.class, Double.class, Double.class, String.class, String.class};
    
    public CocheTableModel(ArrayList<Coche> coches) {
        items = coches;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Coche coche = (Coche) getElement(rowIndex);
        switch(columnIndex) {
            case 0: return coche.getModelo();
            case 1: return coche.getPotencia();
            case 2: return coche.getAerodinamica();
            case 3: return coche.getNeumaticos();
            case 4: return String.format("%.2f", coche.getVelocidadEnRecta()) + " km/h";
            case 5: return String.format("%.2f", coche.getVelocidadEnCurva()) + " km/h";
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
