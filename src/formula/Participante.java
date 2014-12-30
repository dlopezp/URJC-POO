
package formula;


public class Participante{
    private Escuderia escuderia;
    private PilotoOficial piloto;
    private Coche coche;

    
    public Participante(Escuderia escuderia, PilotoOficial piloto, Coche coche){
        this.escuderia = escuderia;
        this.piloto = piloto;
        this.coche = coche;
    }
    
    
    public Integer sumarPuntos(Integer puntos){
        return puntos;
    }
    
    public Double getTiempoPorVuelta(Circuito circuito){
        Double tiempo = this.coche.getTiempoPorVuelta(circuito);
        tiempo -= (0.1 * piloto.getValoraciónGlobal());
        return tiempo;
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
