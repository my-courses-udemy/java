
public class HolaMundo {
    public static void main(String args[]){
        int a = 3, b = 2; // var no se puede usar para declarar asi
        
        var resultado = a + b;
        
        System.out.println("resultado = " + resultado);
        
        resultado = a - b;
        System.out.println("resultado = " + resultado);
        
        resultado = a * b;
        System.out.println("resultado = " + resultado);
        
        resultado = a / b;
        System.out.println("resultado = " + resultado);
        
        resultado = a % b;
        System.out.println("resultado = " + resultado);
     
        if ( a % 2 == 0){
            System.out.println("Es numero par");
        } else {
            System.out.println("Es numero impar");
        }
        
    } 
}
