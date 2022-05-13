
package Modeloo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoProvider2 implements Interfaces.CRUDGenerico <Producto>{
Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    boolean r;
    
    @Override
    public List<Producto> obtenerTodos() {
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
    @Override
    public Producto obtenerPorId(int id) {
         Producto doc= new Producto();
        String sql = "select * from Producto where id_producto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                             
                doc.setPrecio(rs.getString(2));
                doc.setNombre(rs.getString(3));
                doc.setStock(rs.getString(4));
                doc.setEstado(rs.getString(5));
                
            }         
       } catch (Exception e) {
       }
        return  doc;
   }
    @Override
    public Boolean registrar(Producto t) {
       String sql="insert into Producto (precio, nombre, stock, estado) values(?,?,?,?)";
        try {
           con = cn.Conexion();
            ps = con.prepareStatement(sql);            
            ps.setString(1, t.getPrecio());
            ps.setString(2, t.getNombre());
            ps.setString(3, t.getStock());
            ps.setString(4, t.getEstado());
       
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
    public Boolean actualizar(Producto t) {
      String sql = "update Producto set precio=?, nombre=?, stock=?, estado=? where id_producto=?";
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

    @Override
    public Boolean eliminar(Producto id) {
     String hql = "delete from Producto where id_producto="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(hql);
            ps.executeUpdate();
         } catch (Exception e) {
         }
            return r;
   }
}
    

