# Packages and Access Modifiers

In Java, Packages and Access Modifiers are essential features that help in organizing code and controlling the visibility and accessibility of classes, methods, and variables.


# 1. Packages in Java

A package in Java is a way to group related classes, interfaces, and sub-packages together.  
It helps to organize code in a modular fashion, preventing naming conflicts and making code easier to manage and maintain.

## Types of Packages:
- **Built-in Packages**: Java provides several built-in packages like java.util, java.io, java.lang, etc., which contain common utility classes.
- **User-defined Packages**: You can create your own custom packages to group related classes together.


Creating a Package:

To define a package, the package keyword is used at the beginning of a Java file.  
The package declaration should always be the first statement in the Java file (before importing other packages or defining the class).

```java
package com.mycompany;

public class MyClass {
    public void display() {
        System.out.println("Hello from MyClass!");
    }
}

```

Using a Package:

To use a class from another package, the import keyword is used.

```java
import com.mycompany.MyClass;

public class Test {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.display();
    }
}

```

Note: If both classes are in the same package, you don't need to import anything.


# 2. Access Modifiers in Java

Access modifiers in Java are used to specify the visibility and accessibility of classes, methods, constructors, and variables.  
They control how and where the members of a class can be accessed from other classes.

Java provides the following access modifiers:

## 1. `public` Access Modifier
- **Visibility**: The member is accessible from any other class, inside or outside the package.
- **Use case**: When you want the class or method to be accessible globally.

```java
public class MyClass {
    public int data = 100; // Accessible from anywhere
}

```  

## 2. `private` Access Modifier
- **Visibility**: The member is only accessible within the same class. It is not visible to other classes or even subclasses.
- **Use case**: When you want to restrict access to certain members of the class.
 
```java
class MyClass {
    private int data = 100; // Not accessible outside this class

    public void display() {
        System.out.println(data); // Accessible within the same class
    }
}

```

## 3. `protected` Access Modifier
- **Visibility**: The member is accessible within the same package and by subclasses (even if they are in different packages).
- **Use case**: When you want the member to be available to subclasses but not accessible globally.
 
```java
class Parent {
    protected int data = 100; // Accessible within the package and by subclasses
}

class Child extends Parent {
    public void display() {
        System.out.println(data); // Accessible in the subclass
    }
}

```

## 4. Default (Package-Private) Access Modifier
- **Visibility**: If no access modifier is specified, the member is accessible only within the same package (this is also called package-private).
- **Use case**: When you want the member to be available to other classes in the same package but not outside.
  

```java
class MyClass {
    int data = 100; // No modifier means package-private

    public void display() {
        System.out.println(data); // Accessible within the same package
    }
}

```

### Access Modifiers Comparison

Here’s a quick comparison of how the access modifiers differ in terms of visibility:

| Access Modifier | Same Class | Same Package | Subclasses (Different Package) | Outside the Package | Anywhere |
|-----------------|------------|--------------|--------------------------------|---------------------|----------|
| **public**      | Yes        | Yes          | Yes                            | Yes                 | Yes      |
| **protected**   | Yes        | Yes          | Yes                            | No                  | No       |
| **Default**     | Yes        | Yes          | No                             | No                  | No       |
| **private**     | Yes        | No           | No                             | No                  | No       |



Examples:

Example 1: Public Access Modifier
 
```java
public class MyClass {
    public int data = 10;

    public void showData() {
        System.out.println("Data: " + data);
    }
}

public class Test {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.showData(); // Accessible everywhere
    }
}

```

Example 2: Private Access Modifier


```java
class MyClass {
    private int data = 10;

    private void showData() {
        System.out.println("Data: " + data);
    }

    public void accessPrivateMethod() {
        showData(); // Can access private method within the same class
    }
}

public class Test {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.accessPrivateMethod(); // Works fine
        // obj.showData(); // Error: showData() has private access in MyClass
    }
}

```

Example 3: Protected Access Modifier

```java
class Parent {
    protected int data = 10;
}

class Child extends Parent {
    public void showData() {
        System.out.println("Data from Parent: " + data); // Can access protected member in subclass
    }
}

public class Test {
    public static void main(String[] args) {
        Child obj = new Child();
        obj.showData(); // Accessible in subclass
    }
}

```

Example 4: Default Access Modifier

```java
class MyClass {
    int data = 10; // Default (package-private)

    void showData() {
        System.out.println("Data: " + data); // Accessible within the same package
    }
}

public class Test {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.showData(); // Accessible within the same package
    }
}

```

Summary: 
- Packages: Help organize your classes and avoid name conflicts. They can be either built-in (like java.util) or user-defined.
- Access Modifiers: Control the visibility of class members (fields, methods) and how they can be accessed.
  - public: Accessible everywhere.
  - private: Accessible only within the same class.
  - protected: Accessible within the same package and subclasses.
  - Default (package-private): Accessible only within the same package.


These concepts help in managing the complexity of code and ensuring proper encapsulation and modularization.






