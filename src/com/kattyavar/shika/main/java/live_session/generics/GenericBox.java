package com.kattyavar.shika.main.java.live_session.generics;

public class GenericBox<T, V, X, Z extends Number> {

  private T item;
  private V item2;
  private X item3;


  public GenericBox() {

  }

  public GenericBox(T item) {

    if ( item instanceof  C ){

    }
    this.item = item;

  }

  public T getItem() {
    return item;
  }

  public void setItem(T item) {
    this.item = item;
  }
  void display() {
    System.out.println("Value of item is => " + item);
    System.out.println("Type of item is => " + item.getClass().getName());

   // item.displayA();
    //item.display();

  }
}


























