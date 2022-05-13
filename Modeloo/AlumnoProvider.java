/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modeloo;
import Modeloo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlumnoProvider implements Interfaces.CRUDGenerico <Cliente>{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public ArrayList<Cliente> Obteneralumno(){
        String sql = "select * from Alumnos";
        ArrayList<Cliente> listaAlumnos = new ArrayList();
        // modelo.Conexion a=new modelo.Conexion();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
        
            while (rs.next()) {
                Cliente alumno= new Cliente();
                alumno.setId(rs.getInt(1));
                alumno.setMatricula(rs.getString(2));
                alumno.setNombre(rs.getString(3));
                alumno.setApellido(rs.getString(4));
                alumno.setTelefono(rs.getString(5));
                alumno.setCorreo(rs.getString(6));
                alumno.setSemestre(rs.getString(7));
                alumno.setCarrera(rs.getString(8));
                alumno.setSexo(rs.getString(3));
              
                listaAlumnos.add(alumno);
                
            }
            return listaAlumnos;
            
        } catch (Exception e) {
            return null;
        }
        finally{
          
        try {
           con.close();
        } catch (Exception ex) {
            Logger.getLogger(AlumnoProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    
    public boolean Insertar (Cliente alumno)
    {
        String hql = "insert into Alumnos ( matricula, nombre, apellido, telefono, correo, semestre, carrera, sexo) values(?,?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(hql);
            ps.setString(1, alumno.getMatricula());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido());
            ps.setString(4, alumno.getTelefono());
            ps.setString(5, alumno.getCorreo());
            ps.setString(6, alumno.getSemestre());
            ps.setString(7, alumno.getCarrera());
            ps.setString(8, alumno.getSexo());
            
            ps.executeUpdate();
            return true;
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
    }
    
    public boolean Modificar (Cliente alumno){
        String hql = "update Alumnos set matricula=?, nombre=?, apellido=?, telefono=?, correo=?, semestre=?, carrera=?, sexo=? where id_alumno=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(hql);
            ps.setString(1, alumno.getMatricula());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido());
            ps.setString(4, alumno.getTelefono());
            ps.setString(5, alumno.getCorreo());
            ps.setString(6, alumno.getSemestre());
            ps.setString(7, alumno.getCarrera());
            ps.setString(8, alumno.getSexo());
            ps.setInt(9, alumno.getId());
            
            ps.executeUpdate();
            return true;
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
           }
    
    public boolean Eliminar (Cliente alumno)
    {
        String hql = "delete from alumno where id=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(hql);
            ps.setInt(1, alumno.getId());
            ps.executeUpdate();
            return true;
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
           }

    @Override
    public List<Cliente> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente obtenerPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean registrar(Cliente t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean actualizar(Cliente t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean eliminar(Cliente t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}