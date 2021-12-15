
package classes;

public class PruebaPersona {

    public static void main(String[] args) {
        
        Persona santiago = new Persona();
        santiago.nombre = "Santiago";
        santiago.apellido = "";
        santiago.desplegarInformacion();
        
        Persona persona2 = new Persona();
        persona2.nombre = "Roberto";
        persona2.apellido = "Perez";
        persona2.desplegarInformacion();
        
    }
    
}
