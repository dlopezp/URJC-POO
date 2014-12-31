package gui;

import formula.Circuito;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author HOME3
 */
public class CircuitoAdapter {
    
    private static CircuitoAdapter instance = null;
    private static FormulaAdapter<Circuito> adapter = null;
    private static final String FICHERO = "ficheros" + System.getProperty("file.separator") + "Circuitos.dat";
    
    private CircuitoAdapter() {}
    
    private FormulaAdapter<Circuito> getAdapter() {
       if (adapter == null) {
           adapter = new FormulaAdapter<>();
       } 
       return adapter;
    }
    
    public static CircuitoAdapter getInstance() {
        if (instance == null) {
            instance = new CircuitoAdapter();
        }
        return instance;
    }
    
    public void guardar(ArrayList<Circuito> pilotosLibres) throws IOException {
        getAdapter().save(pilotosLibres, FICHERO);
    }
    
    public ArrayList<Circuito> leer() throws ClassNotFoundException, IOException {
        return getAdapter().read(FICHERO);
    }
}

