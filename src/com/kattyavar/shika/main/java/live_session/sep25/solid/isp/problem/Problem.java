package com.kattyavar.shika.main.java.live_session.sep25.solid.isp.problem;

public class Problem {
  public static void main(String[] args) {

  }
}

interface Vehicle {
  void start();

  void stop();

  void fly();

  void sail();
}


class Car implements Vehicle {
  @Override
  public void start() {
    System.out.println("car started ..");
  }

  @Override
  public void stop() {
    System.out.println("Car stopped ...");

  }

  @Override
  public void fly() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void sail() {
    throw new UnsupportedOperationException();

  }
}

class Airplan implements Vehicle {
  @Override
  public void start() {

  }

  @Override
  public void stop() {

  }

  @Override
  public void fly() {

  }

  @Override
  public void sail() {
    throw new UnsupportedOperationException();
  }
}