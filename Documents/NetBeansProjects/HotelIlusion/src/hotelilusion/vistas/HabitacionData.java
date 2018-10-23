
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelilusion.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author agus
 */
public class HabitacionData {
     private Connection connection = null;
     private Conexion conexion;

    public HabitacionData(Conexion conexion) {
        try {
            this.conexion=conexion;
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    
    
    public void guardarHabitacion(Habitacion habitacion){
        try {
            
            String sql = "INSERT INTO habitacion (numero, piso, caracteristicas, cant_personas, cant_camas, precio_diario, id_tipohabitacion) VALUES ( ? , ? , ? , ?, ?, ?, ? );";

            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setInt(1, habitacion.getNumero());
                statement.setInt(2, habitacion.getPiso());
                statement.setString(3, habitacion.getCaracteristicas());
                statement.setInt(4, habitacion.getCant_personas());
                statement.setInt(5, habitacion.getCant_de_camas());
                statement.setDouble(6, habitacion.getPrecio_diario());
                statement.setInt(7, habitacion.getTipohabitacion().getId_tipoHabitacion());
               
                
                
                
                statement.executeUpdate();
                
                ResultSet rs = statement.getGeneratedKeys();
                
                if (rs.next()) {
                    habitacion.setId_habitacion(rs.getInt(1));
                } else {
                    System.out.println("No se pudo obtener el id luego de insertar un habitacion");
                }
            }
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un habitacion: " + ex.getMessage());
        }
    }      
        public List<Habitacion> obtenerHabitaciones(){
        List<Habitacion> habitaciones = new ArrayList<Habitacion>();
            

        try {
            String sql = "SELECT * FROM huesped;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Habitacion habitacion;
            while(resultSet.next()){
                habitacion = new Habitacion();
                habitacion.setId_habitacion(resultSet.getInt("id_habitacion"));
                habitacion.setNumero(resultSet.getInt("numero"));
                habitacion.setPiso(resultSet.getInt("piso"));
                habitacion.setCaracteristicas(resultSet.getString("caracteristicas"));
                habitacion.setCant_personas(resultSet.getInt("cant_personas"));
                habitacion.setCant_de_camas(resultSet.getInt("cant_de_camas"));
                habitacion.setPrecio_diario(resultSet.getDouble("precio_diario"));
              
               
                Tipo_habitacionData thd=new Tipo_habitacionData(conexion);
                Tipo_habitacion a=thd.buscarTipo_habitacion(resultSet.getInt("id_tipoHabitacion"));
                habitacion.setTipohabitacion(a);

                habitaciones.add(habitacion);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los habitaciones: " + ex.getMessage());
        }
        
        
        return habitaciones;
    }
    
    public void borrarHabitacion(int id_habitacion){
    try {
            
            String sql = "DELETE FROM habitacion WHERE id_habitacion =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_habitacion);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un habitacion: " + ex.getMessage());
        }
        
    
    }
    
    public void actualizarHabitacion(Habitacion habitacion){
    
        try {
             
            String sql = "UPDATE habitacion SET numero = ?, piso = ? , caracteristicas =? , cant_personas = ? , cant_camas = ? , precio_diario = ?  WHERE id_tipohabitacion = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, habitacion.getNumero());
                statement.setInt(2, habitacion.getPiso());
                statement.setString(3, habitacion.getCaracteristicas());
                statement.setInt(4, habitacion.getCant_personas());
                statement.setInt(5, habitacion.getCant_de_camas());
                statement.setDouble(6, habitacion.getPrecio_diario());
               
                statement.executeUpdate();
            
          
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un habitacion: " + ex.getMessage());
        }
    
    }
    
    public Habitacion buscarHabitacion(int id_habitacion){
    Habitacion habitacion=null;
    try {
            
            String sql = "SELECT * FROM habitacion WHERE id_habitacion =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_habitacion);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                 habitacion = new Habitacion();
                habitacion.setId_habitacion(resultSet.getInt("id_habitacion"));
                habitacion.setNumero(resultSet.getInt("numero"));
                habitacion.setPiso(resultSet.getInt("piso"));
                habitacion.setCaracteristicas(resultSet.getString("caracteristicas"));
                habitacion.setCant_personas(resultSet.getInt("cant_personas"));
                habitacion.setCant_de_camas(resultSet.getInt("cant_de_camas"));
                habitacion.setPrecio_diario(resultSet.getDouble("precio_diario"));

                
            }      
            statement.close();
            
            
            
            
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
        
        return habitacion;
    }
    }
    
    

