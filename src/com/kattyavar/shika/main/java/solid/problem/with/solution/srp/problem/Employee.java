package com.kattyavar.shika.main.java.solid.problem.with.solution.srp.problem;

/**
 * Problem: The original Employee class does too much:
 * it manages employee data, calculates salaries, saves to a database, and sends emails.
 */

/**
 * Importance: SRP states that a class should have one, and only one, reason to change.
 * This means that a class should have a single responsibility or job, making it easier to maintain and modify.
 */
public class Employee {
  private String name;
  private String department;
  private double salary;

  public Employee(String name, String department, double salary) {
    this.name = name;
    this.department = department;
    this.salary = salary;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public void calculateSalary() {
    // Apply salary calculation logic.
  }

  public void saveToDatabase() {
    // Save employee record to database.
  }

  public void sendWelcomeEmail() {
    // Email logic to send welcome email.
  }
}
