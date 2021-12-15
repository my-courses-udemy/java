package org.shuanacu.thread.examples;

public class ExampleInterfaceRunnableJava8 {

    public static void main(String[] args) throws InterruptedException {

        /* Runnable trip = new Runnable() {
            @Override
            public void run() {
                for (int index = 0; index < 10; index++) {
                    System.out.println(index + " - " + Thread.currentThread().getName());
                    try {
                        Thread.sleep((long) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("I'm finally going on a trip to " + Thread.currentThread().getName());
            }
        };*/

        Thread main = Thread.currentThread();

        Runnable trip = () -> {
            for (int index = 0; index < 10; index++) {
                System.out.println(index + " - " + Thread.currentThread().getName());
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("I'm finally goin on a trip to " + Thread.currentThread().getName());
            System.out.println(main.getState());
        };

        Thread thread1 = new Thread(trip, "Colombia");
        Thread thread2 = new Thread(trip, "EE. UU.");
        Thread thread3 = new Thread(trip, "Germany");
        Thread thread4 = new Thread(trip, "New Zealand");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

//        Thread.sleep(6000);
        System.out.println(main.getState());
        System.out.println("Continued execution method main");
    }

}
