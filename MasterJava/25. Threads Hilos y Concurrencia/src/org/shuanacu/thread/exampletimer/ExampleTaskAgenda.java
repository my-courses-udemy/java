package org.shuanacu.thread.exampletimer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ExampleTaskAgenda {

    public static void main(String[] args) {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task done: " +  new Date() + ", Thread name: " + Thread.currentThread().getName());
                System.out.println("Task finished");
                timer.cancel();
            }
        }, 5000);

        System.out.println("I scheduled an assignment for 5 seconds....");

    }

}
