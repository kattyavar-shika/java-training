package com.kattyavar.shika.main.java.solid.employeeexample.dip.solution;


public class Solution {
}

class EmployeeService {
  private final DatabaseOperations repository;
  private final EmailService emailService;

  public EmployeeService(DatabaseOperations repository, EmailService emailService) {
    this.repository = repository;
    this.emailService = emailService;
  }

  public void addEmployee(Employee employee) {
    //repository.saveToDatabase(employee);
    emailService.sendWelcomeEmail(employee);
  }
}

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

interface DatabaseOperations {
  void saveToDatabase(Employee employee);
}

class EmailService {
  public void sendWelcomeEmail(Employee employee) {
    // Send welcome email logic.
  }
}