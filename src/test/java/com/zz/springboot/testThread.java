package com.zz.springboot;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Consumer implements Runnable {
    BlockingQueue q = null;

    public Consumer(BlockingQueue q) {
        this.q = q;
    }

    @Override
    public void run() {
        Lock lock =new ReentrantLock();
        Condition condition =lock.newCondition();

        while(true) {
            try {
                q.take();
                System.out.println("Consumer has taken a product.");
                Thread.sleep(2000);
            }catch(InterruptedException e) {

            }
        }
    }
}

class Producer implements Runnable {
    BlockingQueue q = null;

    public Producer(BlockingQueue q) {
        this.q = q;
    }

    @Override
    public void run() {
        while(true) {
            try { // note that if there is any chance that block, usually we need a InterruptedException
                Object o = new Object();
                q.put(o);
                System.out.println("Producer has puted a product.");
                Thread.sleep(20);
            }catch(InterruptedException e) {

            }
        }
    }


}

public class testThread {
    static int queueCapacity = 20;
    static BlockingQueue<Object> q = new ArrayBlockingQueue<Object>(queueCapacity); // Can also compile
//    static BlockingQueue q = new ArrayBlockingQueue(queueCapacity); // ABQ must has a capacity
    public static void main(String[] args) {
        Thread t1 = new Thread(new Producer(q));
        Thread t2 = new Thread(new Consumer(q));
        t1.start();
        t2.start();
    }


}