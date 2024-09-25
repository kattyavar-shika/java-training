package com.kattyavar.shika.main.java.live_session.sep25.solid.lsp.problem;

public class Problem {

  public static void main(String[] args) {
    Vehicle vehicle = new TataEv();

    refuelVehicle(vehicle);

  }

  static void refuelVehicle(Vehicle vehicle) {
    vehicle.drive();
    vehicle.refuel();
  }
}


class Vehicle {
  public void drive() {
    System.out.println("Driving vehicle ");
  }

  public void refuel() {
    System.out.println("Refueling vehicle ");
  }
}


class WagonR extends Vehicle {

  @Override
  public void drive() {
    System.out.println("Driving WagonR ..");
  }

  @Override
  public void refuel() {
    System.out.println("Refueling WagonR");
  }
}

class TataEv extends Vehicle {
  @Override
  public void drive() {
    System.out.println("Driving Tata Ev car");
  }

  @Override
  public void refuel() {
    throw new UnsupportedOperationException();
  }
}