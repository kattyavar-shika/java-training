package com.kattyavar.shika.main.java.live_session.mar3.overridewithexception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo {
  public static void main(String[] args) {

    Base obj = new Base();
    Base obj2 = new Derived();

    testThis(obj);
    testThis(obj2);

  }

  static void testThis(Base base) {
 //   base.display(1);
  }
}


class SubchildOfFileNotFoundException extends FileNotFoundException {

}

class Base {

  void display(Integer input) throws FileNotFoundException {
    System.out.println("Void display ");
  }
}

class Derived extends Base {
  @Override
  void display(Integer input2)  {


  //  BufferedReader br = new BufferedReader(new FileReader("example.txt")))

  }
}
