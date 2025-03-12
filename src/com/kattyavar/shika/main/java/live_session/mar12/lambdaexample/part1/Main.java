package com.kattyavar.shika.main.java.live_session.mar12.lambdaexample.part1;

public class Main {
  public static void main(String[] args) {

    Base obj = new Base();

    //Here we would need to write some code so that name and lastName should have following values..
    // name = "Big man  "
    // lastName = "Try to chang my last name if you can"

    //obj.name = "Big man ";
    //obj.lastName = "Try to chang my last name if you can";
    System.out.println(obj);

  }
}

class Base {
  private String name;
  private String lastName;

  @Override
  public String toString() {
    return "Base{" +
      "name='" + name + '\'' +
      ", lastName='" + lastName + '\'' +
      '}';
  }
}
