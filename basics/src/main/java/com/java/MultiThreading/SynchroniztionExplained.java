package com.java.MultiThreading;

public class SynchroniztionExplained {

    public static int counter = 0;

    public static synchronized void incrementProcess() {
        // when we use synchronized key word it make sure one thread can is executed during this method call
        // so other thread has to wait .
        counter++;
    }

    public static void sync() {

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for(int i=0; i<100; i++) {
                    incrementProcess();
               //     counter++; // is we increment like this we may get wired result because
                                 // t1 and t2 will try to increment with same value sometime
                                //  though counter is save in diff stack memory for each thread
                               // they share same heap memory.
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for(int j=0; j<100; j++) {
                    incrementProcess();
                    //counter++;
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("counter is : " + counter);
    }

    public static void main(String[] args) {
        sync();
    }
}
