/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Universidad
 */
public abstract class PilotoDecorador extends PilotoBase{
    PilotoLibre p;

    public PilotoDecorador(String nombre, String apellidos, Integer edad, double altura, double peso, Integer puntos, double reflejos, double agresividad, double paciencia, double valentia) {
        super(nombre, apellidos, edad, altura, peso, puntos, reflejos, agresividad, paciencia, valentia);
    }
    
    public abstract double getIncremento();
    
    @Override
    public abstract void mejorar();
    
    public PilotoLibre getPiloto(){
        return this.p;
    }
    
    public void entrenar(){
        this.mejorar();
    }
    

}
