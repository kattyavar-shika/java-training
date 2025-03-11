# Wrapper Classes in Java

In Java, Wrapper classes are used to convert primitive data types into objects.  
These classes are part of the java.lang package, and each primitive data type (e.g., int, char, float, etc.) has a corresponding wrapper class.  
Wrapper classes provide utility methods and allow primitive types to be treated as objects.


## List of Primitive Types and Their Corresponding Wrapper Classes:

### List of Primitive Types and Their Corresponding Wrapper Classes

| Primitive Type | Wrapper Class |
|----------------|---------------|
| byte           | Byte          |
| short          | Short         |
| int            | Integer       |
| long           | Long          |
| float          | Float         |
| double         | Double        |
| char           | Character     |
| boolean        | Boolean       |




## Definition:

Wrapper classes are designed to "wrap" a primitive data type inside an object.  
This is especially useful in cases where an object is required, such as when working with collections (e.g., ArrayList), because collections in Java can only store objects, not primitive types.

## Why Use Wrapper Classes?
- Object-Oriented Operations: Primitive types can't be used in situations where objects are required, like storing in data structures such as ArrayList, HashMap, etc.  
Wrapper classes allow primitives to behave like objects.
- Utility Methods: Wrapper classes provide methods for converting between types and performing other useful operations. For example:
  - Integer.parseInt(): Converts a String to an int.
  - Double.valueOf(): Converts a String to a Double.

- **Autoboxing and Unboxing**: Java provides automatic conversion between primitive types and their corresponding wrapper classes:
  - **Autoboxing**: Automatic conversion of primitive to wrapper class (e.g., int to Integer).
  - **Unboxing**: Automatic conversion of wrapper class to primitive (e.g., Integer to int).


Let’s go through a couple of examples to demonstrate how wrapper classes work in Java.

1. Autoboxing and Unboxing Example:

```java
 public class WrapperExample {
  public static void main(String[] args) {
    // Autoboxing: Converting primitive to wrapper class
    int num1 = 10;
    Integer integerNum = num1;  // Autoboxing (int to Integer)

    // Unboxing: Converting wrapper class to primitive
    Integer num2 = Integer.valueOf(20);  // Using valueOf instead of new Integer()
    int num3 = num2;  // Unboxing (Integer to int)

    System.out.println("Autoboxed Integer: " + integerNum);
    System.out.println("Unboxed int: " + num3);
  }
}


```

2. Wrapper Classes in Collections:

Since collections only accept objects and not primitive types, wrapper classes allow you to store primitive values in collections like ArrayList, HashMap, etc.

```java
import java.util.ArrayList;

public class WrapperInCollections {
    public static void main(String[] args) {
        // Using wrapper class Integer in ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);  // Autoboxing happens here (int -> Integer)
        list.add(20);
        list.add(30);

        // Iterating through the list
        for (Integer num : list) {
            System.out.println(num);  // Unboxing happens when accessing values (Integer -> int)
        }
    }
}

```

3. Using Wrapper Class Methods:

Wrapper classes provide various utility methods that can be used for type conversion, parsing, and comparison. For instance:


```java
public class WrapperMethodsExample {
    public static void main(String[] args) {
        // Using Integer class to parse a string to int
        String str = "123";
        int num = Integer.parseInt(str); // Converts String "123" to int

        // Using Double class to parse a string to double
        String str2 = "45.67";
        double d = Double.parseDouble(str2); // Converts String "45.67" to double
        
        System.out.println("Parsed int: " + num);
        System.out.println("Parsed double: " + d);
        
        // Using static constants of wrapper classes
        System.out.println("Maximum value of Integer: " + Integer.MAX_VALUE);
        System.out.println("Minimum value of Integer: " + Integer.MIN_VALUE);
    }
}

```








