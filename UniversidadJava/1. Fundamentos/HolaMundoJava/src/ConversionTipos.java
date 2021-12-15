
import java.util.Scanner;

public class ConversionTipos {

    public static void main(String args[]){
        
        // CONVERSION DE STRING A ENTERO
        var edad = Integer.parseInt("20"); // usamos integer y su metodo parseInt
        System.out.println("edad = " + (edad + 1));
        
        var valorPi = Double.parseDouble("3.1416"); // usamor de double su metodo parseDouble
        System.out.println("valorPi = " + valorPi);
        
        // Pedimos un valor
//        System.out.print("Proporciona tu edad: ");
        var consola = new Scanner(System.in); // pedimos un valor por consola, que es un String
//        edad = Integer.parseInt(consola.nextLine()); // convertimos el valor a un entero para usarlo
//        System.out.println("edad = " + edad);
        
        var edadText = String.valueOf(edad); // asi se vuelve un valor a String
        System.out.println("edadText = " + edadText); 
        
        var caracter = "Hola".charAt(0); // odemos usar charAt para poder seleccionar una letra de indice seleccionado
        System.out.println("caracter = " + caracter);
        
        System.out.print("Proporciona un caracter: ");
        caracter = consola.nextLine().charAt(0); // solo los string tienen el metodo de charAt
        System.out.println("caracter = " + caracter);
        
    }
    
}
