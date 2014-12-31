package gui;


import formula.Escuderia;
import java.io.IOException;
import java.util.ArrayList;


public class EscuderiaAdapter {
    private static EscuderiaAdapter instance = null;
    private static FormulaAdapter<Escuderia> adapter = null;
    private static final String FICHERO = "ficheros" + System.getProperty("file.separator") + "Escuderia.dat";
    
    private EscuderiaAdapter() {}
    
    private FormulaAdapter<Escuderia> getAdapter() {
       if (adapter == null) {
           adapter = new FormulaAdapter<>();
       } 
       return adapter;
    }
    
    public static EscuderiaAdapter getInstance() {
        if (instance == null) {
            instance = new EscuderiaAdapter();
        }
        return instance;
    }
    
    public void guardar(ArrayList<Escuderia> escuderias) throws IOException {
        getAdapter().save(escuderias, FICHERO);
    }
    
    public ArrayList<Escuderia> leer() throws ClassNotFoundException, IOException {
        return getAdapter().read(FICHERO);
    }
    
    
}


