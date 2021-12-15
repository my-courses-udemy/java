
public class OperadorTernario {

    public static void main(String args[]){
        
        var resultado = (3 > 3) ? "3 es mayor que 2" : "el 1er valor no es mayor que el 2do";
        System.out.println("resultado = " + resultado);
        
        var numero = 3;
        resultado = (numero % 2 == 0) ? "el numero es par" : "el numero es impar";
        System.out.println("resultado = " + resultado);
    }
    
}
