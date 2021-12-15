package test;

import datos.Conexion;
import datos.UsuarioDAO;
import domain.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestManejoUsuarios {
    
    public static void main(String[] args) {
        
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
            
            Usuario usuario = new Usuario("dani.robles@gmail.com", "dani123");
            usuarioDAO.insertar(usuario);
            
            Usuario modificarUsuario = new Usuario(4, "santini123@gmail.com", "santini123");
            usuarioDAO.editar(modificarUsuario);
            
            conexion.commit();
            System.out.println("Commit de la transaccion");
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
        
    }
    
}
