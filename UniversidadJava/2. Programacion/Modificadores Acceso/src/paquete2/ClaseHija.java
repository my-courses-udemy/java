package paquete2;

import paquete1.Clase1;

public class ClaseHija extends Clase1 {
    
    // podemos usar al padre desde otro paquete
    public ClaseHija(){
        super();
        this.atributoprotected = "modificando el atributo protected";
        System.out.println("atributo protegido: " + this.atributoprotected);
        this.metodoProtected();
    }

}
