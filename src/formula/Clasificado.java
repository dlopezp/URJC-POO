package formula;

import java.io.Serializable;

public class Clasificado implements Comparable<Clasificado>, Serializable {
    
    private Participante participante;
    private Double tiempoPorVuelta;
    private Integer puntos;
    private Integer premio;

    public Clasificado(Participante participante, Double tiempoPorVuelta){
        this.participante = participante;
        this.tiempoPorVuelta = tiempoPorVuelta;
        this.puntos = 0;
        this.premio = 0;
    }
    
    @Override
    public int compareTo(Clasificado clasificado2){
       return (int) ((getTiempoPorVuelta()*100) - (clasificado2.getTiempoPorVuelta()*100));
    }
    
    public void premiar(Integer puntos, Integer premio) {
        this.puntos = puntos;
        this.premio = premio;
        participante.sumarPuntos(puntos);
        participante.sumarPremio(premio);
    }
    
    public String getTiempoPorVueltaFormateado() {
        String tiempo = "";
        Integer minutos = Double.valueOf(tiempoPorVuelta / 60).intValue();
        tiempo = tiempo.concat(minutos.toString());
        tiempo = tiempo.concat(":");
        Integer segundos = Double.valueOf(tiempoPorVuelta % 60).intValue();   
        tiempo = tiempo.concat(segundos.toString());
        Double milisegundos = (tiempoPorVuelta - tiempoPorVuelta.intValue())*1000;
        tiempo = tiempo.concat(".");
        tiempo = tiempo.concat(Integer.valueOf(milisegundos.intValue()).toString());
        return tiempo;
    }

    public Participante getParticipante() {
        return participante;
    }

    public Double getTiempoPorVuelta() {
        return tiempoPorVuelta;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Integer getPremio() {
        return premio;
    }

    public void setPremio(Integer premio) {
        this.premio = premio;
    }

}
