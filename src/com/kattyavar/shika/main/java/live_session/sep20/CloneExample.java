package com.kattyavar.shika.main.java.live_session.sep20;

public class CloneExample {

  public static void main(String[] args) throws CloneNotSupportedException {
    Person person1 = new Person("Person 1", new Address("41101"));
    Person person2 = (Person) person1.clone();

  }
}

class Person implements Cloneable{
  String name;
  Address address;

  public Person(String name, Address address) {
    this.name = name;
    this.address = address;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    Person cloned = (Person) super.clone();
    cloned.address = (Address) address.clone();
    return cloned;
  }

  @Override
  public String toString() {
    return "Person{" +
      "name='" + name + '\'' +
      ", address=" + address +
      '}';
  }
}

class Address implements Cloneable {
  String areaCode;

  public Address(String areaCode) {
    this.areaCode = areaCode;
  }

  @Override
  public String toString() {
    return "Address{" +
      "areaCode='" + areaCode + '\'' +
      '}';
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
