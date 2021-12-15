
package test;

import domain.Persona;

public class TestArrreglosObject {

    public static void main(String[] args) {
        
        // como es tipo object su valor es null
        Persona personas[] = new Persona[2]; // un arreglo de personas
        
        personas[0] = new Persona("Santi");
        personas[1] = new Persona("Dani");
        
//        System.out.println("persona 1 = " + personas[0]);
        
        for(int i = 0; i < personas.length; i++){
            
            System.out.println("persona " + i + ": " + personas[i]);
        
        }
        
    }
    
}
