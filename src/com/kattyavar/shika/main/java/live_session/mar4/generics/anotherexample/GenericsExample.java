package com.kattyavar.shika.main.java.live_session.mar4.generics.anotherexample;

public class GenericsExample {
  public static void main(String[] args) {


  }
}

class Person{}

interface Store {
  void StoreData();
}


class Box <T extends  Store> {
  private T inputType;

  void display(){

    inputType.StoreData();
    //inputType.
  }
}
