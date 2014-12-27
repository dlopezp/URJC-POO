
import java.sql.Time;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Universidad
 */
public class Coche {
    private String modelo;
    private double potencia;
    private double aerodinamica;
    private double neumaticos;
    
    public Coche (String modelo, double potencia, double aerodinamica, double neumaticos ){
        this.modelo = modelo;
        this.potencia = potencia;
        this.aerodinamica = aerodinamica;
        this.neumaticos = neumaticos;    
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public double getAerodinamica() {
        return aerodinamica;
    }

    public void setAerodinamica(double aerodinamica) {
        this.aerodinamica = aerodinamica;
    }

    public double getNeumaticos() {
        return neumaticos;
    }

    public void setNeumaticos(double neumaticos) {
        this.neumaticos = neumaticos;
    }
    
    public double getVelocidadEnRecta(){
        return (getPotencia()*20) + (getAerodinamica()*30);
    }
    
     public double getVelocidadEnCurva(){
        return (getPotencia()*10) + (getNeumaticos()*10) + (getAerodinamica()*10);
    }
     
     public void mejorar(double incremento){
         setAerodinamica(getAerodinamica()+incremento);
         setPotencia(getPotencia()+ incremento);
         setNeumaticos(getNeumaticos()+incremento);
         
     }
     
     public void getTiempoPorVuelta(){
         
     }
    

    
    
            
    
}
