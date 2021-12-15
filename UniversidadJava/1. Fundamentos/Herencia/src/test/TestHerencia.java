
package test;

import domain.Cliente;
import domain.Empleado;
import java.util.Date;

public class TestHerencia {
    
    public static void main(String[] args) {
        
        Empleado empleado = new Empleado("Santi",200);
        System.out.println("empleado = " + empleado);
        
//        Cliente c = new Cliente(new Date(),false,"Santi",'F',12,"Santa Monica");
//        System.out.println("c = " + c);
        
    }
    
}
