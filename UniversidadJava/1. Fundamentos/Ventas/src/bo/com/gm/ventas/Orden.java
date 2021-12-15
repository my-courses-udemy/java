package bo.com.gm.ventas;

public class Orden {

    private int idOrden;
    private Producto productos[];
    private int contadorProductos;
    private static int contadorOrdenes;
    private static final int MAX_PRODUCT = 10;

    public Orden() {

        this.idOrden = ++Orden.contadorOrdenes; // siempre indicar el nombre de la clase y su atributo estatico
        this.productos = new Producto[Orden.MAX_PRODUCT];

    }

    public void agregarProducto(Producto producto) {

        if (this.contadorProductos < Orden.MAX_PRODUCT) {
            this.productos[this.contadorProductos++] = producto;
        } else {
            System.out.println("Se ha superado el maximo de productos: " + Orden.MAX_PRODUCT);
        }

    }

    public double calcularTotal() {

        double total = 0;
        for (int i = 0; i < this.contadorProductos; i++) {
//            Producto producto = this.productos[i];
//            total += producto.getPrecio();
            total += this.productos[i].getPrecio();
        }
        return total;

    }

    public void mostrarOrden() {

        System.out.println("Id Orden: " + this.idOrden);
        double totalOrden = calcularTotal();
        System.out.println("Total orden: $" + totalOrden);
        System.out.println("Productos de la orden: ");

        for (int i = 0; i < this.contadorProductos; i++) {

            System.out.println("    " + this.productos[i]);

        }

    }

}
