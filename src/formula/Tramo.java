package formula;

import java.io.Serializable;

/**
 *
 * @author jaimedemora
 */

public class Tramo implements Serializable {
    Double distancia; 

    public Tramo (Double distancia){
        this.distancia = distancia;
    }
    
    public Double getDistancia(){
    return distancia;
}

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }
    
}
