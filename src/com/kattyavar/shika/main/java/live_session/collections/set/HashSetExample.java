package com.kattyavar.shika.main.java.live_session.collections.set;

import com.kattyavar.shika.main.java.live_session.collections.StudentDemo;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class HashSetExample {


  static void whyEqualAndHashCodeAreImportant() {
    class Temp {
      String name;

      public Temp(String name) {
        this.name = name;
      }

      @Override
      public String toString() {
        return "Temp{" +
          "name='" + name + '\'' +
          '}';
      }
    }

    Set<Temp> set = new HashSet<>();

    //let try to insert tow same object into set without giving any hashCode and equal method.

    set.add(new Temp("same object"));
    //Lets add one more time. As part of Set we can not have duplicate values but this case you will have it.
    set.add(new Temp("same object"));

    //You will find two entries there.
    System.out.println("Set contains " + set);
  }

  static void whyEqualAndHashCodeAreImportantByGivingTheMethod() {
    class Temp {
      String name;

      public Temp(String name) {
        this.name = name;
      }

      @Override
      public String toString() {
        return "Temp{" +
          "name='" + name + '\'' +
          '}';
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temp temp = (Temp) o;
        return Objects.equals(name, temp.name);
      }

      @Override
      public int hashCode() {
        return Objects.hashCode(name);
      }
    }

    Set<Temp> set = new HashSet<>();

    //let try to insert tow same object into set without giving any hashCode and equal method.

    set.add(new Temp("same object"));
    //Lets add one more time. As part of Set we can not have duplicate values but this case you will have it.
    set.add(new Temp("same object"));

    //Now this problem will be solve now you will have only one entries.
    System.out.println("Set contains " + set);
  }

  static void letAddInsertAndDeleteOperation (){
    Set<Student> set = new HashSet<>();

    //to insert into set

    set.add(new Student("student 1"));
    set.add(null);
    set.add(null);
    set.add(null);

    System.out.println("Set contains " + set);

    //Try to check is element is present in set

    if (set.contains(new Student("student 1")) ) {
      System.out.println("Yes student 1 is exits...");
    }

    //to iterate the set using foreach
    set.forEach( x -> System.out.println(x));

    //To iterate the set using iterator...
  }


  static void letGiveSameHashCodeAndEqualAreFalse(){
    class Temp {
      String name;

      public Temp(String name) {
        this.name = name;
      }

      @Override
      public boolean equals(Object o) {
        //hard coded false
       return false;
      }

      @Override
      public int hashCode() {
        //To create hash collision
        return 1;
      }

      @Override
      public String toString() {
        return "Temp{" +
          "name='" + name + '\'' +
          '}';
      }
    }

    Set<Temp> set = new HashSet<>();

    set.add(new Temp("Step 1"));
    set.add(new Temp("Step 1"));
    set.add(new Temp("Step 1"));

    System.out.println("have look at the elements " + set);



  }

  static void checkTherOrderOfEntries(){
    Set<StudentDemo> set = new HashSet<>();

    set.add(new StudentDemo("student 1"));
    set.add(new StudentDemo("student 2"));
    set.add(new StudentDemo("student 3"));
    set.add(new StudentDemo("student 4"));
    set.add(new StudentDemo("student 5"));
    set.add(new StudentDemo("student 6"));
    set.add(new StudentDemo("student 0"));

    System.out.println(set);
  }
  public static void main(String[] args) {

    //whyEqualAndHashCodeAreImportant();
    //whyEqualAndHashCodeAreImportantByGivingTheMethod();
    //letAddInsertAndDeleteOperation();
   // letGiveSameHashCodeAndEqualAreFalse();
    checkTherOrderOfEntries();
  }
}



class Student {
  String name;

  public Student(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return Objects.equals(name, student.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }

  @Override
  public String toString() {
    return "Student{" +
      "name='" + name + '\'' +
      '}';
  }
}
