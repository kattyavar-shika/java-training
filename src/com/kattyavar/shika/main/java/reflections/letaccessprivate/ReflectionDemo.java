package com.kattyavar.shika.main.java.reflections.letaccessprivate;

import java.lang.reflect.Field;

public class ReflectionDemo {

  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
    Person person = new Person("User 1", 20);

    System.out.println(" Person object content :" + person.displayInfo());

    //If you try to do following you will get compile error.
    // person.name = "New user name"

    //Let try to do change the name value as "New user name" instead of "User 1" using reflections.

    Class<?> clazz = person.getClass();

    Field nameField = clazz.getDeclaredField("name");

    nameField.setAccessible(true);
    nameField.set(person, "New user name");

    System.out.println("Person object after modification of name private attribute : " + person.displayInfo());
  }
}
