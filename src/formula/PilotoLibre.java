package formula;

import java.io.Serializable;

public class PilotoLibre extends PilotoBase implements Serializable {
    
    protected String nombre;
    protected String apellidos;
    protected Integer edad;
    protected Double altura;
    protected Double peso;
    protected Integer puntos;
    protected Double reflejos;
    protected Double agresividad;
    protected Double paciencia;
    protected Double valentia;
    
    public PilotoLibre(
            String nombre, 
            String apellidos, 
            Integer edad, 
            Double altura, 
            Double peso, 
            Double reflejos, 
            Double agresividad, 
            Double paciencia, 
            Double valentia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.reflejos = getValorCaracteristicaEnLimite(reflejos);
        this.agresividad = getValorCaracteristicaEnLimite(agresividad);
        this.paciencia = getValorCaracteristicaEnLimite(paciencia);
        this.valentia = getValorCaracteristicaEnLimite(valentia);
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
    
    public Double getSueldo() {
        Double sueldo;
        sueldo = reflejos + agresividad + paciencia + valentia;
        sueldo *= EUROS_POR_VALORACION;
        return sueldo;
    }
    
    public Double getValoraciónGlobal() {
        return reflejos + agresividad + paciencia + valentia;
    }
    
    public void sumarPuntos(Integer puntos) {
        this.puntos += puntos;
    }
    
    protected void mejorar(Double mejora) {
        setReflejos(reflejos + mejora);
        setAgresividad(agresividad + mejora);
        setPaciencia(paciencia + mejora);
        setValentia(valentia + mejora);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Double getReflejos() {
        return reflejos;
    }

    public void setReflejos(Double reflejos) {
        this.reflejos = getValorCaracteristicaEnLimite(reflejos);
    }

    public Double getAgresividad() {
        return agresividad;
    }

    public void setAgresividad(Double agresividad) {
        this.agresividad = getValorCaracteristicaEnLimite(agresividad);
    }

    public Double getPaciencia() {
        return paciencia;
    }

    public void setPaciencia(Double paciencia) {
        this.paciencia = getValorCaracteristicaEnLimite(paciencia);
    }

    public Double getValentia() {
        return valentia;
    }

    public void setValentia(Double valentia) {
        this.valentia = getValorCaracteristicaEnLimite(valentia);
    }
}
