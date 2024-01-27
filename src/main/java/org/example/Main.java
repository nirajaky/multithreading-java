package org.example;

import org.example.threads.Stack;
import org.example.threads.Thread1;
import org.example.threads.Thread2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting...");

        // Extending Thread class
        Thread thread1 = new Thread1("thread1");
        thread1.start();

        /* Implementing Runnable Interface
           Most used/compared to extending Thread class as java is single threaded language,
           so it's better to use Runnable interface to create Threads and
           that same class can extend other required class */
        Thread thread2 = new Thread(new Thread2(), "thread2");
        thread2.start();

        Thread thread3 = new Thread(() -> {
            // Implementation of run method
            System.out.println("Thread 3 is running ... " + Thread.currentThread());
        }, "thread2");
        thread3.start();

        // Synchronization
        /*
            Since multiple thread is trying to use same class at same time asynchronously,
            So, It's better to make our class Stack as Thread safe - means when the internal value or
            the value returned from method will always be correct irrespective of multiple threads trying
            to access that same class concurrently.
         */
        Stack stack = new Stack(5);

        new Thread(() -> {
            int counter = 0;
            while (++counter <= 5) {
                stack.push(100);
            }
        }, "pusher").start();

        new Thread(() -> {
            int counter = 0;
            while (++counter <= 5) {
                stack.pop();
            }
        }, "poper").start();

        System.out.println("Ending...");
    }
}