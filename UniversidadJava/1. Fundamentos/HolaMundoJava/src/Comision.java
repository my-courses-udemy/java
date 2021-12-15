
import java.util.ArrayList;


public class Comision {

    public ArrayList<Persona> listaComision = new ArrayList<>();
    
    public void definirComision(){
        Persona presidente = new Persona("Alfonso Cuella",23244,false,"presidente");
        Persona vocal1 = new Persona("Roberto 1",23245,false,"vocal");
        Persona vocal2 = new Persona("Roberto 2",23246,false,"vocal");
        Persona vocal3 = new Persona("Roberto 3",23241,false,"vocal");
        Persona vocal4 = new Persona("Roberto 4",23242,false,"vocal");
        
        listaComision.add(presidente);
        listaComision.add(vocal1);
        listaComision.add(vocal2);
        listaComision.add(vocal3);
        listaComision.add(vocal4);
    }
    
    public String votar(){
        String res = "";
        int votoFavor = 0;
        int votoContra = 0;
        for(int i = 1; i < listaComision.size(); i++){
            if (listaComision.get(i).getVoto() == true){
                votoFavor++;
            } else{
                votoContra++;
            }
        }
        return votar2(votoFavor,votoContra);
    }
    
    public String votar2(int votoFavor, int votoContra){
        String res = "";
        if(votoFavor == votoContra){
            if (listaComision.get(0).getVoto() == true){
                votoFavor++;
            } else{
                votoContra++;
            }
        }
        if(votoFavor > votoContra){
            res = "Se aprueba el proyecto";
        }
        
        else if(votoContra > votoFavor) {
            res = "No se aprobo el proyecto";
        }
        return res;
    }
    
    public static void main(String args[]){
        Comision comision = new Comision();
        comision.definirComision();
        comision.listaComision.get(0).setVoto(false);
        comision.listaComision.get(1).setVoto(true);
        comision.listaComision.get(3).setVoto(true);
        
        String res = comision.votar();
        System.out.println(res);
    }
    
}
