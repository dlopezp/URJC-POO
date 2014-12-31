package gui;

import formula.Circuito;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author HOME3
 */
public class CircuitoAdapter extends FormulaAdapter<Circuito>{
    
    private static CircuitoAdapter instance = null;
    private static final String FICHERO = "ficheros" + System.getProperty("file.separator") + "Circuitos.dat";
    
    private CircuitoAdapter() {}
    
    public static CircuitoAdapter getInstance() {
        if (instance == null) {
            instance = new CircuitoAdapter();
        }
        return instance;
    }
    
    public void guardar(ArrayList<Circuito> pilotosLibres) throws IOException {
        save(pilotosLibres, FICHERO);
    }
    
    public ArrayList<Circuito> leer() throws ClassNotFoundException, IOException {
        return read(FICHERO);
    }
}

