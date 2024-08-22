package com.kattyavar.shika.main.java.live_session.collections.set;

import com.kattyavar.shika.main.java.live_session.collections.StudentDemo;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {


  public static void main(String[] args) {

    Set<StudentDemo> set = new LinkedHashSet<>();
    set.add(new StudentDemo("student 1"));
    set.add(new StudentDemo("student 1"));
    set.add(new StudentDemo("student 2"));
    set.add(new StudentDemo("student 3"));
    set.add(new StudentDemo("student 4"));
    set.add(new StudentDemo("student 5"));
    set.add(new StudentDemo("student 0"));
    set.add(null);
    set.add(null);
    set.add(null);
    System.out.println("Set values as " + set);

    set.remove(new StudentDemo("student 1"));


    //Keep in mind you will access to doubly link list here. That why you always get the insertion order
    set.iterator();

    System.out.println("After remove set " + set);

    set.remove(null);

    System.out.println("After remove of null ==> " + set);

  }
}
