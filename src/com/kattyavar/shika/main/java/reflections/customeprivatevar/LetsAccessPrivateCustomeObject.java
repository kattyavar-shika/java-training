package com.kattyavar.shika.main.java.reflections.customeprivatevar;

import java.lang.reflect.Field;

public class LetsAccessPrivateCustomeObject {

  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

    //Let create the founder

    Person person = new Person("patil");

    College college = new College();

    applyTrick(college, person);

    college.founderName();
  }

  static void applyTrick(College college, Person person) throws NoSuchFieldException, IllegalAccessException {
    //Lets apply the trick here..
    Field founderFiled = college.getClass().getDeclaredField("founder");
    founderFiled.setAccessible(true);
    founderFiled.set(college, person);
    //Trick end ..
  }

}

class College {
  private Person founder;

  void founderName() {
    System.out.println("Founder " + founder.getName());
  }
}

class Person {

  private String name;

  public Person(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Person{" +
      "name='" + name + '\'' +
      '}';
  }
}
