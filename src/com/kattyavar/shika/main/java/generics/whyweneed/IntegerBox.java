package com.kattyavar.shika.main.java.generics.whyweneed;

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

  void display() {
    System.out.println("Item as =" + item);

  }
}
