package com.threads;

import java.util.concurrent.Semaphore;

public class Semaphore1 {
    public static void main(String[] args) throws InterruptedException {
    Semaphore semaphore=new Semaphore(4);
    Thread.sleep(2000);
        System.out.println("Avaliable parking area is "+semaphore.availablePermits());

        Car car1=new Car("Car1",semaphore);
        Car car2=new Car("Car2",semaphore);
        Car car3=new Car("Car3",semaphore);
        Car car4=new Car("Car4",semaphore);
        Car car5=new Car("Car5",semaphore);
        Car car6=new Car("Car6",semaphore);

        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();



    }
}

class Car extends Thread{
    private String name;
    private Semaphore semaphore;

    public Car(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        try {
            System.out.println(name +" is trying to park..");
            semaphore.acquire();//is trying to park
            System.out.println(name+" has parked..");

            for(int i=1;i<=4;i++)
            {
                System.out.println(name+" is parked for "+i+" hours");
                Thread.sleep(5000);

            }
            System.out.println(name+" left the park");
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}