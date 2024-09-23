package com.kattyavar.shika.main.java.solid.employeeexample.isp.solution;

public class Solution {
}

interface SalaryCalculator {
  double calculateSalary(Employee employee);
}

interface DatabaseOperations {
  void saveToDatabase(Employee employee);
}

interface EmailService {
  void sendWelcomeEmail(Employee employee);
}

// Employee class implementation does not need to implement all operations
class Employee {
  private String name;
  private String department;
  private double salary;

  public Employee(String name, String department, double salary) {
    this.name = name;
    this.department = department;
    this.salary = salary;
  }
}