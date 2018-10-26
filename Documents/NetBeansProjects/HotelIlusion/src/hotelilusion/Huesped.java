package hotelilusion.modelo;

/**
 *
 * @author Noelia
 */
public class Huesped {
    private int id_huesped;
    private String nombre_apellido;
    private long numero_documento;
    private String direccion;
    private long telefono;
    private String email;

    public int getId_huesped() {
        return id_huesped;}
    public void setId_huesped(int id_huesped) {
        this.id_huesped = id_huesped;}
    public String getNombre_apellido() {
        return nombre_apellido;}
    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;}
    public long getNumero_documento() {
        return numero_documento; }
    public void setNumero_documento(long numero_documento) {
        this.numero_documento = numero_documento;}
    public String getDireccion() {
        return direccion;}
    public void setDireccion(String direccion) {
        this.direccion = direccion;}
    public long getTelefono() {
        return telefono;}
    public void setTelefono(long telefono) {
        this.telefono = telefono;}
    public String getEmail() {
        return email;}
    public void setEmail(String email) {
        this.email = email;}
     public Huesped(int id_huesped, String nombre_apellido, long numero_documento, String direccion, long telefono, String email) {
        this.id_huesped = id_huesped;
        this.nombre_apellido = nombre_apellido;
        this.numero_documento = numero_documento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }
     
     public Huesped(String nombre_apellido, long numero_documento, String direccion, long telefono, String email) {
        this.id_huesped =-1;
        this.nombre_apellido = nombre_apellido;
        this.numero_documento = numero_documento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }
     public Huesped(){
        this.id_huesped = -1;
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int getInt(String id_huesped) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getString(String nombre_apellido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
