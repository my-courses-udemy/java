package org.shuanacu.thread.examplessync.runnable;

import org.shuanacu.thread.examplessync.Bakery;

public class Customer implements Runnable{

    private Bakery bakery;

    public Customer(Bakery bakery) {
        this.bakery = bakery;
    }

    @Override
    public void run() {
        for (int index = 0; index < 10; index++) {
            bakery.consume();
        }
    }
}
