package test;

import enumeracion.Continentes;
import enumeracion.Dias;

public class TestEnumeraciones {
    
    public static void main(String[] args) {
        
//        System.out.println("Dia 1 de la semana: " + Dias.LUNES);
    //    indicarDiaSemana(Dias.SABADO);
        System.out.println("Coninente nro 4: " + Continentes.OCEANIA);
        System.out.println("Numero paises continente nro 4: " + Continentes.OCEANIA.getPaises());
        System.out.println("Coninente nro 1: " + Continentes.AFRICA);
        System.out.println("Numero paises continente nro 1: " + Continentes.AFRICA.getPaises());
        
    }
    
    private static void indicarDiaSemana(Dias dias){
        
        switch(dias){
            case LUNES:
                System.out.println("Primer dia de la semana");
                break;
            case MARTES:
                System.out.println("Segundo dia de la semana");
                break;
            case MIERCOLES:
                System.out.println("Tercer dia de la semana");
                break;
            case JUEVES:
                System.out.println("Cuarto dia de la semana");
                break;
            case VIERNES:
                System.out.println("Quinto dia de la semana");
                break;
            case SABADO:
                System.out.println("Sexto dia de la semana");
                break;
            case DOMINGO:
                System.out.println("Septimo dia de la semana");
                break;
        }
        
    }
    
}
