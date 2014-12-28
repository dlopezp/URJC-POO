package formula;

import static org.hamcrest.core.Is.is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PilotoOficialTest {
    
    private PilotoLibre pilotoLibre;
    private PilotoOficial pilotoProbador;
    
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
        pilotoProbador = new PilotoOficial(pilotoLibre);
    }
    
    @Test
    public void test_GetValoracionGlobal() {
        Double valoracionGlobal = reflejos + agresividad + paciencia + valentia;
        assertThat(valoracionGlobal, is(pilotoProbador.getValoraciónGlobal()));
    }

    @Test
    public void test_GetSueldo() {
        Double valoracionGlobal = pilotoProbador.getValoraciónGlobal();
        Double sueldoEstimado = (valoracionGlobal * PilotoOficial.EUROS_POR_VALORACION) + PilotoOficial.PLUS_PELIGROSIDAD;
        assertThat(sueldoEstimado.intValue(), is(pilotoProbador.getSueldo()));
    }
    
    @Test
    public void test_Mejorar() {
        pilotoProbador.entrenar();
        Double reflejosEstimados = reflejos + PilotoOficial.INCREMENTO_MEJORA;
        assertThat(reflejosEstimados, is(pilotoProbador.getReflejos()));
        Double agresividadEstimada = agresividad + PilotoOficial.INCREMENTO_MEJORA;
        assertThat(agresividadEstimada, is(pilotoProbador.getAgresividad()));
        Double pacienciaEstimada = paciencia + PilotoOficial.INCREMENTO_MEJORA;
        assertThat(pacienciaEstimada, is(pilotoProbador.getPaciencia()));
        Double valentiaEstimada = valentia + PilotoOficial.INCREMENTO_MEJORA;
        assertThat(valentiaEstimada, is(pilotoProbador.getValentia()));
    }
    
    @Test
    public void test_Mejorar_por_encima_de_limite() {
        Double valorMaximo = PilotoOficial.VALOR_MAXIMO_CARACTERISTICAS;
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
