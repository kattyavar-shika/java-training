package com.kattyavar.shika.main.java.solid.employeeexample.dip.problem;

import com.kattyavar.shika.main.java.solid.employeeexample.srp.solution.EmailService;
import com.kattyavar.shika.main.java.solid.employeeexample.srp.solution.Employee;
import com.kattyavar.shika.main.java.solid.employeeexample.srp.solution.EmployeeRepository;

public class Problem {

  public static void main(String[] args) {
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
