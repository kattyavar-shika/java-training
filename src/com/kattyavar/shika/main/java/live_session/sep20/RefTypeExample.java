package com.kattyavar.shika.main.java.live_session.sep20;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class RefTypeExample {

  public static void main(String[] args) {

    softRefExample();

  }

  static void strongRefExample() {
    Profile obj = new Profile();
    //Its just request. not a order...
    System.gc();
    obj = null; // When ever GC happen this will go way...
  }

  static void weekRefExample() {
    Profile obj = new Profile();
    WeakReference<Profile> weakReference = new WeakReference<>(obj);
    System.out.println("Weak Ref data = " + weakReference.get());
    obj = null;
    System.gc();
    System.out.println("Weak Ref data = " + weakReference.get());
  }

  static void softRefExample() {
    Profile obj = new Profile();
    SoftReference<Profile> softReference = new SoftReference<>(obj);

    System.out.println("Soft ref data = " + softReference.get());
    obj = null;
    System.gc();
    System.gc();
    System.gc();
    System.gc();
    System.out.println("Soft ref data = " + softReference.get());
  }

}
