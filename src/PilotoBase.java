/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HOME3
 */
public abstract class PilotoBase {
    
    private String nombre;
    private String apellidos;
    private Integer edad;
    private Double altura;
    private Double peso;
    private Integer puntos;
    private Double reflejos;
    private Double agresividad;
    private Double paciencia;
    private Double valentia;
    
    
    public PilotoBase(String nombre, String apellidos, Integer edad, double altura, double peso, 
            Integer puntos, double reflejos, double agresividad, double paciencia, double valentia){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.puntos = puntos;
        this.reflejos = reflejos;
        this.agresividad = agresividad;
        this.valentia = valentia;
                
    }
    
    public abstract void mejorar();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Double getReflejos() {
        return reflejos;
    }

    public void setReflejos(Double reflejos) {
        this.reflejos = reflejos;
    }

    public Double getAgresividad() {
        return agresividad;
    }

    public void setAgresividad(Double agresividad) {
        this.agresividad = agresividad;
    }

    public Double getPaciencia() {
        return paciencia;
    }

    public void setPaciencia(Double paciencia) {
        this.paciencia = paciencia;
    }

    public Double getValentia() {
        return valentia;
    }

    public void setValentia(Double valentia) {
        this.valentia = valentia;
    }
    
    
    public void SumarPuntos(){
        
    }
    
    public double getValoracionGlobal(){
       return getReflejos() + getAgresividad() + getPaciencia() + getValentia();
    }
 
    
    
    public void sumarPuntos(){
        
    }
}
