package org.shuanacu.thread.exampletimer;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class ExampleTaskAgendaPeriod {

    public static void main(String[] args) {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        AtomicInteger counterAtomic = new AtomicInteger(3);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                int counter = counterAtomic.getAndDecrement();
                if (counter > 0) {
                    toolkit.beep();
                    System.out.println("Periodic task: " + new Date() + ", Thread name: " + Thread.currentThread().getName());
                } else {
                    System.out.println("Task finished");
                    timer.cancel();
                }
            }
        }, 0, 3000);

        System.out.println("I scheduled an assignment for 2 seconds....");

    }

}
