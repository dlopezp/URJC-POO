/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Universidad
 */
public class Escuderia {
    private String nombre;
    private String pais;
    private Integer añoFundacion;
    private double presupuesto;
    private Integer puntos;
    PilotoOficial[] p_oficiales;
    Coche[] coches;
    PilotoProbador[] p_probadores;
    
    public void entrenar(PilotoDecorador p, Coche c){
        p.mejorar();
        c.mejorar(p.getIncremento());
        
    }
    
    
}
