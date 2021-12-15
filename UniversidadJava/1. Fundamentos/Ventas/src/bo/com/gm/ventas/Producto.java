
package bo.com.gm.ventas;

// siempre creamos la clase que no tiene dependencias
public class Producto {

    private final int idProducto;
    private String nombre;
    private double precio;
    private static int contadorProductos;
    
    private Producto(){
        
        this.idProducto = ++Producto.contadorProductos;
        
    }
    
    public Producto(String nombre, double precio){
        
        // hacemos la llamada al constructor vacio
        this();
        this.nombre = nombre;
        this.precio = precio;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + '}';
    }
    
}
