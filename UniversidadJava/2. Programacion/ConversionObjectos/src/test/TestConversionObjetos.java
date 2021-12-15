package test;

import domain.*;

public class TestConversionObjetos {
    
    public static void main(String[] args) {
        Empleado empleado;

        empleado = new Escritor("Juan", 5000, TipoEscritura.CLASICO);
        System.out.println(empleado);

        // accedemos a la informacion del hijo, porque el metodo esta sobreescrito
        System.out.println(empleado.obtenerDetalles());
        
        // DOWNCASTING
        // para poder acceder a metodos del hijo no sobreescritos debemos convertir empleado en tipo EScritor
        // System.out.println(((Escritor) empleado).getTipoEscritura()); 
        Escritor escritor = (Escritor) empleado;
        System.out.println(escritor.getTipoEscritura());

        // UPCASTING, no es necesario hacer una conversion
        Empleado empleado2 = escritor;
        System.out.println(empleado2.obtenerDetalles());

    }

}
