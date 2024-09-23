package com.kattyavar.shika.main.java.solid.employeeexample.lsp.solution;

public class Solution {
}

abstract class Employee {
  protected double salary;

  public abstract double getSalary();
}

class FullTimeEmployee extends Employee {
  public FullTimeEmployee(double salary) {
    this.salary = salary;
  }

  @Override
  public double getSalary() {
    return salary; // Full-time salary logic
  }
}


class Contractor extends Employee {
  private double hourlyRate;
  private int hoursWorked;

  public Contractor(double hourlyRate, int hoursWorked) {
    this.hourlyRate = hourlyRate;
    this.hoursWorked = hoursWorked;
  }

  @Override
  public double getSalary() {
    return hourlyRate * hoursWorked; // Contractor salary logic
  }
}