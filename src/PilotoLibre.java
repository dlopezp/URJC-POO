/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Universidad
 */
public abstract class PilotoLibre extends PilotoBase{

    public PilotoLibre(String nombre, String apellidos, Integer edad, double altura, double peso, Integer puntos, double reflejos, double agresividad, double paciencia, double valentia) {
        super(nombre, apellidos, edad, altura, peso, puntos, reflejos, agresividad, paciencia, valentia);
    }
    
    public abstract void mejorar();
    
}
