/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author agus
 */

public class Test {
    
    public static void main(String[] args) throws SQLException{
        
        String url = "jdbc:mysql://localhost/hotelilusion";
        String usuario = "root";
        String password = "";
        Connection conexion;
        PreparedStatement ps;
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
            
 //         Huesped huesped1 = new Huesped("Agustin Ligorria", 44058111, 
 //         "Jacinto Suarez 222", 26641212, agus@gmail.com);
 //         huespedData.guardarHuesped(huesped1);
 //         System.out.println("El id del huesped es: " + huesped1.getId_huesped());
 
        ps=conexion.prepareStatement("SELECT *FROM huesped");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                
                System.out.println("Nombre: "+rs.getString(2));
            }
            
            ps.close();
        
        } catch (ClassNotFoundException e) {
            System.out.println("Error al instanciar la clase conexion: " + 
                    e.getMessage());
            
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

        
    

    