package com.kattyavar.shika.main.java.live_session.sep25.solid.lsp.solution;

public class Solution {
  public static void main(String[] args) {

    //refuelVehicle(new TataEv()); // This will give you error at compile time
    refuelVehicle(new Verna());

  }

  static void refuelVehicle(Refuelable refuelable) {
    refuelable.refuel();
  }

}


abstract class Vehicle {
  public abstract void drive();

}

interface Refuelable {
  void refuel();
}

interface Chargeable {
  void charge();
}


class WagonR extends Vehicle implements Refuelable {
  @Override
  public void drive() {
    System.out.println("Driving WagonR");
  }

  @Override
  public void refuel() {
    System.out.println("Refuel WagonR with petrol...");
  }
}

class Verna extends Vehicle implements Refuelable {
  @Override
  public void refuel() {
    System.out.println("Refule verna ");
  }

  @Override
  public void drive() {
    System.out.println("Drive verna");

  }
}

class TataEv extends Vehicle implements Chargeable {
  @Override
  public void drive() {
    System.out.println("Driving Tata Ev");
  }

  @Override
  public void charge() {

    System.out.println("Charging Tata Ev car..");
  }
}