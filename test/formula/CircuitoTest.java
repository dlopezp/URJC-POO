package formula;

import static org.hamcrest.core.Is.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class CircuitoTest {
    
    private String nombre = "Spa-Francorchamps";
    private Integer aforo = 1;
    private Integer canon = 1;
    private Tramo[] rectas = {new Tramo(1334.33), new Tramo(1334.33), new Tramo(1334.33)};
    private Tramo[] curvas = {new Tramo(600.00), new Tramo(600.00), new Tramo(600.00)};
    
            
    
    private Circuito circuito = new Circuito(nombre, aforo, canon, rectas, curvas);
    
    @Test
    public void test_Get_Distancia_Recta() {
        Double distanciaEstimada = 0.0;
        for (Tramo recta : rectas) {
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
