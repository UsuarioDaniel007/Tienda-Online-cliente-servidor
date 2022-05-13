
package Modeloo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProductoDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
   public List listar(){
       String sql = "select * from Producto";
        List<Producto>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                
                Producto pro=new Producto ();
                pro.setId(rs.getInt(1));
                pro.setPrecio(rs.getString(2));
                pro.setNombre(rs.getString(3));
               pro.setStock(rs.getString(4));
                pro.setEstado(rs.getString(5));

                lista.add(pro);
                
            }
        } catch (Exception e) {
            
        }
           return lista; 
   }
   public int agregar(Producto t){
       String sql="insert into Producto (precio, nombre, stock, estado) values(?,?,?,?)";
        try {
           con = cn.Conexion();
            ps = con.prepareStatement(sql);            
            ps.setString(1, t.getPrecio());
            ps.setString(2, t.getNombre());
            ps.setString(3, t.getStock());
            ps.setString(4, t.getEstado());
            ps.setInt(5, t.getId());
            ps.executeUpdate();
      } catch (Exception e) {
      
      }
         return r;
   }  
   public Producto listarId(int id){
        Producto alu= new Producto ();
        String sql = "select * from Producto where id_producto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                             
                alu.setPrecio(rs.getString(2));
                alu.setNombre(rs.getString(3));
                alu.setStock(rs.getString(4));
                alu.setEstado(rs.getString(5));
             
            }         
       } catch (Exception e) {
       }
        return  alu;
   }
   public int actualizar(Producto al){
     String sql = "update Producto set precio=?, nombre=?, stock=?, estado=? where id_producto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);            
            ps.setString(1, al.getPrecio());
            ps.setString(2, al.getNombre());
            ps.setString(3, al.getStock());
            ps.setString(4, al.getEstado());
            ps.setInt(5, al.getId());
            ps.executeUpdate();
            
      } catch (Exception e) {
      
      }
         return r;
        }
       
   public void delete(int id){
       String Sql = "delete from Producto where id_producto="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(Sql);
            ps.executeUpdate();
         } catch (Exception e) {
         }
   }
}
  
   
