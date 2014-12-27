
package formula;

import static org.hamcrest.core.Is.is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CircuitoTest {
    
    private String nombre = "Spa-Francorchamps";
    private Integer aforo = 1;
    private Integer canon = 1;
    private Double[] rectas = {1334.33, 1334.33, 1334.33};
    private Double[] curvas = {600.0, 600.0, 600.0, 600.0, 600.0};
    private Circuito circuito;
    
    @Before
    public void setUp() {
        circuito = new Circuito(nombre, aforo, canon, rectas, curvas);
    }
    
    @Test
    public void test_Get_Distancia_Recta() {
        Double distanciaEstimada = 0.0;
        for (Double recta : rectas) {
            distanciaEstimada += recta;
        }
        assertThat(distanciaEstimada, is(circuito.getDistanciaRecta()));
    }
    
    @Test
    public void test_Get_Distancia_Curva() {
        Double distanciaEstimada = 0.0;
        for (Double curva : curvas) {
            distanciaEstimada += curva;
        }
        assertThat(distanciaEstimada, is(circuito.getDistanciaCurva()));
    }
}
