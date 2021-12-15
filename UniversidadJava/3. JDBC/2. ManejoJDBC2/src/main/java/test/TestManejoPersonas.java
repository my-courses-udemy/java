
package test;

import datos.Conexion;
import datos.PersonaDAO;
import domain.Persona;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestManejoPersonas {

    public static void main(String[] args) {
        
        Connection conexion = null;
        try {
            
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false); // necesitamos que no haga autocommit
            }
            
            PersonaDAO personaDAO = new PersonaDAO(conexion);
            
            Persona cambioPersona = new Persona(2, "Carla Ivone", "Lara", "carlaIvone@gmail.com", "4335278");
            personaDAO.modificar(cambioPersona);
            
            Persona insertarPersona = new Persona();
            insertarPersona.setNombre("Carlos");
//            insertarPersona.setApellido("Blancodfasfadsfasdfasdfdsfadfffffffffffffffffffffffffffffff");
            insertarPersona.setApellido("Blanco");
            insertarPersona.setEmail("carlos.blanco@gmail.com");
            insertarPersona.setTelefono("344356354");
            personaDAO.insertar(insertarPersona);
            
            // aqui recien se guardan los cambios
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