
package test;

import domain.Persona;


public class TestFinal {
    
    public static void main(String[] args) {
        
        final int miVariable = 10; // no podemos modificar su valor despues de definirla
        System.out.println("miVariable = " + miVariable);
        
//        miVariable = 5; no se puede hacer esta accion

        System.out.println("Mi constante: " + Persona.MI_CONSTANTE);
        
        final Persona persona1 = new Persona();
        // no se puede agregar: persona1 = new Persona()
        
        // si podemos cambiar sus atributos y utilizar sus metodos
        persona1.setNombre("Santi");
        System.out.println("persona1 = " + persona1.getNombre());
        
    }
    
}
