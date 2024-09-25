package com.kattyavar.shika.main.java.live_session.sep25.solid.ocp.solution;

import com.kattyavar.shika.main.java.solid.problem.with.solution.srp.problem.Employee;

public class Solution {
}


interface SalaryCalculator {
  double calculateSalary(Employee employee);
}


class FixSalaryCalculator implements SalaryCalculator {
  @Override
  public double calculateSalary(Employee employee) {
    //you can add the logic here..
    return 0;
  }
}

class HourlySalaryCalculator implements SalaryCalculator {
  @Override
  public double calculateSalary(Employee employee) {
    //Apply the logic here
    return 0;
  }
}

class HighPerformanceSalaryCalculator implements SalaryCalculator {
  @Override
  public double calculateSalary(Employee employee) {
    return 0;
  }
}

























