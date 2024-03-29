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

public class PilotoLibreTableModel extends FormulaTableModel {
    
    protected String[] COLUMNAS_NOMBRES = {"Nombre", "Agresividad", "Paciencia", "Reflejos", "Valentía", "Valoración Global", "Sueldo"};
    protected Class[] COLUMNAS_CLASES = {String.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class};
    
    public PilotoLibreTableModel(ArrayList<PilotoLibre> pilotos) {
        items = pilotos;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PilotoLibre piloto = (PilotoLibre) getElement(rowIndex);
        NumberFormat formato = NumberFormat.getCurrencyInstance(new Locale("es", "ES"));
        switch(columnIndex) {
            case 0: return piloto.getNombreCompleto();
            case 1: return piloto.getAgresividad();
            case 2: return piloto.getPaciencia();
            case 3: return piloto.getReflejos();
            case 4: return piloto.getValentia();
            case 5: return piloto.getValoraciónGlobal();
            case 6: return formato.format(piloto.getSueldo());
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
