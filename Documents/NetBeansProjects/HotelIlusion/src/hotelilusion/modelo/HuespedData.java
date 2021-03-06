
package hotelilusion.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import proyectojava.modelo.Conexion;
//import javaapplication1.modelo.Huesped;

/**
 *
 * @author agus
 */
public class HuespedData {
    private Connection connection = null;

    public HuespedData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    
    
    public void guardarHuesped(Huesped huesped){
        try {
            
            String sql = "INSERT INTO huesped (nombre_apellido, numero_documento, dirección, telefono, email) VALUES ( ? , ? , ? , ? , ? );";

            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, huesped.getNombre_apellido());
                statement.setInt(2, huesped.getNumero_documento());
                statement.setString(3, huesped.getDireccion());
                statement.setInt(4, huesped.getTelefono());
                statement.setString(5, huesped.getEmail());
                
                statement.executeUpdate();
                
                ResultSet rs = statement.getGeneratedKeys();
                
                if (rs.next()) {
                    huesped.setId_huesped(rs.getInt(1));
                } else {
                    System.out.println("No se pudo obtener el id luego de insertar un huesped");
                }
            }
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
    }
    
    public List<Huesped> obtenerHuespedes(){
        List<Huesped> huespedes = new ArrayList<Huesped>();
            

        try {
            String sql = "SELECT * FROM huesped;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Huesped huesped;
            while(resultSet.next()){
                huesped = new Huesped();
                huesped.setId_huesped(resultSet.getInt("id_huesped"));
                huesped.setNombre_apellido(resultSet.getString("nombre_apellido"));
                huesped.setNumero_documento(resultSet.getInt("numero_documento"));
                huesped.setDireccion(resultSet.getString("direccion"));
                huesped.setTelefono(resultSet.getInt("telefono"));
                huesped.setEmail(resultSet.getString("email"));
                

                huespedes.add(huesped);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los huesped: " + ex.getMessage());
        }
        
        
        return huespedes;
    }

    public Object obtenerHuesped() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void actualizarHuesped(Huesped huesped){
        try {            
            String sql = "UPDATE huesped SET dni = ?, nombre = ? , activo =? WHERE idCliente = ?;";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);            
            statement.setInt(1, huesped.getInt("id_huesped"));
            statement.setString(2, huesped.getString("nombre_apellido"));    
            huesped.setNumero_documento(resultSet.getInt("numero_documento"));
            huesped.setDireccion(resultSet.getString("direccion"));
            huesped.setTelefono(resultSet.getInt("telefono"));
            huesped.setEmail(resultSet.getString("email"));            
            statement.executeUpdate();                      
            statement.close();    
        } 
        catch (SQLException ex){
            System.out.println("Error al insertar un huésped: " + ex.getMessage());
        }    
    }
    
    public Huesped buscarHuesped(int id){
      Huesped huesped = null;
        try{            
            String sql = "SELECT * FROM huesped WHERE id_huesped =?;";
          try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
              statement.setInt(1, id);
              ResultSet resultSet=statement.executeQuery();
              
              while(resultSet.next()){
                  huesped = new Huesped();
                  huesped.setId_huesped(resultSet.getInt("id_huesped"));
                  huesped.setNombre_apellido(resultSet.getString("nombre_apellido"));
                  huesped.setNumero_documento(resultSet.getInt("numero_documento"));
                  huesped.setDireccion(resultSet.getString("direccion"));
                  huesped.setTelefono(resultSet.getInt("telefono"));
                  huesped.setEmail(resultSet.getString("email"));
              }
          }              
        }catch (SQLException ex){
            System.out.println("Error al insertar un huesped: " + ex.getMessage());
        }        
        return huesped;
    }

    private static class resultSet {

        private static int getInt(String numero_documento) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static String getString(String direccion) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public resultSet() {
        }
    }
    
    
}


