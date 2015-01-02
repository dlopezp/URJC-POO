package formula;

import java.io.Serializable;
import java.util.*;

/**
 * @author Eduardo Benito Fernández
 */

public class Mundial implements Serializable {
    
    private ArrayList<Carrera> carreras;
    private Boolean comenzado;
    
    private static final Integer MAXIMO_CARRERAS = 5;
    
    public Mundial() {
        carreras = new ArrayList<>();
        comenzado = false;
    }
    
    public Boolean puedeAgregarCarreras() {
        return carreras.size() < MAXIMO_CARRERAS;
    }
    
    public Boolean puedeComenzar() {
        return carreras.size() == MAXIMO_CARRERAS;
    }
    
    public void addCarrera (Carrera carrera) {
        if (puedeAgregarCarreras()) {
            carreras.add(carrera);
        }
    }
    
    public Carrera getCarrera (int indice) {
        return carreras.get(indice);
    }
    
    public ArrayList<String> getClasificacionEscuderias(ArrayList<Escuderia> escuderias){
        ArrayList<String> lineas = new ArrayList<>();
        Collections.sort(escuderias);
        String linea;
        int i=0;
        for (Escuderia escuderia: escuderias ){
            i++;
            linea = "Posición " + i +": " + escuderia.getNombre()+ ", Puntos: "+ Double.toString(escuderia.getPuntos());
            lineas.add(linea);
        }
        return lineas;
    }
    
    public ArrayList<String> getClasificacionPilotos(ArrayList<PilotoOficial> pilotos){
        ArrayList<String> lineas = new ArrayList<>();
        Collections.sort(pilotos);
        String linea;
        int i=0;
        for (PilotoOficial piloto: pilotos ){
            i++;
            linea = "Posición " + i +": " + piloto.getNombre()+ ", Puntos: "+ Double.toString(piloto.getPuntos());
            lineas.add(linea);
        }
        return lineas;
    }
    
    public Boolean estaComenzado() {
        return comenzado;
    }
    
    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }

}
