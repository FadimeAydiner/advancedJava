package com.threads;
class MyTask1{
    void executeTask(){
        for(int i=1;i<=10;i++){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Printer 1 is running:"+i);}
    }
}
class MyTaskWithThread1 extends Thread{

    @Override
    public void run() {
        for(int i=1;i<=10;i++){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Printer 3 is running:" +i);}
    }
}
public class MultiThreading {
    public static void main(String[] args) {
        long appThreadStarted=System.currentTimeMillis();
        System.out.println("============Application without thred started==============");

        MyTask1 task1=new MyTask1();
        task1.executeTask();

        for(int i=1;i<=10;i++){
            System.out.println("Printer 2 is running:" +i);}

        System.out.println("============Application without thred ended==============");
        long appThreadEnded=System.currentTimeMillis();
        System.out.println("Total time for application wtihout thread: "+(appThreadEnded-appThreadStarted));

        long appWithThreadStarted=System.currentTimeMillis();
        System.out.println("============Application with thred started==============");
        MyTaskWithThread1 myTaskWithThread1=new MyTaskWithThread1();
        myTaskWithThread1.start();

        for(int i=1;i<=10;i++){
            System.out.println("Printer 4 is running:" +i);}
        System.out.println("============Application with thred ended==============");
        try {
            //join() wait until the thread is died
            myTaskWithThread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long appWithThreadEnded=System.currentTimeMillis();
        System.out.println("Total time for application with thread: "+(appWithThreadEnded-appWithThreadStarted));


    }
}
