package formula;

import java.io.Serializable;

public class Clasificado implements Comparable<Clasificado>, Serializable {
    
    private Participante participante;
    private Double tiempoPorVuelta;

    public Clasificado(Participante participante, Double tiempoPorVuelta){
        this.participante = participante;
        this.tiempoPorVuelta = tiempoPorVuelta;
    }
    
    @Override
    public int compareTo(Clasificado clasificado2){
       return (int) ((clasificado2.getTiempoPorVuelta()*100) - (getTiempoPorVuelta()*100));
    }
    
    public void sumarPuntos(Integer puntos) {
        participante.sumarPuntos(puntos);
    }
    
    public void sumarPremio(Integer premio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Participante getParticipante() {
        return participante;
    }

    public Double getTiempoPorVuelta() {
        return tiempoPorVuelta;
    }

}
