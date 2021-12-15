import practica.Cuenta;
import practica.Persona;

public class App {
    public static void main(String[] args) throws Exception {
        
        Persona persona1 = new Persona();
        System.out.println(persona1.mostrar());
        persona1.setNombre("Santi");
        System.out.println(persona1.mostrar());
        persona1.setEdad(15);
        System.out.println(persona1.mostrar());
        
        persona1.setNombre("Gaby");
        System.out.println(persona1.mostrar());

        Cuenta cuenta = new Cuenta(persona1);
        cuenta.ingresarCantidad(100);
        System.out.println(cuenta.mostrar());


    }
}
