# Enums in Java

An enum (short for enumeration) in Java is a special data type used to define a fixed set of constants.  
It is a class type that extends java.lang.Enum, and it provides type safety compared to traditional constant definitions (e.g., using static final variables).

Enums were introduced in Java 5 to provide a more structured way to represent a group of predefined constant values.

## Purpose of Enums in Java

Enums are used when a variable should be restricted to a predefined set of values.  
They enhance code readability, maintainability, and safety by ensuring that only valid values can be assigned.


How Enums Are Used in Java

### Defining an Enum

```java
public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}

```

### Using an Enum in a Program

```java
public class EnumExample {
    public static void main(String[] args) {
        Day today = Day.MONDAY;
        System.out.println("Today is: " + today);
    }
}

```

### Enum with Methods

Enums can have constructors, methods, and instance variables.

```java
public enum Status {
    SUCCESS(200), ERROR(500);

    private int code;

    Status(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

public class EnumTest {
    public static void main(String[] args) {
        Status s = Status.SUCCESS;
        System.out.println("Status: " + s + ", Code: " + s.getCode());
    }
}

```

Java enums can have abstract methods. If an enum contains an abstract method, each constant in the enum must provide its own implementation of that method.  
This is useful when different enum constants require different behaviors.

Example of an Enum with an Abstract Method

```java
public enum Operation {
    ADD {
        @Override
        public int execute(int a, int b) {
            return a + b;
        }
    },
    SUBTRACT {
        @Override
        public int execute(int a, int b) {
            return a - b;
        }
    },
    MULTIPLY {
        @Override
        public int execute(int a, int b) {
            return a * b;
        }
    },
    DIVIDE {
        @Override
        public int execute(int a, int b) {
            return b != 0 ? a / b : 0;  // Handling division by zero
        }
    };

    // Abstract method to be implemented by each enum constant
    public abstract int execute(int a, int b);
}

```

Using the Enum in a Program

```java
public class EnumAbstractMethodExample {
    public static void main(String[] args) {
        int num1 = 10, num2 = 5;

        System.out.println("Addition: " + Operation.ADD.execute(num1, num2));
        System.out.println("Subtraction: " + Operation.SUBTRACT.execute(num1, num2));
        System.out.println("Multiplication: " + Operation.MULTIPLY.execute(num1, num2));
        System.out.println("Division: " + Operation.DIVIDE.execute(num1, num2));
    }
}

```

#### When to Use Abstract Methods in Enums?
- You should use an abstract method in an enum when different constants need different implementations of a common behavior. Here are some scenarios:
  - Strategy Pattern Implementation
    - When each enum constant represents a different strategy or algorithm.
    - Example: Different discount strategies in an e-commerce system.

Example : 

```java
// Enum implementing Strategy Pattern
public enum DiscountStrategy {
    REGULAR {
        @Override
        public double applyDiscount(double amount) {
            return amount * 0.95; // 5% discount
        }
    },
    PREMIUM {
        @Override
        public double applyDiscount(double amount) {
            return amount * 0.90; // 10% discount
        }
    },
    VIP {
        @Override
        public double applyDiscount(double amount) {
            return amount * 0.80; // 20% discount
        }
    },
    NO_DISCOUNT {
        @Override
        public double applyDiscount(double amount) {
            return amount; // No discount
        }
    };

    // Abstract method to be implemented by each discount strategy
    public abstract double applyDiscount(double amount);
}
//Usage : 
public class DiscountStrategyExample {
  public static void main(String[] args) {
    double billAmount = 1000.0;

    // Example: Apply different discounts
    System.out.println("Regular Customer: $" + DiscountStrategy.REGULAR.applyDiscount(billAmount));
    System.out.println("Premium Customer: $" + DiscountStrategy.PREMIUM.applyDiscount(billAmount));
    System.out.println("VIP Customer: $" + DiscountStrategy.VIP.applyDiscount(billAmount));
    System.out.println("New Customer: $" + DiscountStrategy.NO_DISCOUNT.applyDiscount(billAmount));
  }
}

```


    - Different Behaviors for Different States
        - When an enum represents states in a finite state machine where each state has different behavior.






### Iterating Over Enum Values

