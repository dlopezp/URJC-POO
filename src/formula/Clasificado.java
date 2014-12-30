
package formula;
import java.util.*;


public class Clasificado implements Comparable<Clasificado> {
    private Participante participante;
    private Double tiempoPorVuelta;

    @Override
   public int compareTo(Clasificado clasificado2){
       return (int) ((clasificado2.getTiempoPorVuelta()*100) - (getTiempoPorVuelta()*100));
   } 
   
    public Clasificado(Participante participante, Double tiempoPorVuelta){
        this.participante = participante;
        this.tiempoPorVuelta = tiempoPorVuelta;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Double getTiempoPorVuelta() {
        return tiempoPorVuelta;
    }

    public void setTiempoPorVuelta(Double tiempoPorVuelta) {
        this.tiempoPorVuelta = tiempoPorVuelta;
    }
    
    

    


    
}
