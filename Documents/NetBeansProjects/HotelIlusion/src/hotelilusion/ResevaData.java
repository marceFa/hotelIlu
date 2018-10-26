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
import hotelilusion.modelo.HuespedData;

/**
 *
 * @author Noelia
 */
public class ResevaData {
    private Connection connection = null;
     private Conexion conexion;
     
     public ResevaData(Conexion conexion) {
        try {
            this.conexion=conexion;
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
     
      public void guardarReserva(Reserva reserva){
        try {
            
            String sql = "INSERT INTO reserva (id_habitacion, id_huesped, estado,  fecha_reserva, fecha_ingreso, fecha_egreso, cantidad_personas, observacion, costo_alojamiento) VALUES ( ? , ? , ? , ? , ? , ? , ? , ? ,? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, reserva.getId_habitacion().getId_habitacion());
            statement.setInt(2, reserva.getId_huesped().getId_huesped());
            statement.setBoolean(3 ,reserva.getEstado());
          
            statement.setDate(4, Date.valueOf(reserva.getFecha_de_reserva()));
            statement.setDate(5, Date.valueOf(reserva.getFecha_de_ingreso()));
            statement.setDate(6, Date.valueOf(reserva.getFecha_de_egreso()));
            statement.setInt(7, reserva.getCant_personas());
        statement.setString(8, reserva.getObservacion());
            statement.setDouble(9, reserva.getCostoalojamiento());
            
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                reserva.setId_reserva(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar una reserva");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar una reserva: " + ex.getMessage());
        }
    }
      
       public List<Reserva> obtenerReservas(){
        List<Reserva> reservas = new ArrayList<Reserva>();
            

        try {
            String sql = "SELECT * FROM reserva;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Reserva reserva;
            while(resultSet.next()){
                reserva = new Reserva();
                reserva.setId_reserva(resultSet.getInt("id_reserva"));
              
                Habitacion a=buscarHabitacion(resultSet.getInt("id_habitacion"));
                reserva.setId_habitacion(a);
                
                Huesped b=buscarHuesped(resultSet.getInt("id_huesped"));
                reserva.setId_huesped(b);
                
                
                
                reserva.setFecha_de_reserva(resultSet.getDate("fecha_de_reserva").toLocalDate());
                reserva.setFecha_de_ingreso(resultSet.getDate("fecha_de_ingreso").toLocalDate());
                reserva.setFecha_de_egreso(resultSet.getDate("fecha_de_egreso").toLocalDate());
                reserva.setCant_personas(resultSet.getInt("cant_personas"));
                reserva.setEstado(resultSet.getBoolean("estado"));
                reserva.setCostoalojamiento(resultSet.getDouble("costoalojamiento"));
                
                reservas.add(reserva);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los alumnos: " + ex.getMessage());
        }
         return reservas;
    }
       
        public List<Reserva> obtenerReservaXHuesped(int id){
        List<Reserva> reservas = new ArrayList<Reserva>();
            

        try {
            String sql = "SELECT * FROM reserva WHERE id_huesped = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            Reserva reserva;
            while(resultSet.next()){
                reserva = new Reserva();
                reserva.setId_reserva(resultSet.getInt("id_reserva"));
                
                Habitacion a=buscarHabitacion(resultSet.getInt("id_habitacion"));
                reserva.setId_habitacion(a);
                
                Huesped b=buscarHuesped(resultSet.getInt("id_huesped"));
                reserva.setId_huesped(b);
                
               
                
                reserva.setFecha_de_reserva(resultSet.getDate("fecha_de_reserva").toLocalDate());
                reserva.setFecha_de_ingreso(resultSet.getDate("fecha_de_ingreso").toLocalDate());
                reserva.setFecha_de_egreso(resultSet.getDate("fecha_de_egreso").toLocalDate());
                reserva.setCant_personas(resultSet.getInt("cant_personas"));
                reserva.setEstado(resultSet.getBoolean("estado"));
                reserva.setCostoalojamiento(resultSet.getDouble("costoalojamiento"));
                reservas.add(reserva);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los huespedes: " + ex.getMessage());
        }
        
        
        return reservas;
    }
        
        public Huesped buscarHuesped(int id){
    
        HuespedData ad=new HuespedData(conexion);
        
        return ad.buscarHuesped(id);
        
    }
        
        public Habitacion buscarHabitacion(int id){
    
        HabitacionData md=new HabitacionData(conexion);
        return md.buscarHabitacion(id);
    
    }
        
        public Tipo_habitacion buscarTipo_habitacion(int id){
    
        Tipo_habitacionData md=new Tipo_habitacionData(conexion);
        return md.buscarTipo_habitacion(id);
    
    }
        
        public List<Habitacion> obtenerHabitacionesReservadas(int id){
    List<Habitacion> habitaciones = new ArrayList<Habitacion>();
            

        try {
            String sql = "SELECT id_habitacion, numero, piso, caracteristicas, cantidad_personas, cantidad_de_camas, precio_diario,  FROM reservada, habitacion WHERE reservada.id_habitacion = habitacion.id\n" +
"and reservada.id_huesped = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Habitacion habitacion;
            while(resultSet.next()){
                habitacion = new Habitacion();
               habitacion.setId_habitacion(resultSet.getInt("id_habitacion"));
                    habitacion.setNumero(resultSet.getInt("numero"));
                    habitacion.setPiso(resultSet.getInt("piso"));
                    habitacion.setCaracteristicas(resultSet.getString("caracteristicas"));
                    habitacion.setCant_personas(resultSet.getInt("cantidad_personas"));
                    habitacion.setCant_de_camas(resultSet.getInt("cantidad_de_camas"));
                    habitacion.setPrecio_diario(resultSet.getDouble("precio_diario"));
                    
                    
                    Tipo_habitacionData thd=new Tipo_habitacionData(conexion);
                    Tipo_habitacion a=thd.buscarTipo_habitacion(resultSet.getInt("id_tipoHabitacion"));
                    habitacion.setId_tipohabitacion(a);
                habitaciones.add(habitacion);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los huespedes: " + ex.getMessage());
        }
        
        
        return habitaciones;
      
    }

    
         public List<Habitacion> obtenerHabitacionesNOReservadas(int id){
    List<Habitacion> habitaciones = new ArrayList<Habitacion>();
            

        try {
            String sql =  "Select * from habitacion where id not in "
                    + "(select id_habitacion from reserva where id_huesped =?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Habitacion habitacion;
            while(resultSet.next()){
                habitacion = new Habitacion();
               habitacion.setId_habitacion(resultSet.getInt("id_habitacion"));
                    habitacion.setNumero(resultSet.getInt("numero"));
                    habitacion.setPiso(resultSet.getInt("piso"));
                    habitacion.setCaracteristicas(resultSet.getString("caracteristicas"));
                    habitacion.setCant_personas(resultSet.getInt("cantidad_personas"));
                    habitacion.setCant_de_camas(resultSet.getInt("cantidad_de_camas"));
                    habitacion.setPrecio_diario(resultSet.getDouble("precio_diario"));
                    
                    
                    Tipo_habitacionData thd=new Tipo_habitacionData(conexion);
                    Tipo_habitacion a=thd.buscarTipo_habitacion(resultSet.getInt("id_tipoHabitacion"));
                    habitacion.setId_tipohabitacion(a);
                habitaciones.add(habitacion);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los huespedes: " + ex.getMessage());
        }
        
        
        return habitaciones;
      
    }

          public void borrarReservaDeUnaHabitacionDeunHuesped(int id_huesped,int id_habitacion){
    
        try {
            
            String sql = "DELETE FROM cursada WHERE id_huesped =? and id_habitacion =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_huesped);
            statement.setInt(2, id_habitacion);
           
             statement.executeUpdate();
             statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un huesped: " + ex.getMessage());
        }
        
     }
          
     public void actualizarHabitacionReserva(Reserva reserva){
    
        try {
            
            String sql = "UPDATE reserva SET habitacion = ? WHERE id_huesped =? and id_habitacion =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,reserva.getId_reserva());
            
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un huesped: " + ex.getMessage());
        }
        
        
        
        
    
    }     
          
}
