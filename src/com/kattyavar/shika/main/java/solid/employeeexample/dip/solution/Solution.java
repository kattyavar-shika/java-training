package com.kattyavar.shika.main.java.solid.employeeexample.dip.solution;

import com.kattyavar.shika.main.java.solid.employeeexample.isp.solution.DatabaseOperations;
import com.kattyavar.shika.main.java.solid.employeeexample.srp.solution.EmailService;
import com.kattyavar.shika.main.java.solid.employeeexample.srp.solution.Employee;

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

