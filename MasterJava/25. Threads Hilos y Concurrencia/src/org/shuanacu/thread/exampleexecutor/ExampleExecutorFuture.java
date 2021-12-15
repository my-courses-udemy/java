package org.shuanacu.thread.exampleexecutor;

import java.util.concurrent.*;

public class ExampleExecutorFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable task = () -> {
            System.out.println("Start of the task...");
            try {
                System.out.println("Name thread: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Task finished...");
        };

        Future<?> result = executor.submit(task);
        executor.shutdown();

        System.out.println("Continued with the execution method main 1");

//        System.out.println(result.isDone());
        while (!result.isDone()) {
            System.out.println("Executed task...");
            TimeUnit.MILLISECONDS.sleep(1500);
        }
        System.out.println(result.get(5, TimeUnit.SECONDS));
        System.out.println(result.isDone());

    }

}
