
package formula;
import java.util.*;


/**
 *
 * @author jaimedemora
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
        for (Escuderia e: escuderias ){
            i++;
            linea = "Posición " + i +": " + e.getNombre()+ ", Puntos: "+ Double.toString(e.getPuntos());
            System.out.println(linea);
        }
    }
    
    
    
    public ArrayList<String> obtenerClasificacionEscuderias(ArrayList<Escuderia> escuderias){
        ArrayList<String> lineas = new ArrayList<>();
        Collections.sort(escuderias);
        String linea;
        int i=0;
        for (Escuderia e: escuderias ){
            i++;
            linea = "Posición " + i +": " + e.getNombre()+ ", Puntos: "+ Double.toString(e.getPuntos());
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
    
    public ArrayList<String> obtenerClasificacionPilotos(ArrayList<PilotoOficial> pilotos){
        ArrayList<String> lineas = new ArrayList<>();
        Collections.sort(pilotos);
        String linea;
        int i=0;
        for (PilotoOficial piloto: pilotos ){
            i++;
            linea = "Posición " + i +": " + piloto.getNombre()+ ", Puntos: "+ Double.toString(piloto.getPuntos());
            System.out.println(linea);
            lineas.add(linea);
        }
        return lineas;
    }
    
    
    
    
    
    
}
