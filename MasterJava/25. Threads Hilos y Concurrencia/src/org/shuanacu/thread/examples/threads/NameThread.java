package org.shuanacu.thread.examples.threads;

public class NameThread extends Thread {
    public NameThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Start method run from Thread" + getName());
        for (int index = 0; index < 9; index++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName());
        }
        System.out.println("Finished the thread");
    }
}
