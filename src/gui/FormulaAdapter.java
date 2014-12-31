package gui;

import formula.PilotoLibre;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author HOME3
 */
public class FormulaAdapter<T> {
    
    public void save(ArrayList<T> elements, String file) throws IOException {
        File fichero = new File(file);
        if(!fichero.exists()) {
            fichero.createNewFile();
        } 
        try {
            FileOutputStream out = new FileOutputStream(fichero);
            ObjectOutputStream so = new ObjectOutputStream(out);
            Iterator<T> elementsIterator = elements.iterator();
            while (elementsIterator.hasNext()) {
                T element = elementsIterator.next();
                so.writeObject(element);
            }
            so.close();
            out.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
    public ArrayList<T> read(String file) throws ClassNotFoundException {
        File fichero = new File(file);
        ArrayList<T> elements = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis);
            T element = null;
            while ((element = (T) ois.readObject()) != null) {
                elements.add(element);
            }
            ois.close();
            fis.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return elements;
    }
}
