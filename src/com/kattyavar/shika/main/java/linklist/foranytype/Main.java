package com.kattyavar.shika.main.java.linklist.foranytype;

public class Main {
  public static void main(String[] args) {
    GernericLinkList<String> linkList = new GernericLinkList<>();
    linkList.add("one");
    linkList.add("one2");
    linkList.add("one3");
    linkList.add("one4");
    linkList.printList();

    //Let us this for Student class
    GernericLinkList<Student> studentGernericLinkList = new GernericLinkList<>();
    studentGernericLinkList.add(new Student("User1", 1));
    studentGernericLinkList.add(new Student("User2", 2));
    studentGernericLinkList.add(new Student("User3", 3));
    studentGernericLinkList.printList();
    studentGernericLinkList.add(1, new Student("User new at 1", 11));
    System.out.println("Have look at updated link list");
    studentGernericLinkList.printList();


  }
}

class Student {
  String name;
  Integer rollNumber;

  public Student(String name, Integer rollNumber) {
    this.name = name;
    this.rollNumber = rollNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getRollNumber() {
    return rollNumber;
  }

  public void setRollNumber(Integer rollNumber) {
    this.rollNumber = rollNumber;
  }

  @Override
  public String toString() {
    return "Student{" +
      "name='" + name + '\'' +
      ", rollNumber=" + rollNumber +
      '}';
  }
}