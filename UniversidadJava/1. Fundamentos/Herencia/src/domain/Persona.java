
package domain;


public class Persona {
 
    // las clases hijas acceden aunque no esten en este paquete
    protected String nombre; // asi definimos que esta clase heredara estos valores a sus hijos
    protected char genero;
    protected int edad;
    protected String direccion;
    
    public Persona(){
        
    }
    
    public Persona(String nombre){
        this.nombre = nombre;
    }

    // insert code, constructor
    public Persona(String nombre, char genero, int edad, String direccion) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", genero=" + genero + ", edad=" + edad + ", direccion=" + direccion + "}";
    }

}
