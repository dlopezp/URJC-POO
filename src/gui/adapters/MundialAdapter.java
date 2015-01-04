package gui.adapters;


import formula.Mundial;
import java.io.IOException;

/**
 * @author Daniel López
 * @version 1.0
 * @since 20-12-2014
 */

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
    
    public void guardar(Mundial mundial) throws IOException {
        save(mundial, FICHERO);
    }
    
    public Mundial leer() throws ClassNotFoundException, IOException {
        Mundial mundial = readOneObject(FICHERO);
        if (mundial == null) {
            mundial = new Mundial();
        }
        return mundial;
    }
    
    
}


