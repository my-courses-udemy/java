
package test;

import Aritmetica.Aritmetica;
import excepciones.OperacionExcepcion;

public class TestExcepciones {

    public static void main(String[] args) {
        int resultado = 0;
        try {
            resultado = Aritmetica.division(10, 0);
        } catch (OperacionExcepcion e) {
            e.printStackTrace(System.out);
            System.out.println(e.getClass());
        } finally {
            System.out.println("Se reviso la division entre 0");
        }
        System.out.println("resultado = " + resultado);
    }
    
}
