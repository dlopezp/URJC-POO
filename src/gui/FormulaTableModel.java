package gui;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author HOME3
 * @param <T>
 */
public abstract class FormulaTableModel<T> implements TableModel {
    
    protected ArrayList listeners = new ArrayList();
    protected ArrayList<T> items = new ArrayList<>();
    
    @Override
    public int getRowCount() {
        return items.size();
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeTableModelListener(TableModelListener listener) {
        listeners.remove(listener);
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }
    
    public ArrayList<T> getElements() {
        return items;
    }
    
    public T getElement(int index) {
        return items.get(index);
    }
    
    public void removeRow(int index) {
        items.remove(index);
    }
    
}
