package org.shuanacu.thread.exampleexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExampleExecutor {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable task = () -> {
            System.out.println("Start of the task...");
            try {
                System.out.println("Name thread: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Task finished...");
        };

        executor.submit(task);
        executor.shutdown();

        System.out.println("Continued with the execution method main 1");
        executor.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("Continued with the execution method main 2");

    }

}
