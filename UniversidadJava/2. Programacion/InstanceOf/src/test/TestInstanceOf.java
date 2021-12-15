package test;

import domain.Empleado;
import domain.Gerente;

public class TestInstanceOf {
    
    public static void main(String[] args) {
        Empleado empleado = new Empleado("Santi", 2000);
        determinarTipo(empleado);
        empleado = new Gerente("Sho", 20000, "Sistemas"); // empleado apunta a un tipo Gerente
        determinarTipo(empleado);
    }

    public static void determinarTipo(Empleado empleado) {
        // primero las clases hija luego las clases padre
        // ligar con else if
        if(empleado instanceof Gerente){
            System.out.println("es de tipo Gerente");
            // nos ayuda el id, debemos decir que es un empleado de tipo Gerente
            // hay 2 formas:
            Gerente gerente = (Gerente) empleado;
            System.out.println(gerente.getDepartamento());
            // gerente.getDepartamento();
            // y la otra forma es todo en una linea
            // ((Gerente) empleado).getDepartamento();
        } else if (empleado instanceof Empleado){
            System.out.println("es de tipo Empleado");
            System.out.println(empleado.getNombre());
        } else if(empleado instanceof Object){
            System.out.println("es de tipo Objeto");
            System.out.println(empleado.toString());
        }
    }

}
