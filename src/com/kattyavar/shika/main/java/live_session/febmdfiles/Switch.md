# Java 8 and Earlier – Traditional Switch

In Java 8, switch is:

- A statement, not an expression.
- Can only operate on: int, char, byte, short, enum, String.
- Requires break to prevent fall-through.

```java
int day = 2;
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    default:
        System.out.println("Other day");
}

```

# Java 12 (Preview) – Switch Expressions Introduced

- Introduced as preview feature.
- Now, switch can be used as an expression that returns a value.
- Added -> syntax (arrow labels).
- break not needed anymore.

```java
int day = 2;
String result = switch (day) {
    case 1 -> "Monday";
    case 2 -> "Tuesday";
    default -> "Other day";
};

```

#  Java 13 (Preview) – yield keyword introduced

You can now use yield in blocks to return a value from a case.

```java
String result = switch (day) {
    case 1 -> "Monday";
    case 2 -> {
        System.out.println("Processing...");
        yield "Tuesday";
    }
    default -> "Other day";
};

```

In Java 12, you couldn’t use a block ({}) in a -> case to compute a value. That’s where Java 13 steps in.

Java 13 added the yield keyword to support multi-statement blocks inside switch expressions.

You use a block with {} when the logic isn’t just a one-liner.

yield tells the compiler what value to return from that block.


### Why Not Just Use return?

- Because:
  - return exits the entire method.
  - yield exits the switch expression with a value.



# Java 14 – Switch Expressions Become Standard
- Switch expressions are standard (not preview) from Java 14.
- Arrow syntax (->) and yield are now part of the language.


# Java 17 – Pattern Matching for Switch (Preview)
- Introduced pattern matching for switch as a preview.
- Now switch can match against types, not just values.

```java
Object obj = "Hello";
String result = switch (obj) {
    case String s -> "String of length " + s.length();
    case Integer i -> "Integer: " + i;
    default -> "Unknown type";
};

```

# Java 21 – Pattern Matching for Switch (Finalized)
- Pattern matching for switch is now standard in Java 21.
- Supports:
  - Type patterns (e.g., case String s)
  - Guarded patterns (e.g., case String s when s.length() > 5)
  - Exhaustiveness checking (compiler ensures all cases are covered)

```java
Object obj = "Hello";
String result = switch (obj) {
    case String s when s.length() > 5 -> "Long string";
    case String s -> "Short string";
    case Integer i -> "Integer";
    default -> "Something else";
};

```

## Use Case: Sealed Class + Pattern Matching in Switch

Step 1: Define the Sealed Class

```java
sealed interface Shape permits Circle, Rectangle, Square {}

final class Circle implements Shape {
    double radius;
    Circle(double radius) {
        this.radius = radius;
    }
}

final class Rectangle implements Shape {
    double length, width;
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
}

final class Square implements Shape {
    double side;
    Square(double side) {
        this.side = side;
    }
}

```

Step 2: Pattern Matching in a Switch

Now we’ll use the new pattern matching switch to calculate the area based on the shape type.


```java
public class ShapeTest {
    public static void main(String[] args) {
        Shape shape = new Rectangle(4, 6);

        double area = switch (shape) {
            case Circle c -> Math.PI * c.radius * c.radius;
            case Rectangle r -> r.length * r.width;
            case Square s -> s.side * s.side;
        };

        System.out.println("Area: " + area);
    }
}

```

Why This Is Cool in Java 21:

- Exhaustiveness: The compiler ensures all permitted subtypes are covered.
- No casting needed: The type is already matched and cast for you.
- Cleaner syntax: No more if instanceof or instanceof + cast.




## Example: Forgetting to Handle Square

Let’s remove the Square case from the switch:

```java
Shape shape = new Rectangle(4, 6);

double area = switch (shape) {
    case Circle c -> Math.PI * c.radius * c.radius;
    case Rectangle r -> r.length * r.width;
    // ⚠️ Square case is missing!
};

```

 Compile-Time Error:

```shell
error: the switch expression does not cover all possible input values
  switch (shape) {
         ^
  missing case for: Square

```

If you're unsure about handling all types right away (like during early dev), you can use a default case — but doing so disables exhaustiveness checking:

```java
double area = switch (shape) {
    case Circle c -> Math.PI * c.radius * c.radius;
    case Rectangle r -> r.length * r.width;
    default -> throw new IllegalStateException("Unhandled shape: " + shape);
};

```

But this should be avoided in final code when working with sealed types, unless you're handling external subtypes via reflection or dynamic logic.


```java
enum Day { MONDAY, TUESDAY,WEDNESDAY, THURSDAY,  FRIDAY, SATURDAY, SUNDAY }

static void handle(Day day) {
    switch (day) {
        case MONDAY -> System.out.println("Back to work!");
        case TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> System.out.println("Midweek grind");
        case SATURDAY, SUNDAY -> System.out.println("Weekend vibes!");
    }
}

```

or you do it this way . 

```java
static void handle(Object obj) {
    switch (obj) {
        case Day d when d == Day.MONDAY -> System.out.println("Back to work!");
        case Day d -> System.out.println("Just another day: " + d);
        case String s -> System.out.println("String: " + s);
        default -> System.out.println("Unknown type");
    }
}

```

Which case gets priority?

The first case with the guard (when) gets higher priority.

In the first case: case Day d when d == Day.MONDAY, you're first checking if obj is a Day, and then you're guarding it with the condition d == Day.MONDAY. So this case will match only when the obj is of type Day and it specifically equals Day.MONDAY.

The second case: case Day d, will match any Day (except for the case where it's already matched by the first case).



