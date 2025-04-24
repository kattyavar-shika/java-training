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




# Open/Closed Principle (OCP)

The Open/Closed Principle states that software entities should be open for extension but closed for modification.   

This means that you should be able to extend the functionality of a class without modifying its existing code.   
By doing so, we ensure that the system remains stable and maintainable while allowing new features to be added without altering existing code.


## Problem (Violation of OCP)
In the original code, the salary calculation logic is tightly coupled with a single method (calculateSalary), which makes it difficult to extend if we need different types of salary calculations in the future.   
If we wanted to add new salary calculation logic (for example, for contract-based employees or commission-based employees), we would have to modify the SalaryCalculator class directly, violating the Open/Closed Principle.

```java
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

```

## Violation of OCP

Problem: If we want to add new types of salary calculations (e.g., hourly-based or commission-based), we would have to modify the SalaryCalculator class, which violates the principle of being closed for modification.

## Solution (Refactored Version - Applying OCP)

To adhere to OCP, we need to make the SalaryCalculator class open for extension (i.e., new types of salary calculations can be added), but closed for modification (i.e., we should not modify existing code).

We can achieve this by using interfaces or abstract classes. Here's the refactored solution:

```java
public class OPCSolution {

    interface SalaryCalculator {
        double calculateSalary(Employee employee);
    }

    class FixedSalaryCalculator implements SalaryCalculator {
        @Override
        public double calculateSalary(Employee employee) {
            // Implement logic for fixed salary employee.
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

    // New implementation for Commission-based salary calculation
    class CommissionSalaryCalculator implements SalaryCalculator {
        @Override
        public double calculateSalary(Employee employee) {
            // Commission-based salary logic
            return employee.getSalary() + (employee.getSalary() * 0.10); // Example calculation
        }
    }

    // Employee class remains the same
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
    }
}

``` 

**Explanation of the Solution:**
- SalaryCalculator Interface:
  - This interface provides a contract for different types of salary calculations.
  - It ensures that each salary calculation type (fixed, hourly, commission) implements the calculateSalary method.




## Conclusion

By applying the Open/Closed Principle (OCP), we ensure that our system is both flexible and stable.   
The SalaryCalculator is now open for extension, allowing us to add new salary calculation types without modifying existing code.   
This makes the codebase easier to maintain and extend, ensuring that the addition of new features won't introduce unexpected side effects.




# L – Liskov Substitution Principle (LSP)

The Liskov Substitution Principle states that objects of a superclass should be replaceable with objects of its subclasses without affecting the correctness of the program.

In other words, if class B is a subclass of class A, then we should be able to use B in place of A without the program misbehaving.

This principle ensures that derived classes extend the base class behavior without altering its expected functionality.

## Problem (Violation of LSP)

Let's consider a system designed to handle different types of vehicles.

We have a base class Vehicle that includes a refuel() method. Traditional cars implement this method appropriately, but electric cars don't need refueling — they require charging instead.

This leads to a violation of LSP when we try to substitute an ElectricCar (e.g., TataEv) where a Vehicle is expected, but the refuel() method throws an exception.

```java
public class Problem {
  public static void main(String[] args) {

    Vehicle vehicle = new TataEv();
    vehicle.refuel(); // Runtime Exception

    refuelVehicle(new SwiftCar()); // Works fine
    refuelVehicle(new TataEv());  // Breaks at runtime
  }

  static void refuelVehicle(Vehicle vehicle) {
    vehicle.refuel();
  }
}

class Vehicle {
  public void drive() {
    System.out.println("Driving vehicle");
  }

  public void refuel() {
    System.out.println("Refueling vehicle");
  }
}

class SwiftCar extends Vehicle {
  @Override
  public void drive() {
    System.out.println("Driving swift car");
  }

  @Override
  public void refuel() {
    System.out.println("Refueling swift with Petrol");
  }
}

class TataEv extends Vehicle {
  @Override
  public void drive() {
    System.out.println("Driving Tata EV car");
  }

  @Override
  public void refuel() {
    throw new UnsupportedOperationException("Electric cars don't refuel!");
  }
}

```

### Violation Explained

- Even though TataEv is a subclass of Vehicle, it cannot perform the refuel() action safely.
- Substituting it in a context expecting a refuelable vehicle leads to a runtime exception.
- This breaks the expectation that subclasses should honor the contracts of their base class.


## Solution (Refactored Version - Applying LSP)

To adhere to LSP, we need to separate behaviors based on what each type of vehicle can actually do.

We will  

