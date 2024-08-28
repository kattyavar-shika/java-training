package com.kattyavar.shika.main.java.live_session.collections.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringSortExample {

  static void stringSortExample(){
    List<String> list = new ArrayList<>();

    list.add("Step 1");
    list.add("Step 5");
    list.add("Step 3");
    list.add("Step 2");
    list.add("Step 0");

    System.out.println("Before sort " + list);

    Collections.sort(list);

    System.out.println("After sort " + list);

  }

  static void integerSortExample(){
    List<Integer> list = new ArrayList<>();

    list.add(66);
    list.add(55);
    list.add(10);

    System.out.println("Before sort" + list);

    Collections.sort(list);
    System.out.println("After sort " + list);


    //now let do the reverse sort.

    Collections.sort(list, Collections.reverseOrder());

    System.out.println("Reverse Sort " + list);
  }

  static void willThisWork(){
    class Student {
      String name;

      public Student(String name) {
        this.name = name;
      }

      @Override
      public String toString() {
        return "Student{" +
          "name='" + name + '\'' +
          '}';
      }

    }

    List<Student> studentList = new ArrayList<>();

    studentList.add(new Student("Student 1"));

    //This will not compile reason: no instance(s) of type variable(s) T exist so that Student conforms to Comparable<? super T>
    //That  why we need either Comparable or Comparator
    //Collections.sort(studentList);
  }
  public static void main(String[] args) {
    stringSortExample();
  }
}
