
package operaciones;

public class PruebaAritmetica {

    public static void main(String[] args) {
        
        // variables locales
        var a = 10;
        var b = 2;
        
        Aritmetica aritmetica1 = new Aritmetica();
        System.out.println("Aritmetica1 a: " + aritmetica1.a);
        System.out.println("Aritmetica1 b: " + aritmetica1.b);
        
        Aritmetica aritmetica2 = new Aritmetica(a, b);
        System.out.println("Aritmetica2 a: " + aritmetica2.a);
        System.out.println("Aritmetica2 b: " + aritmetica2.b);
        
    }
    
}

//        aritmetica1.a = 2;
//        aritmetica1.b = 3;
//        
//        aritmetica1.sumar();
//        
//        int resultado = aritmetica1.sumarConRetorno();
//        System.out.println("resultado = " + resultado);
//        
//        resultado = aritmetica1.sumarConArgumentos(4, 6);
//        System.out.println("resultado = " + resultado);