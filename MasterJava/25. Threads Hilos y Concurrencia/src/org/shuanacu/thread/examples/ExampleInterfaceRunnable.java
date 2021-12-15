package org.shuanacu.thread.examples;

import org.shuanacu.thread.examples.runnable.HomeworkTrip;

public class ExampleInterfaceRunnable {

    public static void main(String[] args) {
        new Thread(new HomeworkTrip("Colombia")).start();
        new Thread(new HomeworkTrip("EE. UU.")).start();
        new Thread(new HomeworkTrip("Germany")).start();
        new Thread(new HomeworkTrip("New Zeland")).start();
    }

}
