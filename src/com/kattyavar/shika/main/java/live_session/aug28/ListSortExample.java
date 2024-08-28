package com.kattyavar.shika.main.java.live_session.aug28;

import java.util.*;

public class ListSortExample {

  static void normalIntegerExample(){
    List<Integer>  list = new ArrayList<>();

    list.add(99);
    list.add(55);
    list.add(5);
    list.add(15);
    list.add(10);

    System.out.println("List content " + list);

    Collections.sort(list);

    System.out.println("After sort have look at the list " + list);
  }
  public static void main(String[] args) {

    List<StudentForList> list = new ArrayList<>();

    list.add(new StudentForList("patil", 22));
    list.add(new StudentForList("amol", 5));
    list.add(new StudentForList("p sir", 99));

    System.out.println("List without sort " + list);

    System.out.println("Let try to sort by rollNumber");
    Collections.sort(list, (t1, t2) -> t1.rollNumber.compareTo(t2.rollNumber));

    System.out.println("Sort base on RollNumber " + list);

    Collections.sort(list, Comparator.comparing(t -> t.name));

    System.out.println("Sort base on name " + list);
    //using the the normal sort
    Collections.sort(list);


  }
}

class StudentForList implements Comparable<StudentForList>{
  String name;
  Integer rollNumber;

  public StudentForList(String name, Integer rollNumber) {
    this.name = name;
    this.rollNumber = rollNumber;
  }

  @Override
  public String toString() {
    return "StudentForList{" +
      "name='" + name + '\'' +
      ", rollNumber=" + rollNumber +
      '}';
  }

  @Override
  public int compareTo(StudentForList studentForList) {
    return 0;
  }
}
