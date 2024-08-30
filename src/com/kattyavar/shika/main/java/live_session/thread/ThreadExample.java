package com.kattyavar.shika.main.java.live_session.thread;

public class ThreadExample {
  public static void main(String[] args) throws InterruptedException {

    A obj = new A();

    //To set the priority

    //This is just request, it base on on scheduler to take final call.
    obj.setPriority(Thread.MAX_PRIORITY);
    //To start the read
    obj.start();

    //To wait for this thread to get finish ...
    obj.join();


    //Option 1
    Runnable bobj = new B();
    // Twhat you can do ..
    //As thread can accept the Runnable constructor.
    Thread t1 = new Thread(bobj);
    t1.join();


    //Option 3 this will not work....     runObjUsingLambda.run(); it is till blocking call...

    Runnable runObjUsingLambda = () -> {
      for (int i = 0; i < 50000; i++) {
        System.out.print(".");
      }
      System.out.println(" i m done from thread... ======>");
    };

    runObjUsingLambda.run();

    //runObjUsingLambda.wait();
    System.out.println(" I am done..");


  }

  static void volatileExampleUsage() {
    VolatileExample example = new VolatileExample();
    Thread writerThread = new Thread(example::setFlagTrue);
    writerThread.start();
    example.checkFlag();
  }
}

class IncrementItemExample {
  int counter;

  synchronized void increment() {

    synchronized (this) {
      counter++;

    }
    ;
    counter++;
  }
}

class A extends Thread {

  @Override
  public void run() {
    System.out.println(" I am running from Thread class");
  }
}

//Option 2

class B implements Runnable {

  @Override
  public void run() {
    System.out.println(" in run method from B");
  }
}

class VolatileExample {
  private volatile boolean flag = false;

  public void setFlagTrue() {
    flag = true;
  }

  public void checkFlag() {
    while (!flag) {
      // Busy-wait until flag becomes true
    }
    System.out.println("Flag is true!");
  }
}