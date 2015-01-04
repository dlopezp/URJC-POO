package formula;

import java.io.Serializable;

/**
 * @author Jaime de Mora
 * @version 1.0
 * @since 20-12-2014
 */

public class Participante implements Serializable {
    private Escuderia escuderia;
    private PilotoOficial piloto;
    private Coche coche;

    
    public Participante(Escuderia escuderia, PilotoOficial piloto, Coche coche){
        this.escuderia = escuderia;
        this.piloto = piloto;
        this.coche = coche;
    }
     /**
     * Realiza la acción de sumar los puntos correspondientes al Piloto y a la Esucdería. 
     * @param puntos
     */    
    public void sumarPuntos(Integer puntos){
        escuderia.sumarPuntos(puntos);
        piloto.sumarPuntos(puntos);
    }
     /**
     * Suma el premio obtenido al Presupuesto de la Escudería.
     * @param tramos[] de Tramo.java
     * @return distancia total;
     */    
    public void sumarPremio(Integer premio) {
        escuderia.sumarPremio(premio);
    }
     /**
     * Calcula el TiempoPorVuelta del Participante en un Circuito concreto.
     * @param circuito de Circuito.java
     * @return tiempo;
     */        
    public Double getTiempoPorVuelta(Circuito circuito){
        Double tiempo = coche.getTiempoPorVuelta(circuito);
        tiempo -= (0.1 * piloto.getValoraciónGlobal());
        if (tiempo < 0) {
            tiempo = 0.0;
        }
        return tiempo;
    }
     /**
     * Calcula si el Participante puede correr en la Carrera.
     * En función de si su escudería tiene presupuesto suficiente.
     * @param circuito from Circuito.java
     * @return TRUE si tiene presupuesto suficiente o FALSE en caso contrario;
     */        
    public boolean puedeCorrerCarrera(Circuito circuito) {
        return escuderia.tienePresupuestoSuficiente(piloto.getSueldo() + circuito.getCanon());
    }
     /**
     * Realiza la acción de Correr una Carrera.
     * Pagando el correspondiente Sueldo al piloto y canon al circuito.
     * @param circuito from Circuito.java
     */        
    public void correrCarrera(Circuito circuito) {
        escuderia.pagarSueldoAPiloto(piloto);
        escuderia.pagarCanonCircuito(circuito);
    }
    
    public Escuderia getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(Escuderia escuderia) {
        this.escuderia = escuderia;
    }

    public PilotoOficial getPiloto() {
        return piloto;
    }

    public void setPiloto(PilotoOficial piloto) {
        this.piloto = piloto;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    

}
