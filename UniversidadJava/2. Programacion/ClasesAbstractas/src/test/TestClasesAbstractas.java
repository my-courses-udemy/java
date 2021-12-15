package test;

import domain.FiguraGeometrica;
import domain.Rectangulo;

public class TestClasesAbstractas {
    
    public static void main(String[] args) {
        
        // no podemos crear objetos de la clase abstracta
        // FiguraGeometrica f = new FiguraGeometrica("aitps");
        FiguraGeometrica figura = new Rectangulo("Rectangulo");
        figura.dibujar();

    }

}
