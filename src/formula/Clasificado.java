package formula;

/**
 * @author Jaime de Mora
 * @version 1.0
 * @since 20-12-2014
 */

    

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
    
     /**
     * Calcula la diferencia de tiempos entre dos clasificados
     * Devuelve un número mayor que 0 si clasificado2 es mayor  que el objeto1,
     * 0 si son iguales o -1 si objeto1 es mayor que clasificado.
     * @param clasificado2 de Clasificado.java
     * @return tiempo de diferencia;
     */    
    @Override
    public int compareTo(Clasificado clasificado2){
       return (int) ((getTiempoPorVuelta()*100) - (clasificado2.getTiempoPorVuelta()*100));
    }
    
     /**
     * Según los puntos obtenidos por un participante, otorga un premio concreto
     * @param punto, premio;
     */    
    public void premiar(Integer puntos, Integer premio) {
        this.puntos = puntos;
        this.premio = premio;
        participante.sumarPuntos(puntos);
        participante.sumarPremio(premio);
    }

     /**
     * Formatea el tiempo total a formato F1 para poder mostrar en las tablas.
     * @return tiempo (formateado);
     */    
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
