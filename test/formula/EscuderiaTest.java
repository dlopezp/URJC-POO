package formula;

import java.util.Set;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class EscuderiaTest {
    private String nombreEscuderia ="Ferrari";
    private String paisEscuderia = "Italia";
    private Integer añoEscuderia = 1930;
    private Integer presupuestoEscuderia = 50000;    
    private Set<PilotoOficial> pilotosOficiales;
    private Set<Coche> coches;
    private Set<PilotoProbador> pilotosProbadores;
    private String dueñoEscuderia = "Maurizio Arrivarrene";
   
    // Datos Piloto Libre1
    private String nombrePiloto1 = "Jim";
    private String apellidosPiloto1 = "Clark";
    private Integer edadPiloto1 = 24;
    private Integer alturaPiloto1 = 160;
    private Integer pesoPiloto1 = 60;
    private Double reflejosPiloto1 = 4.0;
    private Double agresividadPiloto1 = 2.5;
    private Double pacienciaPiloto1 = 4.5;
    private Double valentiaPiloto1 = 3.3;
    private PilotoLibre pilotoLibre1 = new PilotoLibre(nombrePiloto1, apellidosPiloto1, edadPiloto1, alturaPiloto1, pesoPiloto1, reflejosPiloto1, agresividadPiloto1, pacienciaPiloto1, valentiaPiloto1);
    
    private String nombrePiloto2 = "Jim";
    private String apellidosPiloto2 = "Clark";
    private Integer edadPiloto2 = 24;
    private Integer alturaPiloto2 = 160;
    private Integer pesoPiloto2 = 60;
    private Double reflejosPiloto2 = 4.0;
    private Double agresividadPiloto2 = 2.5;
    private Double pacienciaPiloto2 = 4.5;
    private Double valentiaPiloto2 = 3.3;    
    private PilotoLibre pilotoLibre2 = new PilotoLibre(nombrePiloto2, apellidosPiloto2, edadPiloto2, alturaPiloto2, pesoPiloto2, reflejosPiloto2, agresividadPiloto2, pacienciaPiloto2, valentiaPiloto2);

    
    private String nombrePiloto3 = "Pep";
    private String apellidosPiloto3 = "Dee";
    private Integer edadPiloto3 = 30;
    private Integer alturaPiloto3 = 170;
    private Integer pesoPiloto3 = 80;
    private Double reflejosPiloto3 = 1.0;
    private Double agresividadPiloto3 = 1.5;
    private Double pacienciaPiloto3 = 1.5;
    private Double valentiaPiloto3 = 1.3;    
    private PilotoLibre pilotoLibre3 = new PilotoLibre(nombrePiloto3, apellidosPiloto3, edadPiloto3, alturaPiloto3, pesoPiloto3, reflejosPiloto3, agresividadPiloto3, pacienciaPiloto3, valentiaPiloto3);
    
    
    private Escuderia escuderia = new Escuderia(nombreEscuderia, paisEscuderia, añoEscuderia, presupuestoEscuderia, dueñoEscuderia, pilotoLibre1);

    @Test
    public void test_puedeFicharPilotoOficial() {
        assertTrue(escuderia.puedeFicharPilotoOficial());
        escuderia.ficharPiloto(new PilotoOficial(pilotoLibre2));
        assertFalse(escuderia.puedeFicharPilotoOficial());
    }
    
    @Test
    public void test_puedeFicharPilotoProbador() {
        assertTrue(escuderia.puedeFicharPilotoProbador());
        escuderia.ficharPiloto(new PilotoProbador(pilotoLibre1));
        assertTrue(escuderia.puedeFicharPilotoProbador());
        escuderia.ficharPiloto(new PilotoProbador(pilotoLibre2));
        assertFalse(escuderia.puedeFicharPilotoProbador());
    }
    
    @Test
    public void test_tienePresupuestoSuficiente() {
        assertTrue(escuderia.tienePresupuestoSuficiente(presupuestoEscuderia - 1));
        assertTrue(escuderia.tienePresupuestoSuficiente(presupuestoEscuderia));
        assertFalse(escuderia.tienePresupuestoSuficiente(presupuestoEscuderia + 1));
    }
    
    @Test
    public void test_ficharPilotoOficial() {
        PilotoOficial piloto = new PilotoOficial(pilotoLibre2);
        Set<PilotoOficial> pilotosOficiales = escuderia.getPilotosOficiales();
        assertFalse(pilotosOficiales.contains(piloto));
        escuderia.ficharPiloto(piloto);
        pilotosOficiales = escuderia.getPilotosOficiales();
        assertTrue(pilotosOficiales.contains(piloto));
    }

    @Test
    public void test_ficharPilotoProbador() {
        PilotoProbador piloto = new PilotoProbador(pilotoLibre2);
        Set<PilotoProbador> pilotosProbadores = escuderia.getPilotosProbadores();
        assertFalse(pilotosProbadores.contains(piloto));
        escuderia.ficharPiloto(piloto);
        pilotosProbadores = escuderia.getPilotosProbadores();
        assertTrue(pilotosProbadores.contains(piloto));
        PilotoProbador piloto2 = new PilotoProbador(pilotoLibre2);
        escuderia.ficharPiloto(piloto2);
        pilotosProbadores = escuderia.getPilotosProbadores();
        assertTrue(pilotosProbadores.contains(piloto2));
        PilotoProbador piloto3 = new PilotoProbador(pilotoLibre2);
        escuderia.ficharPiloto(piloto3);
        pilotosProbadores = escuderia.getPilotosProbadores();
        assertFalse(pilotosProbadores.contains(piloto3));
    }
    
    @Test
    public void test_sonPilotosIntercambiables(){
        PilotoOficial pilotoOficial1 = new PilotoOficial(pilotoLibre2);
        PilotoProbador pilotoProbador2 =  new PilotoProbador(pilotoLibre2);
        PilotoProbador pilotoProbador3 =  new PilotoProbador(pilotoLibre3);
        assertTrue(Escuderia.sonPilotosIntercambiables(pilotoOficial1, pilotoProbador2));
        assertFalse(Escuderia.sonPilotosIntercambiables(pilotoOficial1, pilotoProbador3));
        assertFalse(Escuderia.sonPilotosIntercambiables(pilotoProbador2, pilotoProbador3));
    }
    
    @Test
    public void test_intercambiarProbadorProbador() {
        PilotoProbador pilotoP1 = new PilotoProbador(pilotoLibre1);
        PilotoProbador pilotoP2 = new PilotoProbador(pilotoLibre2);
        escuderia.ficharPiloto(pilotoP1);
        assertTrue(escuderia.getPilotosProbadores().contains(pilotoP1));
        assertFalse(escuderia.getPilotosProbadores().contains(pilotoP2));
        escuderia.intercambiarPiloto(pilotoP1, pilotoP2);
        assertFalse(escuderia.getPilotosProbadores().contains(pilotoP1));
        assertTrue(escuderia.getPilotosProbadores().contains(pilotoP2));  
    }
    
    @Test
    public void test_intercambiarOficialOficial() {
        Set<PilotoOficial> oficiales; 
        PilotoOficial pilotoO1 = new PilotoOficial(pilotoLibre1);
        PilotoOficial pilotoO2 = new PilotoOficial(pilotoLibre2);
        escuderia.ficharPiloto(pilotoO1);
        oficiales = escuderia.getPilotosOficiales();
        assertTrue(oficiales.contains(pilotoO1));
        assertFalse(oficiales.contains(pilotoO2));
        escuderia.intercambiarPiloto(pilotoO1, pilotoO2);
        oficiales = escuderia.getPilotosOficiales();
        assertFalse(oficiales.contains(pilotoO1));
        assertTrue(oficiales.contains(pilotoO2));       
    }
    
    @Test
    public void test_intercambiarOficialProbador() {
 
        PilotoOficial pilotoO1 = new PilotoOficial(pilotoLibre1);
        PilotoOficial pilotoO2 = new PilotoOficial(pilotoLibre2);
        PilotoProbador pilotoP1 = new PilotoProbador(pilotoLibre1);
        PilotoProbador pilotoP2 = new PilotoProbador(pilotoLibre2);
        PilotoProbador pilotoP3 = new PilotoProbador(pilotoLibre2);
        
        // si solo hay un piloto oficial en nuestra escuderia no se puede intercambiar
        escuderia.ficharPiloto(pilotoO1);
        escuderia.intercambiarPiloto(pilotoO1, pilotoP1);
        assertTrue(escuderia.getPilotosOficiales().contains(pilotoO1));
        assertFalse(escuderia.getPilotosProbadores().contains(pilotoP1));
        
        // si hay 2 pilotos oficiales en nuestra escuderia se puede intercambiar
        escuderia.getPilotosOficiales().clear();
        escuderia.getPilotosProbadores().clear();
        escuderia.ficharPiloto(pilotoO1);
        escuderia.ficharPiloto(pilotoO2);
        escuderia.intercambiarPiloto(pilotoO1, pilotoP1);
        assertFalse(escuderia.getPilotosOficiales().contains(pilotoO1));
        assertTrue(escuderia.getPilotosProbadores().contains(pilotoP1));
        
        // si ya hay 2 pilotos probadores en nuestra escudería no se puede intercambiar
        escuderia.getPilotosOficiales().clear();
        escuderia.getPilotosProbadores().clear();
        escuderia.ficharPiloto(pilotoO1);
        escuderia.ficharPiloto(pilotoO2);
        escuderia.ficharPiloto(pilotoP1);
        escuderia.ficharPiloto(pilotoP2);
        escuderia.intercambiarPiloto(pilotoO1, pilotoP3);
        assertTrue(escuderia.getPilotosOficiales().contains(pilotoO1));
        assertFalse(escuderia.getPilotosProbadores().contains(pilotoP3));
        
        
    }
    
   // @Test
   // public void test_intercambiarProbadorOficial() {}

}
