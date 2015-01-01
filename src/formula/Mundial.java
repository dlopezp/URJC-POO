package formula;

import java.util.*;

/**
 * @author Eduardo Benito Fernández
 */

public class Mundial {
    
    private Carrera[] Carreras;
    
    public Mundial(Carrera[] carreras){
        this.Carreras = carreras;
    }
    
    public void mostrarClasificacionEscuderias(ArrayList<Escuderia> escuderias){
        Collections.sort(escuderias);
        String linea;
        int i=0;
        for (Escuderia escuderia: escuderias ){
            i++;
            linea = "Posición " + i +": " + escuderia.getNombre()+ ", Puntos: "+ Double.toString(escuderia.getPuntos());
            System.out.println(linea);
        }
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
    
    public void mostrarClasificacionPilotos(ArrayList<PilotoOficial> pilotos){
        Collections.sort(pilotos);
        String linea;
        int i=0;
        for (PilotoOficial piloto: pilotos ){
            i++;
            linea = "Posición " + i +": " + piloto.getNombre()+ ", Puntos: "+ Double.toString(piloto.getPuntos());
            System.out.println(linea);
        }
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

}
