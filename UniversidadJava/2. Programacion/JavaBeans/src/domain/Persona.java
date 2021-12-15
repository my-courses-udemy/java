package domain;

import java.io.Serializable;

public class Persona implements Serializable {

    private String nombre;
    private String apelllido;

    // OBLIGATORIO tener siempre un constructor vacio, cuando mandemos los demas metodos no sabran cuantos parametros necesita para crear el objeto de este tipo de clase 
    public Persona(){
        
    }
    
    public Persona(String nombre, String apelllido) {
        this.setNombre(nombre);
        this.setApelllido(apelllido);
    }

    public String getApelllido() {
        return apelllido;
    }

    public void setApelllido(String apelllido) {
        this.apelllido = apelllido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona [apelllido=" + apelllido + ", nombre=" + nombre + "]";
    }
       
}