package com.kattyavar.shika.main.java.generics.whyweneed;

public class StringBox {
  private String item;

  public StringBox(String item) {
    this.item = item;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  void display() {
    System.out.println("Item as = " + item);
  }
}
