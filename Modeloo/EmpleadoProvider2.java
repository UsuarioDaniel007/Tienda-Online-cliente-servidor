
package Modeloo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Negriz07
 */
public class EmpleadoProvider2 implements Interfaces.CRUDGenerico <Empleado>{
Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    boolean r;

    @Override
    public List<Empleado> obtenerTodos() {
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
    

    @Override
    public Empleado obtenerPorId(int id) {
         Empleado ad= new Empleado();
        String sql = "select * from Empleado where id_empleado="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                             
                ad.setMatricula(rs.getString(2));
                ad.setNombre(rs.getString(3));
                ad.setApellido(rs.getString(4));
                ad.setTelefono(rs.getString(5));
                ad.setCorreo(rs.getString(6));
                ad.setSexo(rs.getString(7)); 
            }         
       } catch (Exception e) {
       }
        return  ad;
   }

    @Override
    public Boolean registrar(Empleado t) {
       String sql="insert into Empleado (matricula, nombre, apellido, telefono, correo,  sexo) values(?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);        
            ps.setString(1, t.getMatricula());
            ps.setString(2, t.getNombre());
            ps.setString(3, t.getApellido());
            ps.setString(4, t.getTelefono());
            ps.setString(5, t.getCorreo());           
            ps.setString(6, t.getSexo());           
            ps.executeUpdate();
            
      } catch (Exception e) {
          return false;
        }
        finally{
          
        try {
           con.close();
        } catch (Exception ex) {
            Logger.getLogger(AlumnoProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        return r;
    }

    @Override
    public Boolean actualizar(Empleado t) {
         String sql = "update Empleado set matricula=?, nombre=?, apellido=?, telefono=?, correo=?, sexo=? where id_empleado=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);            
            ps.setString(1, t.getMatricula());
            ps.setString(2, t.getNombre());
            ps.setString(3, t.getApellido());
            ps.setString(4, t.getTelefono());
            ps.setString(5, t.getCorreo());
            ps.setString(6, t.getSexo());
            ps.setInt(7, t.getId());
            ps.executeUpdate();
            
      } catch (Exception e) {
      
      }
         return r;
        }

    @Override
    public Boolean eliminar(Empleado id) {
        String hql = "delete from Empleado where id_empleado="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(hql);
            ps.executeUpdate();
         } catch (Exception e) {
         }
            return r;
   }
}
    


