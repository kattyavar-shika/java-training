package com.kattyavar.shika.main.java.live_session.feb24;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class Main {
  public static void main(String[] args) {

    Derived obj = new Derived();
    System.out.println("Derived name -> " + obj.getName());
    System.out.println("Base name -> " + obj.getNameBase());

    System.out.println("Let update the values as ");
    obj.setDerivedName("Out side value set for derived ");
    obj.setBaseName("Out side values set for base...");

    System.out.println("Derived name -> " + obj.getName());
    System.out.println("Base name -> " + obj.getNameBase());

    Base obj1 = new Base();

    new Vector<>();

  }
}



class Base  {
  protected String name;
  private String lastName;

  public Base() {
    this("Default value for name");
    //
    // super();
    name = "Base hard code value";
  }

  public Base(String name) {
    this("Default value for name", name);
    this.name = name;
  }

  public Base(String name, String lastName) {
    this.name = name;
    this.lastName = lastName;
  }
}

class Derived extends Base {
  private String name;

  public Derived() {
    this.name = "Derived hard code value";
  }

  public String getName() {
    return name;
  }

  public String getNameBase() {
    return super.name;
  }

  public void setDerivedName(String name) {
    this.name = name;
  }

  public void setBaseName(String name) {
    super.name = name;
  }
}