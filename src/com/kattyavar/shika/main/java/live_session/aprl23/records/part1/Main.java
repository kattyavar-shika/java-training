package com.kattyavar.shika.main.java.live_session.aprl23.records.part1;

import java.util.Objects;

public class Main {

  public static void main(String[] args) {


    Person1 obj1 = new Person1("p1", "lastName", 11);
    Person1 obj2 = new Person1("p1");



    System.out.println("Let have look at record data ==> " + obj1);


  }

  static void testMe(Person obj) {
    //obj.setName("Modified from function...");
  }
}

class Temp {
  String name;

  public Temp(String name) {
    this.name = name;
  }
}


record Student (String name, Integer age, int nickName) {

}



record Person1 (String name, String lastName, Integer age)  {

  Person1 (String name, String lastName, Integer age ) {
    // check
    if (age < 18) {
      throw new IllegalArgumentException("Age cannot be less than 18");
    }

    this.name = name;
    this.lastName = lastName;
    this.age = age;
  }



  Person1(String name){
    this(name, "last name default", 11);
  }
}


final class Person extends Temp{
  private String name;
  private String lastName;
  private Integer age;


  public Person(String name, String lastName, Integer age) {
    super("");
  }

  public String getName() {
    return name;
  }


  public String getLastName() {
    return lastName;
  }

  public Integer getAge() {
    return age;
  }


  @Override
  public String toString() {
    return "Person{" +
      "name='" + name + '\'' +
      ", lastName='" + lastName + '\'' +
      ", age=" + age +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return Objects.equals(name, person.name) && Objects.equals(lastName, person.lastName) && Objects.equals(age, person.age);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, lastName, age);
  }
}

