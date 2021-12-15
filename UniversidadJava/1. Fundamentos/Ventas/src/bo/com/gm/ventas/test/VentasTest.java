
package bo.com.gm.ventas.test;

//import bo.com.gm.ventas.*;
import bo.com.gm.ventas.Producto;
import bo.com.gm.ventas.Orden;

public class VentasTest {

    public static void main(String[] args) {
        
        Producto producto1 = new Producto("Camisa",200);
        Producto producto2 = new Producto("Pantalon",100);
        Producto producto3 = new Producto("Corbata",50);
        
        Orden orden = new Orden();
        orden.agregarProducto(producto3);
        orden.agregarProducto(producto3);
        orden.agregarProducto(producto3);
        orden.agregarProducto(producto1);
        orden.agregarProducto(producto1);
        orden.agregarProducto(producto1);
        orden.agregarProducto(producto2);
        orden.agregarProducto(producto2);
        orden.mostrarOrden();
        
    }
    
}
