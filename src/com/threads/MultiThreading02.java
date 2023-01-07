package com.threads;
class Printer{
    //2.way of synchronize
  // synchronized void printDocument(int numOfCopies,String documentName){
  void printDocument(int numOfCopies,String documentName){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(int i=1;i<=numOfCopies;i++)
            System.out.println(">>Printing "+documentName+" "+i);
    }
}

class MyThread extends Thread{
    Printer printer;
    MyThread(Printer printer){
        this.printer=printer;
    }

    //3.way of syn
    @Override
    public void run() {
        synchronized (this.printer){
        printer.printDocument(10,"johnsdocumnet.pdf");
    }}
}

class YourThread extends Thread{
    Printer printer;
    YourThread(Printer printer){
        this.printer=printer;
    }

    @Override
    public void run() {
        synchronized (this.printer){
            printer.printDocument(10,"davidsdocumnet.pdf");
        }}
}
public class MultiThreading02 {
    public static void main(String[] args) {

        System.out.println("============Application without thred started==============");
        Printer printer=new Printer();
        MyThread myThread=new MyThread(printer);
        YourThread yourThread=new YourThread(printer);
        myThread.start();
        //1.way of synchronize
        /*try {
            myThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        yourThread.start();
        System.out.println("============Application without thred ended==============");

    }
}
