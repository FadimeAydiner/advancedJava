package com.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {

        ExecutorService service= Executors.newFixedThreadPool(3);
        ThreadCreater thread1=new ThreadCreater("thread1");
        ThreadCreater thread2=new ThreadCreater("thread2");
        ThreadCreater thread3=new ThreadCreater("thread3");
        ThreadCreater thread4=new ThreadCreater("thread4");
        ThreadCreater thread5=new ThreadCreater("thread5");

        /*thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();*/

        service.execute(thread1);
        service.execute(thread2);
        service.execute(thread3);
        service.execute(thread4);
        service.execute(thread5);

        service.shutdown();


    }
}

class ThreadCreater extends Thread{
    private String threadName;
    public ThreadCreater(String threadName){
        this.threadName=threadName;
    }

    public void run(){
        System.out.println(threadName+" thread started to run");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(threadName+" thread stopped to run");

    }

}
