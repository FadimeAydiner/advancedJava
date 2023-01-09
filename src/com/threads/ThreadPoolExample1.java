package com.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample1 {
    public static void main(String[] args) {
        //creating a single thread for one task
        /*Thread t1=new Thread(new Task());
        t1.start();
        System.out.println("Thread name: "+Thread.currentThread().getName());
*/
        //Suppose that we have 10 task
/*
        for(int i=0;i<10;i++)
        {
            Thread thread=new Thread(new Task());
            thread.start();
        }
        System.out.println("Thread name: "+Thread.currentThread().getName());
*/
        int coreCount=Runtime.getRuntime().availableProcessors();
        System.out.println("avaliable processros "+coreCount );
        ExecutorService service= Executors.newFixedThreadPool(coreCount);
        for(int i=0;i<10;i++)
        {
            service.execute(new Task());
        }
        System.out.println("Thread name: "+Thread.currentThread().getName());
service.shutdown();
    }
}
class Task implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread name: "+Thread.currentThread().getName());
    }
}
