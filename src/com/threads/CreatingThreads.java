package com.threads;

//1.way
class MyTask{
  //burda Thread sınıfı kullanıp 50 ms bekletme yapmamıza rağmen.
    //main metodu çalıştırıp bu sınıfın metodunu çağırdığımızda. main metod bu metodun işini bitirmesini bekler.
    //syhnron bi şekilde akış olduğu için burdan sonuç gelince main metot da kaldığı yerden çalışmaya devam eder.
    void executeTask(){
      for(int i=1;i<=10;i++){
          try {
              Thread.sleep(50);
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
          System.out.println("Printer 2 is running:"+i);}
  }
}
class MyTaskWithThread extends Thread{
    //burda Thread sınıfı extends edildiği için run metodu çağırıldığında bu işi başka bir işlemci alır. böylexce main metot bu metodu belmeden işlerini yapmaya devam eder.
    //en son bu sınıftan gelenleri işler
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

//2.way
class MyTaskWithThread2 extends MyTask implements Runnable{

    @Override
    public void run() {
        for(int i=1;i<=10;i++){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Printer 5 is running:" +i);}

    }
}
public class CreatingThreads {
    public static void main(String[] args) {
        //job1
        System.out.println("===============application without thread started==============");

        //job2
        MyTask myTask=new MyTask();
        myTask.executeTask();
        //job3
        for(int i=1;i<=10;i++)
            System.out.println("Printer 1 is running:"+i);

        //job4
        System.out.println("===============application without thread finished==============");

        //job1
        System.out.println("===============application with thread started==============");
        //job2
        MyTaskWithThread myTaskWithThread=new MyTaskWithThread();
        myTaskWithThread.start();//it initialize the thread run() method

        MyTaskWithThread2 myTaskWithThread2=new MyTaskWithThread2();
        Thread thread=new Thread(myTaskWithThread2);
        thread.start();

        //3.way
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("This is anonynous way of creating thread");
            }
        });
        thread1.start();

        //4.way: using lambda
        Thread thread2=new Thread(()->{
            System.out.println("This thread is created with lambda");

        });
        thread2.start();

        //job3
        for(int i=1;i<=10;i++)
            System.out.println("Printer 4 is running:"+i);

        //job4
        System.out.println("===============application with thread finished==============");

    }
}
