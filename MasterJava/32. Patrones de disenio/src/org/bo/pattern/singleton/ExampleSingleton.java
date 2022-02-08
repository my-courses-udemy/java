package org.bo.pattern.singleton;

public class ExampleSingleton {

    public static void main(String[] args) {
        BDConnectionSingleton conn = null;
        for (int index = 0; index < 10; index++) {
            conn = BDConnectionSingleton.getInstance();
            System.out.println("bdConnectionSingleton = " + conn);
        }
        BDConnectionSingleton conn2 = BDConnectionSingleton.getInstance();
        BDConnectionSingleton conn3 = BDConnectionSingleton.getInstance();
        boolean isEquals = ((conn == conn2) && (conn2 == conn3));
        System.out.println("isEquals = " + isEquals);
    }

}
