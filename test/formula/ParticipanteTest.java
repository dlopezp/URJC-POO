package formula;

import java.util.Set;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;



public class ParticipanteTest {

    //Composición de coche
    private String modelo = "FW37";
    private Double potencia = 4.5;
    private Double aerodinamica = 3.8;
    private Double neumaticos = 4.0;
    
    private Coche coche = new Coche(modelo, potencia, aerodinamica, neumaticos);

    //Composicion piloto
    private String nombre = "Jim";
    private String apellidos = "Clark";
    private Integer edad = 24;
    private Integer altura = 160;
    private Integer peso = 60;
    private Double reflejos = 4.0;
    private Double agresividad = 2.5;
    private Double paciencia = 4.5;
    private Double valentia = 3.3;    
    PilotoLibre pilotoLibre = new PilotoLibre(nombre, apellidos, edad, altura, peso, reflejos, agresividad, paciencia, valentia);
    PilotoOficial piloto = new PilotoOficial(pilotoLibre);
    
    //Composicion de Escuderia
    private String nombreEscuderia ="Ferrari";
    private String paisEscuderia = "Italia";
    private Integer añoEscuderia = 1930;
    private Integer presupuestoEscuderia = 50000;    
    private Set<PilotoOficial> pilotosOficiales;
    private Set<Coche> coches;
    private Set<PilotoProbador> pilotosProbadores;
    private String[] directivos = {"Maurizio Arrivarrene", "Piero Ferrari"};
   
    // Datos Piloto Libre1
    private String nombrePiloto1 = "Jim";
    private String apellidosPiloto1 = "Clark";
    private Integer edadPiloto1 = 24;
    private Integer alturaPiloto1 = 160;
    private Integer pesoPiloto1 = 60;
    private Double reflejosPiloto1 = 4.0;
    private Double agresividadPiloto1 = 2.5;
    private Double pacienciaPiloto1 = 4.5;
    private Double valentiaPiloto1 = 3.3;
    private PilotoLibre pilotoLibre1 = new PilotoLibre(nombrePiloto1, apellidosPiloto1, edadPiloto1, alturaPiloto1, pesoPiloto1, reflejosPiloto1, agresividadPiloto1, pacienciaPiloto1, valentiaPiloto1);
    
    private String nombrePiloto2 = "Jim";
    private String apellidosPiloto2 = "Clarkk";
    private Integer edadPiloto2 = 24;
    private Integer alturaPiloto2 = 160;
    private Integer pesoPiloto2 = 60;
    private Double reflejosPiloto2 = 4.0;
    private Double agresividadPiloto2 = 2.5;
    private Double pacienciaPiloto2 = 4.5;
    private Double valentiaPiloto2 = 3.3;    
    private PilotoLibre pilotoLibre2 = new PilotoLibre(nombrePiloto2, apellidosPiloto2, edadPiloto2, alturaPiloto2, pesoPiloto2, reflejosPiloto2, agresividadPiloto2, pacienciaPiloto2, valentiaPiloto2);

    
    private String nombrePiloto3 = "Pep";
    private String apellidosPiloto3 = "Dee";
    private Integer edadPiloto3 = 30;
    private Integer alturaPiloto3 = 170;
    private Integer pesoPiloto3 = 80;
    private Double reflejosPiloto3 = 1.0;
    private Double agresividadPiloto3 = 1.5;
    private Double pacienciaPiloto3 = 1.5;
    private Double valentiaPiloto3 = 1.3;    
    private PilotoLibre pilotoLibre3 = new PilotoLibre(nombrePiloto3, apellidosPiloto3, edadPiloto3, alturaPiloto3, pesoPiloto3, reflejosPiloto3, agresividadPiloto3, pacienciaPiloto3, valentiaPiloto3);
    
    private String nombrePiloto4 = "Pep";
    private String apellidosPiloto4 = "Dee";
    private Integer edadPiloto4 = 30;
    private Integer alturaPiloto4 = 170;
    private Integer pesoPiloto4 = 80;
    private Double reflejosPiloto4 = 1.0;
    private Double agresividadPiloto4 = 1.5;
    private Double pacienciaPiloto4 = 1.5;
    private Double valentiaPiloto4 = 1.3;    
    private PilotoLibre pilotoLibre4 = new PilotoLibre(nombrePiloto3, apellidosPiloto3, edadPiloto3, alturaPiloto3, pesoPiloto3, reflejosPiloto3, agresividadPiloto3, pacienciaPiloto3, valentiaPiloto3);
    
    
    private Escuderia escuderia = new Escuderia(nombreEscuderia, paisEscuderia, añoEscuderia, presupuestoEscuderia, directivos);
    
    
    Participante participante = new Participante(escuderia, piloto, coche);
    
    
    @Test 
    public void test_sumarPuntos(){
       int puntos = 10;
       int valorEsperadoEscuderia = escuderia.getPuntos()+puntos;
       int valorEsperadoPiloto = piloto.getPuntos()+puntos;
       
       participante.sumarPuntos(puntos);
       assertThat(valorEsperadoEscuderia, is(escuderia.getPuntos()));
       assertThat(valorEsperadoPiloto, is(piloto.getPuntos()));
   } 
   
   
   @Test
   public void getTiempoPorVuelta(){
        String nombre = "Spa-Francorchamps";
        Integer aforo = 1;
        Integer canon = 1;
        Tramo[] rectas = {new Tramo(10.00), new Tramo(0.00),new Tramo(0.00),new Tramo(0.00)};
        Tramo[] curvas = {new Tramo(0.00),new Tramo(0.00),new Tramo(0.00),new Tramo(0.00)};
        Circuito circuito = new Circuito(nombre, aforo, canon, rectas, curvas);
        
        Double valoracionGlobalPiloto = 1.00;

        Double tiempo = (this.coche.getTiempoPorVuelta(circuito)) - (0.1 * piloto.getValoraciónGlobal());
        assertTrue(tiempo>1000);
    }
    
    
    
    
    
    
    
}
