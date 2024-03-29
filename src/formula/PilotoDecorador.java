package formula;

/**
 * @author Daniel López
 * @version 1.0
 * @since 20-12-2014
 */

public abstract class PilotoDecorador extends PilotoBase {
    
    protected PilotoLibre piloto;

    public PilotoDecorador(PilotoLibre piloto) {
        this.piloto = piloto;
    }
    
    public abstract void entrenar();
 
      /**
     * Devuelve el nombre completo del Piloto en un String.
     * @return NombreCompleto;
     */      
    @Override
    public String toString() {
        return getNombreCompleto();
    }

    public PilotoLibre getPiloto() {
        return piloto;
    }
    
    public String getNombreCompleto() {
        return piloto.getNombreCompleto();
    }
    
    public Double getValoraciónGlobal() {
        return piloto.getValoraciónGlobal();
    }
    
    public Integer getSueldo() {
        return piloto.getSueldo();
    }
     /**
     * Suma los puntos introducidos al total de puntos del Piloto.
     * @param puntos;
     */      
    public void sumarPuntos(Integer puntos) {
        piloto.sumarPuntos(puntos);
    }
    
    public String getNombre() {
        return piloto.getNombre();
    }

    public void setNombre(String nombre) {
        piloto.setNombre(nombre);
    }

    public String getApellidos() {
        return piloto.getApellidos();
    }

    public void setApellidos(String apellidos) {
        piloto.setApellidos(apellidos);
    }

    public Integer getEdad() {
        return piloto.getEdad();
    }

    public void setEdad(Integer edad) {
        piloto.setEdad(edad);
    }

    public Integer getAltura() {
        return piloto.getAltura();
    }

    public void setAltura(Integer altura) {
        piloto.setAltura(altura);
    }

    public Integer getPeso() {
        return piloto.getPeso();
    }

    public void setPeso(Integer peso) {
        piloto.setPeso(peso);
    }

    public Integer getPuntos() {
        return piloto.getPuntos();
    }

    public void setPuntos(Integer puntos) {
        piloto.setPuntos(puntos);
    }

    public Double getReflejos() {
        return piloto.getReflejos();
    }

    public void setReflejos(Double reflejos) {
        piloto.setReflejos(reflejos);
    }

    public Double getAgresividad() {
        return piloto.getAgresividad();
    }

    public void setAgresividad(Double agresividad) {
        piloto.setAgresividad(agresividad);
    }

    public Double getPaciencia() {
        return piloto.getPaciencia();
    }

    public void setPaciencia(Double paciencia) {
        piloto.setPaciencia(paciencia);
    }

    public Double getValentia() {
        return piloto.getValentia();
    }

    public void setValentia(Double valentia) {
        piloto.setValentia(valentia);
    }
   
}
