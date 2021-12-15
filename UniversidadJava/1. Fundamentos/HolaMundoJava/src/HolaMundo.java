
import java.util.Scanner; // exportamos la clase Scanner

public class HolaMundo {
    
    public static void main(String args[]) {

        // TIPOS ENTEROS: byte, short, int, long
        
        byte numByte = 10; // no usar
        System.out.println("numByte = " + numByte);
        System.out.println("Valor minimo del Byte: " + Byte.MIN_VALUE);
        System.out.println("Valor maximo del Byte: " + Byte.MAX_VALUE);
        
        short numShort = 10;
        System.out.println("numShort = " + numShort);
        System.out.println("Valor minimo del short: " + Short.MIN_VALUE);
        System.out.println("Valor maximo del short: " + Short.MAX_VALUE);
        
        int numInt = (int) 10L;
        System.out.println("numInt = " + numInt);
        System.out.println("numInt = " + numInt);
        System.out.println("Valor minimo del Int: " + Integer.MIN_VALUE);
        System.out.println("Valor maximo del Int: " + Integer.MAX_VALUE);
        
        
        long numLong = 120;
        System.out.println("numLong = " + numLong);
        System.out.println("Valor minimo del Long: " + Long.MIN_VALUE);
        System.out.println("Valor maximo del Long: " + Long.MAX_VALUE);
        
        // TIPOS PRIMIVITOS FLOTANTES:  float y duoble
        float numFloat = 10;
        System.out.println("numFloat = " + numFloat);
        System.out.println("Valor minimo del Float: " + Float.MIN_VALUE);
        System.out.println("Valor maximo del Float: " + Float.MAX_VALUE);
        
        double numDouble = 10;
        System.out.println("numDouble = " + numDouble);
        System.out.println("Valor minimo del Double: " + Double.MIN_VALUE);
        System.out.println("Valor maximo del Double: " + Double.MAX_VALUE);
        
    }

    /*
    var usuario = "Juan";
        var titulo = "Ingeniero";

        var union = titulo + " " + usuario;
        //System.out.println("union = " + union); // snippet: alt+shift+F
        
        
        var i = 3;
        var j = 4;
        //System.out.println(i + j); // se realiza la suma de numeros
        //System.out.println(i + j + usuario); // se suma los nros, y se concatena con usuario
        //System.out.println(usuario + i + j); // si ponemos primero la cadena, se vuelve todo Stirng
        //System.out.println(usuario + (i + j)); // aca se realiza la suma por prioridad
        
        
        // CARACTERES ESPECIALES EN JAVA
        var nombre = "Karla";
        System.out.println( "Nueva Linea: \n" + nombre ); // \n sirve para salto de linea
        System.out.println("Tabulador: \t" + nombre ); // \t para usar tabulador
        System.out.println("Tabulador: \b" + nombre ); // \b elimina el espacio hacia atras
        System.out.println("Comilla simple: \'" + nombre + "\'"); // \' envolvemos el nombre en 'nombre'
        System.out.println("Comilla simple: \"" + nombre + "\""); // \" envolvemos el nombre en "nombre"
    */
    
    /*
    System.out.print("Escribe tu nombre: ");
        Scanner consola = new Scanner(System.in);
        var usuario = consola.nextLine(); // este metodo lee una linea completa de la consola
        System.out.println("usuario = " + usuario);
        
        System.out.print("Escribe tu titulo: ");
        var titulo = consola.nextLine();
        System.out.println("Resultado: " + titulo + " " + usuario);
    */

}
