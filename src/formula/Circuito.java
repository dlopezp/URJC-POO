package formula;

public class Circuito {
    
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAforo() {
        return aforo;
    }

    public void setAforo(Integer aforo) {
        this.aforo = aforo;
    }

    public Integer getCanon() {
        return canon;
    }

    public void setCanon(Integer canon) {
        this.canon = canon;
    }

    public Tramo[] getRectas() {
        return rectas;
    }

    public void setRectas(Tramo[] rectas) {
        this.rectas = rectas;
    }

    public Tramo[] getCurvas() {
        return curvas;
    }

    public void setCurvas(Tramo[] curvas) {
        this.curvas = curvas;
    }
      
}
