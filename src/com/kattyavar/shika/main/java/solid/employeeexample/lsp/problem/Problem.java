package com.kattyavar.shika.main.java.solid.employeeexample.lsp.problem;

public class Problem {
}

/**
 * Problem: Subclasses of Employee may not behave correctly if they don’t conform to the expected interface or behavior.
 */

/**
 * Importance: LSP states that subclasses should be substitutable for their base classes without
 * affecting the correctness of the program.
 * This ensures that derived classes extend the base class's behavior without altering its expected functionality.
 */

class Employee {
  double salary;

  public double getSalary() {
    return salary;
  }
}


class Contractor extends Employee {
  @Override
  public double getSalary() {
    // Implementation that may not be compatible with Employee
    return 0;
  }
}