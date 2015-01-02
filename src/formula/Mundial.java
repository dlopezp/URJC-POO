package formula;

import java.io.Serializable;
import java.util.*;

/**
 * @author Eduardo Benito Fernández
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
    
    public Boolean puedeAgregarCarreras() {
        return carreras.size() < MAXIMO_CARRERAS;
    }
    
    public Boolean puedeComenzar() {
        return carreras.size() == MAXIMO_CARRERAS;
    }

    public void comenzar() {
        this.comenzado = true;
    }
    
    public Boolean estaComenzado() {
        return comenzado;
    }
    
    public void añadirCarrera (Carrera carrera) {
        if (puedeAgregarCarreras()) {
            carreras.add(carrera);
        }
    }
    
    public void añadirEscuderia(Escuderia escuderia) {
        escuderias.add(escuderia);
    }
    
    public void añadirPiloto(PilotoLibre piloto) {
        pilotos.add(piloto);
    }
    
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
