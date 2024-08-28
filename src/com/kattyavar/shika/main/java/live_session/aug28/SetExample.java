package com.kattyavar.shika.main.java.live_session.aug28;

import java.util.*;

public class SetExample {
  static void withIntegerDataType(){
    Set<Integer> set = new HashSet<>();

    set.add(15);
    set.add(10);
    set.add(1);
    set.add(25);
    Object value = new Object();
    //this is internally HashSet is doing it...
    Map<Integer, Object> internally = new HashMap<>();
    set.iterator();

    System.out.println(set);
  }

  static void withCustomObject (){
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


    Set<String> stringSet = new HashSet<>();

    Set<Student> set = new HashSet<>();

    Student patil  = new Student("patil new");


    set.add(new Student("patil"));
    set.add(new Student("patil"));
    set.add(new Student("patil"));

    set.add(patil);
    set.add(patil);
    set.add(patil);
    set.add(patil);

    System.out.println("Have look at the set data " + set);

  }
  public static void main(String[] args) {

    class Student2  {
      String name;
      String className;
      Integer rollNumber;

      public Student2(String name) {
        this.name = name;
        this.className = "11th std";
        this.rollNumber = 12;
      }

      @Override
      public String toString() {
        return "Student{" +
          "name='" + name + '\'' +
          '}';
      }


      /*
      if equal return zero.
      if return values < 0
      if return values > 0
       */

      /*
      @Override
      public int compareTo(Student2 student) {
        return this.rollNumber.compareTo(student.rollNumber);
      }

       */

    }


    class StudentNameCompare implements Comparator<Student2> {
      @Override
      public int compare(Student2 student2, Student2 t1) {
        return student2.name.compareTo(t1.name);
      }
    }

    class StudentRollNumberCompare implements Comparator<Student2> {

      @Override
      public int compare(Student2 student2, Student2 t1) {
        return student2.rollNumber.compareTo(t1.rollNumber);
      }
    }

    class StudentClassNameCompare implements Comparator<Student2>{

      @Override
      public int compare(Student2 student2, Student2 t1) {
        return student2.className.compareTo(t1.className);
      }
    }



    //Set<Student2> set = new TreeSet<>((t1, t2) -> t1.name.compareTo(t2.name));
    Set<Student2> set = new TreeSet<>(new Comparator<Student2>() {
      @Override
      public int compare(Student2 student2, Student2 t1) {
        return 0;
      }
    });

    set.add(new Student2("patil"));
    set.add(new Student2("patil 1"));
    set.add(new Student2("patil 99"));
    set.add(new Student2("patil"));
    System.out.println(set);


  }
}
