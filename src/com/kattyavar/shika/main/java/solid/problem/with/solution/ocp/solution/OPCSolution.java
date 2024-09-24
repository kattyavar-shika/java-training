package com.kattyavar.shika.main.java.solid.problem.with.solution.ocp.solution;

import com.kattyavar.shika.main.java.solid.problem.with.solution.srp.problem.Employee;

public class OPCSolution {
}

interface SalaryCalculator {
  double calculateSalary(Employee employee);
}

class FixedSalaryCalculator implements SalaryCalculator {
  @Override
  public double calculateSalary(Employee employee) {
    //Implement logic for Fixed Salary employee.
    return employee.getSalary();
  }
}

class HourlySalaryCalculator implements SalaryCalculator {
  @Override
  public double calculateSalary(Employee employee) {
    // Logic for hourly employees
    return employee.getSalary() * 20; // Example calculation
  }
}