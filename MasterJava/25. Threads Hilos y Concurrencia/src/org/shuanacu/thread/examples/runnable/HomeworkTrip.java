package org.shuanacu.thread.examples.runnable;

public class HomeworkTrip implements Runnable{

    private String name;

    public HomeworkTrip(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        for (int index = 0; index < 10; index++) {
            System.out.println(index + " - " + this.name);
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("I'm finally goin on a trip to " + this.name);
    }
}
