package org.example.threads;

public class Stack {
    private int[] array;
    private int stackTop;
    private Object obj;

    public Stack(int capacity) {
        array = new int[capacity];
        stackTop = -1;
        obj = new Object();
    }

    public synchronized boolean push(int element) {
        if (isFull())
            return false;
        ++stackTop;

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        array[stackTop] = element;
        return true;
    }

    public synchronized int pop() {
        if (isEmpty())
            return Integer.MIN_VALUE;

        int obj = array[stackTop];
        array[stackTop] = Integer.MIN_VALUE;

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        stackTop--;
        return obj;
    }

    public boolean isEmpty() {
        return stackTop < 0;
    }

    public boolean isFull() {
        return stackTop >= array.length - 1;
    }
}

/*
    By using synchronized keyword in method definition implies the implicit
    use of lock as "this" keyword referring to the current Object.

    Explicitly also we can define synchronized method as -

    public int pop() {
        synchronized(obj) {
            if (isEmpty())
            return Integer.MIN_VALUE;

            int obj = array[stackTop];
            array[stackTop] = Integer.MIN_VALUE;

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }

            stackTop--;
            return obj;
        }
    }

 */


/*
    If we have all the methods in our class as synchronized then only one thread can access all the
    methods of that class at a time.

    In the above class if we have not used synchronized keyword then
    one thread can execute push and another thread can execute pop concurrently.
 */
