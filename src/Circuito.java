/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Universidad
 */
public class Circuito {
    private static final Integer[] PREMIOS = {100000,75000,50000,25000,15000,10000} ;
    private String nombre;
    private Integer aforo;
    private Integer canon;
    private Tramo[] rectas;
    private Tramo[] curvas;
    
    public Circuito(String nombre, Integer aforo, Integer canon, Tramo[] rectas, Tramo[] curvas ){
       this.nombre = nombre;
       this.aforo = aforo;
       this.canon = canon;
       this.rectas = rectas;
       this.curvas = curvas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAforo() {
        return aforo;
    }

    public void setAforo(Integer aforo) {
        this.aforo = aforo;
    }

    public Integer getCanon() {
        return canon;
    }

    public void setCanon(Integer canon) {
        this.canon = canon;
    }

    
    public double getPremio1(){
        return PREMIOS[0];   
    }
    
    public double getPremio2(){
        return PREMIOS[1];   
    }
    
    public double getPremio3(){
        return PREMIOS[2];   
    }
       
    public double getPremio4(){
        return PREMIOS[3];  
    }
     
    public double getPremio5(){
        return PREMIOS[4];
    }
    
    public double getPremio6(){
        return PREMIOS[5];
    }    
    
    
       public double getDistanciaRectas(){
        double total=0;
        for(int i=0; i<6; i++){
           total = total + rectas[i].getDistancia(); 
        }
        return total;
    } 
    
    
    public double getDistanciaCurvas(){
        double total=0;
        for(int i=0; i<6; i++){
           total = total + curvas[i].getDistancia(); 
        }
        return total;
    }
    
    
    
}
