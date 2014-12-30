
package formula;
import java.util.*;
/**
 *
 * @author jaimedemora
 */
public class Participante {
    private Set<Escuderia> escuderias;
    private Set<PilotoOficial> piloto;
    private Set<Coche> coche;

    Participante(){
        escuderias = new HashSet<Escuderia>();
        piloto = new HashSet<PilotoOficial>();
        coche = new HashSet<Coche>();    
    }

    public Set<Escuderia> getEscuderias() {
        return escuderias;
    }

    public void setEscuderias(Set<Escuderia> escuderias) {
        this.escuderias = escuderias;
    }

    public Set<PilotoOficial> getPiloto() {
        return piloto;
    }

    public void setPiloto(Set<PilotoOficial> piloto) {
        this.piloto = piloto;
    }
    
    public Set<Coche> getCoches() {
        return coche;
    }

    public void setCoches(Set<Coche> coche) {
        this.coche = coche;
    }

    public void sumarPuntos(Integer puntos){
        puntos += Carrera.asignarPuntos(Circuito circuito); 
    }
    
    public void TiempoPorVuelta(Circuito circuito){
        return Coche.getTiempoPorVuelta(circuito); 
    }

    
}


