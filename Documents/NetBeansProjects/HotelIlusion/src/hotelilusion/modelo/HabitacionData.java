
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelilusion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            
            String sql = "INSERT INTO habitacion (numero, piso, caracteristicas,cant_personas,cant_camas, precio_diario, id_habitacion) VALUES ( ? , ? , ? , ?, ?, ?, ? );";

            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setInt(1, habitacion.getNumero());
                statement.setInt(2, habitacion.getPiso());
                statement.setInt(3, habitacion.getCant_de_camas());
                statement.setDouble(4, habitacion.getPrecio_diario());
                
                
                
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
    
    
}
