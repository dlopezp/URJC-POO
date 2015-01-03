package formula;


import java.io.Serializable;
import java.util.*;

/**
 * @author Eduardo Benito Fernández
 */


public class Carrera implements Serializable {
    private Circuito circuito;
    private ArrayList<Participante> participantes;
    private ArrayList<Clasificado> clasificados;
    private Boolean finalizada;
    
    private static final Integer[] PUNTUACION = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};
    private static final Integer[] PREMIOS = {100000,75000,50000,25000,15000,10000};
    
    
    public Carrera(Circuito circuito) {
        this.circuito = circuito;
        participantes = new ArrayList<>();
        clasificados = new ArrayList<>();
        finalizada = false;
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
    
    public Boolean estaFinalizada() {
        return finalizada;
    }
    
    public void celebrar() {
        for (Participante participante : participantes) {
            participante.correrCarrera(circuito);
            clasificados.add(new Clasificado(participante, participante.getTiempoPorVuelta(circuito)));
        }
        asignarPuntos();
        finalizada = true;
    }

    private void asignarPuntos() {
        Collections.sort(clasificados);
        for (int i = 0; i < clasificados.size(); i++) {
            clasificados.get(i).sumarPuntos(PUNTUACION[i]);
            clasificados.get(i).sumarPremio(PREMIOS[i]);
        }
    }
    
    public Circuito getCircuito() {
        return circuito;
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public ArrayList<Clasificado> getClasificacionFinal() {
        return clasificados;
    }
    
}
