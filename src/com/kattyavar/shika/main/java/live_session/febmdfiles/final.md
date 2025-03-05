# Understanding `final` in Java

In Java, the keyword `final` can be used in several contexts to define constants, prevent method overriding, or prevent inheritance. Here's an explanation of how `final` works in different situations:

## 1. `final` with Member Variables

When `final` is used with a member variable, it indicates that the variable's value cannot be changed after it is initialized. This is commonly used to define constants.

### Example:

```java
public class Example {
    final int MAX_VALUE = 100;  // Constant, can't be modified
    
    public void changeValue() {
        // MAX_VALUE = 200; // This will give an error because MAX_VALUE is final
    }
}
```

MAX_VALUE is a constant that can only be assigned a value once. Any attempt to modify it later will result in a compile-time error.


- You can initialize a final variable using a constructor, which allows you to assign a value only once when an object is created.

```java
public class Example {
    final int MAX_VALUE;  // Final variable, must be initialized either here or in the constructor

    // Constructor to initialize MAX_VALUE
    public Example(int value) {
        this.MAX_VALUE = value; // Allowed since it's being initialized for the first time
    }

    public void changeValue() {
        // MAX_VALUE = 200; // This will still give an error, as final variables can't be reassigned
    }

    public static void main(String[] args) {
        Example obj1 = new Example(100);
        Example obj2 = new Example(200); // Different objects can have different final values
        System.out.println(obj1.MAX_VALUE); // Output: 100
        System.out.println(obj2.MAX_VALUE); // Output: 200
    }
}

```


- You can also use an instance initialization block ({}) to initialize a final variable. Here's how it works:

```java
public class Example {
    final int MAX_VALUE;  // Final variable, not initialized yet

    // Initialization block
    {
        MAX_VALUE = 100;  // Allowed, as final variables can be initialized once
    }

    public void changeValue() {
        // MAX_VALUE = 200; // Error! Final variables cannot be reassigned
    }

    public static void main(String[] args) {
        Example obj = new Example();
        System.out.println(obj.MAX_VALUE); // Output: 100
    }
}

```

## 2. `final` with Method Parameters

When final is used with method parameters, it ensures that the value of the parameter cannot be changed within the method.

```java
public class Example {
    public void printValue(final int value) {
        // value = 10; // This will give an error because value is final
        System.out.println(value);
    }
}

```

## 3. `final` at Method Level

When final is used in a method, it prevents the method from being overridden by subclasses.  
This is useful when you want to ensure that a specific method implementation cannot be changed.

```java
public class Example {
    public final void printMessage() {
        System.out.println("This message cannot be overridden.");
    }
}

class SubExample extends Example {
    // public void printMessage() {} // This will give an error because printMessage is final
}

```

- The method printMessage() is marked as final, so it cannot be overridden by any subclass.

## 4. `final` at  Class Level

When final is used with a class, it prevents the class from being subclassed.  
This is useful when you want to ensure that the class cannot be extended.


```java
public final class Example {
    // Class code here
}

// class SubExample extends Example {} // This will give an error because Example is final

```
The class Example is marked as final, meaning no class can extend it.

## Summary 
- final with member variables: The value cannot be modified after initialization (constant).
- final with method parameters: The parameter value cannot be modified within the method.
- final with methods: The method cannot be overridden by subclasses.
- final with classes: The class cannot be subclassed.


## Final vs Static: Key Differences and Complementary Use Cases

### **Key Differences**

| Feature       | `final` | `static` |
|--------------|---------|----------|
| **Definition** | Used to declare constants or prevent modifications | Belongs to the class rather than instances |
| **Usage with Variables** | Prevents reassignment after initialization | Shared among all instances of a class |
| **Usage with Methods** | Prevents method overriding | Allows calling a method without an instance |
| **Usage with Classes** | Prevents inheritance (final class) | Not applicable to classes |
| **Memory Allocation** | Separate copy for each object | Single copy shared across all objects |

### **Complementary Use Cases**

- `static final` is commonly used for constants (e.g., `static final int MAX_VALUE = 100;`).
- `final` can be used to enforce immutability, while `static` can be used for shared resources.
- When defining utility methods, `static` is useful, while `final` prevents modification of logic in subclasses.

