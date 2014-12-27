package formula;

class Circuito {
    
    private String nombre;
    private Integer aforo;
    private Integer canon;
    private Double[] rectas;
    private Double[] curvas;
    
    public static final Integer PREMIOS[] = {100000, 75000, 50000, 25000, 15000, 10000};

    Circuito(String nombre, Integer aforo, Integer canon, Double[] rectas, Double[] curvas) {
        this.nombre = nombre;
        this.aforo = aforo;
        this.canon = canon;
        this.rectas = rectas;
        this.curvas = curvas;
    }
    
    private Double getDistancia(Double[] tramos) {
        Double distancia = 0.0;
        for (Double tramo : tramos) {
            distancia += tramo;
        }
        return distancia;
    }
    
    public Double getDistanciaRecta() {
        return getDistancia(rectas);
    }
    
    public Double getDistanciaCurva() {
        return getDistancia(curvas);
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

    public Double[] getRectas() {
        return rectas;
    }

    public void setRectas(Double[] rectas) {
        this.rectas = rectas;
    }

    public Double[] getCurvas() {
        return curvas;
    }

    public void setCurvas(Double[] curvas) {
        this.curvas = curvas;
    }
          
}
