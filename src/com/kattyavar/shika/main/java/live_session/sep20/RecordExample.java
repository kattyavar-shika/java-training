package com.kattyavar.shika.main.java.live_session.sep20;

import java.util.Objects;

public class RecordExample {
  public static void main(String[] args) {

  }
}


record UseRecordExample(String name, Integer age, String pincode) {

  public static String profile = "p1";
  //But you can nto have member variable here.


  //Compact constructor..
  UseRecordExample {
    //I can apply validation here.. note all variable is coming from (String name, Integer age, String pincode)
    if (age <= 10) {
      throw new IllegalArgumentException();
    }
  }

  public UseRecordExample(String name) {
    this(name, 10, "defult pin code");
  }
  //Constructor
  //Get method
  //Equal and hasCode
  //toString
  //You can not modify the object ..

  //You can have static method Static variable
  //But you can not have instance variable
  //you can implement any interface
  //But you can extend or any other class can not extend record.

}


class RecordClassDemo {
  private String name;

  public RecordClassDemo() {
  }

  public RecordClassDemo(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RecordClassDemo that = (RecordClassDemo) o;
    return Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }

  @Override
  public String toString() {
    return "RecordClassDemo{" +
      "name='" + name + '\'' +
      '}';
  }
}
