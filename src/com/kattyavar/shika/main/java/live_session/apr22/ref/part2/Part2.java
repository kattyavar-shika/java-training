package com.kattyavar.shika.main.java.live_session.apr22.ref.part2;

public class Part2 {
  public static void main(String[] args) {
    String name = "jkdfj";

    Person obj = new Person("p1");



    var obj2 = new Person("p2");

    var stringVarName = "String var value";

    Human human = new Person("p2");

    var usingFunctionCallVairable = testMe();




  }

  static Human testMe(){
    return new Person("p2");
  }
}

class Human {

}

class Person extends Human {
  String name;

  public Person(String name) {

    var name3 = "Test";
    this.name = name;
  }
}

