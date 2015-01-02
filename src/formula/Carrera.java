package formula;


import java.io.Serializable;
import java.util.*;

/**
 * @author Eduardo Benito Fernández
 */


public class Carrera implements Serializable {
    private Circuito circuito;
    private ArrayList<Participante> participantes;
    private ArrayList<Clasificado> clasificacionFinal;
    
    private static final Integer[] PUNTUACION = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};
    private static final Integer[] PREMIOS = {100000,75000,50000,25000,15000,10000};
    
    
    public Carrera(Circuito circuito) {
        this.circuito = circuito;
        participantes = new ArrayList<>();
        clasificacionFinal = new ArrayList<>();
    }
    
    public ArrayList<Participante> getParticipantes(Escuderia escuderia) {
        ArrayList<Participante> participantesEscuderia = new ArrayList<>();
        for (Participante participante : participantes) {
            if (participante.getEscuderia().equals(escuderia)) {
                participantesEscuderia.add(participante);
            }
        }
        return participantesEscuderia;
    }
    
    public void añadirParticipante(Participante participante) {
        participantes.add(participante);
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

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }

    public ArrayList<Clasificado> getClasificacionFinal() {
        return clasificacionFinal;
    }

    public void setClasificacionFinal() {
        this.clasificacionFinal = obtenerClasificacion();
    }
    
}
