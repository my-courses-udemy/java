package test;

public class TestArgumentosVariables {
    
    public static void main(String[] args) {
        
        imprimirNumeros(3,5,6,6);
        imprimirNumeros(3,6);
        variosParametros("Santi", 1,2,3);
        
    }
    
    // si tenemos varios argumentos el argumento variable debe estar al final
    private static void variosParametros(String nombre, int... numeros){
        
        System.out.println("El nombre: " + nombre);
        imprimirNumeros(numeros);
        
    }
    
    // recibira N cantidad de variables de tipo int
    private static void imprimirNumeros(int... numeros){// se comporta como un arreglo
        
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Elemento: " + numeros[i]);
        }
        
    }
    
}
