package com.kattyavar.shika.main.java.strongandweek;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class JavaReferenceExample {
  public static void main(String[] args) throws InterruptedException {
    //strongRefExample();
    //weekRefExample();
    //softRefExample();
    phantomRefExample();
  }

  static void strongRefExample() {

    Employee emp = new Employee("Emp1", 21);

    System.out.println(emp);
    emp = null; // When ever GC happen this will go way...

  }

  static void weekRefExample() {
    Employee emp = new Employee("Emp1", 21);

    WeakReference<Employee> weakReference = new WeakReference<>(emp);

    //Example WeekHashMap

    System.out.println(weakReference.get());

    //Now let make original ref as null .
    emp = null;

//Now request to garbage collect to run. Note. this may happen or may not happen it depends on JVM.

    System.gc();
    //Now try to print the week reference object

    System.out.println(weakReference.get()); //Most of the time you will get null here...

    //Trick here is if you give Employee emp2 = weakReference.get(); before gc. main Employee("Emp1", 21) will not be removed.
  }

  static void softRefExample() {
    Employee emp = new Employee("Emp1", 21);

    SoftReference<Employee> softRef = new SoftReference<>(emp);  // gc will remove object only and only if jvm need more memory.
    //If jvm has enough memory it will keep the object.

    System.out.println(softRef.get());

    //Now let make original ref as null .
    emp = null;

//Now request to garbage collect to run. Note. this may happen or may not happen it depends on JVM.

    System.gc();
    //Now try to print the week reference object

    System.out.println(softRef.get()); //Most of the time you will get null here...

    //Trick here is if you give Employee emp2 = softRef.get(); before gc. main Employee("Emp1", 21) will not be removed.
  }

  static void phantomRefExample() throws InterruptedException {

    /***
     * Unlike WeakReference, which allows you to access the object if it hasn't been collected,
     * PhantomReference does not provide a way to access the object;
     * it merely notifies you when the object has been collected.
     * This makes it useful for cleanup activities without interfering with garbage collection.
     *
     * Note: PhantomReference, you get a notification that the object has been collected, but you cannot interact with the object itself.
     */
    // Create a ReferenceQueue
    ReferenceQueue<Employee> referenceQueue = new ReferenceQueue<>();

    // Create a PhantomReference to MyObject
    Employee myObject = new Employee("emp1", 11);
    PhantomReference<Employee> phantomRef = new PhantomReference<>(myObject, referenceQueue);

    // Nullify the strong reference to myObject
    myObject = null;

    // Suggest garbage collection
    System.gc();

    // Wait for the PhantomReference to be enqueued
    PhantomReference<? extends Employee> refFromQueue = (PhantomReference<? extends Employee>) referenceQueue.remove();

    // Check if the reference has been cleared
    System.out.println("PhantomReference is cleared: " + (refFromQueue.get() == null));
    System.out.println("PhantomReference object: " + refFromQueue);



  }


}

class Employee {
  String name;
  Integer age;

  public Employee(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public void testMe() {
    System.out.println("Dummy method...");
  }


  @Override
  public String toString() {
    return "Employee{" +
      "name='" + name + '\'' +
      ", age=" + age +
      '}';
  }
}
