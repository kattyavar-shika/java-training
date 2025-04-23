# SOLID principles 

These principles are a set of five design principles that help developers create more maintainable, flexible, and scalable code.   
They were introduced by **Robert C. Martin (Uncle Bob)** and are often applied in object-oriented design.   
Let's go through each one with definitions

## S – Single Responsibility Principle (SRP)

#### The Single Responsibility Principle states that a class should have only one reason to change, meaning it should only have one job or responsibility.

## O – Open/Closed Principle (OCP)

#### The Open/Closed Principle states that a class should be open for extension but closed for modification. This means you should be able to add new functionality to a class without changing its existing code.

## L – Liskov Substitution Principle (LSP)

#### The Liskov Substitution Principle states that objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.


## I – Interface Segregation Principle (ISP)

#### The Interface Segregation Principle states that no client should be forced to depend on methods it does not use. Essentially, it's better to have several small, specific interfaces than one large, general-purpose interface.


## D – Dependency Inversion Principle (DIP)

#### The Dependency Inversion Principle states that high-level modules should not depend on low-level modules. Both should depend on abstractions (e.g., interfaces). Additionally, abstractions should not depend on details; details should depend on abstractions.




# S – Single Responsibility Principle (SRP)

Problem (Violation of SRP)

In this example, the Employee class is doing too much. It is handling multiple responsibilities:

- Storing employee data
- Calculating salary
- Saving employee data to the database
- Sending emails to the employee

This violates the Single Responsibility Principle (SRP), which states that a class should have one reason to change, i.e., it should have only one responsibility.

```java
/**
 * Problem: The original Employee class does too much:
 * it manages employee data, calculates salaries, saves to a database, and sends emails.
 */

/**
 * Importance: SRP states that a class should have one, and only one, reason to change.
 * This means that a class should have a single responsibility or job, making it easier to maintain and modify.
 */
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

  public void calculateSalary() {
    // Apply salary calculation logic.
  }

  public void saveToDatabase() {
    // Save employee record to database.
  }

  public void sendWelcomeEmail() {
    // Email logic to send welcome email.
  }
}

```

## Violation of SRP
- Problem: The Employee class is responsible for:
  - Managing employee data.
  - Calculating salary.
  - Saving to a database.
  - Sending a welcome email.

Each of these responsibilities requires changes for different reasons:
- Changing the way salary is calculated requires modifying the Employee class.
- Changing the database persistence logic requires modifying the Employee class.
- Changing the email notification system requires modifying the Employee class.

This makes the class difficult to maintain, as it forces developers to change one class for multiple reasons.


## Solution (Refactored Version - Applying SRP)

We can refactor this by applying the Single Responsibility Principle (SRP). Instead of having a single class handle multiple responsibilities, we break them down into separate classes, each focusing on one specific task.

```java
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

// Salary Calculation Logic
class SalaryCalculator {
  public double calculateSalary(Employee employee) {
    return employee.getSalary();
  }
}

// Database Logic
public interface EmployeeRepository {
    void saveToDatabase(Employee employee);
}

public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Override
    public void saveToDatabase(Employee employee) {
        // Logic to save employee record to a database.
    }
}

// Notification Logic
public interface NotificationService {
    void sendWelcomeNotification(Employee employee);
}

public class EmailService implements NotificationService {
    @Override
    public void sendWelcomeNotification(Employee employee) {
        // Logic to send a welcome email.
    }
}

```

### Why This Refactor Works

After applying SRP, each class now has a single responsibility:

- Employee: Stores employee data.
- SalaryCalculator: Handles salary calculation logic.
- EmployeeRepository: Deals with saving the employee to a database.
- EmailService: Manages sending welcome emails.


### Key Benefits of Applying SRP:
- Simplifies Maintenance: With separate concerns, code is easier to maintain.
- Improves Testability: Each class can be tested independently.
- Facilitates Extension: New functionality can be added without touching unrelated code.
- Reduces Side Effects: Changes in one area do not accidentally break other parts of the system.




### Conclusion

This example shows how to refactor a class that was doing too much by applying the Single Responsibility Principle (SRP).   
Each class now focuses on a single responsibility, making the code easier to maintain, test, and extend. By isolating each responsibility, changes are limited to the appropriate class, reducing complexity and improving overall code quality.



