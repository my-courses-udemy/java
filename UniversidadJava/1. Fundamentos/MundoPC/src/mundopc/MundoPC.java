package mundopc;

import bo.com.gm.mundopc.*;

public class MundoPC {
    
    public static void main(String[] args) {
        
        Monitor monitor = new Monitor("HP", 13);
        Teclado teclado = new Teclado("bluetooh", "HP");
        Raton raton = new Raton("Bluetooh", "HP");
        
        Computadora computadora = new Computadora("HP", monitor, teclado, raton);
        
        Monitor monitorGamer = new Monitor("HP", 34);
        Teclado tecladoGamer = new Teclado("bluetooh", "Gamer");
        Raton ratonGamer = new Raton("Bluetooh", "Gamer");
        
        Computadora computadoraGamer = new Computadora("HP", monitorGamer, tecladoGamer, ratonGamer);
        
        Orden orden1 = new Orden();
        orden1.agregarComputadora(computadora);
        orden1.agregarComputadora(computadoraGamer);
        orden1.mostrarOrden();
        
    }
    
}
