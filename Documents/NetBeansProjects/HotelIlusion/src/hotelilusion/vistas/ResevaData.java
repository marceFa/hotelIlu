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
 * @author Usuario
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
            
            String sql = "INSERT INTO reserva (id_habitacion, id_huesped, tipo_habitacion, fecha_de_reserva, fecha_de_ingreso, fecha_de_egreso, cant_personas, estado, costoalojamiento) VALUES ( ? , ? , ?, ? , ? , ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, reserva.getId_habitacion().getId_habitacion()); 
            statement.setInt(2, reserva.getId_huesped().getId_huesped());                                          //           getMateria().getId());
            statement.setInt(3, reserva.getTipo_de_habitacion().getId_tipoHabitacion());
            statement.setDate(4, Date.valueOf(reserva.getFecha_de_reserva()));
            statement.setDate(5, Date.valueOf(reserva.getFecha_de_ingreso()));
            statement.setDate(6, Date.valueOf(reserva.getFecha_de_egreso()));
            statement.setInt(7, reserva.getCant_personas());
            statement.setInt(8, reserva.getEstado());
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
    
    public List<Habitacion> obtenerHabitaciones(){
        List<Habitacion> habitaciones = new ArrayList<Habitacion>();
            

        try {
            String sql = "SELECT * FROM habitacion;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Habitacion habitacion;
            while(resultSet.next()){
                habitacion = new Habitacion();
                habitacion.setId_habitacion(resultSet.getInt("id_reserva"));
                Huesped a=buscarHuesped(resultSet.getInt("idHuesped"));//error en buscarhabitacion
                habitacion.setHuesped(a);//error en setthuesped
                
                 Habitacion m=buscarHabitacion(resultSet.getInt("id_habitacion"));//error en buscar habitacion
                habitacion.setId_habitacion(m);
                
                Huesped a=buscarHuesped(resultSet.getInt("id_habitacion"));//error en buscar habitacion
                huesped.setHuesped(a);
                
                Tipo_habitacion l=buscrTipo_habitacion(resultSet.getInt("id_tipoHabitacion"));//error en buscar tipo de habitacion
                tipo_habitacion.setId_tipoHabitacion(l);
               
                habitacion.setTipohabitacion(resultSet.getInt("tipo de habitacion"));//error en get int
               

                habitaciones.add(habitacion);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los alumnos: " + ex.getMessage());
        }
        
        
        return habitaciones;
    }
    public List<Habitacion> obtenerHabitacionesXHuesped(int id){
        List<Habitacion> cursadas = new ArrayList<Habitacion>();
            

        try {
            String sql = "SELECT * FROM habitacion WHERE id_habitacion = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id_habitacion);
            ResultSet resultSet = statement.executeQuery();
            Cursada cursada;
            while(resultSet.next()){
                cursada = new Cursada();
                cursada.setId(resultSet.getInt("id"));
                
                Alumno a=buscarAlumno(resultSet.getInt("idAlumno"));
                cursada.setAlumno(a);
                
                Materia m=buscarMateria(resultSet.getInt("idMateria"));
                cursada.setMateria(m);
                cursada.setNota(resultSet.getInt("nota"));
               

                cursadas.add(cursada);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los alumnos: " + ex.getMessage());
        }
        
        
        return cursadas;
    }

    
    public Alumno buscarAlumno(int id){
    
        AlumnoData ad=new AlumnoData(conexion);
        
        return ad.buscarAlumno(id);
        
    }
    
    public Materia buscarMateria(int id){
    
        MateriaData md=new MateriaData(conexion);
        return md.buscarMateria(id);
    
    }
    
    public List<Materia> obtenerMateriasCursadas(int id){
    List<Materia> materias = new ArrayList<Materia>();
            

        try {
            String sql = "SELECT idMateria, nombre FROM cursada, materia WHERE cursada.idMateria = materia.id\n" +
"and cursada.idAlumno = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Materia materia;
            while(resultSet.next()){
                materia = new Materia();
                materia.setId(resultSet.getInt("idMateria"));
                materia.setNombre(resultSet.getString("nombre"));
                materias.add(materia);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los alumnos: " + ex.getMessage());
        }
        
        
        return materias;
      
    }
    
    public List<Materia> obtenerMateriasNOCursadas(int id){
    List<Materia> materias = new ArrayList<Materia>();
            

        try {
            String sql = "Select * from materia where id not in "
                    + "(select idMateria from cursada where idAlumno =?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Materia materia;
            while(resultSet.next()){
                materia = new Materia();
                materia.setId(resultSet.getInt("id"));
                materia.setNombre(resultSet.getString("nombre"));
                materias.add(materia);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los alumnos: " + ex.getMessage());
        }
        
        
        return materias;
      
    }
    
    public void borrarCursadaDeUnaMateriaDeunAlumno(int idAlumno,int idMateria){
    
        try {
            
            String sql = "DELETE FROM cursada WHERE idAlumno =? and idMateria =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, idAlumno);
            statement.setInt(2, idMateria);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
        
        
        
        
    
    }
    public void actualizarNotaCursada(int idAlumno,int idMateria, int nota){
    
        try {
            
            String sql = "UPDATE cursada SET nota = ? WHERE idAlumno =? and idMateria =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,nota);
            statement.setInt(2, idAlumno);
            statement.setInt(3, idMateria);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
        
        
        
        
    
    }
    
}

