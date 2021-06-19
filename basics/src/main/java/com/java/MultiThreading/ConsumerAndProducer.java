package com.java.MultiThreading;

import java.util.ArrayList;
import java.util.List;

public class ConsumerAndProducer {

    private  List<Integer> list = new ArrayList<>();
    private static final int UPPER_LIMIT = 5;
    private static final int LOWER_LIMIT = 0;
    private final Object lock = new Object();
    private int value = 0;

    public void producer() throws InterruptedException {
        synchronized (lock) {
            while(true) {
                if(list.size() == UPPER_LIMIT) {
                    value =0;
                    System.out.println("waiting for remove item");
                    lock.wait();
                } else {
                    System.out.println("Addding : "+ value);
                    list.add(value);
                    value++;
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }
    public void consumer() throws InterruptedException {
        synchronized (lock) {
            while(true) {
                if(list.size() == LOWER_LIMIT) {
                    System.out.println("waiting for Adding item");
                    lock.wait();
                } else {
                      System.out.println("removing: "+ list.remove(list.size()-1));
                      lock.notify();
                }
               Thread.sleep(500);
            }
        }
    }
}

class InitatorClass {

    public static void main(String[] args) {
        final ConsumerAndProducer consumerAndProducer = new ConsumerAndProducer();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumerAndProducer.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumerAndProducer.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
