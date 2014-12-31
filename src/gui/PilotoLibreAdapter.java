package gui;

import formula.PilotoLibre;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author HOME3
 */
public class PilotoLibreAdapter {
    
    private static PilotoLibreAdapter instance = null;
    private static FormulaAdapter<PilotoLibre> adapter = null;
    private static final String FICHERO = "ficheros" + System.getProperty("file.separator") + "PilotosLibres.dat";
    
    private PilotoLibreAdapter() {}
    
    private FormulaAdapter<PilotoLibre> getAdapter() {
       if (adapter == null) {
           adapter = new FormulaAdapter<>();
       } 
       return adapter;
    }
    
    public static PilotoLibreAdapter getInstance() {
        if (instance == null) {
            instance = new PilotoLibreAdapter();
        }
        return instance;
    }
    
    public void guardar(ArrayList<PilotoLibre> pilotosLibres) throws IOException {
        getAdapter().save(pilotosLibres, FICHERO);
    }
    
    public ArrayList<PilotoLibre> leer() throws ClassNotFoundException {
        return getAdapter().read(FICHERO);
    }
}
