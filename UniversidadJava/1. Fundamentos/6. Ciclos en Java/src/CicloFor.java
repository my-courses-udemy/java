
public class CicloFor {

    public static void main(String args[]){
        
        inicio: // el continue viene hasta aca, lo mismo con break
        for(int i = 0; i < 10; i++){
            if( i % 2 != 0 ){
                
                continue inicio; // salta a la sig iteracion
                
            }
            
            System.out.println("i:" + i);
        }
        
//        for(int i = 0; i < 10; i++){
//            if( i % 2 == 0 ){
//                
//                System.out.println("i:" + i);
////                break; // rompe el ciclo for
//            }
//        }
//        
    }
    
}
