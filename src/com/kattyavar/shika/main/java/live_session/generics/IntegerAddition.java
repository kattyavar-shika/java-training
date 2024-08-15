package com.kattyavar.shika.main.java.live_session.generics;

public class IntegerAddition {

  Integer item;

  public IntegerAddition(Integer item) {
    this.item = item;
  }

  public Integer getItem() {
    return item;
  }

  public void setItem(Integer item) {
    this.item = item;
  }

  @Override
  public String toString() {
    return "IntergerAddition{" +
      "item=" + item +
      '}';
  }

  public Integer addition(IntegerAddition another) {
    return this.item + another.item;
  }

}
