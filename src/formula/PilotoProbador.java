package formula;

public class PilotoProbador extends PilotoDecorador {
    
    public static final Double INCREMENTO_MEJORA = 0.05;

    public PilotoProbador(PilotoLibre piloto) {
        super(piloto);
    }
    
    @Override
    public void entrenar() {
        piloto.mejorar(INCREMENTO_MEJORA);
    }
}
