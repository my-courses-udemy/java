package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TestMysqlJDBC {
    
    public static void main(String[] args) {
        
        // especificamos que no queremos coneccion SSL, y la zona horaria
        String url = "jdbc:mysql://localhost:3306/santi?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conection = DriverManager.getConnection(url,"root", "tupassword");
            Statement instruction = conection.createStatement();
            var sql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
            ResultSet resultado = instruction.executeQuery(sql);
            while(resultado.next()){
                System.out.print("id Persona:" + resultado.getInt("id_persona"));
                System.out.print(", nombre:" + resultado.getString("nombre"));
                System.out.print(", apellido:" + resultado.getString("apellido"));
                System.out.print(", email:" + resultado.getString("email"));
                System.out.print(", telefono:" + resultado.getString("telefono"));
                System.out.println();
            }
            resultado.close();
            instruction.close();
            conection.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
    
}
