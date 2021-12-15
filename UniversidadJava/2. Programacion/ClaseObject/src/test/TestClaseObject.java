package test;

import domain.Empleado;

public class TestClaseObject {
    
    public static void main(String[] args) {
        
        Empleado empleado1 = new Empleado("juan", 4000);
        Empleado empleado2 = new Empleado("juan", 4000);

        // con el igual comparamos la direccion de memoria
        if(empleado1 == empleado2){
            System.out.println("tienen la misma referencia en memoria");
        } else {
            System.out.println("tienen distinta referencia en memoria");
        }

        // comparamos contenido
        if(empleado1.equals(empleado2)){
            System.out.println("los objectos son iguales en contenido");
        } else {
            System.out.println("los objetos son diferentes en contenido");
        }

        // comparando utilizando un valor entero
        if(empleado1.hashCode() == empleado2.hashCode()){
            System.out.println("el valor hashCode es igual");
        } else {
            System.out.println("el valor hascoud es distinto");
        }

    }

}
