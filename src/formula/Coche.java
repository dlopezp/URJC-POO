package formula;


import java.io.Serializable;
import java.text.NumberFormat;

/**
 * @author Eduardo Benito Fernández
 */

public class Coche implements Serializable {
 
    private String modelo;
    private Double potencia;
    private Double aerodinamica;
    private Double neumaticos;
    
    public static final Double VALOR_MINIMO_CARACTERISTICAS = 0.0;
    public static final Double VALOR_MAXIMO_CARACTERISTICAS = 5.0;
    public static final Integer FACTOR_POTENCIA_RECTA = 20;
    public static final Integer FACTOR_AERODINAMICA_RECTA = 30;
    public static final Integer FACTOR_POTENCIA_CURVA = 10;
    public static final Integer FACTOR_AERODINAMICA_CURVA = 10;
    public static final Integer FACTOR_NEUMATICOS_CURVA = 10;
    public static final Double INCREMENTO_MEJORA = 0.1;

    public Coche(String modelo, Double potencia, Double aerodinamica, Double neumaticos) {
        this.modelo = modelo;
        this.potencia = getValorCaracteristicaEnLimite(potencia);
        this.aerodinamica = getValorCaracteristicaEnLimite(aerodinamica);
        this.neumaticos = getValorCaracteristicaEnLimite(neumaticos);
    }
    
    private Double getValorCaracteristicaEnLimite(Double valor) {
        Double valorSeguro;
        if (valor < 0) {
            valorSeguro = 0.0;
        } else if (valor > VALOR_MAXIMO_CARACTERISTICAS) {
            valorSeguro = VALOR_MAXIMO_CARACTERISTICAS;
        } else {
            valorSeguro = valor;
        }
        return valorSeguro;
    }
    
    
    public Double getVelocidadEnRecta() {
        Double velocidad;
        velocidad = potencia * FACTOR_POTENCIA_RECTA;
        velocidad += (aerodinamica + FACTOR_AERODINAMICA_RECTA);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        return Double.valueOf(nf.format(velocidad));
    }
    
    public Double getVelocidadEnCurva() {
        Double velocidad;
        velocidad = potencia * FACTOR_POTENCIA_CURVA;
        velocidad += (aerodinamica + FACTOR_AERODINAMICA_CURVA);
        velocidad += (neumaticos + FACTOR_NEUMATICOS_CURVA);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        return Double.valueOf(nf.format(velocidad));
    }
    
    public void entrenar() {
        setPotencia(potencia + INCREMENTO_MEJORA);
        setAerodinamica(aerodinamica + INCREMENTO_MEJORA);
        setNeumaticos(neumaticos + INCREMENTO_MEJORA);
    }
    
    public Double getTiempoPorVuelta(Circuito circuito) {
        Double tiempo = 0.0;
        Double distanciaRecta = circuito.getDistanciaRecta();
        Double velocidadRecta = getVelocidadEnRecta();
        tiempo += velocidadRecta / distanciaRecta;
        Double distanciaCurva = circuito.getDistanciaCurva();
        Double velocidadCurva = getVelocidadEnCurva();
        tiempo += velocidadCurva / distanciaCurva;
        tiempo *= 3600;
        return tiempo;
    }
    
    @Override
    public String toString() {
        return modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPotencia() {
        return potencia;
    }

    public void setPotencia(Double potencia) {
        this.potencia = getValorCaracteristicaEnLimite(potencia);
    }

    public Double getAerodinamica() {
        return aerodinamica;
    }

    public void setAerodinamica(Double aerodinamica) {
        this.aerodinamica = getValorCaracteristicaEnLimite(aerodinamica);
    }

    public Double getNeumaticos() {
        return neumaticos;
    }

    public void setNeumaticos(Double neumaticos) {
        this.neumaticos = getValorCaracteristicaEnLimite(neumaticos);
    }
}
