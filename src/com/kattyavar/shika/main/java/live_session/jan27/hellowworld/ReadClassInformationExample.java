package com.kattyavar.shika.main.java.live_session.jan27.hellowworld;


import com.sun.security.jgss.GSSUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;

public class ReadClassInformationExample {
  public static void main(String[] args) {

    Person obj = new Person();

    Class c1 = obj.getClass();

    //Class Name
    System.out.println("Class Name " + c1.getName());

    //Get the all method
    Method[] methods = c1.getDeclaredMethods();

    System.out.println("Method information....");
    for (Method method : methods) {
      System.out.println("===================================");
      System.out.println("Method name -> " + method.getName());
      System.out.println("Method Return type -> " + method.getReturnType().getName());
      System.out.println("Method access specifier ->" + method.getModifiers());
    }


    System.out.println("Fields Information .....");
    //Now let get member variables
    Field[] fields = c1.getDeclaredFields();
    for (Field field : fields) {
      System.out.println("===================================");
      System.out.println("Member variable name -> " + field.getName());
      System.out.println("Member variable Type -> " + field.getType());
      System.out.println("Member variable access specifier -> " + field.getModifiers());
    }

    //Super class Information
    System.out.println("Super class Name ->" + c1.getSuperclass().getName());

    getLoaderInformation();
  }

  public static void getLoaderInformation() {

    //Bootstrap loader
    System.out.println("String.class loader name " + String.class.getClassLoader());

    //Extension Class Loader (in java 8) Platform class Loader name (java 9 onwards)
    System.out.println("Connection.class loader Name ->" + Connection.class.getClassLoader());

    //Application Class loader Name
    System.out.println("Person.class loader name -> " + Person.class.getClassLoader());

  }
}

class Person {

  private String name;
  public String lastName;
  protected Integer age;
  Boolean gender;

  public Person() {
  }

  //Lets add some method

  private String getName() {
    return name;
  }

  public String getLastName() {
    return lastName;
  }

  protected Integer age() {
    return age;
  }

  Boolean getGender() {
    return gender;
  }
}
