
package formula;
import java.util.*;

/**
 *
 * @author jaimedemora
 */
public class Clasificado {
    private Set<Participante> participantes;
    protected Double tiempoPorVuelta;

    
    public Clasificado(Double tiempoPorVuelta){
        participantes = new HashSet<Participante>(); 
        this.tiempoPorVuelta = getTiempoPorVuelta();
    }

    
    public Set<Participante> getParticipante() {
        return participantes;
    }

    public void setParticipante(Set<Participante> participantes) {
        this.participantes = participantes;
    }

    public Double getTiempoPorVuelta() {
        return tiempoPorVuelta;
    }

    
}
