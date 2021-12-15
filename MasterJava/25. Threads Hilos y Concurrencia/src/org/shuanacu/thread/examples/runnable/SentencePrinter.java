package org.shuanacu.thread.examples.runnable;

import static org.shuanacu.thread.examples.ExampleSynchronization.*;

public class SentencePrinter implements Runnable{

    private String phrase1, phrase2;

    public SentencePrinter(String phrase1, String phrase2) {
        this.phrase1 = phrase1;
        this.phrase2 = phrase2;
    }

    @Override
    public void run() {
        printPhrase(this.phrase1, this.phrase2);
    }
}
