package com.kattyavar.shika.main.java.live_session.sep25.solid.srp.problem.solution;

public class solution {

  public static void main(String[] args) {

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
  //Rest is getter and setter for this class


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
}

class SalaryCalculator {
  public double calculateSalary(Employee employee) {
    //Salary logic is here...
    return employee.getSalary();
  }
}

class EmployeeRepository {
  public void saveToDataBase(Employee employee) {
    //Save Employee to data base.
  }
}

class EmailService {
  public void sendWelcomeEmail() {
    // send the email ...
  }
}