package formula;
import java.util.*;

public class Escuderia {
    private String nombre;
    private String pais;
    private Integer año;
    private Integer presupuesto;
    private Integer puntos;
    private Set<PilotoOficial> pilotosOficiales;
    private Set<Coche> coches;
    private Set<PilotoProbador> pilotosProbadores;
    private String dueño;
    
    private static final Integer MINIMA_CANTIDAD_DE_PILOTOS_OFICIALES = 1;
    private static final Integer MAXIMA_CANTIDAD_DE_PILOTOS_OFICIALES = 2;
    private static final Integer MAXIMA_CANTIDAD_DE_PILOTOS_PROBADORES = 2;
    private static final Integer MAXIMA_CANTIDAD_DE_COCHES = 2;
    private static final Double MARGEN_VALORACION_PARA_INTERCAMBIO = 0.1;
    
    public Escuderia( 
            String nombre,
            String pais,
            Integer año,
            Integer presupuesto,
            String dueño,
            Set<PilotoOficial> pilotosOficiales
    ) {
        this.nombre = nombre;
        this.pais = pais;
        this.año = año;
        this.presupuesto = presupuesto;
        this.dueño = dueño;
        this.pilotosOficiales = pilotosOficiales;
    }
    
    public boolean puedeFicharPilotoOficial(){
        return (pilotosOficiales.size() < MAXIMA_CANTIDAD_DE_PILOTOS_OFICIALES);
    }
    
    public boolean puedeFicharPilotoProbador(){
        return (pilotosProbadores.size() < MAXIMA_CANTIDAD_DE_PILOTOS_PROBADORES);
    }    
    
    public boolean tienePresupuestoSuficiente(Integer gasto){
            return (presupuesto >= gasto);
    }    
    
    public void ficharPiloto(PilotoOficial piloto) {
        if (puedeFicharPilotoOficial() && tienePresupuestoSuficiente(piloto.getSueldo())) {
            pilotosOficiales.add(piloto);
            pagarSueldoAPiloto(piloto);
        }
    }
    
    public void ficharPiloto(PilotoProbador piloto) {
        if (puedeFicharPilotoProbador()&& tienePresupuestoSuficiente(piloto.getSueldo())) {
            pilotosProbadores.add(piloto);
            pagarSueldoAPiloto(piloto);
        }
    }  
   
    public static boolean sonPilotosIntercambiables(PilotoDecorador p1, PilotoDecorador p2){
        Double diferencia = Math.abs(p1.getValoraciónGlobal() - p2.getValoraciónGlobal());
        Double margen = Math.max(p1.getValoraciónGlobal(), p2.getValoraciónGlobal()) * MARGEN_VALORACION_PARA_INTERCAMBIO;
        return (margen >= diferencia);
    }
    
    public void intercambiarPiloto(PilotoDecorador pilotoVenta, PilotoDecorador pilotoCompra) {
        if (Escuderia.sonPilotosIntercambiables(pilotoVenta, pilotoCompra)) {
           if (pilotosOficiales.remove(pilotoVenta)) {
               PilotoOficial pilotoOficial = new PilotoOficial(pilotoCompra.getPiloto());
               pilotosOficiales.add(pilotoOficial);
           } else if (pilotosProbadores.remove(pilotoVenta)) {
               PilotoProbador pilotoProbador = new PilotoProbador(pilotoCompra.getPiloto());
               pilotosProbadores.add(pilotoProbador);
           }
           
        }
    }
   
    public boolean puedeFabricarCoche(){
       return coches.size() < MAXIMA_CANTIDAD_DE_COCHES;
    }
    
    public void pagarSueldoAPiloto(PilotoDecorador piloto){
        this.presupuesto = this.presupuesto - piloto.getSueldo();
    }    
    
    public boolean puedeDescartarPilotoOficial(){
        return pilotosOficiales.size() > MINIMA_CANTIDAD_DE_PILOTOS_OFICIALES;
    }

    public boolean puedeEntrenar(Circuito c){
        return tienePresupuestoSuficiente(c.getCanon());
    }
    
    public void entrenar(Circuito circuito, PilotoDecorador piloto, Coche coche){
        if (puedeEntrenar(circuito)){
            presupuesto -= circuito.getCanon();
            coche.entrenar();
            piloto.entrenar();
        }
    }
    
    public void fabricarCoche(String modelo, Double potencia, Double aerodinamica, Double neumaticos){
        if (puedeFabricarCoche()){
           Coche coche = new Coche(modelo, potencia, aerodinamica, neumaticos);
           coches.add(coche);
        }
    }    
    
    public void descartarPiloto(PilotoOficial piloto){
        if (puedeDescartarPilotoOficial()) {
            pilotosOficiales.remove(piloto);
        }
    }
    
    public void descartarPiloto(PilotoProbador piloto){
        this.pilotosProbadores.remove(piloto);
    }
    
    public void sumarPuntos(Integer puntos){
        this.puntos += puntos; 
    }
    
    /*
    Se implementarán cuando las clases Participante y Carrera estén listas
    
    public Participante configurarCarrera(Carrera race, PilotoOficial piloto, Coche c){
        Participante parti = new Participante(this,piloto, c); 
        return parti;
    }
    
    public ArrayList<Participante> configurarCarrera(Carrera race){
       ArrayList<Participante> participantes = new ArrayList<>();
       Iterator<PilotoOficial> it_oficiales = this.pilotosOficiales.iterator();
       Iterator<Coche> it_coches = this.coches.iterator();
       
       int total = Math.min(this.coches.size(), this.pilotosOficiales.size());
       for (int i=0; i<total; i++){
           participantes.add(Participante(it_oficiales.next(),it_coches.next()));
           i++;
       }
       return participantes;
    }
    
    public void obtenerPremio() {
        
    }

    public boolean puedeParticiparEnCarrera(Carrera carrera){
        
    }
    */
    
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

    public Integer getPresup() {
        return presupuesto;
    }

    public void setPresup(Integer presup) {
        this.presupuesto = presup;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }
    
    public Set<PilotoOficial> getPilotosOficiales() {
        return pilotosOficiales;
    }

    public void setPilotosOficiales(Set<PilotoOficial> pilotosOficiales) {
        this.pilotosOficiales = pilotosOficiales;
    }

    public Set<Coche> getCoches() {
        return coches;
    }

    public void setCoches(Set<Coche> coches) {
        this.coches = coches;
    }

    public Set<PilotoProbador> getPilotosProbadores() {
        return pilotosProbadores;
    }

    public void setPilotosProbadores(Set<PilotoProbador> pilotosProbadores) {
        this.pilotosProbadores = pilotosProbadores;
    }
}
    