- Keep a common abstract Vehicle base class
- Use interfaces (Refuelable, Chargeable) to define specific behaviors


```java
public class Solution {
  public static void main(String[] args) {
    refuelVehicle(new SwiftCar());       // Works fine
    // refuelVehicle(new TataEv());     // Compile-time error: TataEv is not Refuelable

    chargeVehicle(new TataEv());         // Works fine
  }

  static void refuelVehicle(Refuelable vehicle) {
    vehicle.refuel();
  }

  static void chargeVehicle(Chargeable vehicle) {
    vehicle.charge();
  }
}

// Abstract base class for all vehicles
abstract class Vehicle {
  public abstract void drive();
}

// Interface for vehicles that can refuel
interface Refuelable {
  void refuel();
}

// Interface for vehicles that can charge
interface Chargeable {
  void charge();
}

class SwiftCar extends Vehicle implements Refuelable {
  @Override
  public void refuel() {
    System.out.println("Refueling swift with Petrol");
  }

  @Override
  public void drive() {
    System.out.println("Driving swift car");
  }
}

class TataEv extends Vehicle implements Chargeable {
  @Override
  public void charge() {
    System.out.println("Charging EV car");
  }

  @Override
  public void drive() {
    System.out.println("Driving Tata EV car");
  }
}

```

## Why This Refactor Works
- Vehicle still serves as the common abstraction, but only the relevant behavior interfaces are implemented.
- We’ve removed the incorrect assumption that all vehicles can refuel.
- Methods like refuelVehicle() and chargeVehicle() now only accept vehicles capable of the action, enforced at compile time.
                                                                                                                      

##  Key Benefits of Applying LSP                                                                          
- Eliminates Runtime Exceptions: Misuse of APIs is caught at compile-time.
- Ensures Behavioral Compatibility: Subclasses can truly substitute their parent classes where appropriate.
- Improves Design Clarity: Each class or interface represents specific, accurate behavior.
- Boosts Maintainability: New vehicle types can be added without fear of breaking existing logic.

## Conclusion

By applying the Liskov Substitution Principle, we avoid dangerous assumptions in our class hierarchy.  
Subclasses only expose the behavior they truly support, making them safely substitutable and more reliable in practice.

This leads to a cleaner, more robust design where each component fulfills its contract — no surprises, no exceptions.


# I – Interface Segregation Principle (ISP)

The Interface Segregation Principle states that no client should be forced to depend on methods it does not use.

Instead of creating large, all-encompassing interfaces, we should design smaller, more specific interfaces tailored to the needs of the clients.

This principle encourages building role-based abstractions that better reflect real-world behavior and reduce unnecessary implementation overhead.

## Problem (Violation of ISP)

Imagine a system that models various types of vehicles.

We have a single Vehicle interface that includes methods for driving, flying, and sailing. However, most vehicles don't support all these capabilities. For example, a Car can't fly or sail, but it is still forced to implement these methods.


```java
/**
 * Problem: A large Vehicle interface forces all implementers to define behaviors they may not support.
 */

interface Vehicle {
  void start();
  void stop();
  void fly();   // Not all vehicles can fly
  void sail();  // Not all vehicles can sail
}

class Car implements Vehicle {
  @Override
  public void start() {
    System.out.println("Car started.");
  }

  @Override
  public void stop() {
    System.out.println("Car stopped.");
  }

  @Override
  public void fly() {
    throw new UnsupportedOperationException("Cars can't fly");
  }

  @Override
  public void sail() {
    throw new UnsupportedOperationException("Cars can't sail");
  }
}

```

## Violation Explained
- The Car class is forced to implement methods it will never use (fly() and sail()).
- This leads to bloated, misleading, and fragile code, as future developers may misuse these unimplemented methods.
- Violates ISP by tightly coupling classes to unnecessary functionality.


## Solution (Refactored Version - Applying ISP)

To follow the Interface Segregation Principle, we break down the large Vehicle interface into smaller, role-based interfaces, such as Drivable, Flyable, and Sailable.

Each class can now implement only the interfaces relevant to its behavior.
 
