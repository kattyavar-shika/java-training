package com.kattyavar.shika.main.java.live_session.mar4.generics;

import java.util.List;

public class GenericsExample {

  public static void main(String[] args) {

    Integer input1 = 10;
    Integer input2 = 20;

    MathOperation<Integer> objInt = new MathOperation<>(input1, input2);
   // MathOperation<String> objString = new MathOperation<>("input1 ", "input 2");

    //MathOperation<Person> objPerson = new MathOperation<>(new Person(""), new Person(""));

    System.out.println(objInt);

  }
}

class Utility {

  //useMe(Integer, String)
  //useMe(Integer, Integer)
  //useMe(String, String)
  public  <T, U > T useMe(T input, U input2) {

    return null;
  }

}

class Person {
  String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Person(String name) {
    this.name = name;
  }
}

//MathOperation<Integer> objInt
class MathOperation<T extends Number> {
  T input1;
  T input2;

  public MathOperation(T input1s, T input2) {
    this.input1 = input1s;
    this.input2 = input2;
  }

  public T getInput1() {
    return input1;
  }

  public T getInput2() {
    return input2;
  }

  double add() {

    return input1.doubleValue() + input2.doubleValue();
  }

  @Override
  public String toString() {
    return "MathOperation{" +
      "input1=" + input1 +
      ", input2=" + input2 +
      '}';
  }
}