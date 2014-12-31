package gui;

import formula.Circuito;
import formula.PilotoLibre;
import formula.Escuderia;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class DataAdapter {
    
    private static DataAdapter instance = null;
    
    private static final String FICHERO_PILOTOS = "ficheros" + System.getProperty("file.separator") + "PilotosLibres.dat";
    private static final String FICHERO_CIRCUITOS = "ficheros" + System.getProperty("file.separator") + "Circuitos.dat";
    private static final String FICHERO_ESCUDERIAS = "ficheros" + System.getProperty("file.separator") + "Escuderias.dat";
    
    private DataAdapter() {}
    
    public static DataAdapter getInstance() {
        if (instance == null) {
            instance = new DataAdapter();
        }
        return instance;
    }
    
    public ArrayList<PilotoLibre> getPilotosLibres () throws ClassNotFoundException {
        File fichero = new File(FICHERO_PILOTOS);
        ArrayList<PilotoLibre> pilotos = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis);
            PilotoLibre piloto = null;
            while ((piloto = (PilotoLibre) ois.readObject()) != null) {
                pilotos.add(piloto);
            }
            ois.close();
            fis.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return pilotos;
    }
    
    public void guardarPilotosLibres(ArrayList<PilotoLibre> pilotosLibres) throws IOException {
        File fichero = new File(FICHERO_PILOTOS);
        if(!fichero.exists()) {
            fichero.createNewFile();
        } 
        try {
            FileOutputStream out = new FileOutputStream(fichero);
            ObjectOutputStream so = new ObjectOutputStream(out);
            Iterator<PilotoLibre> pilotos = pilotosLibres.iterator();
            while (pilotos.hasNext()) {
                PilotoLibre piloto = pilotos.next();
                so.writeObject(piloto);
            }
            so.close();
            out.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
    public ArrayList<Circuito> getCircuitos () throws ClassNotFoundException {
        File fichero = new File(FICHERO_CIRCUITOS);
        ArrayList<Circuito> circuitos = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Circuito circuito = null;
            while ((circuito = (Circuito) ois.readObject()) != null) {
                circuitos.add(circuito);
            }
            ois.close();
            fis.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return circuitos;
    }
    
    public void guardarCircuitos(ArrayList<Circuito> circuitos) throws IOException {
        File fichero = new File(FICHERO_PILOTOS);
        if(!fichero.exists()) {
            fichero.createNewFile();
        } 
        try {
            FileOutputStream out = new FileOutputStream(fichero);
            ObjectOutputStream so = new ObjectOutputStream(out);
            Iterator<Circuito> circuitosIterator = circuitos.iterator();
            while (circuitosIterator.hasNext()) {
                Circuito circuito = circuitosIterator.next();
                so.writeObject(circuito);
            }
            so.close();
            out.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
        public ArrayList<Escuderia> getEscuderias () throws ClassNotFoundException {
        File fichero = new File(FICHERO_ESCUDERIAS);
        ArrayList<Escuderia> escuderias = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Escuderia escuderia = null;
            while ((escuderia = (Escuderia) ois.readObject()) != null) {
                escuderias.add(escuderia);
            }
            ois.close();
            fis.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return escuderias;
    }
        
    public void guardarEscuderias(ArrayList<Escuderia> escuderias) throws IOException {
        File fichero = new File(FICHERO_ESCUDERIAS);
        if(!fichero.exists()) {
            fichero.createNewFile();
        } 
        try {
            FileOutputStream out = new FileOutputStream(fichero);
            ObjectOutputStream so = new ObjectOutputStream(out);
            Iterator<Escuderia> itEscuderias = escuderias.iterator();
            while (itEscuderias.hasNext()) {
                Escuderia escuderia = itEscuderias.next();
                so.writeObject(escuderia);
            }
            so.close();
            out.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
    
    
}
