# Override

## Quick Summary of Key Overriding Rules:

- **Method Overriding**: Allows a subclass to provide a specific implementation of a method already defined in its superclass. It is based on the method's signature, not the variables.
- **Method Signature**: Must match in name and parameters.
- **Return Type**: Must be the same or covariant.
- **Access Modifiers**: The overriding method must have the same or more permissive access.
- **Exception Handling**: The overriding method cannot throw more checked exceptions.
- **Static Methods**: Static methods are hidden, not overridden.
- **Final Methods**: Cannot be overridden.
- **Abstract Methods**: Must be implemented in the subclass (unless the subclass is abstract).
- **Constructors**: Cannot be overridden, but can be invoked using `super()`.


## Rules for Access Modifier Compatibility in Method Overriding


| Original Modifier             | Can Be Overridden As         |
|-------------------------------|------------------------------|
| **public**                     | public                       |
| **protected**                  | protected, public            |
| **default (package-private)**  | default, protected, public   |
| **private**                    | Cannot be overridden         |


# Overloading

## Summary of Key Overloading Rules:

| **Overloading Rule**        | **Explanation**                                                                 |
|-----------------------------|---------------------------------------------------------------------------------|
| **Method Name**              | The method name must be the same.                                                |
| **Parameter List**           | The parameter list must differ by number, type, or order of parameters.         |
| **Return Type**              | The return type cannot be used to distinguish overloaded methods.                |
| **Access Modifiers**         | Methods can have different access modifiers (e.g., public, private), but this does not affect overloading. |
| **Varargs**                  | Varargs can be used to accept variable-length arguments but must be the last parameter. |
| **Number of Parameters**     | Methods can be overloaded based on the number of parameters.                    |
| **Data Type**                | Methods can be overloaded by the type of parameters (e.g., int vs double).     |
| **Type Promotion**           | Java allows type promotion (e.g., int to double) for method resolution.         |
| **Constructor Overloading**  | Constructors can be overloaded similarly to methods.                            |


# Interface

## The Need for Interfaces in Java
- **Multiple Inheritance of Behavior**:  In Java, a class can only inherit from one other class (single inheritance). However, sometimes, we want a class to inherit behavior from multiple sources. Abstract classes allow for some inheritance, but they still restrict the class to only one parent class. Interfaces solve this problem by allowing a class to implement multiple interfaces, providing a form of multiple inheritance.
  - Abstract Class: A class can only extend one abstract class
  - Interface: A class can implement multiple interfaces.

This is particularly useful in situations where you want to add different sets of functionality to a class without the constraint of a single parent class.

- **Decoupling**: Interfaces help achieve loose coupling. By defining a contract in the form of an interface, the classes implementing the interface don't need to know the specific implementation details of the other classes. This allows for flexibility in changing or extending the implementation while maintaining the interface.
  - With interfaces, you can define a behavior (like Runnable, Serializable, etc.), but the actual implementation of that behavior can vary across different classes. This allows the code to be more modular and easier to maintain.

- **Polymorphism**: Interfaces are crucial for achieving polymorphism. Since classes can implement multiple interfaces, you can reference different classes using the interface type, making the code more flexible. You can treat any object that implements a given interface the same way, regardless of the class it's from.

- **Separation of Contract and Implementation:**:  An interface provides a way to define what a class should do, without specifying how it does it. This is the key difference between abstract classes and interfaces. An abstract class can provide some concrete methods, but an interface only provides the method signatures (before Java 8). This allows the interface to focus purely on the contract, and each implementing class decides how to implement that contract.

- **Functional Interfaces and Lambda Expressions:**  With Java 8, interfaces became even more important with the introduction of functional programming features like lambda expressions and streams. Functional interfaces (interfaces with a single abstract method) are used to represent behavior as data, allowing for cleaner and more concise code with lambdas.

## What is the Diamond Problem?

The diamond problem occurs when a class inherits from two interfaces that define the same method, but with different implementations. 
This creates ambiguity: when the class tries to call the method, which version of the method should it use? This problem is called the "diamond problem" because of the shape of the inheritance hierarchy, which can be visualized as a diamond.

### Diamond Problem in Java with Default Methods

```java
interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}

interface B {
    default void hello() {
        System.out.println("Hello from B");
    }
}

class C implements A, B {
    // Overriding the method to resolve ambiguity
    @Override
    public void hello() {
        // Decide which version of the hello() method to use
        A.super.hello(); // Calling hello() from interface A
        // or
        // B.super.hello(); // Calling hello() from interface B
      //Or you can give your own version...
    }
}

public class Main {
    public static void main(String[] args) {
        C c = new C();
        c.hello();
    }
}

```

## Example Before Java 8:

```java
interface A {
    void hello();
}

interface B {
    void hello();
}

class C implements A, B {
    // The class C must provide its own implementation
    @Override
    public void hello() {
        System.out.println("Hello from C");
    }
}

```

- Before Java 8, interfaces could only declare method signatures (abstract methods), so there was no concept of default implementations.
- As a result, no diamond problem existed because there were no conflicts between method implementations from multiple interfaces.
- The diamond problem only arises after Java 8, when interfaces were allowed to have default methods, which can provide concrete implementations.

