package gui;

import formula.Coche;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HOME3
 */
public class CocheTableModel extends AbstractTableModel {
    
    private ArrayList<Coche> coches;
    
    /**
     *
     * @param coches
     */
    public CocheTableModel(ArrayList<Coche> coches) {
        this.coches = coches;
    }

    @Override
    public int getRowCount() {
        return coches.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object valor = null;
        Coche coche = (Coche)coches.get(rowIndex);
        switch (columnIndex) {
            case 0:
                valor = coche.getModelo();
                break;
            case 1:
                valor = coche.getVelocidadEnRecta();
                break;
            case 2:
                valor = coche.getVelocidadEnCurva();
                break;
        }
        return valor;
    }
    
    public Coche getCocheAt(int index) {
        return coches.get(index);
    }
}
