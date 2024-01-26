package org.example.threads;

public class Thread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread 2 is running ... " + Thread.currentThread());
    }
}
