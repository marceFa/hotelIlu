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
   private Tipo_habitacion tipo_habitacion;
   private LocalDate fecha_de_reserva;
   private LocalDate fecha_de_ingreso;// fechaCheckin,fecha de entrada
   private LocalDate fecha_de_egreso;// fechaCheckout,fecha de salida
   private int cant_personas;
   private int estado;//si es 1 esta ocupado
   private double costoalojamiento;

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

    public Tipo_habitacion getTipo_de_habitacion() {
        return tipo_habitacion;
    }

    public void setTipo_habitacion(Tipo_habitacion tipo_habitacion) {
        this.tipo_habitacion = tipo_habitacion;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public double getCostoalojamiento() {
        return costoalojamiento;
    }

    public void setCostoalojamiento(double costoalojamiento) {
        this.costoalojamiento = costoalojamiento;
    }

    

    
    public Reserva(int id_reserva, Habitacion id_habitacion, Huesped id_huesped, Tipo_habitacion tipo_habitacion, LocalDate fecha_de_reserva, LocalDate fecha_de_ingreso, LocalDate fecha_de_egreso, int cant_personas, int estado, double costoalojamiento) {
        this.id_reserva = id_reserva;
        this.id_habitacion = id_habitacion;
        this.id_huesped = id_huesped;
        this.tipo_habitacion = tipo_habitacion;
        this.fecha_de_reserva = fecha_de_reserva;
        this.fecha_de_ingreso = fecha_de_ingreso;
        this.fecha_de_egreso = fecha_de_egreso;
        this.cant_personas = cant_personas;
        this.estado = estado;
        this.costoalojamiento = costoalojamiento;
    }
     public Reserva( Habitacion id_habitacion, Huesped id_huesped, Tipo_habitacion tipo_habitacion, LocalDate fecha_de_reserva, LocalDate fecha_de_ingreso, LocalDate fecha_de_egreso, int cant_personas, int estado, double costoalojamiento) {
        this.id_reserva=-1;
        this.id_habitacion = id_habitacion;
        this.id_huesped = id_huesped;
        this.tipo_habitacion = tipo_habitacion;
        this.fecha_de_reserva = fecha_de_reserva;
        this.fecha_de_ingreso = fecha_de_ingreso;
        this.fecha_de_egreso = fecha_de_egreso;
        this.cant_personas = cant_personas;
        this.estado = estado;
        this.costoalojamiento = costoalojamiento;
    }
      public Reserva(){
        this.id_reserva = -1;
    }
      
      
      
    
}
