
package Aritmetica;

import excepciones.OperacionExcepcion;

public class Aritmetica {

    public static int division(int numerador, int denominador) 
            throws OperacionExcepcion{
        if( denominador == 0){
            // reportamos la excepcion
            throw new OperacionExcepcion("Division entre 0");
        }
        return numerador/denominador;
    }
    
}
