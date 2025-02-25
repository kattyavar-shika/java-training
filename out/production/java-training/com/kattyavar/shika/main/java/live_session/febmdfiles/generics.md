# Generics?

Generics in Java is a feature that allows you to write classes, interfaces, and methods with a type parameter.  
The primary goal of generics is to provide type safety while allowing you to write more flexible and reusable code.

## What Are Generics?

Generics enable you to create classes, methods, and interfaces that work with any data type.  
You can define a generic type placeholder `(e.g., <T>, <E>, <K, V>)` and specify that type later when you create an
object or call a method.

Instead of writing separate classes for different data types (like IntegerList, StringList, etc.), you can write one
generic class that works with any type of object.

## Why Use Generics?

- Type Safety: With generics, you can specify the type of objects that a class or method can work with, which reduces
  the risk of ClassCastException.
- Code Reusability: You can write a generic class or method that works with many types of objects, which makes your code
  more flexible and reusable.
- Compile-Time Checking: The Java compiler can check type consistency during compilation, preventing many runtime
  errors.

## Basic Syntax of Generics

`In Java, you define generics with angle brackets (<>), followed by the type parameter(s).`

```java
// Generic class with a type parameter T
class Box<T> {
  private T value;

  public void setValue(T value) {
    this.value = value;
  }

  public T getValue() {
    return value;
  }
}

```

You can use this class with any type:

```java
Box<Integer> intBox = new Box<>();
intBox.

setValue(10);
System.out.

println(intBox.getValue()); // 10

Box<String> strBox = new Box<>();
strBox.

setValue("Hello");
System.out.

println(strBox.getValue()); // Hello

```

## Bounded Type Parameters

Sometimes, you might want to limit the types that can be used in a generic class or method.  
This is done with bounded type parameters.

**Upper Bound:** Restrict the type to be a subclass of a particular class (or implement an interface).

```java
// Only numbers (and their subclasses) are allowed
class NumberBox<T extends Number> {
  private T value;

  public void setValue(T value) {
    this.value = value;
  }

  public T getValue() {
    return value;
  }
}

```

Here, T can only be a subclass of Number, so it can be Integer, Double, etc., but not a String.

## Generic Methods

You can also create generic methods that use type parameters.

```java
public <T> void printArray(T[] array) {
  for (T element : array) {
    System.out.println(element);
  }
}

```

You can call this method with different types of arrays:

```java
Integer[] intArray = {1, 2, 3};

printArray(intArray); // Output: 1 2 3

String[] strArray = {"A", "B", "C"};

printArray(strArray); // Output: A B C

```

## WildCards

- wildcards can actually be used in a few different places in Java, and they are not limited to just methods. Let’s
  break down the key areas where wildcards can be used:

### `1. Upper Bounded Wildcards (? extends T)`

- An upper-bounded wildcard is used when you want to restrict the type to a certain class or any subclass of that class.
  It allows you to pass types that are subtypes of the specified type.
  `Syntax: ? extends T`
- This means "any type that is a subclass of T (including T itself)."
- This is useful when you want to read from a structure (like a List) because you're working with objects of type T or
  its subtypes.

Example of Upper-Bounded Wildcard:

```java
public class UpperBoundedWildcard {
  // A method that accepts a Box of any subclass of Number
  public static void printBox(Box<? extends Number> box) {
    // We can safely retrieve the value as a Number
    Number value = box.getValue();
    System.out.println("Value: " + value);
  }

  public static void main(String[] args) {
    Box<Integer> integerBox = new Box<>(10);
    Box<Double> doubleBox = new Box<>(3.14);

    // Valid: Integer is a subclass of Number
    printBox(integerBox);

    // Valid: Double is a subclass of Number
    printBox(doubleBox);
  }
}

```

### `2. Lower Bounded Wildcards (? super T)`

- A lower-bounded wildcard is used when you want to allow types that are superclasses of a specific type. It’s useful
  when you want to write to a structure (like a List) and you want to be sure that the type is at least the specified
  type or one of its superclasses.
- `Syntax: ? super T`
    - This means "any type that is a superclass of T (including T itself)."
    - This is useful when you want to add elements to a structure, and you want to ensure the element is compatible with
      the type or any of its superclasses.

