package com.java.MultiThreading;

// TimeSlicing is making one thread to run for sometime and another
//thread to run for sometime simulataneously
public class Timeslicing implements Runnable{

    public void run() {
        for(int i=0; i<=10; ++i){
            System.out.println("Runner 1: " +i);
        }
    }
}

class TimeSlicing2 implements Runnable {

    public void run() {

        for(int j=0; j<=10; ++j) {
            System.out.println("Runner 2: " +j);
        }
    }
}

class ThreadExcecution {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Timeslicing());
        Thread t2 = new Thread(new TimeSlicing2());

        t1.start();
        t2.start();

    }
}
