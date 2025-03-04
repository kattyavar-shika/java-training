package com.kattyavar.shika.main.java.live_session.mar4.callbyvalue;

public class Main {
  void testintCallByValue() {
    int a = 10;
    System.out.println("Before calling function value of a is => " + a);
    testInt(a);
    System.out.println("After calling function value of a is => " + a);
  }

  public static void main(String[] args) {

    Person obj = new Person("Name of the person from main method...");
    System.out.println("Before calling function as name => " + obj.getName());
    testPersonObj(obj);
    System.out.println("Afters calling function as name => " + obj.getName());


  }

  static void testPersonObj(final Person temp) {
    System.out.println("We got the name of person is => " + temp.getName());
    //temp = new Person("");
    temp.setName("Name of the person from testPersonObj ...");

    System.out.println("We have update the value of name as => " + temp.getName());


  }

  static void testInt(int a) {

    System.out.println("We got input as ===> " + a);
    a = 20;
    System.out.println("We have updated values as ===> " + a);

  }
}

interface A1 {}
interface A2 {}

interface B1 extends A1, A2{}


 class Person {
  final String name;

  public Person(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    //this.name = name;
  }
}

