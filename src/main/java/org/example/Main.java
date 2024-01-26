package org.example;

import org.example.threads.Thread1;
import org.example.threads.Thread2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting...");

        // Extending Thread class
        Thread thread1 = new Thread1("thread1");
        thread1.start();

        /* Implementing Runnable Interface
           Most used as java is single threaded language,
           so its better to use Runnable interface to create Threads */
        Thread thread2 = new Thread(new Thread2(), "thread2");
        thread2.start();

        System.out.println("Ending...");
    }
}