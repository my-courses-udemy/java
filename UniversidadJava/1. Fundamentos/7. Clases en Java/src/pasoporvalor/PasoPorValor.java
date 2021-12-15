
package pasoporvalor;

public class PasoPorValor {

    public static void main(String[] args) {
        
        var x = 10;
        System.out.println("x = " + x);
        
        cambioValor(x); // lo que hacemos es mandar una copia al metodo
        
        System.out.println("x nuevo valor = " + x); // aunque modifiquemos el argumento, no modifica el valor de x
    }
    
    public static void cambioValor(int arg1){ // para poder realizar cambios debemos retornar el nuevo valor
        
        System.out.println("arg1 = " + arg1);
        arg1 = 15;
        
    }
    
}
