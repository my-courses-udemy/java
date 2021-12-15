package test;

import static aritmetica.Aritmetica.division;

import excepciones.OperacionExcepcion;

public class TestExcepciones {

    public static void main(String[] args) {
        int resultado = 0;
        try {
            resultado = division(10, 0);
        } catch(OperacionExcepcion e){
            System.out.println(e.getMessage());
        } catch (Exception e) { // recibimos la excepcion
            System.out.println("Ocurrio un error:");
            // e.printStackTrace(System.out); // imprimimos la pila de excepciones
            System.out.println(e.getMessage());// podemos imprimir directamente el mensaje
        } finally {
            System.out.println("Se reviso la division entre 0");
        }
        System.out.println("resultado = " + resultado);

    }
    
}