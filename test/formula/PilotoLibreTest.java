
package formula;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.hamcrest.core.Is.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PilotoLibreTest {
    
    private String nombre = "Jim";
    private String apellidos = "Clark";
    private Integer edad = 24;
    private Double altura = 1.6;
    private Double peso = 60.0;
    private Double reflejos = 4.0;
    private Double agresividad = 2.5;
    private Double paciencia = 4.5;
    private Double valentia = 3.3;
    private PilotoLibre pilotoLibre;
    
    public PilotoLibreTest() {
    }
       
    @Before
    public void setUp() {
        pilotoLibre = new PilotoLibre(nombre, apellidos, edad, altura, peso, reflejos, agresividad, paciencia, valentia);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void test_getValorCaracteristicaEnLimite() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Double valorMinimo = 0.0;
        Double valorMaximo = PilotoBase.VALOR_MAXIMO_CARACTERISTICAS;
        Class clase = pilotoLibre.getClass();
        Method metodo = null;
        Class[] argumentos = new Class[1];
        argumentos[0] = Double.class;
        try {
            metodo = clase.getDeclaredMethod("getValorCaracteristicaEnLimite", argumentos);
        } catch (NoSuchMethodException e) {
            fail("No existe método getValorCaracteristicaEnLimite");
        }
        metodo.setAccessible(true);
        Object valorNegativo[] = {-1.0};
        assertThat(valorMinimo, is(metodo.invoke(pilotoLibre, valorNegativo)));
        Object valorSuperior[] = {5.1};
        assertThat(valorMaximo, is(metodo.invoke(pilotoLibre, valorSuperior)));
    }

    @Test
    public void test_Valores_Fuera_De_Rango_En_Caracteristicas() {
        PilotoLibre piloto = new PilotoLibre(nombre, apellidos, edad, altura, peso, -1.0, -0.5, 5.1, 10.0);
        Double reflejosEstimados = 0.0;
        assertThat(reflejosEstimados, is(piloto.getReflejos()));
        Double agresividadEstimada = 0.0;
        assertThat(agresividadEstimada, is(piloto.getAgresividad()));
        Double pacienciaEstimada = PilotoBase.VALOR_MAXIMO_CARACTERISTICAS;
        assertThat(pacienciaEstimada, is(piloto.getPaciencia()));
        Double valentiaEstimada = PilotoBase.VALOR_MAXIMO_CARACTERISTICAS;
        assertThat(valentiaEstimada, is(piloto.getValentia()));
    }
    
    @Test
    public void test_GetSueldo() {
        Double valoracionGlobal = pilotoLibre.getValoraciónGlobal();
        Double sueldoEstimado = (valoracionGlobal * PilotoLibre.EUROS_POR_VALORACION);
        assertThat(sueldoEstimado, is(pilotoLibre.getSueldo()));
    }
    
}
