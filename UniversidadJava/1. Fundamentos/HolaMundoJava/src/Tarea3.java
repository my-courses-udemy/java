
import java.util.Scanner;


public class Tarea3 {

    public static void main(String args[]){
        
        var consola = new Scanner(System.in);
        
        System.out.print("Proporciona el nombre: ");
        var nombre = consola.nextLine();
        System.out.print("Proporciona el id: ");
        var id = consola.nextLine();
        System.out.print("Proporciona el precio: ");
        var precio = consola.nextLine();
        System.out.print("Proporciona el envio gratuito: ");
        var envio = consola.nextLine();
        
        System.out.println(nombre + " #" + id);
        System.out.println("Precio: " + precio);
        System.out.println("Envio gratuito: " + envio);
        
    }
    
}
