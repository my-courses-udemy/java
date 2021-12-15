package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
    
    private static final String jdbc_url = "jdbc:mysql://localhost:3306/santi?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String jdbc_user = "root";
    private static final String jdbc_password = "tupassword";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(jdbc_url, jdbc_user, jdbc_password);
    }
    
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    public static void close(PreparedStatement smtm) throws SQLException{
        smtm.close();
    }
    
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
    
}
