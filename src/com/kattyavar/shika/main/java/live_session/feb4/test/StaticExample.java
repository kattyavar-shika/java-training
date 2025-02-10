package com.kattyavar.shika.main.java.live_session.feb4.test;

public class StaticExample {

  public static void main(String[] args) {
    Base baseObj = new Base("name1", "Last name1");
    Base baseObj2 = new Base("name2", "Last name2");
    Base baseObj3 = new Base("name2", "Last name2");

    System.out.println(baseObj.getStaticCount());
    System.out.println(baseObj2.getStaticCount());
    System.out.println(baseObj3.getStaticCount());

    //Then you will increment from any obj
    baseObj2.incrementCounter();

    //Let print obj
    System.out.println(baseObj2.getStaticCount());


    System.out.println(baseObj.getStaticCount());
    System.out.println(baseObj3.getStaticCount());






  }
}

class Base {
  private String name;
  private String lastName;

  static Integer count;


  public Base() {
  }


  public Base(String name, String lastName) {
    this.name = name;
    this.lastName = lastName;
  }

  public Integer getStaticCount(){
    return count;
  }

  public void incrementCounter(){
    count = count + 1;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}


class Derived  {

}