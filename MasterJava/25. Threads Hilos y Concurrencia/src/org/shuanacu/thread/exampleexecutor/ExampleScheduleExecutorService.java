package org.shuanacu.thread.exampleexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExampleScheduleExecutorService {

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Some task in the main...");

        executor.schedule(() -> {
            /*try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            System.out.println("Hello world");
        }, 2000, TimeUnit.MILLISECONDS);

        System.out.println("Another task in the main");
        executor.shutdown();

    }

}
