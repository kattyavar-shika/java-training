package com.kattyavar.shika.main.java.live_session.apr14.collections.part1;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {

    List<Student> list = new ArrayList<>();
    list.add(new Student());



    Collections.sort(list); // This will sort base on age...


    Collections.sort(list, new StudentBySalary());


    Collections.sort(list, (a, b) -> a.salary.compareTo(b.salary));
    //Sorting ...

  }
}

class StudentBySalary implements Comparator<Student>{
  @Override
  public int compare(Student a, Student b) {
    return a.salary.compareTo(b.salary);
  }
}

class StudentByPincode implements Comparator<Student>{
  @Override
  public int compare(Student student, Student t1) {
    return student.pinCode.compareTo(t1.pinCode);
  }
}

class Student implements Comparable<Student> {

  String name;
  Integer age;
  Boolean gender;
  Integer pinCode;
  Long salary;

  @Override
  public int compareTo(Student student) {

    //
     //ON what ground should we compare ...
    //name?
    //age?
    //gender?
    // or any other attribute present in the class...
   return this.age.compareTo(student.age);
  }
}