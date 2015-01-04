package gui.models;

import formula.Participante;
import java.util.ArrayList;

/**
 * @author Daniel López
 * @version 1.0
 * @since 20-12-2014
 */

public class ParticipantesTableModel extends FormulaTableModel {
    
    protected String[] COLUMNAS_NOMBRES = {"Piloto", "Coche"};
    protected Class[] COLUMNAS_CLASES = {String.class, String.class};
    
    public ParticipantesTableModel(ArrayList<Participante> participantes) {
        items = participantes;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Participante participante = (Participante) getElement(rowIndex);
        switch(columnIndex) {
            case 0: return participante.getPiloto();
            case 1: return participante.getCoche();
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
