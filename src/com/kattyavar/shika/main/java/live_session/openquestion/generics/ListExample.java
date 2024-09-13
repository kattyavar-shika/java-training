package com.kattyavar.shika.main.java.live_session.openquestion.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListExample {

  public static void main(String[] args) {

    Customer customer1 = new Customer("Cust 1");
    Customer customer2 = new Customer("Cust 2");
    Customer customer3 = new Customer("Cust 3");
    Customer customer4 = new Customer("Cust 4");

    Customer[] customers1 = {customer1, customer2, customer3, customer4};


    List<Customer> list = new ArrayList<>();


    list.addAll(Arrays.asList(customers1));

    Generics<List<Customer>, Customer> obj = new Generics<>(list);

    //To get the full list

    System.out.println("Complete list " + obj.getItem());

    System.out.println("Item at index 0" + obj.getItemList());


  }
}


class Generics<T extends List<?>, R> {
  T item;

  public Generics(T item) {
    this.item = item;

    System.out.println("In constructor class of T is =" + this.item.getClass().getName());
  }

  public T getItem() {
    return item;
  }

  public void setItem(T item) {
    this.item = item;
  }

  public R getItemList() {

    //Take get parameter of any index..
    return (R) item.get(0);
  }

}

class Customer {
  private String name;

  public Customer(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Customer{" +
      "name='" + name + '\'' +
      '}';
  }
}