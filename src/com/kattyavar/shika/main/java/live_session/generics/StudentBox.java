package com.kattyavar.shika.main.java.live_session.generics;

public class StudentBox {
  private Student item;

  public StudentBox() {
    item = new Student("A", "p", 1);


  }

  public Student getItem() {
    return item;
  }

  public void setItem(Student item) {
    this.item = item;
  }

  @Override
  public String toString() {
    return "StudentBox{" +
      "item=" + item +
      '}';
  }

  void display() {
    System.out.println("Value of item is => " + item);
    System.out.println("Type of item is => " + item.getClass().getName());
  }
}
