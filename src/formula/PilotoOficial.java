package formula;

public class PilotoOficial extends PilotoDecorador {
    
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
    public Double getSueldo() {
        return piloto.getSueldo() + PLUS_PELIGROSIDAD;
    }
}
