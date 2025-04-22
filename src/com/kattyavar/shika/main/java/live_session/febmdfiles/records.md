# Why was record introduced in Java?
Before records, Java developers had to write a lot of boilerplate code just to model data carriers (classes that only hold data).   
This included:

- Private final fields
- Constructor
- Getters
- equals()
- hashCode()
- toString()


This was repetitive and error-prone.

Java record was introduced in Java 14 (as a preview) and became stable in Java 16 to solve this issue.  
It provides a compact syntax for declaring classes whose main purpose is to hold data.


# What is a record in Java?

A record is a special kind of class in Java designed to model **immutable data**. It automatically provides:

- Private final fields
- A canonical constructor
- Getters (with the same name as the field)
- equals(), hashCode(), and toString()

Syntax: 
```java
public record Person(String name, int age) { }

```

This is equivalent to a full class like:

```java
public final class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String name() { return name; }
    public int age() { return age; }

    @Override public boolean equals(Object o) { ... }
    @Override public int hashCode() { ... }
    @Override public String toString() { ... }
}

```

# why immutability is important in Java

**Immutability in Records**  
Immutability means that once an instance of a record is created, its state cannot be modified. This has several benefits:

- Thread Safety: Since records are immutable, they can be safely shared between multiple threads without synchronization.
- Simplicity: Immutable objects are easier to reason about, as their state does not change after creation.
- Predictability: As the state cannot change, it helps in avoiding bugs related to unexpected mutations.



# How many constructors can we have in a record?

You can have three types of constructors in a record:

## 1 Canonical Constructor

This constructor matches the record components exactly.

```java
public record Person(String name, int age) {
  public Person(String name, int age) {
    if (age < 0) throw new IllegalArgumentException("Age cannot be negative");
    this.name = name; // Must assign manually
    this.age = age;
  }
}

```

## 2 Compact Canonical Constructor

This omits the parameter list (it's assumed from the record header) and doesn’t require assigning fields — Java does it for you automatically.

```java
public Person {
    if (age < 0) throw new IllegalArgumentException("Invalid age");
}

```

## 3 Custom Constructor (with different parameters)

You can create custom constructors with different parameters as long as you call the canonical one.

```java
public record Person(String name, int age) {
    public Person(String name) {
        this(name, 0); // default age
    }
}

```

## Execution Order Example:

- **Canonical Constructor** → **Compact Canonical Constructor (if applicable)** → **Custom Constructor**

In summary, when an object is instantiated, the execution starts with the Canonical Constructor (if it's the default or no constructor is defined), followed by any Compact Canonical Constructors (if specified), and finally, the Custom Constructor (if defined).






## So, what’s the key difference Canonical Constructor Vs Compact Canonical Constructor?

| Feature                     | Canonical Constructor                          | Compact Canonical Constructor         |
|----------------------------|--------------------------------------------------|----------------------------------------|
| Must write parameter list  | ✅ Yes                                           | ❌ No                                  |
| Must assign fields manually| ✅ Yes                                           | ❌ No                                  |
| Ideal for                  | Full control (e.g. reordering, modifying data) | Simple validation/checks              |


## How is it different from a normal constructor?

| Feature                                              | Normal Class Constructor | Record Constructor                      |
|------------------------------------------------------|---------------------------|------------------------------------------|
| Must assign fields manually?                         | ✅ Yes                    | ❌ No (in compact canonical)             |
| Fields final & private?                              | ❌ Optional               | ✅ Always                                |
| Requires `this.field = param`?                       | ✅ Yes                    | ❌ Not in compact version                |
| Generates `equals`, `hashCode`, `toString` automatically? | ❌ No                     | ✅ Yes                                   |
| Can override methods?                                | ✅ Yes                    | ✅ Yes (with some restrictions)          |


# Inheritance in Records

Records cannot extend classes (they are implicitly final)

- Records cannot inherit from other classes (except java.lang.Record, which is implicit).
- They are implicitly final, so they cannot be extended either.

```java
public record Person(String name, int age) {
    // Can't extend another class
}

```

Attempting to extend a class:

```java
public record Person(String name) extends Human {} // ❌ Compilation error

```

### Why
Records are meant to be simple data carriers, and inheritance would complicate their design and break immutability guarantees.


# Interface Implementation in Records

Records CAN implement interfaces

This is fully allowed and often useful if you want your record to have behavior or fit into a type hierarchy.

```java
interface Greetable {
    String greet();
}

public record Person(String name) implements Greetable {
    @Override
    public String greet() {
        return "Hello, my name is " + name;
    }
}

```

Records can implement one or more interfaces and provide method implementations just like a class.

## Summary Table

| Feature                      | Record                          |
|-----------------------------|----------------------------------|
| Can extend a class?         | ❌ No                            |
| Can be extended by a class? | ❌ No (records are `final`)      |
| Can implement interfaces?   | ✅ Yes                           |


# Can records have non-final fields?
Yes, but only if you define them manually.

By default, record components (the fields in the header) are:

- private
- final
- Automatically assigned via the canonical constructor

However, you can add your own fields inside the record body, and those can be non-final if you want — but they are not part of the record's state, meaning:

- They’re not included in equals(), hashCode(), or toString()
- They’re treated just like normal fields in a class

Example:

```java
public record Person(String name, int age) {
    private static int instanceCount = 0; // static non-final field
    private String nickname;              // instance non-final field

    public Person {
        instanceCount++;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String nickname() {
        return nickname;
    }
}

```

What’s happening here?

- name and age are part of the record — they’re final and auto-included in equality/hashcode/etc.
- nickname is a regular, mutable field you added manually.
- You can add methods to access or modify nickname, just like a normal class.


##  Things to watch out for

| Behavior                       | Record Component (`name`, `age`) | Custom Field (`nickname`)         |
|-------------------------------|----------------------------------|-----------------------------------|
| Automatically final?          | ✅ Yes                           | ❌ No (unless declared `final`)   |
| Included in `equals()`?       | ✅ Yes                           | ❌ No                              |
| Included in `toString()`?     | ✅ Yes                           | ❌ No                              |
| Can be changed after creation?| ❌ No                            | ✅ Yes (if non-final)             |




