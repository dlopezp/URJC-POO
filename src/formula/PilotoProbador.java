package formula;

/**
 * @author Daniel López
 * @version 1.0
 * @since 20-12-2014
 */

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
