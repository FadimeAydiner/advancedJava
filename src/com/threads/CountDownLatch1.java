package com.threads;

import java.util.concurrent.CountDownLatch;

public class CountDownLatch1 {
    public static void main(String[] args) {
        CountDownLatch latch=new CountDownLatch(4);
        AssignTaskThread team1=new AssignTaskThread("Team 1",latch,1000);
        AssignTaskThread team2=new AssignTaskThread("Team 2",latch,2000);
        AssignTaskThread team3=new AssignTaskThread("Team 3",latch,3000);
        AssignTaskThread team4=new AssignTaskThread("Team 4",latch,4000);

        team1.start();
        team2.start();
        team3.start();
        team4.start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName()+" has finished");
        System.out.println("Code is ready to the submitted to QA Team");
    }
}

class AssignTaskThread extends Thread{
    private int delay;
    private CountDownLatch latch;

    public AssignTaskThread(String name,CountDownLatch latch,int delay){
        super(name);
        this.delay=delay;
        this.latch=latch;

    }
    public void run(){

        try {
            Thread.sleep(delay);
            //there will be some tasks for team
            System.out.println(Thread.currentThread().getName()+" finished");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        latch.countDown();
    }
}
