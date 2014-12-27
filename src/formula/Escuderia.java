package formula;
import java.util.*;

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
    Set<PilotoOficial> p_oficiales;
    Set<Coche> coches;
    Set<PilotoProbador> p_probadores;
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
    

    
    
    

    public boolean puedeFicharPiloto(PilotoOficial p){
        return ((this.presup - p.getSueldo()) > 0) & (this.p_oficiales.size() <2);
    }
    
    public boolean puedeFicharPiloto(PilotoProbador p){
        return ((this.presup - p.getSueldo()) > 0) & (this.p_probadores.size() <2);
    }
    
    
    
    
    public boolean puedeFabricarCoche(){
       return coches.size() < 2;
        
    }
    
   
    public void ficharPiloto(PilotoOficial p){
        
        if (puedeFicharPiloto(p)){
            this.p_oficiales.add(p);
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
            Iterator<PilotoOficial> it_poficial = p_oficiales.iterator();
            while (it_poficial.hasNext()){
                    if (it_poficial.equals(p_vendido.getPiloto())){
                        this.p_oficiales.add(new PilotoOficial(p_comprado.getPiloto()));
                        it_poficial.remove();
                    }
                    it_poficial.next();
                    }
            Iterator<PilotoProbador> it_pruebas = p_probadores.iterator();
            while (it_pruebas.hasNext()){
                    if (it_pruebas.equals(p_vendido.getPiloto())){
                        this.p_probadores.add(new PilotoProbador(p_comprado.getPiloto()));
                        it_pruebas.remove();
                    }
                    it_pruebas.next();
                    }
        }

    }
        
    public void pagarSueldoAPiloto(PilotoDecorador p){
        this.presup = this.presup - p.getSueldo();
    }
    
    
    
    
    public void tienePresupuestoSuficiente(){}
    public void puedeDescartarPilotoOficial(){};
    public void fabricarCoche(){}
    public void entrenar(){} 
    public void configurarCarrera(){}
    public void sumarPuntos(){}
    public void puedeParticiparEnCarrera(){}
    public void puedeEntrenar(){}
    public void obtenerPremio(){}
    public void descartarPiloto(){}
    
    
    
    

    
    
    
    
    
    
}
