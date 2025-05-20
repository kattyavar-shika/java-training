
# Variable Types in Java

- Java is a strongly-typed language, which means each variable must be explicitly declared with a type.
- The two main categories of types are **primitive types** and **reference types**.



## Primitive Data Types in Java

These types represent simple values. Java has 8 primitive data types:

1. **int**: Integer numbers (e.g., 5, -100, 0)
2. **boolean**: Represents a true or false value (e.g., true, false)
3. **char**: Single characters (e.g., 'a', '1', '$')
4. **byte**: 8-bit integer (range: -128 to 127)
5. **short**: 16-bit integer (range: -32,768 to 32,767)
6. **long**: 64-bit integer (e.g., 100000L)
7. **float**: Single-precision floating-point number (e.g., 3.14f)
8. **double**: Double-precision floating-point number (e.g., 3.14159)

```java
int age = 25;
boolean isStudent = true;
char grade = 'A';
double pi = 3.14159;
```


## Reference Data Types in Java

Reference types store references to objects. They include:

1. **Objects**: Instances of classes.
2. **Arrays**: Collections of similar types of elements.
3. **Strings**: A sequence of characters.


# Types of Variables:

Java has four main types of variables based on their scope and where they are declared:

- Instance Variables (Non-static fields):
  - Defined within a class, but outside any method, constructor, or block.
  - Each object (instance) of the class has its own copy of instance variables.
  - They are used to store the state of an object.

Example:
```java
public class Person {
    String name;  // instance variable
    int age;      // instance variable
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

```

- Class Variables (Static fields):
  - Declared with the static keyword.
  - Only one copy of the variable exists regardless of how many objects are created from the class.
  - Used for storing data that is shared among all instances of the class.

Example:
```java
public class Car {
    static int numberOfCars = 0;  // class variable (static)
    
    public Car() {
        numberOfCars++;
    }
}

```

- Local Variables:
  - Declared within a method, constructor, or block.
  - They only exist within the scope of that method or block.
  - Do not have default values. You must initialize them before use.

```java
public void greet(String name) {
    String greeting = "Hello, " + name;  // local variable
    System.out.println(greeting);
}

```

- Parameters
  - Variables that are passed to methods or constructors.
  - They act as local variables but are initialized with the passed arguments.

```java
public void setAge(int age) {
    this.age = age;  // 'age' is a parameter, which is also a local variable
}

```

# Variable Scope in Java

1. **Local Variables**: Only accessible within the method, constructor, or block in which they are declared.
2. **Instance Variables**: Accessible by any method, constructor, or block within the class, but each object gets its own copy.
3. **Class Variables (Static)**: Accessible from anywhere within the class, and shared among all instances of the class.
4. **Parameters**: Local to the method they are passed to.

# Constants

Java allows you to define constant variables using the final keyword. These variables cannot be changed once initialized.


```java
public class Constants {
    public static final double PI = 3.14159;  // Constant variable
}

```

Constants are often written in uppercase to distinguish them from regular variables.


# Variable Naming Rules in Java

1. **Can start with**: A letter (A-Z or a-z), dollar sign ($), or underscore (_).
2. **Cannot start with**: A digit (0-9).
3. **Can include**: Letters, digits, dollar sign ($), and underscores (_).
4. **Cannot use**: Java reserved keywords (like `int`, `for`, `class`, etc.).
5. **Case-sensitive**: `age` and `Age` are considered different variables.


# Literals in Java

| Type                  | Examples                         | Description                                                       |
|-----------------------|----------------------------------|-------------------------------------------------------------------|
| **Integer Literals**   | 123, 075, 0x7F, 0b1010          | Represent whole numbers in decimal, octal, hex, binary.          |
| **Floating-point Literals** | 3.14, 2.718f                 | Represent numbers with decimal points (default double, use f for float). |
| **Character Literals** | 'A', '1', '%', '\n'              | Represent a single character, can include escape sequences.       |
| **String Literals**    | "Hello", "Java"                  | Represent sequences of characters enclosed in double quotes.     |
| **Boolean Literals**   | true, false                      | Represent boolean values.                                        |
| **Null Literal**       | null                             | Represents the null reference, used with object variables.        |


# Arithmetic Operators in Java

In Java, arithmetic operations are used to perform mathematical calculations on numeric types (like `int`, `double`, `float`, `long`, etc.). Java provides a set of arithmetic operators that allow you to perform basic mathematical operations such as addition, subtraction, multiplication, division, and more.

## Arithmetic Operators in Java

Java supports the following arithmetic operators:

| Operator | Operation    | Example | Description                                       |
|----------|--------------|---------|---------------------------------------------------|
| `+`      | Addition     | `a + b` | Adds two numbers                                  |
| `-`      | Subtraction  | `a - b` | Subtracts one number from another                 |
| `*`      | Multiplication | `a * b` | Multiplies two numbers                             |
| `/`      | Division     | `a / b` | Divides one number by another                     |
| `%`      | Modulus      | `a % b` | Finds the remainder of a division (modulo)        |


# Summary of Logical Operators in Java

| Operator | Description                                | Example |
|----------|--------------------------------------------|---------|
| `&&`     | AND (both must be true)                   | `a && b` |
| ||     | OR (at least one must be true)            | a || b |
| `!`      | NOT (inverts the value)                   | `!a` |

## Explanation of Logical Operators:

- **AND (`&&`)**: Evaluates to `true` only when both operands are `true`.
- **OR (`||`)**: Evaluates to `true` if at least one operand is `true`.
- **NOT (`!`)**: Inverts the boolean value of the operand.
