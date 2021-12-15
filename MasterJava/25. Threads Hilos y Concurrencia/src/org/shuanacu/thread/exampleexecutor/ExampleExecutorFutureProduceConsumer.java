package org.shuanacu.thread.exampleexecutor;

import org.shuanacu.thread.examplessync.Bakery;
import org.shuanacu.thread.examplessync.runnable.Baker;
import org.shuanacu.thread.examplessync.runnable.Customer;

import java.util.concurrent.*;

public class ExampleExecutorFutureProduceConsumer {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Bakery bakery = new Bakery();
        Runnable baker = new Baker(bakery);
        Runnable customer = new Customer(bakery);

        Future<?> result2 = executor.submit(customer);
        Future<?> result = executor.submit(baker);
        executor.shutdown();

        System.out.println("Continued with the execution method main 1");

    }

}
