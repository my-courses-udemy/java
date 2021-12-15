package org.shuanacu.thread.examplessync.runnable;

import org.shuanacu.thread.examplessync.Bakery;

import java.util.concurrent.ThreadLocalRandom;

public class Baker implements Runnable {

    private Bakery bakery;

    public Baker(Bakery bakery) {
        this.bakery = bakery;
    }

    @Override
    public void run() {
        for (int index = 0; index < 10; index++) {
            bakery.bake("Pan n:" + index);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
