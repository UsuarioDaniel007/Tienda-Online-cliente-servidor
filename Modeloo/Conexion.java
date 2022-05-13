
package Modeloo;

/**
 *
 * @author Negriz07
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
   Connection con;
    String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String URL = "jdbc:sqlserver://DESKTOP-RM0U201\\SQLEXPRESS:1433;databaseName=ControlServicios;";        
    String USER="daniel1";
    String pass="sa";
    
    public Connection Conexion() throws Exception{
        try{
            Class.forName(JDBC_DRIVER);
            con=DriverManager.getConnection(URL,USER,pass);
        }catch (Exception e){
            throw e;
        }
        return con;
        }
    }