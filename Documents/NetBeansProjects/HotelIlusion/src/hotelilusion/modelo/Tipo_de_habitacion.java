
package hotelIlusion.modelo;

/**
 *
 * @author Noelia
 */
public class Tipo_de_habitacion {
    private int id_tipo_de_camas;
    private String descripcion;

    public int getId_tipo_de_camas() {
        return id_tipo_de_camas;
    }

    public void setId_tipo_de_camas(int id_tipo_de_camas) {
        this.id_tipo_de_camas = id_tipo_de_camas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tipo_de_habitacion(int id_tipo_de_camas, String descripcion) {
        this.id_tipo_de_camas = id_tipo_de_camas;
        this.descripcion = descripcion;
    }
    
}
