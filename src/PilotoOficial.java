

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Universidad
 */
public class PilotoOficial extends PilotoDecorador{
    private static final double INCREMENTO_OFICIAL = 0.1;

    public PilotoOficial(String nombre, String apellidos, Integer edad, double altura, double peso, Integer puntos, double reflejos, double agresividad, double paciencia, double valentia) {
        super(nombre, apellidos, edad, altura, peso, puntos, reflejos, agresividad, paciencia, valentia);
    }

    @Override
    public void mejorar() {
        setReflejos(getReflejos()+INCREMENTO_OFICIAL);
        setAgresividad(getAgresividad()+ INCREMENTO_OFICIAL);
        setPaciencia(getPaciencia()+ INCREMENTO_OFICIAL);
        setValentia(getValentia() + INCREMENTO_OFICIAL);
    }

    @Override
    public double getIncremento() {
        return INCREMENTO_OFICIAL;
    }
    
    
    
    
}
