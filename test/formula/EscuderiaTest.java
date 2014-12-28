package formula;

import java.util.Set;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eduardo Benito Fernández
 */
public class EscuderiaTest {
    private String nombre ="Ferrari";
    private String pais = "Italia";
    private Integer año = 1930;
    private double presup = 1500;
    private Integer puntos = 0;
    
    
    private Set<PilotoOficial> p_oficiales;
    private Set<Coche> coches;
    private Set<PilotoProbador> p_probadores;
    String dueño;

    
    private Escuderia escuderia = new Escuderia(nombre, pais, año, presup, puntos, p_oficiales, coches, p_probadores, dueño);
    
    // Datos Piloto Libre1
    private String[] nom = {"Jim","Pepe"};
    private String[] apellidos = {"Clark","Pérez"};
    private Integer[] edad = {24, 30};
    private Integer[] altura = {160, 170};
    private Integer[] peso = {60, 72};
    private Double[] reflejos = {4.0, 3.1};
    private Double[] agresividad = {2.5, 4.7};
    private Double[] paciencia = {4.5, 1.0};
    private Double[] valentia = {3.3, 4.0};
    private PilotoLibre[] pilotoLibre = new PilotoLibre(nombre, apellidos, edad, altura, peso, reflejos, agresividad, paciencia, valentia);
   

    



@Test
 public void test_puedeIntercambiarPiloto(){
    
}
