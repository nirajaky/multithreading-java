package org.example.threads;

public class Thread1 extends Thread {

    // providing name to thread
    public Thread1(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        System.out.println("Thread 1 is running ...");

        for (int i =0; i <=5; i++) {
            System.out.println("Current Thread is : " + Thread.currentThread());
        }
    }
}
