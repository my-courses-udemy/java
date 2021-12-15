
package test;

//import bo.com.globalmentoring.Utileria;

// para importar metodos estaticos
import static bo.com.globalmentoring.Utileria.imprimir;

public class TestUtileria {

    public static void main(String[] args) {
        
//        Utileria.imprimir("hola mundo");

        // podemos imprimir metodos estaticos
        imprimir("Hola mundo");
        
        // podemos llamar directamente el paquete, la clase y su metodo
        bo.com.globalmentoring.Utileria.imprimir("hola");

    }
    
}
