
package test;

import org.graalvm.compiler.phases.common.inlining.policy.GreedyInliningPolicy;

import domain.Empleado;
import domain.Gerente;

public class TestSobreescritura {
    
    public static void main(String[] args) {
        
        /* Gerente gerente1 = new Gerente("Santi", 20000, "Tecnologia");
        System.out.println(gerente1.obtenerDetalles()); */

        Empleado empleado1 = new Empleado("Juan", 5000);
        // System.out.println(empleado1.obtenerDetalles());    
        imprimir(empleado1);
        
        Gerente gerente1 = new Gerente("Carla", 10000, "contabilidad");
        // System.out.println(gerente1.obtenerDetalles()); 
        imprimir(gerente1);

        

    }

    public static void imprimir(Empleado empleado) {
        // el metodo es del objeto empleado, si se lo llama o de tipo gerente
        System.out.println(empleado.obtenerDetalles()); 

    }

}
