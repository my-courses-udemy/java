
package test;
import dominio.Persona; // se importa asi

public class PersonaPrueba {

    public static void main(String[] args) {
        
        Persona persona = new Persona("Santi", 5000, false);
//        System.out.println("nombre persona = " + persona.getNombre() );
        System.out.println("persona = " + persona.toString() );
        persona.setNombre("Santiago");
//        System.out.println("nombre persona = " + persona.getNombre() );
//        System.out.println("sueldo persona = " + persona.getSueldo() );
//        System.out.println("eliminado persona = " + persona.isEliminado());
        
        System.out.println("persona = " + persona ); // cuando estamos dentro del metodo print, no es necesario poner toString()
        
    }
    
}
