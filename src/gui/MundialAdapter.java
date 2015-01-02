package gui;


import formula.Mundial;
import java.io.IOException;
import java.util.ArrayList;


public class MundialAdapter extends FormulaAdapter<Mundial>{
    
    private static MundialAdapter instance = null;
    private static final String FICHERO = "ficheros" + System.getProperty("file.separator") + "Mundial.dat";
    
    private MundialAdapter() {}
    
    public static MundialAdapter getInstance() {
        if (instance == null) {
            instance = new MundialAdapter();
        }
        return instance;
    }
    
    public void guardar(ArrayList<Mundial> mundial) throws IOException {
        save(mundial, FICHERO);
    }
    
    public ArrayList<Mundial> leer() throws ClassNotFoundException, IOException {
        return read(FICHERO);
    }
    
    
}


