package log;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DB {
  public  Connection GetConnection()
    {
        Connection conexion=null;
            File ruta= new File("");
            
        try
        {
            Class.forName("com.mysql.jdbc.Driver");  //driver 
            String servidor = "jdbc:mysql://localhost:3306/Data";  //esta ruta de servidor puede ser localhost 3306 para linux
            String usuarioDB="root";
            String passwordDB="Admin1@@";
            conexion= DriverManager.getConnection(servidor,usuarioDB,passwordDB);
           
            
        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        finally
        {
            return conexion;
        }
    
        
       
    }
  
}
  
