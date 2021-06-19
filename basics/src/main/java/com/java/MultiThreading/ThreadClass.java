package com.java.MultiThreading;

/* output
        Runner1 : 0 completes upto Runner1:10
        then "finished with t1 thread and t2 started"
        Runner2 with print in loop
 */

public class ThreadClass extends Thread {

    public void run() {
        for(int i=0; i<=10; ++i){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Runner 1: " +i);
        }
    }

}

class threadclass2 extends Thread {

    public void run() {

        for (int j = 0; j <= 10; ++j) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Runner 2: " + j);
        }
    }
}

class Initiate {

    public static void main(String[] args) {

        Thread t1 = new ThreadClass();
        Thread t2 = new threadclass2();

        t1.start();
        t2.start();

    // join Threads help with wait for the particular thread to finish
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finished with t1 thread and t2 started");
    }
}