```java
public class LowerBoundedWildcard {
  // A method that accepts a Box of Integer or any supertype of Integer
  public static void addValue(Box<? super Integer> box) {
    // We can safely add an Integer to the box
    box.setValue(10);
  }

  public static void main(String[] args) {
    Box<Number> numberBox = new Box<>(20);
    Box<Object> objectBox = new Box<>(new Object());

    // Valid: Box<Number> can hold Integer (since Integer is a subclass of Number)
    addValue(numberBox);

    // Valid: Box<Object> can hold Integer (since Object is a superclass of Integer)
    addValue(objectBox);
  }
}

```

## Where wildCards can be used

### 1. Wildcards in Method Signatures

-
`Yes, wildcards (like ?, ? extends T, ? super T) are commonly used in method signatures to define flexible, type-safe method parameters. This is the most common place you'll see them.`

Example :

```java
class Box<T> {
  private T value;

  public Box(T value) {
    this.value = value;
  }

  public T getValue() {
    return value;
  }

  public class WildcardExample {

    // Method that accepts any Box with a wildcard (lower-bounded)
    public static void printBox(Box<? super Integer> box) {
      Object value = box.getValue();  // Return type is Object after type erasure
      System.out.println(value);
    }

    public static void main(String[] args) {
      Box<Number> numberBox = new Box<>(10);
      printBox(numberBox);  // Valid because Box<Number> can be assigned to Box<? super Integer>
    }
  }

```

### 2. Wildcards in Field Declarations

- Wildcards can also be used in fields. You might not see this as frequently as in methods, but it’s possible to declare
  a field of a generic type with a wildcard.

```java
public class WildcardInField {
  // Field using a wildcard type (lower-bounded)
  private Box<? super Integer> box;

  public WildcardInField(Box<? super Integer> box) {
    this.box = box;
  }

  public void setBox(Box<? super Integer> box) {
    this.box = box;
  }

  public Box<? super Integer> getBox() {
    return box;
  }

  public static void main(String[] args) {
    Box<Number> numberBox = new Box<>(20);
    WildcardInField field = new WildcardInField(numberBox);

    // Access and modify the field
    Box<? super Integer> box = field.getBox();
    System.out.println(box.getValue());
  }
}

```

- Here, we’re declaring a field box that can be any type of Box that holds a superclass of Integer, like Number or
  Object. The wildcard is used to provide flexibility in what type of Box can be assigned to this field.

### 3. Wildcards in Variable Declarations

You can also use wildcards in variables, allowing you to define variables that can hold different types of Box objects,
depending on the wildcard.

```java
public class WildcardInVariable {
  public static void main(String[] args) {
    // Variable with a wildcard (upper-bounded)
    Box<? extends Number> numberBox = new Box<>(10);
    System.out.println(numberBox.getValue());  // Works because Box<? extends Number> can hold any subclass of Number

    // Variable with a wildcard (lower-bounded)
    Box<? super Integer> integerBox = new Box<>(30);
    System.out.println(integerBox.getValue());  // Works, but only as an Object after type erasure
  }
}

```

### What Wildcards Cannot Be Used For

`Class or Interface Type Parameters: You cannot use wildcards like ? super Integer in the class declaration or interface declaration type parameters. Instead, you define a type parameter (e.g., T or E) and use wildcards in method signatures to define bounds.`

```java
// This is NOT valid
public class Box<? super Integer>{...}

```

Instead, you would write:

```java
public class Box<T> { ...
}

```

### Summary

- Wildcards can be used in method parameters, field declarations, and variable declarations.
- They cannot be used in class or interface type parameters.
- The most common use is in method signatures, where wildcards allow flexibility in the types of objects passed to the
  method.

## Limitations of Generics

- Cannot Use Primitive Types: Generics can only be used with objects, not with primitive types (like int, char, etc.).
  However, Java provides wrapper classes (like Integer, Double, etc.) for primitive types.
- Type Erasure: At runtime, generic type information is erased. This means you can’t directly instantiate a generic
  class with a type parameter (e.g., new T() is not allowed).

