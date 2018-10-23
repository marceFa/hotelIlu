
package hotelilusion.modelo;

/**
 *
 * @author agus
 */
public class Tipo_habitacion {
    private int id_tipoHabitacion;
    private String descripcion;

    public Tipo_habitacion(int id_tipoHabitacion, String descripcion) {
        this.id_tipoHabitacion = id_tipoHabitacion;
        this.descripcion = descripcion;
    }
    public Tipo_habitacion(String descripcion){
    this.id_tipoHabitacion=-1;
    this.descripcion=descripcion;
    }
    public Tipo_habitacion(){
    this.id_tipoHabitacion=-1;
    }

    public int getId_tipoHabitacion() {
        return id_tipoHabitacion;
    }

    public void setId_tipoHabitacion(int id_tipoHabitacion) {
        this.id_tipoHabitacion = id_tipoHabitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
 
    
    
}