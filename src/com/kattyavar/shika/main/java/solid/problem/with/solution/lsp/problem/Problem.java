package com.kattyavar.shika.main.java.solid.problem.with.solution.lsp.problem;

public class Problem {
  public static void main(String[] args) {

    Vehicle vehicle = new TataEv();

    vehicle.refuel();

    refuelVehicle(new SwiftCar()); //Work fine

    refuelVehicle(new TataEv()); // This will not work
  }

  static void refuelVehicle(Vehicle vehicle) {
    vehicle.refuel();
  }
}

/**
 * Imagine a system designed to handle various types of vehicles, including Car and ElectricCar.
 * The base class Vehicle has a method refuel().
 * However, the implementation violates LSP, as electric cars do not refuel in the same way traditional cars do.
 */

/**
 * Importance: LSP states that subclasses should be substitutable for their base classes without
 * affecting the correctness of the program.
 * This ensures that derived classes extend the base class's behavior without altering its expected functionality.
 */

class Vehicle {
  public void drive() {
    System.out.println("Driving vehicle");
  }

  public void refuel() {
    System.out.println("Refueling vehicle");
  }
}

//Now lets implement class

class SwiftCar extends Vehicle {
  @Override
  public void drive() {
    System.out.println("Driving swift car");
  }

  @Override
  public void refuel() {
    System.out.println("Refueling swift with Petrol");
  }
}

class TataEv extends Vehicle {
  @Override
  public void drive() {
    System.out.println("Driving Tata EV car");
  }

  @Override
  public void refuel() {
    throw new UnsupportedOperationException();
  }
}
