

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Universidad
 */
public class PilotoProbador extends PilotoDecorador{
    private static final double INCREMENTO_PROBADOR = 0.05;

    public PilotoProbador(String nombre, String apellidos, Integer edad, double altura, double peso, Integer puntos, double reflejos, double agresividad, double paciencia, double valentia) {
        super(nombre, apellidos, edad, altura, peso, puntos, reflejos, agresividad, paciencia, valentia);
    }
    

    @Override
    public void mejorar() {
        setReflejos(getReflejos()+INCREMENTO_PROBADOR);
        setAgresividad(getAgresividad()+ INCREMENTO_PROBADOR);
        setPaciencia(getPaciencia()+ INCREMENTO_PROBADOR);
        setValentia(getValentia() + INCREMENTO_PROBADOR);
    }

    @Override
    public double getIncremento() {
        return INCREMENTO_PROBADOR;
    }
    
    
}
