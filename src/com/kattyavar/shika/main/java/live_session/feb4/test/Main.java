package com.kattyavar.shika.main.java.live_session.feb4.test;

class Employee {
  private String age;
  private String name;
  protected String designation;

  public Employee(String age, String name, String designation) {
    //Default...
    this.age = age;
    this.name = name;
    this.designation = designation;
  }

  public String getAge() {
    return age;
  }
}


public class Main extends Employee {
  Main() {
    super("1", "1", "1");
    System.out.println("before calling parent constructor....");
  }

  public static void main(String[] args) {
    Employee emp = new Employee("1", "1", "1");






    Main obj = new Main();

    Object parentParentObj = obj;
    Employee parent = obj;
    Main mainObj = obj;












  }
}

class Test {


  //Default constructor...(compiler...)

  Test(String name, Integer a) {

  }

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Test{" +
      "name='" + name + '\'' +
      '}';
  }
}



























