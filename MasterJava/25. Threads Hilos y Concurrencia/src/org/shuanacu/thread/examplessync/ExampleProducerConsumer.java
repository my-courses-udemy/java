package org.shuanacu.thread.examplessync;

import org.shuanacu.thread.examplessync.runnable.Baker;
import org.shuanacu.thread.examplessync.runnable.Customer;

public class ExampleProducerConsumer {

    public static void main(String[] args) {
        Bakery bakery = new Bakery();
        new Thread(new Baker(bakery)).start();
        new Thread(new Customer(bakery)).start();
    }

}
