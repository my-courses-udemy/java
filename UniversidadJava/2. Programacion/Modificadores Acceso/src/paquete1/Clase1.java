package paquete1;

// public puede ser usado desde cualquier lado
// default solo puede ser usado en el paquete
public class Clase1 {
    
    protected String atributoprotected = "valor atributo protected"; 

    protected Clase1(){
        System.out.println("constructor protected");
    }

    public Clase1(String arg){
        System.out.println("constructor publico");

    }

    protected void metodoProtected() {
        System.out.println("metodo protected");
    }

}
