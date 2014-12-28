package formula;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class CocheTest {
    
    private String modelo = "FW37";
    private Double potencia = 4.5;
    private Double aerodinamica = 3.8;
    private Double neumaticos = 4.0;
    private Coche coche = new Coche(modelo, potencia, aerodinamica, neumaticos);
    
    private String nombre = "Spa-Francorchamps";
    private Integer aforo = 1;
    private Integer canon = 1;
    private Double[] rectas = {1334.33, 1334.33, 1334.33};
    private Double[] curvas = {600.0, 600.0, 600.0, 600.0, 600.0};
    private Circuito circuito = new Circuito(nombre, aforo, canon, rectas, curvas);
    
    @Test
    public void test_getValorCaracteristicaEnLimite() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Double valorMinimo = Coche.VALOR_MINIMO_CARACTERISTICAS;
        Double valorMaximo = Coche.VALOR_MAXIMO_CARACTERISTICAS;
        Class clase = coche.getClass();
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
        assertThat(valorMinimo, is(metodo.invoke(coche, valorNegativo)));
        Object valorSuperior[] = {5.1};
        assertThat(valorMaximo, is(metodo.invoke(coche, valorSuperior)));
    }
    
    @Test
    public void test_Entrenar() {
        coche.entrenar();
        Double potenciaEsperada = potencia + Coche.INCREMENTO_MEJORA;
        assertThat(potenciaEsperada, is(coche.getPotencia()));
        Double aerodinamicaEsperada = aerodinamica + Coche.INCREMENTO_MEJORA;
        assertThat(aerodinamicaEsperada, is(coche.getAerodinamica()));
        Double neumaticosEsperados = neumaticos + Coche.INCREMENTO_MEJORA;
        assertThat(neumaticosEsperados, is(coche.getNeumaticos()));
    }
    
    @Test
    public void test_Get_Velocidad_En_Recta() {
        Double velocidadEstimada;
        velocidadEstimada = potencia * Coche.FACTOR_POTENCIA_RECTA;
        velocidadEstimada += (aerodinamica + Coche.FACTOR_AERODINAMICA_RECTA);
        assertThat(velocidadEstimada, is(coche.getVelocidadEnRecta()));
    }
    
    @Test
    public void test_Get_Velocidad_En_Curva() {
        Double velocidadEstimada;
        velocidadEstimada = potencia * Coche.FACTOR_POTENCIA_CURVA;
        velocidadEstimada += (aerodinamica + Coche.FACTOR_AERODINAMICA_CURVA);
        velocidadEstimada += (neumaticos + Coche.FACTOR_NEUMATICOS_CURVA);
        assertThat(velocidadEstimada, is(coche.getVelocidadEnCurva()));
    }
    
    @Test
    public void test_Get_Tiempo_Por_Vuelta() {
        Double tiempoEstimado = 0.0;
        Double distanciaRecta = circuito.getDistanciaRecta();
        Double velocidadRecta = coche.getVelocidadEnRecta();
        tiempoEstimado += velocidadRecta / distanciaRecta;
        Double distanciaCurva = circuito.getDistanciaCurva();
        Double velocidadCurva = coche.getVelocidadEnCurva();
        tiempoEstimado += velocidadCurva / distanciaCurva;
        tiempoEstimado *= 3600;
        assertThat(tiempoEstimado, is(coche.getTiempoPorVuelta(circuito)));
    }
}
