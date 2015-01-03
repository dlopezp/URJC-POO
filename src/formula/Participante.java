package formula;

import java.io.Serializable;



public class Participante implements Serializable {
    private Escuderia escuderia;
    private PilotoOficial piloto;
    private Coche coche;

    
    public Participante(Escuderia escuderia, PilotoOficial piloto, Coche coche){
        this.escuderia = escuderia;
        this.piloto = piloto;
        this.coche = coche;
    }
    
    public void sumarPuntos(Integer puntos){
        escuderia.sumarPuntos(puntos);
        piloto.sumarPuntos(puntos);
    }
    
    public void sumarPremio(Integer premio) {
        escuderia.sumarPremio(premio);
    }
    
    public Double getTiempoPorVuelta(Circuito circuito){
        Double tiempo = coche.getTiempoPorVuelta(circuito);
        tiempo -= (0.1 * piloto.getValoraciónGlobal());
        if (tiempo < 0) {
            tiempo = 0.0;
        }
        return tiempo;
    }
    
    public boolean puedeCorrerCarrera(Circuito circuito) {
        return escuderia.tienePresupuestoSuficiente(piloto.getSueldo() + circuito.getCanon());
    }
    
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
