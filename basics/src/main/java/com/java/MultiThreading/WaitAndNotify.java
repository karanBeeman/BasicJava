package com.java.MultiThreading;

/*Instrinct block is when they have two synchronized block inside a class
  which means both synchronized key cannot be executed at same time.
   */

import java.io.InputStream;
import java.io.OutputStream;

/* two types of block class-level, method-level
 */
public class WaitAndNotify {

    public void produce() throws InterruptedException {
        synchronized (this) { //class level synchronized block
            System.out.println("running produce method going to release the intrinc lock because of wait()");
            wait(); // once the synchronized block gets executed wait method will
            // relase the instrinct lock.
            System.out.println("again produce method");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(2000);
        synchronized (this) {
            System.out.println("consume method executed, it is going to notify the wait method");
            notify(); // once the block is executed it will notify the wait
            // that i have executed my block and you can make use of it.
        }
    }
}

class App {
    public static void main(String[] args) {
        final WaitAndNotify waitAndNotify = new WaitAndNotify();

            Thread t1 = new Thread(new Runnable() {
                public void run() {
                    try {
                        waitAndNotify.produce();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    waitAndNotify.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
