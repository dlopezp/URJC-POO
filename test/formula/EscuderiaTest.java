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
}
