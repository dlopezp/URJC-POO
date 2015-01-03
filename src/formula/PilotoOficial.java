package formula;

public class PilotoOficial extends PilotoDecorador implements Comparable<PilotoOficial> {
    
    public static final Double INCREMENTO_MEJORA = 0.1;
    public static final Integer PLUS_PELIGROSIDAD = 50;

    public PilotoOficial(PilotoLibre piloto) {
        super(piloto);
    }
    
    @Override
    public void entrenar() {
        piloto.mejorar(INCREMENTO_MEJORA);
    }

    @Override
    public Integer getSueldo() {
        return piloto.getSueldo() + PLUS_PELIGROSIDAD;
    }
    
    @Override
    public int compareTo(PilotoOficial piloto){
        return piloto.getPuntos() - getPuntos();
    }
    
}
