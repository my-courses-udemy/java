package org.shuanacu.thread.exampleexecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ExampleScheduleExecutorServicePeriod {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Some task in the main...");

        AtomicInteger counter = new AtomicInteger(5);
//        CountDownLatch lock = new CountDownLatch(5);
        Future<?> future = executor.scheduleAtFixedRate(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
//                lock.countDown();
                counter.getAndDecrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello world");
        }, 1000, 2000, TimeUnit.MILLISECONDS);

//        TimeUnit.SECONDS.sleep(10);
//        lock.await();
//        future.cancel(true);
        while (counter.get() >= 0) {
            if(counter.get() == 0) {
                future.cancel(true);
                counter.getAndDecrement();
            }
        }
        System.out.println("Another task in the main");
        executor.shutdown();

    }

}
