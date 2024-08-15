package com.kattyavar.shika.main.java.live_session.generics;

public class StringBox {
  public String item;

  public StringBox(String item) {
    this.item = item;
  }

  public StringBox(Integer input) {
    //Here you will convert integer to string your custom logic
  }

  public StringBox(Student sutdentInput) {

  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  void display() {
    System.out.println("Value of item is => " + item);
    System.out.println("Type of item is => " + item.getClass().getName());
  }

  @Override
  public String toString() {
    return "StringBox{" +
      "item='" + item + '\'' +
      '}';
  }
}
