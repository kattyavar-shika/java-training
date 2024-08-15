package com.kattyavar.shika.main.java.live_session.generics;

public class IntegerBox {
  private Integer item;

  public IntegerBox(Integer item) {
    this.item = item;
  }

  public Integer getItem() {
    return item;
  }

  public void setItem(Integer item) {
    this.item = item;
  }

  void display(){
    System.out.println("Value of item is => " + item);
    System.out.println("Type of item is => " + item.getClass().getName());
  }

  @Override
  public String toString() {
    return "IntegerBox{" +
      "item=" + item +
      '}';
  }
}