```java
/**
 * Refactored: Interfaces are split based on capability.
 */

// Basic driving behavior
interface Drivable {
  void start();
  void stop();
}

// Behavior for flying vehicles
interface Flyable {
  void fly();
}

// Behavior for watercraft
interface Sailable {
  void sail();
}

// Car only drives
class Car implements Drivable {
  @Override
  public void start() {
    System.out.println("Car started.");
  }

  @Override
  public void stop() {
    System.out.println("Car stopped.");
  }
}

// Airplane drives and flies
class Airplane implements Drivable, Flyable {
  @Override
  public void start() {
    System.out.println("Airplane started.");
  }

  @Override
  public void stop() {
    System.out.println("Airplane stopped.");
  }

  @Override
  public void fly() {
    System.out.println("Airplane flying.");
  }
}

// Boat drives and sails
class Boat implements Drivable, Sailable {
  @Override
  public void start() {
    System.out.println("Boat started.");
  }

  @Override
  public void stop() {
    System.out.println("Boat stopped.");
  }

  @Override
  public void sail() {
    System.out.println("Boat sailing.");
  }
}

```

## Why This Refactor Works
- Each class implements only the behavior it needs, avoiding unneeded method implementations.
- The system is easier to understand and maintain, with clear separation of responsibilities.
- Changes to one capability (e.g., sailing logic) don’t impact unrelated vehicle types.

## Key Benefits of Applying ISP
- Cleaner Interfaces: Clients only see methods they actually use.
- Improved Maintainability: Adding new behaviors doesn't bloat existing interfaces.
- Better Scalability: New vehicle types can mix and match capabilities without side effects.
- Encourages Composition Over Inheritance: You can assemble classes from small, focused interfaces.


## Conclusion

By applying the Interface Segregation Principle, we avoid the pitfalls of large, general-purpose interfaces and promote a more modular, flexible design.

Each class focuses on what it can actually do, leading to more accurate models, safer code, and better developer experience.



# LSP vs ISP – Key Differences at a Glance

| **Aspect**             | **Liskov Substitution Principle (LSP)**                                          | **Interface Segregation Principle (ISP)**                                           |
|------------------------|----------------------------------------------------------------------------------|-------------------------------------------------------------------------------------|
| **Main Concern**       | Behavioral correctness when using inheritance                                   | Design clarity and relevance of interfaces                                          |
| **Problem It Solves**  | Ensures subclasses don’t break expectations of the parent class                 | Prevents classes from being forced to implement irrelevant methods                 |
| **Core Idea**          | A subclass should be substitutable for its parent without breaking the program  | Clients should only depend on what they actually use                               |
| **Violation Example**  | A subclass throws an exception for a method it inherited but doesn’t support (e.g., `TataEv` trying to `refuel()`) | A class has to implement empty or invalid methods because an interface is too broad (e.g., `Car` implementing `fly()` and `sail()`) |
| **How to Fix**         | Adjust the class hierarchy or extract interfaces to ensure only valid behaviors are inherited | Break large interfaces into smaller, more focused interfaces based on roles/capabilities |
| **Perspective**        | Subclass to superclass relationship (inheritance/substitutability)              | Interface to implementer relationship (client-specific interfaces)                 |
| **Goal**               | Correctness and reliability when using polymorphism                             | Decoupling and simplicity through focused interfaces                                |


## Summary

- **LSP** : "A subclass should behave like its superclass."
  - "If it walks like a duck and quacks like a duck… it better actually be a duck." In other words, don’t let subclasses lie about what they can do.
- **ISP** : "Don’t force me to implement what I don’t need."
  - "Don’t give me a remote with 50 buttons when I only need 2." Clients should get only the functionality they need, nothing more.


# D – Dependency Inversion Principle (DIP)

The Dependency Inversion Principle states that:

High-level modules should not depend on low-level modules. Both should depend on abstractions.  
Abstractions should not depend on details. Details should depend on abstractions.

This principle promotes loosely coupled code by introducing abstractions (typically interfaces) between high-level logic and low-level implementations.

## Problem (Violation of DIP)

In this example, the UserService class is tightly coupled to the Database class.

This makes it hard to:
- Swap out the database (e.g., for a mock during testing).
- Extend or modify the data access layer without changing the business logic.

```java
/**
 * Problem: Tight coupling between high-level module (UserService)
 * and low-level module (Database).
 */

class Database {
  public String getUserData() {
    return "User data from database.";
  }
}

class UserService {
  private Database database;

  public UserService() {
    this.database = new Database(); // Direct dependency
  }

  public String getUser() {
    return database.getUserData();
  }
}

```

## Why This Violates DIP

- UserService is a high-level module (business logic).
- Database is a low-level module (data access logic).
- The high-level module directly depends on the low-level one.
- There's no abstraction between them, making changes fragile and testing harder.


##  Solution (Refactored Version - Applying DIP)

To follow DIP, we introduce a UserRepository interface and have both Database and MockUserRepository implement it.

