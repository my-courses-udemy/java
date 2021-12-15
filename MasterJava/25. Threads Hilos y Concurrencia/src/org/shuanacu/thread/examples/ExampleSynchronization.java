package org.shuanacu.thread.examples;

import org.shuanacu.thread.examples.runnable.SentencePrinter;

public class ExampleSynchronization {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new SentencePrinter("How are ", "you?"));
        Thread thread2 = new Thread(new SentencePrinter("Thank you ", "so much buddy"));
        Thread thread3 = new Thread(new SentencePrinter("Hello ", "how are you?"));

        thread1.start();
        thread2.start();
        Thread.sleep(100);
        thread3.start();
        Thread.sleep(100);
        System.out.println(thread3.getState());
    }

    public synchronized static void printPhrase(String phrase1, String phrase2) {
        System.out.print(phrase1);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(phrase2);
    }

}
