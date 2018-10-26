package hotelilusion.modelo;

import java.time.LocalDate;

/**
 *
 * @author Noelia
 */
public class Reserva {
   private int id_reserva=-1; 
   private Habitacion id_habitacion;
   private Huesped id_huesped;
   private boolean estado;
   private LocalDate fecha_de_reserva;
   private LocalDate fecha_de_ingreso;// fechaCheckin,fecha de entrada
   private LocalDate fecha_de_egreso;// fechaCheckout,fecha de salida
   private int cant_personas;
   private double costoalojamiento;
   private String observacion;

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Habitacion getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(Habitacion id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public Huesped getId_huesped() {
        return id_huesped;
    }

    public void setId_huesped(Huesped id_huesped) {
        this.id_huesped = id_huesped;
    }

   

    

    public LocalDate getFecha_de_reserva() {
        return fecha_de_reserva;
    }

    public void setFecha_de_reserva(LocalDate fecha_de_reserva) {
        this.fecha_de_reserva = fecha_de_reserva;
    }

    public LocalDate getFecha_de_ingreso() {
        return fecha_de_ingreso;
    }

    public void setFecha_de_ingreso(LocalDate fecha_de_ingreso) {
        this.fecha_de_ingreso = fecha_de_ingreso;
    }

    public LocalDate getFecha_de_egreso() {
        return fecha_de_egreso;
    }

    public void setFecha_de_egreso(LocalDate fecha_de_egreso) {
        this.fecha_de_egreso = fecha_de_egreso;
    }

    public int getCant_personas() {
        return cant_personas;
    }

    public void setCant_personas(int cant_personas) {
        this.cant_personas = cant_personas;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getCostoalojamiento() {
        return costoalojamiento;
    }

    public void setCostoalojamiento(double costoalojamiento) {
        this.costoalojamiento = costoalojamiento;
    }

    

   
    public Reserva(int id_reserva, Habitacion id_habitacion, Huesped id_huesped, LocalDate fecha_de_reserva, LocalDate fecha_de_ingreso, LocalDate fecha_de_egreso, int cant_personas, boolean estado, double costoalojamiento, String observacion) {
        this.id_reserva = id_reserva;
        this.id_habitacion = id_habitacion;
        this.id_huesped = id_huesped;
        
        this.fecha_de_reserva = fecha_de_reserva;
        this.fecha_de_ingreso = fecha_de_ingreso;
        this.fecha_de_egreso = fecha_de_egreso;
        this.cant_personas = cant_personas;
        this.estado = estado;
        this.costoalojamiento = costoalojamiento;
        this.observacion=observacion;
    }
     public Reserva( Habitacion id_habitacion, Huesped id_huesped, LocalDate fecha_de_reserva, LocalDate fecha_de_ingreso, LocalDate fecha_de_egreso, int cant_personas, boolean estado, double costoalojamiento,String observacion) {
        this.id_reserva=-1;
        this.id_habitacion = id_habitacion;
        this.id_huesped = id_huesped;
       
        this.fecha_de_reserva = fecha_de_reserva;
        this.fecha_de_ingreso = fecha_de_ingreso;
        this.fecha_de_egreso = fecha_de_egreso;
        this.cant_personas = cant_personas;
        this.estado = estado;
        this.costoalojamiento = costoalojamiento;
         this.observacion=observacion;
    }
      public Reserva(){
        this.id_reserva = -1;
    }

   
      
      
      
    
}
