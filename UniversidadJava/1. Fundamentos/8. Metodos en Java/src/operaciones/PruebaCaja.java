
package operaciones;

public class PruebaCaja {

    public static void main(String[] args) {
        
        Caja caja1 = new Caja(3,2,6);
        
        int volumenCaja = caja1.calcularVolumen();
        System.out.println("volumenCaja = " + volumenCaja);
        
    }
    
}
