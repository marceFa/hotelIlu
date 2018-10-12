package hotelilusion.modelo;

import hotelilusion.modelo.Tipo_habitacion;
import hotelilusion.modelo.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import javaapplication1.modelo.Conexion;
//import javaapplication1.modelo.Tipo_de_habitacion;

/**
 *
 * @author Noelia
 */
public class Tipo_habitacionData {
    private Connection connection = null;

    public Tipo_habitacionData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    
    
    public void guardarTipo_habitacion(Tipo_habitacion tipo_habitacion){
        try {
            
            String sql = "INSERT INTO tipo_de_habitacion (id_habitacion, descripcion) VALUES ( ?, ?);";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, tipo_habitacion.getId_tipoHabitacion());
            statement.setString(2, tipo_habitacion.getDescripcion());
            
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                tipo_habitacion.setId_tipohabitacion(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id_tipo_de_habitacion luego de insertar una tipo_de_habitacion");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar una tipo_de_habitacion: " + ex.getMessage());
        }
    }
    
    public List<Tipo_habitacion> obtenerTipo_habitacion(){
        List<Tipo_habitacion> tipo_habitaciones = new ArrayList<Tipo_habitacion>();
            

        try {
            String sql = "SELECT * FROM tipo_habitacion;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Tipo_habitacion tipo_habitacion;
            while(resultSet.next()){
                tipo_habitacion = new Tipo_habitacion();
                tipo_habitacion.setId_tipoHabitacion(resultSet.getInt("id_tipo_habitacion"));
                tipo_habitacion.setDescripcion(resultSet.getString("descripcion"));
                
                tipo_habitaciones.add((Tipo_habitacion) tipo_habitacion);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener el tipo_de_habitacion: " + ex.getMessage());
        }
        
        
        return tipo_habitaciones;
    }
    
}
