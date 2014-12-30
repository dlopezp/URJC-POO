
package formula;
import java.util.*;


public class Carrera {
    private Circuito circuito;
    private Set<Participante> participantes;
    private ArrayList<Clasificado> clasificacionFinal;
    
    private static final Integer PUNTUACION[] = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};
    private static final Integer PREMIOS[] = {1000,75000,50000,25000,15000,10000};
    
    
    public Carrera(Circuito circuito, Set<Participante> participantes ) {
        this.circuito = circuito;
        this.participantes = participantes;
        this.clasificacionFinal = null;
    }
 
    
    public ArrayList<Clasificado> obtenerClasificacion(){
        ArrayList<Clasificado> clasificados = new ArrayList<>();
        Participante participante;
        Iterator <Participante> it = getParticipantes().iterator();
        while(it.hasNext()){
            participante = it.next();
            clasificados.add(new Clasificado(participante,participante.getTiempoPorVuelta(this.getCircuito())));
        }
        Collections.sort(clasificados);
        return clasificados; 
    }
    
    
    public void asignarPuntos(){
        ArrayList<Clasificado> clasificados = obtenerClasificacion();
        Clasificado clasificado;
        Participante participante;
        Iterator<Clasificado> it = clasificados.iterator();
        while (it.hasNext()){
            for(Integer i : PUNTUACION){
                clasificado = it.next();
                participante = clasificado.getParticipante();
                participante.sumarPuntos(i);
                participante.getEscuderia().sumarPuntos(i);
            }
        }
    }
     
    
    public void darPremios(){
        ArrayList<Clasificado> clasificados = obtenerClasificacion();
        Clasificado clasificado;
        Participante participante;
        Iterator<Clasificado> it = clasificados.iterator();
        while (it.hasNext()){
            for(Integer i : PREMIOS){
                clasificado = it.next();
                participante = clasificado.getParticipante();
                participante.getEscuderia().obtenerPremio(i);   
            }
        }
    }
    
    
    
    
    public void celebrarCarrera(){
        setClasificacionFinal();
        asignarPuntos();
        darPremios();
    }

    
    public Circuito getCircuito() {
        return circuito;
    }

    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

    public Set<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Set<Participante> participantes) {
        this.participantes = participantes;
    }

    public ArrayList<Clasificado> getClasificacionFinal() {
        return clasificacionFinal;
    }

    public void setClasificacionFinal() {
        this.clasificacionFinal = obtenerClasificacion();
    }
    
}
