package com.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class BlockQueue {
    public static int counter=0;
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue=new ArrayBlockingQueue<>(10);
        Producer producer=new Producer(queue);
        Thread producerThread=new Thread(producer);

        Consumer consumer=new Consumer(queue);
        Thread consumerThread=new Thread(consumer);

        producerThread.start();
        consumerThread.start();

    }
}

class Producer implements Runnable{

    private ArrayBlockingQueue<Integer> queue;
    public Producer(ArrayBlockingQueue<Integer> queue){
        this.queue=queue;
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
                queue.put(BlockQueue.counter);
                BlockQueue.counter++;
                System.out.println("Counter value is put the queue:" +BlockQueue.counter);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
class Consumer implements Runnable{

    private ArrayBlockingQueue<Integer> queue;
    public Consumer(ArrayBlockingQueue<Integer> queue){
        this.queue=queue;
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(2000);
                queue.take();
                BlockQueue.counter--;
                System.out.println("Counter value is taking from  the queue:" +BlockQueue.counter);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}