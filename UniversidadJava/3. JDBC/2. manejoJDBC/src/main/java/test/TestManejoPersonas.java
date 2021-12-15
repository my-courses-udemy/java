
package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;

public class TestManejoPersonas {

    public static void main(String[] args) {
        
        
        // listando las personas
        PersonaDAO personaDAO = new PersonaDAO();
        
        // creamos otra persona y la insertamos en la base de datos
//        Persona persona2 = new Persona("Jhon", "Suarez", "jhon@suarez.com", "423259070");
//        personaDAO.insertar(persona2);


        Persona personaModificada = new Persona(5, "Juan Carlos", "Suarez", "juanca@suarez.com", "423259070");
        personaDAO.modificar(personaModificada);
        
        
        // personaDAO.eliminar(4);
        List<Persona> personas = personaDAO.seleccionar();
        
        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });
        
        
        
    }
    
}