package com.kattyavar.shika.main.java.solid.employeeexample.isp.problem;

/*
Problem: A large interface forces all classes to implement methods they may not need, leading to bloated code.
 */

/**
 * Importance: ISP states that no client should be forced to depend on methods it does not use.
 * This encourages the use of smaller, more specific interfaces instead of large, general-purpose ones.
 */
public class Problem {
}

interface EmployeeOperations {
  void calculateSalary();

  void saveToDatabase();

  void sendWelcomeEmail();
}

class Employee implements EmployeeOperations {
  @Override
  public void calculateSalary() {

  }

  @Override
  public void saveToDatabase() {

  }

  @Override
  public void sendWelcomeEmail() {

  }
  // Implementation that must include all methods
}