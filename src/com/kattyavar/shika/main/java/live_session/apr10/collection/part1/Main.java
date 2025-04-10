package com.kattyavar.shika.main.java.live_session.apr10.collection.part1;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {
    Map<Temp, String> map = new TreeMap<>((a, b) -> a.input.compareTo(b.input));
    map.put(new Temp(1), "one");
    map.put(new Temp(2), "one");
    map.put(new Temp(3), "one");
    map.put(new Temp(4), "one");
    map.put(new Temp(55), "one");
    map.put(new Temp(6), "one");
    map.put(new Temp(77), "one");
    map.put(new Temp(8), "one");

    System.out.println(map);


  }
}

class Student {
  int rollNo;
  String name;

  Student(int rollNo, String name) {
    this.rollNo = rollNo;
    this.name = name;
  }
}

class NameComparator implements Comparator<Student> {
  @Override
  public int compare(Student s1, Student s2) {
    return s1.name.compareTo(s2.name);  // Sort by name
  }
}

class InputComparator implements Comparator<Temp> {
  @Override
  public int compare(Temp temp, Temp t1) {
    return 0;
  }
}

class Temp {

  Integer input;
  Integer age;

  public Temp(Integer input) {
    this.input = input;
  }


  @Override
  public String toString() {
    return "Temp{" +
      "input=" + input +
      '}';
  }
}