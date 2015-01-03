package formula;


import java.io.Serializable;
import java.util.*;

/**
 * @author Eduardo Benito Fernández
 * @version 1.0
 * @since 20-12-2014
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
    
    /**
     * Devuelve Listado de Participantes de una Escudería Concreta para la Carrera
     * @param escuderia de Escuderia.java
     * @return Array de participantes de Participantes.java;
     */
    
    public ArrayList<Participante> getParticipantes(Escuderia escuderia) {
        ArrayList<Participante> participantesEscuderia = new ArrayList<>();
        for (Participante participante : participantes) {
            if (participante.getEscuderia().equals(escuderia)) {
                participantesEscuderia.add(participante);
            }
        }
        return participantesEscuderia;
    }
    
    /**
     * Añade Participante a la Carrera
     * @param participante de Participante.java
     */
    
    public void añadirParticipante(Participante participante) {
        participantes.add(participante);
    }

     /**
     * Especifica si una Carrera ha finalizado o no
     * @return TRUE si está finalizada, FALSE en caso contrario;
     */
    public Boolean estaFinalizada() {
        return finalizada;
    }
    
    /**
     * Celebra la carrera, asignando tiempos, puntos y premios a cada participante.
     * 
     * Cada participante de la carrera en cuestión comienza ésta, calculándose a
     * la vez el tiempo que tarda por vuelta, en el circuito y su clasificación.
     * Finalmente los clasificados se ordenan por orden de llegada y se les asignan
     * sus correspondientes puntos y, en consecuencia, sus puntos. 
     * Una vez realizado esto, se da por terminada la carrera.
     */
    
    public void celebrar() {
        for (Participante participante : participantes) {
            if (participante.puedeCorrerCarrera(circuito)) {
                participante.correrCarrera(circuito);
                clasificados.add(new Clasificado(participante, participante.getTiempoPorVuelta(circuito)));
            }
        }
        Collections.sort(clasificados);
        for (int i = 0; i < clasificados.size(); i++) {
            Integer puntos = (i < PUNTUACION.length) ? PUNTUACION[i] : 0;
            Integer premio = (i < PREMIOS.length) ? PREMIOS[i] : 0;
            clasificados.get(i).premiar(puntos, premio);
        }
        finalizada = true;
    }

     /**
     * Devuelve un circuito concreto
     * @return circuito from Circuito.java;
     */    
    public Circuito getCircuito() {
        return circuito;
    }

     /**
     * Devuelve un Array con los participantes de la carrera.
     * @return Array de participantes from Participante.Java;
     */    
    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }
    
     /**
     * Calcula los pilotos clasificados en la carrera
     * @return Array de clasificados from Clasificado.java;
     */
    public ArrayList<Clasificado> getClasificacionFinal() {
        return clasificados;
    }
    
}
