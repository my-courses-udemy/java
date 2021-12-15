
package test;

import Domain.Persona;

public class PersonaPrueba {
    
    public static void main(String[] args) {
        
        Persona persona = new Persona("Santi");
        imprimir( persona );
        
        Persona persona2 = new Persona("Dani");
        imprimir( persona2 ); // el metodo estaico nos permite asociarse a la clase
        
    }
    
    // los modificadores puede estar invertidos, no hay diferencia
    static public void imprimir( Persona persona ){
        System.out.println("persona = " + persona);
    }
    
}
