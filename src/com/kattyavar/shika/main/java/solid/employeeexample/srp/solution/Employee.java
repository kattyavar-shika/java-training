package com.kattyavar.shika.main.java.solid.employeeexample.srp.solution;

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

  @Override
  public String toString() {
    return "Employee{" +
      "name='" + name + '\'' +
      ", department='" + department + '\'' +
      ", salary=" + salary +
      '}';
  }
}

class SalaryCalculator {
  public double calculateSalary(Employee employee) {
    //Apply any logic if you want to add it.
    return employee.getSalary();
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