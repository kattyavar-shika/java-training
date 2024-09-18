package com.kattyavar.shika.main.java.strongandweek.cleanable;

import java.lang.ref.Cleaner;

public class CleanableExample {
  public static void main(String[] args) throws InterruptedException {

    testCleaner();
    System.out.println("Lets request to GC ");
    System.gc();

    Thread.sleep(1000);
    System.out.println("Main ends here...");


  }

  static void testCleaner() {
    MyResource myResource = new MyResource();

    System.out.println("Any how my Resource will be remove after gc");
    return;
  }
}


class MyResource {
  //As finalize method is deprecated java 9 onwards.. you can use below option
  private static final Cleaner cleaner = Cleaner.create();
  private final Cleaner.Cleanable cleanable;

  public MyResource() {
    cleanable = cleaner.register(this, new CleanupAction());
  }

  private static class CleanupAction implements Runnable {
    @Override
    public void run() {
      // Cleanup logic here
      System.out.println("Cleanup action executed.");
    }
  }

  // Other methods...

  public void close() {
    cleanable.clean();
  }
}