UserService now depends only on this interface — not on a specific implementation.

```java
/**
 * Refactored: High-level module (UserService) depends on abstraction (UserRepository),
 * not on a concrete database implementation.
 */

interface UserRepository {
  String getUserData();
}

class Database implements UserRepository {
  @Override
  public String getUserData() {
    return "User data from Database.";
  }
}

class MockUserRepository implements UserRepository {
  @Override
  public String getUserData() {
    return "Mock user data.";
  }
}

class UserService {
  private UserRepository userRepository;

  // Constructor injection
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public String getUser() {
    return this.userRepository.getUserData();
  }

  // Optional setter to allow swapping implementations at runtime
  public void setUserRepository(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
}

```

## Why This Refactor Works
- UserService is now decoupled from any specific database implementation.
- You can easily switch between different implementations (e.g., real DB, mock, file-based).
- Supports unit testing by injecting test doubles.
- Follows DIP by making both high- and low-level modules depend on abstractions.


## Key Benefits of Applying DIP
- Flexible Architecture: Easily switch or extend low-level modules without affecting business logic.
- Improved Testability: Swap real implementations with mocks/stubs for testing.
- Decoupling: High-level policies are not bound to low-level details.
- Better Maintenance: Changes are isolated and less risky.

## Conclusion

The Dependency Inversion Principle helps achieve loose coupling by shifting dependencies to abstractions, not concrete classes.

By depending on interfaces, your system becomes more adaptable, testable, and resilient to change.






# When *Not* to Apply SOLID Principles (Tradeoffs & Real-World Considerations)

Design principles are guidelines, not strict rules. Overapplying the SOLID principles can lead to **unnecessary complexity**, **overengineering**, and **slow development**, especially in the early stages of a project or in small applications.

---

##  S – Single Responsibility Principle (SRP)

> **"A class should have only one reason to change."**

### When to Apply:
- When a class is handling unrelated concerns (e.g., business logic, database access, and UI).
- In growing systems with multiple developers or domains.

### Tradeoffs / When *Not* to Overuse:
- Over-splitting can lead to **too many small, fragmented classes**.
- Can increase **cognitive overhead** and reduce readability in small or simple projects.
- Not always worth it for **scripts, prototypes, or simple CRUD apps**.

---

##  O – Open/Closed Principle (OCP)

> **"Software entities should be open for extension, but closed for modification."**

###  When to Apply:
- When the application is expected to undergo **frequent enhancements** or feature additions.
- In plugin-style systems or where new rules/types are added regularly.

###  Tradeoffs / When *Not* to Overuse:
- **Premature abstraction** can hurt more than help.
- May lead to **deep inheritance hierarchies** or **too many interfaces**.
- Don’t apply OCP to parts of the code that are unlikely to change — **YAGNI (You Aren’t Gonna Need It)**.

---

##  L – Liskov Substitution Principle (LSP)

> **"Subtypes must be substitutable for their base types."**

###  When to Apply:
- When building polymorphic systems where substituting subclasses is expected.
- To ensure behavioral consistency across an inheritance hierarchy.

###  Tradeoffs / When *Not* to Overuse:
- Forcing substitutability may result in **awkward or broken hierarchies**.
- Sometimes it's better to use **composition** instead of inheritance.
- Can lead to **overengineered solutions** in simple codebases.

---

##  I – Interface Segregation Principle (ISP)

> **"Clients should not be forced to depend on methods they do not use."**

###  When to Apply:
- When a single interface starts growing too large or unrelated.
- When multiple clients use **different subsets** of the interface.

###  Tradeoffs / When *Not* to Overuse:
- Too many tiny interfaces can lead to **interface bloat** and **fragmentation**.
- Adds boilerplate and **increases mental effort** for new developers.
- Over-segmentation can make **refactoring or adding new features harder**.

---

##  D – Dependency Inversion Principle (DIP)

> **"Depend on abstractions, not concretions."**

### When to Apply:
- When you want to decouple high-level business logic from low-level implementations.
- In large, testable systems that need **mocking or swapping implementations**.

###  Tradeoffs / When *Not* to Overuse:
- Too many interfaces can lead to **"interface hell"** and verbose code.
- Adds **setup complexity** (e.g., factories, dependency injection frameworks).
- Not needed for **simple, linear apps or prototypes**.

---

##  Final Thoughts

- SOLID principles are meant to **guide maintainable design**, not to be blindly enforced.
- Apply them **progressively** — refactor toward SOLID as the codebase grows.
- Remember: **Overengineering is just as harmful as underengineering**.













