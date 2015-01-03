package formula;

import java.io.Serializable;
import java.util.*;

/**
 * @author Eduardo Benito Fernández
 * @version 1.0
 * @since 20-12-2014
 */

public class Mundial implements Serializable {
    
    private ArrayList<Carrera> carreras;
    private ArrayList<Escuderia> escuderias;
    private ArrayList<PilotoLibre> pilotos;
    private ArrayList<Circuito> circuitos;
    private Boolean comenzado;
    
    private static final Integer MAXIMO_CARRERAS = 5;
    
    public Mundial() {
        carreras = new ArrayList<>();
        escuderias = new ArrayList<>();
        pilotos = new ArrayList<>();
        circuitos = new ArrayList<>();
        comenzado = false;
    }
     /**
     * Calcula si se pueden agregar más carreras al presente Mundial.
     * @return TRUE si el número de carreras del Mundial < que el máximo de carreras
     * y FALSE en caso contrario;
     */    
    public Boolean puedeAgregarCarreras() {
        return carreras.size() < MAXIMO_CARRERAS;
    }
     /**
     * Calcula si el número de Carreras es el permitido para Comenzar el Mundial. 
     * @return TRUE si el número de carreras del Mundial < que el máximo de carreras
     * y FALSE en caso contrario;
     */        
    public Boolean puedeComenzar() {
        return carreras.size() == MAXIMO_CARRERAS;
    }
     /**
     * Pone el estado Comenzado = TRUE.
     */    
    public void comenzar() {
        this.comenzado = true;
    }
      /**
     * Calcula si el Mundial ha comenzado o no.
     * @return TRUE si ha comenzado y FALSE en caso contrario. 
     */       
    public Boolean estaComenzado() {
        return comenzado;
    }
      /**
     * Realiza la acción de Añadir una nueva Carrera al Mundial.
     * Siempre que no haya sobrepasado el número máximo permitido.
     * @param carrera. 
     */           
    public void añadirCarrera (Carrera carrera) {
        if (puedeAgregarCarreras()) {
            carreras.add(carrera);
        }
    }
     /**
     * Realiza la acción de Añadir una nueva Escudería al Mundial.
     * @param escudería. 
     */        
    public void añadirEscuderia(Escuderia escuderia) {
        escuderias.add(escuderia);
    }
     /**
     * Realiza la acción de Añadir un nuevo Piloto al Mundial.
     * @param piloto. 
     */      
    public void añadirPiloto(PilotoLibre piloto) {
        pilotos.add(piloto);
    }
     /**
     * Realiza la acción de Añadir un nuevo Circuito al Mundial.
     * @param escudería. 
     */      
    public void añadirCircuito(Circuito circuito) {
        circuitos.add(circuito);
    }

    public Carrera getCarrera (int indice) {
        return carreras.get(indice);
    }
    
    public PilotoLibre getPiloto(int indice) {
        return pilotos.get(indice);
    }
    
    public Escuderia getEscuderia(int indice) {
        return escuderias.get(indice);
    }
    
    public Circuito getCircuito(int indice) {
        return circuitos.get(indice);
    }
    
    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }
    
    public ArrayList<Escuderia> getEscuderias() {
        return escuderias;
    }

    public ArrayList<PilotoLibre> getPilotos() {
        return pilotos;
    }

    public ArrayList<Circuito> getCircuitos() {
        return circuitos;
    }

}
