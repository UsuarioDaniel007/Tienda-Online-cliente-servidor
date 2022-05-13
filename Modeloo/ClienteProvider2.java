
package Modeloo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteProvider2 implements Interfaces.CRUDGenerico <Cliente>{
Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    boolean r;
    
    @Override
    public List<Cliente> obtenerTodos() {
       String sql = "select * from Clientes";
        List<Cliente>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                
                Cliente alumno=new Cliente ();
                alumno.setId(rs.getInt(1));
                alumno.setMatricula(rs.getString(2));
                alumno.setNombre(rs.getString(3));
                alumno.setApellido(rs.getString(4));
                alumno.setTelefono(rs.getString(5));
                alumno.setCorreo(rs.getString(6));
                alumno.setSemestre(rs.getString(7));
                alumno.setCarrera(rs.getString(8));
                alumno.setSexo(rs.getString(9));
              
                lista.add(alumno);
                
            }
        } catch (Exception e) {
            
        }
           return lista; 
   }
    @Override
    public Cliente obtenerPorId(int id) {
         Cliente alu= new Cliente();
        String sql = "select * from Clientes where id_cliente="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                             
                alu.setMatricula(rs.getString(2));
                alu.setNombre(rs.getString(3));
                alu.setApellido(rs.getString(4));
                alu.setTelefono(rs.getString(5));
                alu.setCorreo(rs.getString(6));
                alu.setSemestre(rs.getString(7));
                alu.setCarrera(rs.getString(8));
                alu.setSexo(rs.getString(9)); 
            }         
       } catch (Exception e) {
       }
        return  alu;
   }

    @Override
    public Boolean registrar(Cliente t) {
       String sql="insert into Clientes (matricula, nombre, apellido, telefono, correo, semestre, carrera, sexo) values(?,?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);        
            ps.setString(1, t.getMatricula());
            ps.setString(2, t.getNombre());
            ps.setString(3, t.getApellido());
            ps.setString(4, t.getTelefono());
            ps.setString(5, t.getCorreo());
            ps.setString(6, t.getSemestre());
            ps.setString(7, t.getCarrera());
            ps.setString(8, t.getSexo());           
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
    public Boolean actualizar(Cliente t) {
        String sql = "update Clientes set matricula=?, nombre=?, apellido=?, telefono=?, correo=?, semestre=?, carrera=?, sexo=? where id_cliente=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);            
            ps.setString(1, t.getMatricula());
            ps.setString(2, t.getNombre());
            ps.setString(3, t.getApellido());
            ps.setString(4, t.getTelefono());
            ps.setString(5, t.getCorreo());
            ps.setString(6, t.getSemestre());
            ps.setString(7, t.getCarrera());
            ps.setString(8, t.getSexo());
            ps.setInt(9, t.getId());
            ps.executeUpdate();
            
      } catch (Exception e) {
      
      }
         return r;
        }
       
    @Override
    public Boolean eliminar(Cliente id) {
     String hql = "delete from Clientes where id_cliente="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(hql);
            ps.executeUpdate();
         } catch (Exception e) {
         }
            return r;
   }
}

