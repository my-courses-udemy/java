package test;

import paquete1.Clase1;
import paquete2.ClaseHija;

public class testModificadoresAcceso {
    
    public static void main(String[] args) {
        
        // Clase1 clase1 = new Clase1("auto");
        /* System.out.println("clase1: " + clase1.atributoPublico);
        clase1.metodoPublico(); */
        ClaseHija claseHija = new ClaseHija();
        System.out.println("ClaseHija: " + claseHija );

    }

}
