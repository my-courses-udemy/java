package org.shuanacu.thread.examplessync;

public class Bakery {

    private String bread;
    private boolean isAvailable;

    public synchronized void bake(String dough) {
        while (isAvailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.bread = dough;
        System.out.println("Baker bakes the bread " + this.bread);
        this.isAvailable = true;
        notify();
    }

    public synchronized String consume() {
        while (!isAvailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Customer consumes the bread" + this.bread);
        this.isAvailable = false;
        notify();
        return this.bread;
    }

}
