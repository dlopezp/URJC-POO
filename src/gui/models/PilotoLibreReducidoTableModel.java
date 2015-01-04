package gui.models;

import formula.PilotoLibre;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * @author Daniel López
 * @version 1.0
 * @since 20-12-2014
 */

public class PilotoLibreReducidoTableModel extends FormulaTableModel {
    
    protected String[] COLUMNAS_NOMBRES = {"Nombre", "Valoración Global", "Sueldo"};
    protected Class[] COLUMNAS_CLASES = {String.class, Double.class, String.class};
    
    public PilotoLibreReducidoTableModel(ArrayList<PilotoLibre> pilotos) {
        items = pilotos;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PilotoLibre piloto = (PilotoLibre) getElement(rowIndex);
        NumberFormat formato = NumberFormat.getCurrencyInstance(new Locale("es", "ES"));
        switch(columnIndex) {
            case 0: return piloto.getNombreCompleto();
            case 1: return piloto.getValoraciónGlobal();
            case 2: return formato.format(piloto.getSueldo());
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
