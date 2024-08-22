package com.kattyavar.shika.main.java.live_session.collections.set;

import com.kattyavar.shika.main.java.live_session.collections.StudentDemo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeHashSetExample {

  static void willThisWork() {
    Set<StudentDemo> set = new TreeSet<>();

    //As you will get the error. As TreeSet sort the item. and system dont know how to sort.

    //To sort we have two options
    //Either give the Comparator or
    set.add(new StudentDemo("Test1"));

  }

  static void thisWillWork() {
    Set<StudentDemo> set = new TreeSet<>(Comparator.comparing(StudentDemo::getName)
    );

    //As you will get the error. As TreeSet sort the item. and system dont know how to sort.

    //To sort we have two options
    //Either give the Comparator or
    set.add(new StudentDemo("Test1"));
  }

  static void fewSetOperations() {

    Set<StudentDemo> set = new TreeSet<>(Comparator.comparing(StudentDemo::getName));
    set.add(new StudentDemo("student 1"));
    set.add(new StudentDemo("student 1"));
    System.out.println("Content " + set);


    //print it using foreach
    set.forEach(x -> System.out.println(x));

    Iterator<StudentDemo> iter = set.iterator();

    System.out.println("Using iterator....");
    while (iter.hasNext()){
      System.out.println(iter.next());
    }

  }

  public static void main(String[] args) {
    //willThisWork();
    //thisWillWork();
    fewSetOperations();
  }
}
