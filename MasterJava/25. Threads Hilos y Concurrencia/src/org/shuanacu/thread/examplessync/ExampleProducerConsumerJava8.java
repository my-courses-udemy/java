package org.shuanacu.thread.examplessync;

import org.shuanacu.thread.examplessync.runnable.Baker;
import org.shuanacu.thread.examplessync.runnable.Customer;

import java.util.concurrent.ThreadLocalRandom;

public class ExampleProducerConsumerJava8 {

    public static void main(String[] args) {
        Bakery bakery = new Bakery();
        new Thread(() -> {
            for (int index = 0; index < 10; index++) {
                bakery.bake("Pan n:" + index);
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int index = 0; index < 10; index++) {
                bakery.consume();
            }
        }).start();
    }

}
