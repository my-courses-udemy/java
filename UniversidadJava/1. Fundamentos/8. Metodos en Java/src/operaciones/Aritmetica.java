package operaciones;

public class Aritmetica {

    int a;
    int b;
    
    public Aritmetica(){
        System.out.println("Soy un constructor");
    }

    // sobrecarga de constructores
    public Aritmetica(int a, int b){
        
        System.out.println("Constructor con  argumentos");
        this.a = a;
        this.b = b;
        
    }
    
    // metodo
    public void sumar() {
        
        int resultado = a + b;
        System.out.println("Suma de a + b: " + resultado );
        
    }
    
    public int sumarConRetorno(){
        return a + b;
    }
    
    public int sumarConArgumentos(int a, int b){
        
        this.a = a;
        this.b = b;
        
        return this.sumarConRetorno()   ;
        
    }

}
