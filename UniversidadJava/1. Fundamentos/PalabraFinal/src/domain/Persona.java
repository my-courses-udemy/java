
package domain;

// en las clases al poner final no podemos tener clases hijas
public final class Persona {
    
    // siempre se poner final y static, se la conoce como constante, SE ESCRIBE EN MAYUSCULA
    public static final int MI_CONSTANTE = 10;
    
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // este metodo de tipo final no se puede modificar su comportamiento
    public final void imprimir(){
        System.out.println("Metodo Imprimir");
    }
    
}
