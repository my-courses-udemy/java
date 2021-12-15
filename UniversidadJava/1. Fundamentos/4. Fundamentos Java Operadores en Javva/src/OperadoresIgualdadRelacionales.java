
public class OperadoresIgualdadRelacionales {

    public static void main(String args[]){
        var a = 3;
        var b = 2;
        
        var c = (a == b);// devuelve un boolean
        System.out.println("c = " + c);
        
        var d = a != b;
        System.out.println("d = " + d);
        
        var cadena = "Hola";
        var cadena2 = "Adios";
        
        var e = cadena == cadena2;// compara la referencia del objeto que almacena la variable
        var f = cadena.equals(cadena2); 
        System.out.println("e = " + e);
        System.out.println("f = " + f);
    
        // operadores realcionales
        var g = a >= b;
        System.out.println("g = " + g);
        
        var edad = 38;
        var adulto = 18;
        if (edad > adulto){
            System.out.println("Es adulto");
        } else {
            System.out.println("Es menor de edad");
        }
        
    }
    
}
