package com.kattyavar.shika.main.java.live_session.mar5.generic.second;

public class Main {

  // Box<Integer> obj;

  Box<? extends Person> personExtentsObj;

  Box<? super Person> personSuperObj;

  //If i am user (developer) ..


  //If i am developer ...
}


class Utlitiy {
  <T> T useThis(T input) {
    //ffd
    //If you apply the modification here...
    //requirment done..
    return input;
  }
}

class Person {

}


class Box<T extends Person> {


  T useMe(T input) {
    return input;
  }
}
