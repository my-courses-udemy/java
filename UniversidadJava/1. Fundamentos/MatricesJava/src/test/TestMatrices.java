
package test;

import domain.Persona;

public class TestMatrices {

    public static void main(String[] args) {
        
        int edades[][] = new int[3][2];
        
        edades[0][0] = 5;
        edades[0][1] = 10;
        edades[1][0] = 15;
        edades[1][1] = 20;
        edades[2][0] = 25;
        edades[2][1] = 30;
        
        // el valor por default de los demas es 0;
        
//        System.out.println("edades valor 0 - 0: " + edades[0][0]);
        for (int fila = 0; fila < edades.length; fila++) {
            for (int col = 0; col < edades[fila].length; col++) {
                System.out.println("edades valor " + fila + "-" + col + ": " + edades[fila][col]);   
            }   
        }
        
        // SINTAXIS SIMPLIFICADA
        String frutas[][] = {{"Naranja","Limon"},{"Sandia","Higo"}};
        imprimir(frutas);
        
        Persona personas[][] = new Persona[2][2];
        
        personas[0][0] = new Persona("Juan");
        personas[0][1] = new Persona("Pedro");
        personas[1][0] = new Persona("Albert");
        personas[1][1] = new Persona("Maria"); // cuando no esta inicializado la res. es null
        imprimir(personas);
        
    }
    
    public static void imprimir(Object matriz[][]){ // hacemos referencia q es una matriz
        for (int fila = 0; fila < matriz.length; fila++) {  
            for (int col = 0; col < matriz[fila].length; col++) {
                System.out.println("Matriz valor " + fila + "-" + col + ": " + matriz[fila][col]);   
            }   
        }
    }
    
}
