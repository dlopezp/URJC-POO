package formula;

import java.io.Serializable;
import java.util.*;

/**
 * @author Eduardo Benito Fernández
 * @version 1.0
 * @since 20-12-2014
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
     /**
     * Calcula la si la Escudería puede fichar otro Piloto Oficial. 
     * Será TRUE si no ha excedido el máximo número de Pilotos Oficiales.
     * @return TRUE si el número de Pilotos Oficiales < Num Maximo. FALSE en caso
     * contrario;
     */
    public boolean puedeFicharPilotoOficial() {
        return (pilotosOficiales.size() < MAXIMA_CANTIDAD_DE_PILOTOS_OFICIALES);
    }
     /**
     * Calcula la si la Escudería puede fichar otro Piloto Probador. 
     * Será TRUE si no ha excedido el máximo número de Pilotos Probadores.
     * @return TRUE si el número de Pilotos Probadores < Num Maximo. FALSE en caso
     * contrario;
     */    
    public boolean puedeFicharPilotoProbador(){
        return (pilotosProbadores.size() < MAXIMA_CANTIDAD_DE_PILOTOS_PROBADORES);
    }    
     /**
     * Calcula la si la Escudería tiene presupuesto para gastar.
     * @param gasto
     * @return TRUE si el presupuesto es >= gasto o FALSE en caso contrario. 
     */    
    public boolean tienePresupuestoSuficiente(Integer gasto){
        return (presupuesto >= gasto);
    }    
     /**
     * Realiza la Accion de Fichar un Piloto Oficial para una Escudería.
     * Sólo será realizable si puedeFicharPilotoOficial y tienePresupuestoSuficiente
     * son TRUE.
     * @param piloto.
     */        
    public void ficharPiloto(PilotoOficial piloto) {
        if (puedeFicharPilotoOficial() && tienePresupuestoSuficiente(piloto.getSueldo())) {
            pilotosOficiales.add(piloto);
            pagarSueldoAPiloto(piloto);
        }
    }
     /**
     * Realiza la Accion de Fichar un Piloto Probador para una Escudería.
     * Sólo será realizable si puedeFicharPilotoProbador y tienePresupuestoSuficiente
     * son TRUE.
     * @param piloto.
     */        
    public void ficharPiloto(PilotoProbador piloto) {
        if (puedeFicharPilotoProbador() && tienePresupuestoSuficiente(piloto.getSueldo())) {
            pilotosProbadores.add(piloto);
            pagarSueldoAPiloto(piloto);
        }
    }    
    /**
     * Chequea si dos pilotos son Intercambiables o no.
     * Lo hace calculando si su valoración no excede del 10%.
     * @param p1, p2 (PilotoDecorador).
     * @return TRUE si el margen < 10%, FALSE en caso contrario.
     */         
    public static boolean sonPilotosIntercambiables(PilotoDecorador p1, PilotoDecorador p2){
        Double diferencia = Math.abs(p1.getValoraciónGlobal() - p2.getValoraciónGlobal());
        Double margen = Math.max(p1.getValoraciónGlobal(), p2.getValoraciónGlobal()) * MARGEN_VALORACION_PARA_INTERCAMBIO;
        return (margen >= diferencia);
    }
     /**
     * Intercambia dos Pilotos en una Escudería.
     * Siempre y cuando sean intercambiables, el piloto en Venta pasa a formar
     * parte de otra Escudería y el piloto en Compra es adquirido por la Escudería
     * en cuestión.
     * @param pilotoVenta, pilotoCompra,(PilotoDecorador).
     */       
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
     /**
     * Calcula si la Escudería no supera el máximo de coches que puede tener.
     * @return TRUE si no ha superado el límite de coches y FALSO en caso contrario.
     */       
    public boolean puedeFabricarCoche(){
       return coches.size() < MAXIMA_CANTIDAD_DE_COCHES;
    }
     /**
     * Realiza la acción de pagar el Sueldo a un piloto concreto.
     * Dicho sueldo se resta del presupuesto de la Escudería
     * @param piloto PilotoDecorador
     */         
    public void pagarSueldoAPiloto(PilotoDecorador piloto){
        this.presupuesto = this.presupuesto - piloto.getSueldo();
    }
     /**
     * Realiza la acción de pagar el Canon a un Circuito concreto.
     * Dicho canon se resta del presupuesto de la Escudería
     * @param circuito.
     */         
    public void pagarCanonCircuito(Circuito circuito) {
        presupuesto -= circuito.getCanon();
    }
     /**
     * Calcula si tiene el número suficiente de Pilotos Oficiales como para
     * descartar a uno.
     * @return TRUE si tiene más pilotos que el número mínimo oficial y FALSE en caso
     * contrario. 
     */         
    public boolean puedeDescartarPilotoOficial(){
        return pilotosOficiales.size() > MINIMA_CANTIDAD_DE_PILOTOS_OFICIALES;
    }
     /**
     * Comprueba si una Escudería puede entrenar en un Circuito o no.
     * Lo hace calculando si tiene sueldo suficiente para pagar el canon. 
     * @param c (Circuito).
     * @return TRUE si tiene presupuestoSuficiente, FALSE en caso contrario. 
     */             
    public boolean puedeEntrenar(Circuito c){
        return tienePresupuestoSuficiente(c.getCanon());
    }
     /**
     * Realiza la acción de poner a Entrenar el Circuito, el piloto y el coche.
     * Realizando sobre estas tres clases los métodos correspondientes.
     * @param circuito, piloto, coche.
     */                 
    public void entrenar(Circuito circuito, PilotoDecorador piloto, Coche coche){
        if (puedeEntrenar(circuito)){
            presupuesto -= circuito.getCanon();
            coche.entrenar();
            piloto.entrenar();
        }
    }
     /**
     * Realiza la acción de crear un nuevo Coche en función de ciertos parámetros.
     * @param modelo, potencia, aerodinamica, neumaticos. 
     */          
    public void fabricarCoche(String modelo, Double potencia, Double aerodinamica, Double neumaticos){
        if (puedeFabricarCoche()){
           Coche coche = new Coche(modelo, potencia, aerodinamica, neumaticos);
           coches.add(coche);
        }
    }
     /**
     * Añade dicho coche al listado de coches de la Escudería.
     * @param coche. 
     */         
    public void fabricarCoche(Coche coche) {
        if (puedeFabricarCoche()){
           coches.add(coche);
        }
    }
     /**
     * Elimina un coche del listado de coches de la Escudería.
     * @param coche. 
     */            
    public void destruirCoche(Coche coche) {
        coches.remove(coche);
    }
     /**
     * Elimina un Piloto del listado de Pilotos Oficiales de la Escudería.
     * @param piloto. 
     */        
    public void descartarPiloto(PilotoOficial piloto){
        if (puedeDescartarPilotoOficial()) {
            pilotosOficiales.remove(piloto);
        }
    }
     /**
     * Elimina un Piloto del listado de Pilotos Probadores de la Escudería.
     * @param piloto. 
     */        
    public void descartarPiloto(PilotoProbador piloto){
        this.pilotosProbadores.remove(piloto);
    }
     /**
     * Suma los puntos correspondientes a la Escudería.
     * @param puntos. 
     */       
    public void sumarPuntos(Integer puntos){
        this.puntos += puntos; 
    }
     /**
     * Comprueba si un PilotoOficial se encuentra ya en el Array de Pilotos Oficiales
     * de la Escudería.
     * @param piloto. 
     */           
    public Boolean esPilotoOficial(PilotoOficial piloto) {
        return esPilotoOficial(piloto.getPiloto());
    }
     /**
     * Comprueba si un PilotoDecorador se encuentra ya en el Array de Pilotos Oficiales
     * de la Escudería.
     * @param piloto. 
     */           
    public Boolean esPilotoOficial(PilotoDecorador piloto) {
        return esPilotoOficial(piloto.getPiloto());
    }
     /**
     * Comprueba si un PilotoLibre se encuentra ya en el Array de Pilotos Oficiales
     * de la Escudería.
     * @param piloto. 
     */     
    public Boolean esPilotoOficial(PilotoLibre piloto) {
        Iterator<PilotoOficial> pilotos = pilotosOficiales.iterator();
        Boolean encontrado = false;
        while (pilotos.hasNext() && !encontrado) {
            PilotoLibre pilotoLibre = pilotos.next().getPiloto();
            encontrado = piloto.equals(pilotoLibre);
        }
        return encontrado;
    }
     /**
     * Comprueba si un PilotoProbador se encuentra ya en el Array de Pilotos Probadores
     * de la Escudería.
     * @param piloto. 
     */         
    public Boolean esPilotoProbador(PilotoProbador piloto) {
        return esPilotoProbador(piloto.getPiloto());
    }
     /**
     * Comprueba si un PilotoDecorador se encuentra ya en el Array de Pilotos Probadores
     * de la Escudería.
     * @param piloto. 
     */        
    public Boolean esPilotoProbador(PilotoDecorador piloto) {
        return esPilotoProbador(piloto.getPiloto());
    }
     /**
     * Comprueba si un PilotoLibre se encuentra ya en el Array de Pilotos Probadores
     * de la Escudería.
     * @param piloto. 
     */        
    public Boolean esPilotoProbador(PilotoLibre piloto) {
        Iterator<PilotoProbador> pilotos = pilotosProbadores.iterator();
        Boolean encontrado = false;
        while (pilotos.hasNext() && !encontrado) {
            PilotoLibre pilotoLibre = pilotos.next().getPiloto();
            encontrado = piloto.equals(pilotoLibre);
        }
        return encontrado;
    }
     /**
     * Suma el Premio de una Carrera al Presupuesto de la Escudería. 
     * @param premio. 
     */ 
    public void sumarPremio(Integer premio) {
        presupuesto += premio;
    }
     /**
     * Compara con otra Escudería para poder establecer
     * un orden de almacenamiento en Collections.
     * @param e (Escudería).
     * @return Diferencia de puntos entre las dos Escuderías.
     */ 
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
    
