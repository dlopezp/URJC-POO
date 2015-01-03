package formula;

import java.io.Serializable;

/**
 * @author Jaime de Mora
 * @version 1.0
 * @since 20-12-2014
 */

public class Circuito implements Serializable {
    
    private String nombre;
    private Integer aforo;
    private Integer canon;
    private Tramo[] rectas;
    private Tramo[] curvas;
    
    public static final Integer PREMIOS[] = {100000, 75000, 50000, 25000, 15000, 10000};

    public Circuito(String nombre, Integer aforo, Integer canon, Tramo[] rectas, Tramo[] curvas) {
        this.nombre = nombre;
        this.aforo = aforo;
        this.canon = canon;
        this.rectas = rectas;
        this.curvas = curvas;
    }
 
     /**
     * Calcula la Distancia Total generada por un conjunto de Tramos
     * @param tramos[] de Tramo.java
     * @return distancia total;
     */
    
    private Double getDistancia(Tramo[] tramos) {
        Double distancia = 0.0;
        for (Tramo tramo : tramos) {
            distancia += tramo.getDistancia();
        }
        return distancia;
    }
    
    public Double getDistanciaRecta() {
        return getDistancia(rectas);
    }
    
    public Double getDistanciaCurva() {
        return getDistancia(curvas);
    }
    
    public Object getDistanciaTotal() {
        return getDistanciaCurva() + getDistanciaRecta();
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getAforo() {
        return aforo;
    }

    public Integer getCanon() {
        return canon;
    }

    public Tramo[] getRectas() {
        return rectas;
    }

    public Tramo[] getCurvas() {
        return curvas;
    }
      
}
