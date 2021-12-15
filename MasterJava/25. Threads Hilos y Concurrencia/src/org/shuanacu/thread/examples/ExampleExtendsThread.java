package org.shuanacu.thread.examples;

import org.shuanacu.thread.examples.threads.NameThread;

public class ExampleExtendsThread {

    public static void main(String[] args) throws InterruptedException {
        // BOTH RUN AT THE SAME TIME
        Thread hilo = new NameThread("Santi Sanchez");

        hilo.start();
        // Thread.sleep(3);
        // Show the thread status

        Thread hilo2 = new NameThread("Maria");
        hilo2.start();

        Thread hilo3 = new NameThread("Pepe");
        hilo3.start();

        System.out.println(hilo.getState());
    }

}
