# 🔒 Sealed Classes in Java

We have a PaymentMethod base type and we want to allow only certain types:
- Credit Card
- PayPal
- Bank Transfer

Note: You don’t want developers to create unauthorized types like BitcoinPayment unless explicitly allowed.

Example: 

```java
public interface PaymentMethod {
    String getDetails();
}

```

Then, you'd define known types:

```java
public class CreditCard implements PaymentMethod { ... }
public class PayPal implements PaymentMethod { ... }
public class BankTransfer implements PaymentMethod { ... }

```

The Problem:

Nothing stops someone from doing this later:

```java
public class BitcoinPayment implements PaymentMethod {
    @Override
    public String getDetails() {
        return "Bitcoin Address: abc123";
    }
}

```

And now your system accepts something you never intended. You lose control over your domain model.

Even worse, if you're using instanceof or switch, you'll need to remember to manually handle BitcoinPayment—or risk missing a case. This breaks safety and maintainability.


# Definition 

Sealed classes are a feature introduced in **Java 15 (preview)** and **fully released in Java 17**.   
They allow you to **control which classes or interfaces can extend or implement another class or interface**.

In Short

“Hey Java, I want to limit who can be my subclasses.”

## Syntax

```java
public sealed class Shape permits Circle, Rectangle, Square {
    // common logic
}
```
- The keyword sealed is used on the base class.
- You must declare which classes are allowed to extend it using the permits clause.
- Those subclasses must be in the same package or module.



# What Can Subclasses Be?

The permitted subclasses must be one of the following:

| Keyword    | Meaning                                 |
|------------|-----------------------------------------|
| `final`    | Can't be extended further               |
| `sealed`   | Can restrict its own subclasses         |
| `non-sealed` | Open for extension (removes sealing) |

Example: 

```java
public sealed class Shape permits Circle, Rectangle {}

public final class Circle extends Shape {
    // cannot be extended further
}

public sealed class Rectangle extends Shape permits Square {
    // can be extended only by Square
}

public non-sealed class Square extends Rectangle {
    // can be extended by anyone
}

```

# Why Use Sealed Classes?

- Benefits
  - Controlled inheritance — You decide exactly who can extend your class.
  - Better modeling — Helps represent fixed sets of types (like enums but more powerful).
  - Exhaustiveness checks — Useful with switch expressions (especially with pattern matching).
  - Safer and cleaner code — Avoid unexpected or insecure extensions.

# Real-world Analogy:

Imagine a university course.

```java
public sealed class Course permits MathCourse, ScienceCourse {}

```

Only MathCourse and ScienceCourse can be official subclasses of Course. No one else can sneak in a FakeCourse.

# Sealed + Switch Example (Pattern Matching)

If you're using Java 21+, you can combine sealed classes with pattern matching for switch:

```java
sealed interface Shape permits Circle, Square {}

record Circle(double radius) implements Shape {}
record Square(double side) implements Shape {}

public static double area(Shape shape) {
    return switch (shape) {
        case Circle c -> Math.PI * c.radius() * c.radius();
        case Square s -> s.side() * s.side();
    };
}

```
Because Shape is sealed, the compiler knows all possible types and ensures the switch is exhaustive.

# Sealed Classes vs Other Tools

| Feature                  | Sealed Class | Abstract Class | Interface | Enum |
|--------------------------|--------------|----------------|-----------|------|
| Limits who can extend    | ✅           | ❌             | ❌        | ✅   |
| Can have fields/methods  | ✅           | ✅             | ✅        | ✅   |
| Works with records       | ✅           | ✅             | ✅        | ❌   |
| Pattern matching support | ✅           | ✅             | ✅        | ✅   |
| Exhaustiveness check     | ✅           | ❌             | ❌        | ✅   |


# Requirements
- Java 17+ for production use.
- All permitted classes must be in the same package or module.


# Sealed Interfaces in Java

Just like sealed classes, sealed interfaces allow you to control which types are allowed to implement an interface.

# Why Use Sealed Interfaces?
- Prevent unauthorized implementations of your interface.
- Combine nicely with records to model immutable, fixed sets of types.
- Enable exhaustiveness checks with switch + pattern matching (Java 21+).
- Safer alternative to open-ended polymorphism.

Syntax 

```java
public sealed interface PaymentMethod permits CreditCard, PayPal, BankTransfer {
    String getDetails();
}

```

- Use the sealed keyword on the interface.
- The permits clause lists all allowed implementors.
- Those classes must be in the same package or module.

# Example with Records. 

```java
sealed interface Shape permits Circle, Square {}

record Circle(double radius) implements Shape {}

record Square(double side) implements Shape {}

```


This is powerful when used with pattern matching:

```java
public static double area(Shape shape) {
    return switch (shape) {
        case Circle c -> Math.PI * c.radius() * c.radius();
        case Square s -> s.side() * s.side();
    };
}

```

- No default case needed — the compiler knows all possible types!
- This is one of the key benefits of sealing interfaces: it allows the compiler to help you reason about all cases.


# Can a Sealed Interface Be Extended by Another Interface?

Yes — as long as the extending interface is listed in the permits clause.

```java
public sealed interface Animal permits Pet {}

public sealed interface Pet extends Animal permits Dog, Cat {}

public final class Dog implements Pet {}
public final class Cat implements Pet {}

```


