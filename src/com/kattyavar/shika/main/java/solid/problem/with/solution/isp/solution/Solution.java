package com.kattyavar.shika.main.java.solid.problem.with.solution.isp.solution;

/**
 * To adhere to the Interface Segregation Principle,
 * we should split the Vehicle interface into more specific interfaces.
 * Here’s how we can refactor the code:
 */
public class Solution {
}

interface Drivable {
  void start();

  void stop();
}

interface Flyable {
  void fly();
}

interface Sailable {
  void sail();
}

class Car implements Drivable {
  @Override
  public void start() {
    System.out.println("Car started..");
  }

  @Override
  public void stop() {
    System.out.println("Car stopped..");
  }
}

class Airplane implements Drivable, Flyable {
  @Override
  public void start() {
    System.out.println("Airplane started ");
  }

  @Override
  public void stop() {
    System.out.println("Airplane stopped");
  }

  @Override
  public void fly() {

    System.out.println("Airplane flying");
  }
}

class Boat implements Drivable, Sailable {
  @Override
  public void start() {
    System.out.println("Boat started");
  }

  @Override
  public void stop() {
    System.out.println("Boat stopped.");

  }

  @Override
  public void sail() {
    System.out.println("Boat sailing");
  }
}