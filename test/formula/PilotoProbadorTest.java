package formula;

import static org.hamcrest.core.Is.is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PilotoProbadorTest {
    
    private PilotoLibre pilotoLibre;
    private PilotoProbador pilotoProbador;
    
    private String nombre = "Jim";
    private String apellidos = "Clark";
    private Integer edad = 24;
    private Integer altura = 160;
    private Integer peso = 60;
    private Double reflejos = 4.0;
    private Double agresividad = 2.5;
    private Double paciencia = 4.5;
    private Double valentia = 3.3;    
    
    @Before
    public void setUp() {
        pilotoLibre = new PilotoLibre(nombre, apellidos, edad, altura, peso, reflejos, agresividad, paciencia, valentia);
        pilotoProbador = new PilotoProbador(pilotoLibre);
    }
    
    @Test
    public void test_GetValoracionGlobal() {
        Double valoracionGlobal = reflejos + agresividad + paciencia + valentia;
        assertThat(valoracionGlobal, is(pilotoProbador.getValoraciónGlobal()));
    }

    @Test
    public void test_GetSueldo() {
        Double valoracionGlobal = pilotoProbador.getValoraciónGlobal();
        Double sueldoEstimado = (valoracionGlobal * PilotoProbador.EUROS_POR_VALORACION);
        assertThat(sueldoEstimado.intValue(), is(pilotoProbador.getSueldo()));
    }
    
    @Test
    public void test_Mejorar() {
        pilotoProbador.entrenar();
        Double reflejosEstimados = reflejos + PilotoProbador.INCREMENTO_MEJORA;
        assertThat(reflejosEstimados, is(pilotoProbador.getReflejos()));
        Double agresividadEstimada = agresividad + PilotoProbador.INCREMENTO_MEJORA;
        assertThat(agresividadEstimada, is(pilotoProbador.getAgresividad()));
        Double pacienciaEstimada = paciencia + PilotoProbador.INCREMENTO_MEJORA;
        assertThat(pacienciaEstimada, is(pilotoProbador.getPaciencia()));
        Double valentiaEstimada = valentia + PilotoProbador.INCREMENTO_MEJORA;
        assertThat(valentiaEstimada, is(pilotoProbador.getValentia()));
    }
    
    @Test
    public void test_Mejorar_por_encima_de_limite() {
        Double valorMaximo = PilotoProbador.VALOR_MAXIMO_CARACTERISTICAS;
        pilotoProbador.setReflejos(valorMaximo);
        pilotoProbador.setAgresividad(valorMaximo);
        pilotoProbador.setPaciencia(valorMaximo);
        pilotoProbador.setValentia(valorMaximo);
        pilotoProbador.entrenar();
        assertThat(valorMaximo, is(pilotoProbador.getReflejos()));
        assertThat(valorMaximo, is(pilotoProbador.getAgresividad()));
        assertThat(valorMaximo, is(pilotoProbador.getPaciencia()));
        assertThat(valorMaximo, is(pilotoProbador.getValentia()));
    }
}
