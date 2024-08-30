package com.kattyavar.shika.main.java.live_session.aug30.thread;

public class UsingRunnableExample {
  static void threadExample() throws InterruptedException {
    Runnable readBookTask = new ReadBookTask();

    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 10; i++) {

          System.out.println("In anonymous class class Working on index " + i + "  With Thread Index " + Thread.currentThread().getId());
        }
      }
    });


    Thread t3 = new Thread(
      () -> {
        for (int i = 0; i < 10; i++) {
          System.out.println("In anonymous class class Working on index " + i + "  With Thread Index " + Thread.currentThread().getId());
        }
      }
    );

    System.out.println("Let the the thread priority = " + t1.getPriority());

    t1.start();

    Thread t2 = new Thread(new ReadBookTask());

    t2.start();

    t1.join();
    t2.join();

    System.out.println("All thread are finished....");
  }

  public static void main(String[] args) throws InterruptedException {

    Thread highPriorityThread = new Thread(new ReadBookTask());
    Thread normalThread = new Thread(new ReadBookTask());

    highPriorityThread.setPriority(Thread.MAX_PRIORITY);
    System.out.println("Let get the highPriorityThread priority = " + highPriorityThread.getPriority());
    System.out.println("Let get the normalThread priority = " + normalThread.getPriority());


    normalThread.start();
    highPriorityThread.start();

    normalThread.join();
    highPriorityThread.join();


  }
}

class ReadBookTask implements Runnable {


  @Override
  public void run() {
    System.out.println("Using Runnable interface...");
    for (int i = 0; i < 200; i++) {
      System.out.println("In ReadBookTask class Working on index " + i + "  With Thread Index " + Thread.currentThread().getId() + "  with priority " + Thread.currentThread().getPriority());

       // Thread.sleep(1000L);

    }
  }
}

