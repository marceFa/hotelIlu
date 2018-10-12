
package hotelilusion.modelo;

/**
 *
 * @author agus
 */
public class Tipo_habitacion {
    private int id_tipoHabitacion;

    public Tipo_habitacion(int id_tipoHabitacion, String descripcion) {
        this.id_tipoHabitacion = id_tipoHabitacion;
        this.descripcion = descripcion;
    }

    Tipo_habitacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    private String descripcion;

    void setId_tipohabitacion(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

    