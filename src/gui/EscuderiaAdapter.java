package gui;


import formula.Escuderia;
import java.io.IOException;
import java.util.ArrayList;


public class EscuderiaAdapter extends FormulaAdapter<Escuderia>{
    
    private static EscuderiaAdapter instance = null;
    private static final String FICHERO = "ficheros" + System.getProperty("file.separator") + "Escuderia.dat";
    
    private EscuderiaAdapter() {}
    
    public static EscuderiaAdapter getInstance() {
        if (instance == null) {
            instance = new EscuderiaAdapter();
        }
        return instance;
    }
    
    public void guardar(ArrayList<Escuderia> escuderias) throws IOException {
        save(escuderias, FICHERO);
    }
    
    public ArrayList<Escuderia> leer() throws ClassNotFoundException, IOException {
        return read(FICHERO);
    }
    
    
}


