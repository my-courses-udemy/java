package test;

import java.util.*;

public class TestCollections {

    public static void main(String[] args) {
        
        // ARRAYLIST
        List myList = new ArrayList();
        myList.add("Monday");
        myList.add("Thursday");
        myList.add("Wenesday");
        myList.add("Thrurday");
        myList.add("Friday");
        myList.add("Saturday");
        myList.add("Sunday");
        myList.add("Sunday"); // se pueden duplicar elementos
        myList.add(23);
        System.out.println("List con orden:");
        print(myList);
        System.out.println("");
        
        // SET
        Set miSet = new HashSet();
        miSet.add("Monday");
        miSet.add("Thursday");
        miSet.add("Wenesday");
        miSet.add("Thrurday");
        miSet.add("Friday");
        miSet.add("Saturday");
        miSet.add("Sunday");
        miSet.add("Sunday"); // no se pueden duplicar elementos
        miSet.add(23);
        System.out.println("Set sin orden:");
        print(miSet);
        
        // MAP
        Map miMapa = new HashMap();
        miMapa.put("valor1", "Juan");
        miMapa.put("valor2", "Roberto");
        miMapa.put("valor3", "Carla");
        
        String elemento = miMapa.get("valor1").toString();
        System.out.println("elemento = " + elemento);
        
        print(miMapa.keySet());
        print(miMapa.values());
        
    }
    
    private static void print(Collection collection){
        // CICLO FOREACH LAMBDA
        collection.forEach(element -> {
            System.out.println(element);
        });
    }

}
