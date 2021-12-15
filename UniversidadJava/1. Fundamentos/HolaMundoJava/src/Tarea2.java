
import java.util.Scanner;


public class Tarea2 {

    public static void main(String args[]){
        
        var consola = new Scanner(System.in);
        
        System.out.print("Proporciona el titulo:");
        var titulo = consola.nextLine();
        System.out.print("Proporciona el autor:");
        var autor = consola.nextLine();
        System.out.println(titulo + " fue escrito por el autor " + autor);
        
    }
    
}
