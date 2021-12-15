package test;

import domain.Persona;

public class TestJavaBeans {
    
    public static void main(String[] args) {
        
        // uso formalizado del uso de un javabean
        Persona persona = new Persona(); // es necesario implementar serializable para javabeans
        persona.setNombre("Juan");
        persona.setApelllido("Perez");
        System.out.println(persona);
        
        persona = new Persona("Roberto", "Rodriguez");
        System.out.println(persona);

    }

}
