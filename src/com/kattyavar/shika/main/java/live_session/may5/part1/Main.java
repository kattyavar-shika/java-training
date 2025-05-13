package com.kattyavar.shika.main.java.live_session.may5.part1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

  void testMe() {
    Person obj = new Person("Person name 1", 21);
    Class<?> cls = obj.getClass();

    Field[] fields = cls.getDeclaredFields();

    for (Field field : fields) {
      System.out.println("variable name is -> " + field.getName());
      System.out.println("Access specifier of var is " + Modifier.toString(field.getModifiers()));
    }

    Method[] methods = cls.getDeclaredMethods();

    for (Method method : methods) {
      System.out.println("Method name -> " + method.getName());
      System.out.println("Access specifier of Method is " + Modifier.toString(method.getModifiers()));

    }
  }

  public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {

    Person obj = new Person("Person name 1", 21);
    System.out.println(obj);

    // I would like to write the code such way that obj.name should be "Person new name"

    //obj.name //compiler error

    Class<?> cls = obj.getClass();

    Field fieldName = cls.getDeclaredField("name");

    fieldName.setAccessible(true);
    fieldName.set(obj, "new person values is ");
    /*
    for (Field field : cls.getDeclaredFields()) {
      System.out.println("Processing var -> " + field.getName());
      if (field.getName().equals("name")) {

        field.setAccessible(true);

        field.set(obj, "Person new name");


      }
    }

     */

    System.out.println("After change new values of obj as --->");

    System.out.println(obj);

  }
}

class Person {

  private String name;
  private Integer age;
  public String openVariable;

  public Person(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person{" +
      "name='" + name + '\'' +
      ", age=" + age +
      '}';
  }
}
