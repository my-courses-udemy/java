public class Cancion {
    
    private String nombre;
    private double duracion;
    private boolean enVivo;
    
    public Cancion(String nombre, double duracion, boolean enVivo) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.enVivo = enVivo;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getDuracion() {
        return duracion;
    }
    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
    public boolean isEnVivo() {
        return enVivo;
    }
    public void setEnVivo(boolean enVivo) {
        this.enVivo = enVivo;
    }

}
