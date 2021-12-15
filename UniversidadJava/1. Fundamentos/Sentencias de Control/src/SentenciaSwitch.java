
public class SentenciaSwitch {

    public static void main(String args[]){
        
        var numero = 2;
        var numero_texto = "valor desconocido";
        
        switch( numero ){
            case 1:
                numero_texto = "numero uno";
                break;
            case 2:
                numero_texto = "numero dos";
                break;
            case 3:
                numero_texto = "numero tres";
                break;
            case 4:
                numero_texto = "numero cuatro";
                break;
            default:
                numero_texto = "caso no encontrado";
        }
        
        System.out.println("numero_texto = " + numero_texto);
        
    }
    
}
