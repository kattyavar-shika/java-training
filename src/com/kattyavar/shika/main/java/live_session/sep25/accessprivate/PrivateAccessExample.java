package com.kattyavar.shika.main.java.live_session.sep25.accessprivate;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrivateAccessExample {

  /*
  @AutoWire
  @Compoent
  constructor injections
   */


  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

    College college = new College();

    Person person = new Person("Patil Amol Prasad...");

    letUseAnnotations(college, person);
    System.out.println("Founder name is = shri shri " + college.getFounderName() + " ");


  }

  static void privateAccessExample() throws NoSuchFieldException, IllegalAccessException {
    College college = new College();

    Person person = new Person("Patil Amol Prasad...");

    letTryThis(college, person);
    System.out.println("Founder name is = shri shri " + college.getFounderName() + " ");

  }

  static void letUseAnnotations(College college, Person person) throws IllegalAccessException {


    System.out.println("Let find out Parent class name ===> " + person.getClass().getSuperclass().getName());

    System.out.println("Let find out Object methods...");

    for (Method method : person.getClass().getSuperclass().getDeclaredMethods()) {
      System.out.println("Object method names as == > " + method.getName());
    }

    System.out.println("let print the method name");
    for (Method method : college.getClass().getDeclaredMethods()) {
      System.out.println(" in class we have method  " + method.getName());
    }

    Field[] declaredFields = college.getClass().getDeclaredFields();
    System.out.println("In new method...");
    for (Field field : declaredFields) {
      System.out.println("Processing the filed = " + field.getName());
      if (field.isAnnotationPresent(AutowirePerson.class)) {
        System.out.println("Found the annotation let s udp");
        field.setAccessible(true);
        field.set(college, person);
      }
    }

  }

  static void letTryThis(College college, Person person) throws NoSuchFieldException, IllegalAccessException {

    for (Field filed : college.getClass().getDeclaredFields()) {
      System.out.println("filed name as " + filed.getName() + " Type as " + filed.getType().getName());
    }


    Field founderField = college.getClass().getDeclaredField("founder");
    founderField.setAccessible(true);
    founderField.set(college, person);
  }
}


class College {
  private String prasad;

  @AutowirePerson
  private Person founder;

  private String name1;
  private String name2;
  private Integer intVal1;

  public College() {

  }

  public College(Person person) {
    this.founder = person;
  }

  public String getFounderName() {
    return founder.getName();
  }

  @Override
  public String toString() {
    return "College{" +
      "founder=" + founder +
      '}';
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


