package com.kattyavar.shika.main.java.solid.problem.with.solution.ocp.problem;

import com.kattyavar.shika.main.java.solid.problem.with.solution.srp.solution.Employee;

/**
 * Problem: The salary calculation logic is hard-coded into one method,
 * making it difficult to extend for different types of salary calculations.
 */

/**
 * Importance: OCP states that software entities (classes, modules, functions, etc.)
 * should be open for extension but closed for modification.
 * This means you can add new functionality without changing existing code.
 */
class SalaryCalculator {
  public double calculateSalary(Employee employee) {
    // Fixed salary calculation logic
    return employee.getSalary();
  }
}
