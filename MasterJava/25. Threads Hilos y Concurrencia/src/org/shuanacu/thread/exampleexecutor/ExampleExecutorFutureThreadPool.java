package org.shuanacu.thread.exampleexecutor;

import java.util.concurrent.*;

public class ExampleExecutorFutureThreadPool {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<String> task = () -> {
            System.out.println("Start of the task...");
            try {
                System.out.println("Name thread: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Task finished...");
            return "Something important result of the task";
        };

        Callable<Integer> task2 = () -> {
            System.out.println("Start of the task2...");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("Task finished...");
            return 21;
        };

        Future<String> result = executor.submit(task);
        Future<String> result2 = executor.submit(task);
        Future<Integer> result3 = executor.submit(task2);
        executor.shutdown();

        System.out.println("Continued with the execution method main 1");

//        System.out.println(result.isDone());
        while (!(result.isDone() && result2.isDone() && result3.isDone())) {
            System.out.println(String.format("Executed task1: %s, task2: %s, task3: %s",
                    result.isDone() ? "finalized" : "in process",
                    result2.isDone() ? "finalized" : "in process",
                    result3.isDone() ? "finalized" : "in process"));
            TimeUnit.MILLISECONDS.sleep(1000);
        }
        System.out.println("Result: " + result.get());
        System.out.println("Is done: " + result.isDone());

        System.out.println("Result: " + result2.get());
        System.out.println("Is done: " + result2.isDone());

        System.out.println("Result: " + result3.get());
        System.out.println("Is done: " + result3.isDone());

    }

}
