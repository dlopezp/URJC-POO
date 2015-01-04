package formula;

import java.io.Serializable;
import java.util.*;

/**
 * Autor: Eduardo Benito Fernández
 */



public class Escuderia implements Comparable<Escuderia>, Serializable {
    private String nombre;
    private String pais;
    private Integer año;
    private Integer presupuesto;
    private Integer puntos;
    private ArrayList<PilotoOficial> pilotosOficiales;
    private ArrayList<Coche> coches;
    private ArrayList<PilotoProbador> pilotosProbadores;
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
            String dueño
    ) {
        this.nombre = nombre;
        this.pais = pais;
        this.año = año;
        this.presupuesto = presupuesto;
        this.dueño = dueño;
        this.puntos = 0;
        pilotosOficiales = new ArrayList<PilotoOficial>();
        pilotosProbadores = new ArrayList<PilotoProbador>();
        coches = new ArrayList<Coche>();
    }
    
    public boolean puedeFicharPilotoOficial() {
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
        if (puedeFicharPilotoProbador() && tienePresupuestoSuficiente(piloto.getSueldo())) {
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
           if (esPilotoOficial(pilotoVenta)) {
               pilotosOficiales.remove(pilotoVenta);
               PilotoOficial pilotoOficial = new PilotoOficial(pilotoCompra.getPiloto());
               ficharPiloto(pilotoOficial);
           } else if (esPilotoProbador(pilotoVenta)) {
               pilotosProbadores.remove(pilotoVenta);
               PilotoProbador pilotoProbador = new PilotoProbador(pilotoCompra.getPiloto());
               ficharPiloto(pilotoProbador);
           }
        }
    }
   
    public boolean puedeFabricarCoche(){
       return coches.size() < MAXIMA_CANTIDAD_DE_COCHES;
    }
    
    public void pagarSueldoAPiloto(PilotoDecorador piloto){
        this.presupuesto = this.presupuesto - piloto.getSueldo();
    }
    
    public void pagarCanonCircuito(Circuito circuito) {
        presupuesto -= circuito.getCanon();
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
    
    public void fabricarCoche(Coche coche) {
        if (puedeFabricarCoche()){
           coches.add(coche);
        }
    }
    
    public void destruirCoche(Coche coche) {
        coches.remove(coche);
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
    
    public Boolean esPilotoOficial(PilotoOficial piloto) {
        return esPilotoOficial(piloto.getPiloto());
    }
    
    public Boolean esPilotoOficial(PilotoDecorador piloto) {
        return esPilotoOficial(piloto.getPiloto());
    }
    
    public Boolean esPilotoOficial(PilotoLibre piloto) {
        Iterator<PilotoOficial> pilotos = pilotosOficiales.iterator();
        Boolean encontrado = false;
        while (pilotos.hasNext() && !encontrado) {
            PilotoLibre pilotoLibre = pilotos.next().getPiloto();
            encontrado = piloto.equals(pilotoLibre);
        }
        return encontrado;
    }
    
    public Boolean esPilotoProbador(PilotoProbador piloto) {
        return esPilotoProbador(piloto.getPiloto());
    }
    
    public Boolean esPilotoProbador(PilotoDecorador piloto) {
        return esPilotoProbador(piloto.getPiloto());
    }
    
    public Boolean esPilotoProbador(PilotoLibre piloto) {
        Iterator<PilotoProbador> pilotos = pilotosProbadores.iterator();
        Boolean encontrado = false;
        while (pilotos.hasNext() && !encontrado) {
            PilotoLibre pilotoLibre = pilotos.next().getPiloto();
            encontrado = piloto.equals(pilotoLibre);
        }
        return encontrado;
    }

    public void sumarPremio(Integer premio) {
        presupuesto += premio;
    }

    @Override
    public int compareTo(Escuderia e){
        int comp = 0;
        if (getPuntos() < e.getPuntos()){
            comp = -1;
        }
        else if (getPuntos() > e.getPuntos()){
            comp = 1;
        }
        return comp;
    }
    
    
    
    @Override
    public String toString() {
        return nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public Integer getAño() {
        return año;
    }

    public Integer getPresup() {
        return presupuesto;
    }

    public Integer getPuntos() {
        return puntos;
    }
    
    public ArrayList<PilotoOficial> getPilotosOficiales() {
        return pilotosOficiales;
    }

    public ArrayList<Coche> getCoches() {
        return coches;
    }

    public ArrayList<PilotoProbador> getPilotosProbadores() {
        return pilotosProbadores;
    }
    
    public Integer getPresupuesto() {
        return presupuesto;
    }

    public String getDueño() {
        return dueño;
    }

}
    

