package org.bo.pattern.observer.example;

import org.bo.pattern.observer.Corporation;

public class ExampleObserver {

    public static void main(String[] args) {
        Corporation google = new Corporation("Google", 1000);
        google.addObserver((observable, object) -> {
            System.out.println("Jhon " + observable);
        });

        google.addObserver((observable, object) -> {
            System.out.println("Andres " + observable);
        });

        google.modifyPrice(2000);
    }

}
