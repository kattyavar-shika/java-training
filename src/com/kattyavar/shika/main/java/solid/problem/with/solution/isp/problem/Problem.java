package com.kattyavar.shika.main.java.solid.problem.with.solution.isp.problem;

/*
Problem: A large interface forces all classes to implement methods they may not need, leading to bloated code.
Imagine you have a Vehicle interface that defines a bunch of methods for different types of vehicles.
However, not all vehicles implement all methods, leading to an implementation that doesn't fit well with certain vehicle types.
 */

/**
 * Importance: ISP states that no client should be forced to depend on methods it does not use.
 * This encourages the use of smaller, more specific interfaces instead of large, general-purpose ones.
 */
public class Problem {
}

interface Vehicle {
  void start();

  void stop();

  void fly(); // Not all Vehicle can fly

  void sail(); // Not all vehicles can sail
}

class car implements Vehicle {
  @Override
  public void start() {
    System.out.println("Car started.");
  }

  @Override
  public void stop() {
    System.out.println("Car stop");
  }

  @Override
  public void fly() {
    throw new UnsupportedOperationException("Cars can't fly");
  }

  @Override
  public void sail() {
    throw new UnsupportedOperationException("Cars can't sail");
  }
}