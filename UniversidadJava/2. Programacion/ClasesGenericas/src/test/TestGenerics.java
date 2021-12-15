package test;

import generico.ClaseGenerica;

public class TestGenerics {
    
    public static void main(String[] args) {
        
        ClaseGenerica<Integer> objetoInt = new ClaseGenerica<Integer>(15);
        objetoInt.obtenerTipo();

        ClaseGenerica<String>  objString = new ClaseGenerica<String>("Hola santi");
        objString.obtenerTipo();

    }

}
