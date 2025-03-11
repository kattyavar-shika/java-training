package com.kattyavar.shika.main.java.live_session.mar11.finalkeyword;

public class Main {
  public static void main(String[] args) {

    Base obj = new Derived();

    obj.applyDiscount();
  }
}

class Base {
  private final String name;

  public String surName;

  public Base(String name) {
    this.name = name;
  }

  public Base() {
    name = "fdfdf";
  }

  final void tryMeIfYouCan(){


  }

  final  void applyDiscount(){

  }

  void display(final Base obj){

  }
}

class Derived extends Base {


}

//Final will be comming at diff places..
//at variable level..
//Method
//Parameter
//class
