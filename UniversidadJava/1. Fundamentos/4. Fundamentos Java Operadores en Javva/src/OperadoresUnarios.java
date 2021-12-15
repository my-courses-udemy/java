
public class OperadoresUnarios {

    public static void main(String args[]){
        
        var a = 3;
        var b =  -a; // esto es un opeardor unario, le asignamos el valor de a pero con signo negativo
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        
        var c = true;
        var d = !c; // esto es un valor unario, un valor de negacion
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        
        // incremento
        // el pre incremento
        var e = 3;
        var f = ++e; // primero incrementa la variable e, luego usa su valor
        System.out.println("e = " + e);
        System.out.println("f = " + f);
        
        var g = 5;
        var h = g++; // primero se usa el valor de g, y luego se incrementa
        System.out.println("g = " + g);
        System.out.println("h = " + h);
       
    }
    
}
