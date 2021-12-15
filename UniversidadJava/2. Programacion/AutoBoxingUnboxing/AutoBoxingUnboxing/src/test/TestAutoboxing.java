package test;

public class TestAutoboxing {
    
    public static void main(String[] args) {
        
        // clases envolventes de tipos primitivos
        /* 
            Las clases envolventes contiene atributos y metodos
            int - Integer
            float - Float
            double - Double
            boolean - Boolean
            byte - Byte
            char - Character
            short - Short
        */

        Integer entero = 10; // autoboxing
        System.out.println("entero: " + entero); // literal de tipo int
        System.out.println("entero: " + entero.toString()); // literal de tipo String
        System.out.println("entero double : " + entero.doubleValue()); // literal de tipo Double

        int entero2 = entero; // esto es unbomxing
        System.out.println("entero2: " + entero2);

    }

}
