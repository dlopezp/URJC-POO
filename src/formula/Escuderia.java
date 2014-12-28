package formula;
import java.util.*;
import javax.swing.JFrame;

public class Escuderia {
    private String nombre;
    private String pais;
    private Integer año;
    private double presup;
    private Integer puntos;
    private Set<PilotoOficial> p_oficiales;
    private Set<Coche> coches;
    private Set<PilotoProbador> p_probadores;
    String dueño;
    
    public Escuderia( 
            String nombre,
            String pais,
            Integer año,
            double presup,
            Integer puntos,
            Set<PilotoOficial> p_oficial,
            Set<Coche> coches,
            Set<PilotoProbador> p_probador,
            String dueño){
        this.nombre = nombre;
        this.pais = pais;
        this.año = año;
        this.presup = presup;
        this.puntos = puntos;
        this.p_oficiales = p_oficial;
        this.coches = coches;
        this.p_probadores = p_probador;
        this.dueño = dueño;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public double getPresup() {
        return presup;
    }

    public void setPresup(double presup) {
        this.presup = presup;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }
    
    public Set<PilotoOficial> getP_oficiales() {
        return p_oficiales;
    }

    public void setP_oficiales(Set<PilotoOficial> p_oficiales) {
        this.p_oficiales = p_oficiales;
    }

    public Set<Coche> getCoches() {
        return coches;
    }

    public void setCoches(Set<Coche> coches) {
        this.coches = coches;
    }

    public Set<PilotoProbador> getP_probadores() {
        return p_probadores;
    }

    public void setP_probadores(Set<PilotoProbador> p_probadores) {
        this.p_probadores = p_probadores;
    }

    
    public boolean puedeFicharPilotoOficial(){
        return (this.getP_oficiales().size() <2);
    }
    
    public boolean puedeFicharPilotoProbador(){
        return (this.getP_probadores().size() <2);
    }
    
    
    public boolean tienePresupuestoSuficiente(PilotoLibre p){
            return (getPresup()- p.getSueldo()) >= 0;
    }
    
    
    public void ficharPiloto(PilotoOficial p){
            if (puedeFicharPilotoOficial() & tienePresupuestoSuficiente(p.getPiloto())){
            this.p_oficiales.add(p);
            pagarSueldoAPiloto(p);
            System.out.println("piloto fichado");
            }
        else
            System.out.println("No puede fichar a este piloto");
    }
    
        public void ficharPiloto(PilotoProbador p){
            if (puedeFicharPilotoProbador() & tienePresupuestoSuficiente(p.getPiloto())){
            this.p_probadores.add(p);
            pagarSueldoAPiloto(p);
            System.out.println("piloto fichado");
            }
        else
            System.out.println("No puede fichar a este piloto");
    }
    
   
    public boolean puedeIntercambiarPiloto(PilotoLibre p1, PilotoLibre p2){
        return (p1.getValoraciónGlobal() < (p2.getValoraciónGlobal()*1.1)) && 
               (p2.getValoraciónGlobal() < (p1.getValoraciónGlobal()*1.1));
    }
    
    
    public boolean esOficial(PilotoLibre p){
        Iterator<PilotoOficial> it = this.p_oficiales.iterator();
        boolean encontrado = false;
        while (it.hasNext() & !encontrado){
                PilotoOficial p_it = it.next();
                if (p_it.getPiloto()== p)
                    encontrado = true;
        }        
        return encontrado;
    }
    
    public void intercambiarPiloto(PilotoLibre p_venta, PilotoLibre p_compra){
        if (puedeIntercambiarPiloto(p_venta, p_compra)){
            if (esOficial(p_venta)){
                if(puedeFicharPilotoOficial() ){
                   PilotoOficial p_vendido = new PilotoOficial(p_venta);
                   Iterator<PilotoOficial> it_oficiales = this.p_oficiales.iterator();
                   boolean borrado = false;
                   while (it_oficiales.hasNext() & !borrado){
                       if (it_oficiales.next().equals(p_vendido)){
                           it_oficiales.remove();
                           borrado = true;
                       }    
                   }
                   PilotoOficial p_comprado = new PilotoOficial(p_compra);
                   p_oficiales.add(p_comprado) ;
                }
                else
                    System.out.println("No se puede fichar, pilotos oficiales completos");
            }
            else{
                if(puedeFicharPilotoProbador()){
                   PilotoProbador p_vendido = new PilotoProbador(p_venta); 
                   Iterator<PilotoProbador> it_probador = this.p_probadores.iterator();
                   boolean borrado = false;
                   while (it_probador.hasNext() & !borrado)
                       if (it_probador.next().equals(p_vendido)){
                           it_probador.remove();
                           borrado = true;
                       }    
                }
                else
                    System.out.println("No se puede fichar, pilotos probadores completos");
            }
        }
    }
    
    
    public boolean puedeFabricarCoche(){
       return getCoches().size() < 2;
    }
    
    public void pagarSueldoAPiloto(PilotoDecorador p){
        this.presup = this.presup - p.getSueldo();
    }
    
    
    
    public boolean puedeDescartarPilotoOficial(){
        return this.getP_oficiales().size()>1;
    }
    

    
    public boolean puedeEntrenar(Circuito c){
        return (getPresup() - c.getCanon()) >= 0;
    }
    
    public void entrenar(Circuito circuit, PilotoDecorador p, Coche c ){
        if (puedeEntrenar(circuit)){
            setPresup(getPresup()-circuit.getCanon());
            c.mejorar();
            p.entrenar();
        }
    } 
    

    
    public void fabricarCoche(String modelo, Double potencia, Double aerodinamica, Double neumaticos){
        if (puedeFabricarCoche()){
           Coche co = new Coche(modelo, potencia, aerodinamica, neumaticos);
           this.coches.add(co);
        }
    }
    
    
    public void descartarPiloto(PilotoOficial p){
        if (puedeDescartarPilotoOficial())
                this.p_oficiales.remove(p);
        else
            System.err.println("No se puede descartar");
    }
    
    public void descartarPiloto(PilotoProbador p){
        this.p_probadores.remove(p);
    }

    
    public void sumarPuntos(Integer puntos){
        setPuntos(this.puntos + puntos); 
    }
    
    public Participante configurarCarrera(Carrera race, PilotoOficial piloto, Coche c){
        Participante parti = new Participante(this,piloto, c); 
        return parti;
    }
    
    public ArrayList<Participante> configurarCarrera(Carrera race){
       ArrayList<Participante> participantes = new ArrayList<>();
       Iterator<PilotoOficial> it_oficiales = this.p_oficiales.iterator();
       Iterator<Coche> it_coches = this.coches.iterator();
       
       int total = Math.min(this.coches.size(), this.p_oficiales.size());
       for (int i=0; i<total; i++){
           participantes.add(Participante(it_oficiales.next(),it_coches.next()));
           i++;
       }
       return participantes;
    }
    
    public void obtenerPremio()

    public boolean puedeParticiparEnCarrera(Carrera race){
        
        }

    
    
}
    

