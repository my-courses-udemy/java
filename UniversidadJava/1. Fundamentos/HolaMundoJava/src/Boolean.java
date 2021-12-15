
public class Boolean {
    
    public static void main(String args[]){
        
        boolean valor = true;
        System.out.println("valor = " + valor);
        
        if (valor) {
            System.out.println("La bandera es verdadera =D");
        } else {
            System.out.println("La bandera es falsa");
        }
        
        var edad = 10;
        var esAdulto = edad >= 18; // lo podemos usar en nuestra asignacion, y el valor de esAdulto es un boolean
        if (esAdulto) {
            System.out.println("Eres mayor de edad");
        } else {
            System.out.println("Eres menor de edad");
        }
        
    }
    
}
