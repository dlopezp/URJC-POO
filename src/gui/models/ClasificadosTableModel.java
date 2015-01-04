package gui.models;

import formula.Carrera;
import formula.Clasificado;
import java.util.ArrayList;

/**
 * @author Daniel López
 * @version 1.0
 * @since 20-12-2014
 */

public class ClasificadosTableModel extends FormulaTableModel {
    
    protected String[] COLUMNAS_NOMBRES = {"Nombre", "Escuderia", "Tiempo", "Puntos"};
    protected Class[] COLUMNAS_CLASES = {String.class, String.class, String.class, Integer.class};
    
    public ClasificadosTableModel(ArrayList<Clasificado> clasificados) {
        items = clasificados;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Clasificado clasificado = (Clasificado) getElement(rowIndex);
        switch(columnIndex) {
            case 0: return clasificado.getParticipante().getPiloto().getNombreCompleto();
            case 1: return clasificado.getParticipante().getEscuderia().getNombre();
            case 2: return clasificado.getTiempoPorVueltaFormateado();
            case 3: return clasificado.getPuntos();
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
