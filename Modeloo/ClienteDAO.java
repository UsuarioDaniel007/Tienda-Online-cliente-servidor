
package Modeloo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Modeloo.Cliente;


public class ClienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Cliente buscar(String matricula){
        Cliente c= new Cliente();
     String sql="select * from Clientes where matricula=" +matricula;
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
                c.setSemestre(rs.getString(7));
                c.setCarrera(rs.getString(8));
                c.setSexo(rs.getString(9));
        } catch (Exception e) {
        }
        return c;
    }
    
   public List listar(){
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
   public int agregar(Cliente al){
       String sql="insert into Clientes (matricula, nombre, apellido, telefono, correo, semestre, carrera, sexo) values(?,?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);        
            ps.setString(1, al.getMatricula());
            ps.setString(2, al.getNombre());
            ps.setString(3, al.getApellido());
            ps.setString(4, al.getTelefono());
            ps.setString(5, al.getCorreo());
            ps.setString(6, al.getSemestre());
            ps.setString(7, al.getCarrera());
            ps.setString(8, al.getSexo());           
            ps.executeUpdate();
            
      } catch (Exception e) {
      
      }
         return r;
   }  
   public Cliente listarId(int id){
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
   public int actualizar(Cliente al){
     String sql = "update Clientes set matricula=?, nombre=?, apellido=?, telefono=?, correo=?, semestre=?, carrera=?, sexo=? where id_alumno=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);            
            ps.setString(1, al.getMatricula());
            ps.setString(2, al.getNombre());
            ps.setString(3, al.getApellido());
            ps.setString(4, al.getTelefono());
            ps.setString(5, al.getCorreo());
            ps.setString(6, al.getSemestre());
            ps.setString(7, al.getCarrera());
            ps.setString(8, al.getSexo());
            ps.setInt(9, al.getId());
            ps.executeUpdate();
            
      } catch (Exception e) {
      
      }
         return r;
        }
       
   public void delete(int id){
       String Sql = "delete from Clientes where id_cliente="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(Sql);
            ps.executeUpdate();
         } catch (Exception e) {
         }
   }
}
  
   
    

