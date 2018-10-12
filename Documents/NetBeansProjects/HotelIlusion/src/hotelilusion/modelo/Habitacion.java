
package hotelilusion.modelo;

import hotelilusion.modelo.Tipo_habitacion;
import java.time.LocalDate;

/**
 *
 * @author agus
 */
public class Habitacion {
    private int id_habitacion=-1;
    private int numero;
    private int piso;
    private String caracteristicas;
    private int cant_personas;
    private int cant_de_camas;
    private double precio_diario;
    private Tipo_habitacion id_tipohabitacion;

    public Habitacion(int numero, int piso, String caracteristicas, int cant_personas, int cant_de_camas, double precio_diario, Tipo_habitacion id_tipohabitacion) {
        this.id_habitacion = -1;
        this.numero = numero;
        this.piso = piso;
        this.caracteristicas = caracteristicas;
        this.cant_personas = cant_personas;
        this.cant_de_camas = cant_de_camas;
        this.precio_diario = precio_diario;
        this.id_tipohabitacion = id_tipohabitacion;
    }

    public Habitacion(int id_habitacion,int numero, int piso, String caracteristicas, int cant_personas, int cant_de_camas, double precio_diario, Tipo_habitacion id_tipohabitacion) {
        
        this.id_habitacion = id_habitacion;
        this.numero = numero;
        this.piso = piso;
        this.caracteristicas = caracteristicas;
        this.cant_personas = cant_personas;
        this.cant_de_camas = cant_de_camas;
        this.precio_diario = precio_diario;
        this.id_tipohabitacion = id_tipohabitacion;
    }

         
         public Habitacion(){
        this.id_habitacion = -1;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public int getCant_personas() {
        return cant_personas;
    }

    public void setCant_personas(int cant_personas) {
        this.cant_personas = cant_personas;
    }

    public int getCant_de_camas() {
        return cant_de_camas;
    }

    public void setCant_de_camas(int cant_de_camas) {
        this.cant_de_camas = cant_de_camas;
    }

    public double getPrecio_diario() {
        return precio_diario;
    }

    public void setPrecio_diario(double precio_diario) {
        this.precio_diario = precio_diario;
    }

    public Tipo_habitacion getId_tipohabitacion() {
        return id_tipohabitacion;
    }

    public void setId_tipohabitacion(Tipo_habitacion id_tipohabitacion) {
        this.id_tipohabitacion = id_tipohabitacion;
    }
    
}