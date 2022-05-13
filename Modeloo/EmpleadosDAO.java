
package Modeloo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadosDAO {
     Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Empleado buscar(int id){
        Empleado c= new Empleado();
     String sql="select * from Empleado where id="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
                 c.setId(rs.getInt(1));
                c.setMatricula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setTelefono(rs.getString(5));
                c.setCorreo(rs.getString(6));
                c.setSexo(rs.getString(7));
        } catch (Exception e) {
        }
        return c;
    }
   public List listar(){
       String sql = "select * from Empleado";
        List<Empleado>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                
                Empleado admi=new Empleado ();
                admi.setId(rs.getInt(1));
                admi.setMatricula(rs.getString(2));
                admi.setNombre(rs.getString(3));
                admi.setApellido(rs.getString(4));
                admi.setTelefono(rs.getString(5));
                admi.setCorreo(rs.getString(6));
                admi.setSexo(rs.getString(7));
              
                lista.add(admi);
                
            }
        } catch (Exception e) {
            
        }
           return lista; 
   }
   public int agregar(Cliente al){
       String sql="insert into Empleado (matricula, nombre, apellido, telefono, correo, semestre, carrera, sexo) values(?,?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);        
            ps.setString(1, al.getMatricula());
            ps.setString(2, al.getNombre());
            ps.setString(3, al.getApellido());
            ps.setString(4, al.getTelefono());
            ps.setString(5, al.getCorreo());
           
            ps.setString(6, al.getSexo());           
            ps.executeUpdate();
            
      } catch (Exception e) {
      
      }
         return r;
   }  
   public Empleado listarId(int id){
        Empleado admi= new Empleado();
        String sql = "select * from Empleado where id_empleado="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                             
                admi.setMatricula(rs.getString(2));
                admi.setNombre(rs.getString(3));
                admi.setApellido(rs.getString(4));
                admi.setTelefono(rs.getString(5));
                admi.setCorreo(rs.getString(6));
               
                admi.setSexo(rs.getString(9)); 
            }         
       } catch (Exception e) {
       }
        return  admi;
   }
   public int actualizar(Empleado al){
     String sql = "update Empleado set matricula=?, nombre=?, apellido=?, telefono=?, correo=?,  sexo=? where id_empleado=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);            
            ps.setString(1, al.getMatricula());
            ps.setString(2, al.getNombre());
            ps.setString(3, al.getApellido());
            ps.setString(4, al.getTelefono());
            ps.setString(5, al.getCorreo());
            ps.setString(6, al.getSexo());
            ps.setInt(7, al.getId());
            ps.executeUpdate();
            
      } catch (Exception e) {
      
      }
         return r;
        }
       
   public void delete(int id){
       String Sql = "delete from Empleado where id_empleado="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(Sql);
            ps.executeUpdate();
         } catch (Exception e) {
         }
   }
}