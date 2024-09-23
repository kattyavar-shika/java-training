package com.kattyavar.shika.main.java.solid.employeeexample.dip.problem;

import com.kattyavar.shika.main.java.solid.employeeexample.srp.solution.Employee;

public class Problem {

  public static void main(String[] args) {
    System.out.println("Min Valus " + Double.MIN_VALUE);
    double minValue = Double.MIN_VALUE;
    System.out.printf("Double.MIN_VALUE in scientific notation: %.2e%n", minValue);

    System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
  }
}

/**
 * The EmployeeService class directly depends on concrete implementations, making it less flexible and harder to test.
 */

/**
 * Importance: DIP states that high-level modules should not depend on low-level modules;
 * both should depend on abstractions. This reduces tight coupling and enhances flexibility.
 */

class EmployeeService {
  public void addEmployee(Employee employee) {
    EmployeeRepository repository = new EmployeeRepository();
    repository.saveToDatabase(employee);

    EmailService emailService = new EmailService();
    emailService.sendWelcomeEmail(employee);
  }
}

class EmployeeRepository {
  public void saveToDatabase(Employee employee) {
    // Save employee record to database.
  }
}

class EmailService {
  public void sendWelcomeEmail(Employee employee) {
    // Send welcome email logic.
  }
}