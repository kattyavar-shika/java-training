package com.kattyavar.shika.main.java.live_session.aprl23.sealed.part1;

public class Main {

  public static void main(String[] args) {

  }
}



interface MyInterface {
  String getData();
}

final class Test {

}



class MyClass implements MyInterface {
  @Override
  public String getData() {
    return "I can do anything ....";
  }
}

class Temp implements MyInterface {
  @Override
  public String getData() {
    return "I can do anything ....";
  }
}