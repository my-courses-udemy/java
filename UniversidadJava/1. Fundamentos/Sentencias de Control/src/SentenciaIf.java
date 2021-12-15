
public class SentenciaIf {

    public static void main(String args[]){
        
        var condicion = false;
        
        if (condicion){ // pregunta si la condicion es true
            System.out.println("condicino es true");
        } else {
            System.out.println("condicion es false");
        }
        
        
        var numero = 6;
        var numero_texto = "Numero desconocido";
        
        if ( numero == 1 ){
            numero_texto = "Numero 1";
        } else if ( numero == 2 ){
            numero_texto = "Numero 2";
        } else if ( numero == 3 ){
            numero_texto = "Numero 3";
        } else if ( numero == 4 ) {
            numero_texto = "Numero 4";
        } else {
            numero_texto = "Numero no encontrado";
        }
        
        System.out.println("numero_texto = " + numero_texto);
        
    }
    
}
