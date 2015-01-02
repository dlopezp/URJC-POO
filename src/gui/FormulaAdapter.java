package gui;

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
public abstract class FormulaAdapter<T> {
    
    protected void save(ArrayList<T> elements, String file) throws IOException {
        File fichero = new File(file);
        if(!fichero.exists()) {
            fichero.createNewFile();
        }
        FileOutputStream out = null;
        ObjectOutputStream so = null;
        try {
            out = new FileOutputStream(fichero);
            so = new ObjectOutputStream(out);
            Iterator<T> elementsIterator = elements.iterator();
            while (elementsIterator.hasNext()) {
                T element = elementsIterator.next();
                so.writeObject(element);
            }
        } catch (IOException ex) {

        } finally {
            so.close();
            out.close();
        }
    }
    
    protected void save(T element, String file) throws IOException {
        File fichero = new File(file);
        if(!fichero.exists()) {
            fichero.createNewFile();
        }
        FileOutputStream out = null;
        ObjectOutputStream so = null;
        try {
            out = new FileOutputStream(fichero);
            so = new ObjectOutputStream(out);
            so.writeObject(element);
        } catch (IOException ex) {

        } finally {
            so.close();
            out.close();
        }
    }
    
    protected ArrayList<T> read(String file) throws ClassNotFoundException, IOException {
        File fichero = new File(file);
        ArrayList<T> elements = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(fichero);
            ois = new ObjectInputStream(fis);
            T element = null;
            while (true) {
                element = (T) ois.readObject();
                elements.add(element);
            }
        } catch (IOException ex) {

        } finally {
            if (fis != null) {
                ois.close();
                fis.close();
            }
        }
        return elements;
    }
    
    /**
     *
     * @param file
     * @return
     */
    protected T readOneObject(String file) throws ClassNotFoundException, IOException {
        File fichero = new File(file);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        T element = null;
        try {
            fis = new FileInputStream(fichero);
            ois = new ObjectInputStream(fis);
            element = (T) ois.readObject();
        } catch (IOException ex) {

        } finally {
            if (fis != null) {
                ois.close();
                fis.close();
            }
        }
        return element;
    }
    
}
