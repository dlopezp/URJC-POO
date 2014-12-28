package formula;

import java.io.Serializable;

public abstract class PilotoDecorador extends PilotoBase implements Serializable {
    
    protected PilotoLibre piloto;

    public PilotoDecorador(PilotoLibre piloto) {
        this.piloto = piloto;
    }
    
    public abstract void entrenar();

    public PilotoLibre getPiloto() {
        return piloto;
    }
    
    public Double getValoraciónGlobal() {
        return piloto.getValoraciónGlobal();
    }
    
    public Integer getSueldo() {
        return piloto.getSueldo();
    }
    
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
