
package test;

public class TestArreglos {
    public static void main(String[] args) {
        int edades[] = new int[3];
        System.out.println("edades = " + edades);
        
        edades[0] = 5;
        System.out.println("edades[0] = " + edades[0]);
        edades[1] = 10;
        System.out.println("edades[0] = " + edades[1]);
        edades[2] = 15;
        System.out.println("edades[0] = " + edades[2]);
        
        // edades[3] = 20; // error en tiempo de ejecucion
        
        for(int i = 0; i < edades.length; i++){
            System.out.println("Edades elemento " + i + ": " + edades[i] );
        }
        
        // sintaxis resumida
        String frutas[] = {"frutilla", "manzana", "sandia"};
        
        for(int i = 0; i < frutas.length; i++){
            System.out.println("Frutas elemento " + i + ": " + frutas[i] );
        }
        
    }
}
