package gui;

import formula.Escuderia;
import formula.PilotoOficial;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.TableModel;

/**
 *
 * @author riki
 */
class ClasificacionPilotosTableModel extends FormulaTableModel {
    
    protected String[] COLUMNAS_NOMBRES = {"Nombre", "Puntos"};
    protected Class[] COLUMNAS_CLASES = {String.class, Integer.class};

    public ClasificacionPilotosTableModel(ArrayList<Escuderia> escuderias) {
        ArrayList<PilotoOficial> pilotos = new ArrayList<>();
        for (Escuderia escuderia : escuderias) {
            pilotos.addAll(escuderia.getPilotosOficiales());
        }
        Collections.sort(pilotos);
        items = pilotos;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PilotoOficial piloto = (PilotoOficial) getElement(rowIndex);
        switch(columnIndex) {
            case 0: return piloto.getNombreCompleto();
            case 1: return piloto.getPuntos();
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
