package com.kattyavar.shika.main.java.live_session.feb10.insidefeb10;

import com.kattyavar.shika.main.java.live_session.feb10.Base;

public class Main {
  public static void main(String[] args) {

  }
}

class Derived extends Base {

  //Let have look how many variables we can access from the Base class.

  //System.out.println(baseStr1Private); // Compile Time Error

  void display() {
    //System.out.println(baseStr1Private); // Compile error...
    System.out.println(baseStr1Public);
    System.out.println(baseStr1Protected);
    //System.out.println(baseStr1Default); //compile error...
  }

}

class DerivedDerived extends  Derived {
  void display() {
    //System.out.println(baseStr1Private); // Compile error...
    System.out.println(baseStr1Public);
    System.out.println(baseStr1Protected);
    //System.out.println(baseStr1Default); //compile error...
  }
}

