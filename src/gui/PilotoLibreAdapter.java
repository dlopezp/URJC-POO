package gui;

import formula.PilotoLibre;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author HOME3
 */
public class PilotoLibreAdapter extends FormulaAdapter<PilotoLibre>{
    
    private static PilotoLibreAdapter instance = null;
    private static final String FICHERO = "ficheros" + System.getProperty("file.separator") + "PilotosLibres.dat";
    
    private PilotoLibreAdapter() {}
    
    public static PilotoLibreAdapter getInstance() {
        if (instance == null) {
            instance = new PilotoLibreAdapter();
        }
        return instance;
    }
    
    public void guardar(ArrayList<PilotoLibre> pilotosLibres) throws IOException {
        save(pilotosLibres, FICHERO);
    }
    
    public ArrayList<PilotoLibre> leer() throws ClassNotFoundException, IOException {
        return read(FICHERO);
    }
}
