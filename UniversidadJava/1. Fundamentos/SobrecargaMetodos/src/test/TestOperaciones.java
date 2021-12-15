
package test;

import operaciones.Operaciones;

public class TestOperaciones {

    public static void main(String[] args) {
        
        var resultado = Operaciones.sumar(3, 10);// la variable resultado es de tipo entero
        System.out.println("resultado = " + resultado);
        
        var resultado2 = Operaciones.sumar(12.0, 12.2); // no podemos asignar un double a un entero
        System.out.println("resultado2 = " + resultado2);
        
    }
    
}
