package formula;
import java.util.*;
import javax.swing.JFrame;

/**
 *  Hay que revisar el algoritmo de sonIntercambiables, 
 * @author Universidad
 */
public class Escuderia {
    private String nombre;
    private String pais;
    private Integer año;
    private double presup;
    private Integer puntos;
    private Set<PilotoOficial> p_oficiales;
    private Set<Coche> coches;
    private Set<PilotoProbador> p_probadores;
    String dueño;
    
    public Escuderia( 
            String nombre,
            String pais,
            Integer año,
            double presup,
            Integer puntos,
            Set<PilotoOficial> p_oficial,
            Set<Coche> coches,
            Set<PilotoProbador> p_probador,
            String dueño){
        this.nombre = nombre;
        this.pais = pais;
        this.año = año;
        this.presup = presup;
        this.puntos = puntos;
        this.p_oficiales = p_oficial;
        this.coches = coches;
        this.p_probadores = p_probador;
        this.dueño = dueño;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public double getPresup() {
        return presup;
    }

    public void setPresup(double presup) {
        this.presup = presup;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }
    
    public Set<PilotoOficial> getP_oficiales() {
        return p_oficiales;
    }

    public void setP_oficiales(Set<PilotoOficial> p_oficiales) {
        this.p_oficiales = p_oficiales;
    }

    public Set<Coche> getCoches() {
        return coches;
    }

    public void setCoches(Set<Coche> coches) {
        this.coches = coches;
    }

    public Set<PilotoProbador> getP_probadores() {
        return p_probadores;
    }

    public void setP_probadores(Set<PilotoProbador> p_probadores) {
        this.p_probadores = p_probadores;
    }


    
    public boolean puedeFicharPiloto(PilotoOficial p){
        return ((this.presup - p.getSueldo()) > 0) & (this.getP_oficiales().size() <2);
    }
    
    public boolean puedeFicharPiloto(PilotoProbador p){
        return ((this.presup - p.getSueldo()) > 0) & (this.getP_probadores().size() <2);
    }
    
    
    
    public boolean puedeFabricarCoche(){
       return getCoches().size() < 2;
        
    }
    
   
    public void ficharPiloto(PilotoOficial p){
        
        if (puedeFicharPiloto(p)){
            this.getP_oficiales().add(p);
            pagarSueldoAPiloto(p);}
        else
            System.out.println("No puede fichar a este piloto");
    }
    
   

    public boolean puedeIntercambiarPiloto(PilotoDecorador p1, PilotoDecorador p2){
        return ( p2.getValoraciónGlobal() > (p1.getValoraciónGlobal()- p1.getValoraciónGlobal()/10) ) || 
               (p1.getValoraciónGlobal() > (p2.getValoraciónGlobal()- p2.getValoraciónGlobal()/10));
        
    }
    
    
    public void intercambiarPiloto(PilotoDecorador p_vendido, PilotoProbador p_comprado){
        if (puedeIntercambiarPiloto(p_vendido, p_comprado)){
            Iterator<PilotoOficial> it_oficiales = getP_oficiales().iterator();
            boolean encontrado = false;
            while (it_oficiales.hasNext() & !encontrado){
                    if (it_oficiales.equals(p_vendido.getPiloto())){
                        this.getP_oficiales().add(new PilotoOficial(p_comprado.getPiloto()));
                        it_oficiales.remove();
                        encontrado = true;
                    }
                    it_oficiales.next();
            }
            
            Iterator<PilotoProbador> it_probadores = getP_probadores().iterator();
            while (it_probadores.hasNext() & !encontrado){
                    if (it_probadores.equals(p_vendido.getPiloto())){
                        this.getP_probadores().add(new PilotoProbador(p_comprado.getPiloto()));
                        it_probadores.remove();
                        encontrado = true;
                    }
                    it_probadores.next();
            }
        }
    }
        
    public void pagarSueldoAPiloto(PilotoDecorador p){
        this.presup = this.presup - p.getSueldo();
    }
    
    
    
    
    public void tienePresupuestoSuficiente(){}
    
    public boolean puedeDescartarPilotoOficial(){
        return this.getP_oficiales().size()>1;
    }
    
    
    public void fabricarCoche(){
        if (puedeFabricarCoche()){
           Coche co = new Coche(String modelo, Double potencia, Double aerodinamica, Double neumaticos);
            getCoches().add(co);
        }
    }
    
    public boolean puedeEntrenar(Circuito c){
        return (getPresup() - c.getCanon()) > 0;
    }
    
    public void entrenar(Circuito circuit, PilotoDecorador p, Coche c ){
        c.mejorar();
        p.entrenar();
    } 
    
    public void configurarCarrera(){}
    public void sumarPuntos(){}
    public void puedeParticiparEnCarrera(){}
    

    public void obtenerPremio(){}
    public void descartarPiloto(){
    }

    
    
    
    
    

    
    
    
    
    
    
}
