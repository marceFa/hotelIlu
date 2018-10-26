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
            
            String sql = "INSERT INTO tipo_habitacion ( descripcion) VALUES ( ? );";

            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                
                statement.setString(1, tipo_habitacion.getDescripcion());
                
                
                statement.executeUpdate();
                
                ResultSet rs = statement.getGeneratedKeys();
                
                if (rs.next()) {
                    tipo_habitacion.setId_tipoHabitacion(rs.getInt(1));
                } else {
                    System.out.println("No se pudo obtener el id_tipoHabitacion luego de insertar una tipo_de_habitacion");
                }
            }
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un tipo_habitacion: " + ex.getMessage());
        }
    }
    
    public List<Tipo_habitacion> obtenerTipo_habitacion(){
        List<Tipo_habitacion> tipo_habitaciones = new ArrayList<>();
            

        try {
            String sql = "SELECT * FROM Tipo_habitacion;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                Tipo_habitacion tipo_habitacion;
                while(resultSet.next()){
                    tipo_habitacion = new Tipo_habitacion();
                    tipo_habitacion.setId_tipoHabitacion(resultSet.getInt("id_tipoHabitacion"));
                    tipo_habitacion.setDescripcion(resultSet.getString("descripcion"));
                    
                    tipo_habitaciones.add((Tipo_habitacion) tipo_habitacion);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el Tipo_habitacion: " + ex.getMessage());
        }
        
        
        return tipo_habitaciones;
    }
    
    public Tipo_habitacion buscarTipo_habitacion(int id_tipoHabitacion){
    
        Tipo_habitacion tipo_habitacion=null;
    try {
            
            String sql = "SELECT * FROM Tipo_habitacion WHERE id_tipoHabitacion =?;";

            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setInt(1, id_tipoHabitacion);
                
                
                ResultSet resultSet=statement.executeQuery();
                
                while(resultSet.next()){
                    tipo_habitacion = new Tipo_habitacion();
                    tipo_habitacion.setId_tipoHabitacion(resultSet.getInt("id_tipoHabitacion"));
                    tipo_habitacion.setDescripcion(resultSet.getString("descripcion"));
                    
                    
                    
                }
            }
            
            
          
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un tipo_habitacion: " + ex.getMessage());
        }
        
        return tipo_habitacion;
    }
    public void borrarTipo_habitacion (int id_tipoHabitacion){
    
        
    try {
            
            String sql = "DELETE FROM Tipo_habitacion WHERE id_tipoHabitacion =?;";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, id_tipoHabitacion);
            
            
            statement.executeUpdate();
        }
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar un Tipo_habitacion: " + ex.getMessage());
        }
        
    
    
    }
    public void actualizarTipo_habitacion(Tipo_habitacion tipo_habitacion){
    try {
            
            String sql = "UPDATE tipo_habitacion SET descripcion = ? WHERE id_tipoHabitacion = ?;";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, tipo_habitacion.getDescripcion());
            statement.setInt(2, tipo_habitacion.getId_tipoHabitacion());
            
            statement.executeUpdate();
        }
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un tipo_habitacion: " + ex.getMessage());
        }
     
        
    
    }
    
    
}