```java
public class EnumIteration {
    public static void main(String[] args) {
        for (Day d : Day.values()) {
            System.out.println(d);
        }
    }
}

```

# Key Benefits of Using Enums
- Type safety – Prevents assigning invalid values.
- Improves code readability – Named constants are more meaningful.
- Can have fields, constructors, and methods – Provides additional functionality.
- Switch-case compatibility – Can be used in switch statements.

Enums are widely used in state management, command options, error codes, and predefined settings in Java applications.



# Note:
-  Java enums cannot be extended because they implicitly extend java.lang.Enum, which is a final class. In Java, a class declared as final cannot be extended (inherited), meaning enums cannot have subclasses.



# Ordinal in Java Enums (ordinal())

- Each enum constant in Java has an implicit index value, known as its ordinal, which represents its position in the enum declaration. This index starts from 0.

How to Get an Enum’s Ordinal?

```java
public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}

public class EnumOrdinalExample {
    public static void main(String[] args) {
        for (Day day : Day.values()) {
            System.out.println(day + " -> Ordinal: " + day.ordinal());
        }
    }
}

```

output: 

```text
SUNDAY -> Ordinal: 0
MONDAY -> Ordinal: 1
TUESDAY -> Ordinal: 2
WEDNESDAY -> Ordinal: 3
THURSDAY -> Ordinal: 4
FRIDAY -> Ordinal: 5
SATURDAY -> Ordinal: 6

```

## Key Points About ordinal()
- Starts from Zero – The first constant gets 0, the second 1, and so on.
- Defined by Declaration Order – Changing the order of constants changes their ordinal values.
- Not Recommended for Persistence – Since ordinal values can change if enum order is modified, it's risky to store or rely on them in databases or serialized files.
- Useful for Iteration & Comparisons – Can be used in sorting, loops, or switch cases, but avoid using it for logic that depends on a fixed value.



# String to Enum (Enum.valueOf(String))

```java
public class EnumValueOfExample {
    public static void main(String[] args) {
        String dayStr = "MONDAY";
        Day day = Day.valueOf(dayStr);
        System.out.println("Parsed Enum: " + day);
    }
}

```

- Helps convert string values to enums (useful when dealing with user input, JSON parsing, etc.).


# How Enums Work with Switch Statements

```java
public class EnumSwitchExample {
    public static void main(String[] args) {
        Day today = Day.MONDAY;

        switch (today) {
            case MONDAY:
                System.out.println("Start of the workweek!");
                break;
            case FRIDAY:
                System.out.println("Weekend is near!");
                break;
            default:
                System.out.println("A regular day.");
        }
    }
}

```

# Enum Constructors
- Enum constructors are always private because enums define a fixed set of constants.
- Making the constructor public or protected would allow new instances, violating the enum's purpose.


```java
public enum InvalidEnum {
    INSTANCE;

    // ❌ This will cause a compilation error
    public InvalidEnum() { } 
}

```

# Where Are Enum Values Stored in Java?
- Enum values in Java are stored in the Method Area /Metaspace (java 8 onwards) , not the Heap.

## Why Are Enums Stored in the Method Area?
- Enums Are Like Static Constants
  - Enums are internally represented as static final instances.
  - Since static members belong to the class level, they are stored in the Method Area, not in the Heap.

- Loaded Only Once
  - Enum constants are created once (singleton-like behavior).
  - The JVM loads them into the Method Area/ Metaspace at class loading time.
  
- Method Area / Metaspace Stores Class Metadata
  - Class structure (metadata)
  - Static variables
  - Method code
  - Enum instances

- Since enum values are final and static, they are stored here.


# Code to Check if Enum Constants Are static and final

```java
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class EnumReflectionTest {
    public static void main(String[] args) {
        Class<?> cls = Day.MONDAY.getClass(); // Getting the class of an enum constant

        // Checking superclass
        System.out.println("Superclass: " + cls.getSuperclass().getName());

        // Checking declared fields
        for (Field field : cls.getSuperclass().getDeclaredFields()) {
            int modifiers = field.getModifiers(); // Getting field modifiers

            System.out.println("Field Name -> " + field.getName() +
                    ", Type -> " + field.getType().getName() +
                    ", Modifiers -> " + Modifier.toString(modifiers)); // Convert modifier to readable format
        }
    }

    enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
    }
}

```













