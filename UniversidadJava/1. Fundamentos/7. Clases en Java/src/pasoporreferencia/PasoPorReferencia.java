
package pasoporreferencia;

import classes.Persona; // importamos la clase Persona

public class PasoPorReferencia {

    public static void main(String[] args) {
        
        Persona persona1 = new Persona(); // todo tipo Object almacena paso por referencia
        persona1.nombre = "Santi";
        System.out.println("nombre persona1 = " + persona1.nombre);
        persona1.apellido = "Sanchez";
        
        persona1 = cambiaValor(persona1); // en objetos, si se puede cambiar el valor porque apunta a la misma referencia
        
        System.out.println("persona1 cambio nombre = " + persona1.nombre);
        
    }
    
//    public static void cambiaValor(Persona persona){
//        
//        persona.nombre = "Dani";
//        
//    }
    
    public static Persona cambiaValor(Persona persona){
        
        if(persona == null){
            return null;
        }
        
        persona.nombre = "Dani";
        return persona;
        
    }
    
}
