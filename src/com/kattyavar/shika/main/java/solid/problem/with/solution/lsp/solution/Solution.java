package com.kattyavar.shika.main.java.solid.problem.with.solution.lsp.solution;

public class Solution {
  public static void main(String[] args) {

    refuelVehicle(new SwiftCar());
    //refuelVehicle(new TataEv()); // As you get compile error ..


  }

  static void refuelVehicle(Refuelable vehicle) {
    vehicle.refuel();
  }
}


//Lets refactor the code

// Base class for all vehicles
abstract class Vehicle {
  public abstract void drive();
}

// Interface for refuelable vehicles
interface Refuelable {
  void refuel();
}

// Interface for electric vehicles
interface Chargeable {
  void charge();
}

class SwiftCar extends Vehicle implements Refuelable {

  @Override
  public void refuel() {
    System.out.println("Refueling swift with Petrol");

  }

  @Override
  public void drive() {
    System.out.println("Driving swift car");

  }
}

class TataEv extends Vehicle implements Chargeable {

  @Override
  public void charge() {
    System.out.println("Charging EV car");
  }

  @Override
  public void drive() {
    System.out.println("Driving Tata EV car");

  }
}