
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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author agus
 */
public class HabitacionData {
     private Connection connection = null;
     private Conexion conexion;
   //  private Connection cn = sql.conectar();

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
            
            String sql = "INSERT INTO habitacion (numero, piso, caracteristicas,cantidad_personas,cantidad_camas, precio_diario, id_tipohabitacion,estado) VALUES ( ? , ? , ? , ?, ?, ?, ? , ? );";

            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setInt(1, habitacion.getNumero());
                statement.setInt(2, habitacion.getPiso());
                statement.setString(3, habitacion.getCaracteristicas());
                statement.setInt(4, habitacion.getCant_personas());
                statement.setInt(5, habitacion.getCant_de_camas());
                statement.setDouble(6, habitacion.getPrecio_diario());
                statement.setInt(7, habitacion.getId_tipohabitacion().getId_tipoHabitacion());
                statement.setBoolean(8, true);
                
                
                
                statement.executeUpdate();
                
                ResultSet rs = statement.getGeneratedKeys();
                
                if (rs.next()) {
                    habitacion.setId_habitacion(rs.getInt(1));
                } else {
                    System.out.println("No se pudo obtener el id luego de guardar una habitación");
                }
            }
    
        } catch (SQLException ex) {
            System.out.println("Error al guardar una habitación: " + ex.getMessage());
        }
    }
    
    public List<Habitacion> obtenerHabitaciones(){
        List<Habitacion> habitaciones = new ArrayList<>();
            

        try {
            String sql = "SELECT * FROM habitacion;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
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
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el listado de las habitaciones: " + ex.getMessage());
        }
        
        
        return habitaciones;
    }
    
    public void borrarHabitacion(int id_habitacion){
    try {
            
            String sql = "DELETE FROM habitacion WHERE id_habitacion =?;";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, id_habitacion);
            
            
            statement.executeUpdate();
        }
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar una habitación: " + ex.getMessage());
        }
        
    
    }
    
    public void actualizarHabitacion(Habitacion habitacion){
    
        try {
             
            String sql = "UPDATE habitacion SET numero = ?, piso = ? , caracteristicas =? , cantidad_personas = ? , cantidad_camas = ? , precio_diario = ?  WHERE id_tipoHabitacion = ?;";

            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setInt(1, habitacion.getNumero());
                statement.setInt(2, habitacion.getPiso());
                statement.setString(3, habitacion.getCaracteristicas());
                statement.setInt(4, habitacion.getCant_personas());
                statement.setInt(5, habitacion.getCant_de_camas());
                statement.setDouble(6, habitacion.getPrecio_diario());
               
                statement.executeUpdate();
            }
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar una habitación: " + ex.getMessage());
        }
    
    }
    
    public Habitacion buscarHabitacion(int id_habitacion){
    Habitacion habitacion=null;
    try {
            
            String sql = "SELECT * FROM habitacion WHERE id_habitacion =?;";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, id_habitacion);
            
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                habitacion = new Habitacion();
                habitacion.setId_habitacion(resultSet.getInt("id_habitacion"));
                habitacion.setNumero(resultSet.getInt("numero"));
                habitacion.setPiso(resultSet.getInt("piso"));
                habitacion.setCaracteristicas(resultSet.getString("caracteristicas"));
                habitacion.setCant_personas(resultSet.getInt("cantidad_personas"));
                habitacion.setCant_de_camas(resultSet.getInt("cantidad_camas"));
                habitacion.setPrecio_diario(resultSet.getDouble("precio_diario"));
                
                
            }
        }
            
            
            
            
    
        } catch (SQLException ex) {
            System.out.println("Error al buscar una habitación: " + ex.getMessage());
        }
        
        return habitacion;
    }
    
  /*  public Integer totalregistros;
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Numero", "piso", "Descripcion", "Caracteristicas", "Precio", "Estado", "Tipo habitacion"};
        //String[][] registros = new String[0][0];
       String[] registro = new String[8];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
      
        String sql = "select * from habitacion where piso like '%" + buscar + "%' order by idhabitacion";
       
                try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if(rs!=null){
                    System.out.println("consulta exitosa!");
                    while (rs.next()) {
                        //System.out.println("Parámetros: "+rs.getString("idhabitacion"));
                        registro[0] = rs.getString("idhabitacion");
                        registro[1] = rs.getString("numero");
                        registro[2] = rs.getString("piso");
                        registro[3] = rs.getString("descripcion");
                        registro[4] = rs.getString("caracteristicas");
                        registro[5] = rs.getString("precio_diario");
                        registro[6] = rs.getString("estado");
                        registro[7] = rs.getString("tipo_habitacion");
                        //System.out.println("REGISTROS: "+registro[0]+" "+registro[1]+" "+registro[2]+" "+registro[3]+" "+registro[4]+" "+registro[5]+" "+registro[6]+" "+registro[7]);
                        
                        totalregistros = totalregistros + 1;
                        modelo.addRow(registro);
                        
                        //System.out.println("Modelo: "+modelo.getColumnName(1));

                    }

                }else{
                    System.out.println("Error al realizar consulta a la BD");
                }
                //return modelo;
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
                System.out.println("Error al cargar modelo");
             }
         return modelo;

    }
    
    
    public boolean insertar(Habitacion dts) {
        String sql = "insert  into habitacion(numero,piso,descripcion,caracteristicas,precio_diario,estado,tipo_habitacion)"
                + "values(?,?,?,?,?,?,?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, dts.getNumero());
            pst.setString(2, dts.getPiso());
            pst.setString(3, dts.getDescripcion());
            pst.setString(4, dts.getCaracteristicas());
            pst.setDouble(5, dts.getPrecio_diario());
            pst.setString(6, dts.getEstado());
            pst.setString(7, dts.getTipo_habitacion());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;

        }

    }*/
    
}
