package org.bo.pattern.singleton;

public class BDConnectionSingleton {
    private static BDConnectionSingleton instance;

    private BDConnectionSingleton() {
        System.out.println("Successful connection");
    }

    public static BDConnectionSingleton getInstance() {
//        It will only be created once
        if (instance == null) instance = new BDConnectionSingleton();
        return instance;
    }

}
