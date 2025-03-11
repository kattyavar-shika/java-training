# Annotations in Java

Annotations in Java are a form of metadata that provide data about a program but are not part of the program itself.  
They offer a way to add extra information to your code, which can be processed by the compiler, development tools, or frameworks at compile time, runtime, or even during code analysis.

Annotations do not change the behavior of the program directly but can provide useful information to tools that process annotations, such as compilers, IDEs, or runtime frameworks.


## Why Use Annotations?
- Code Documentation: Provide additional context or information about code elements like classes, methods, and fields.
- Code Analysis: Help tools analyze code more effectively.
- Configuration: Used in frameworks like Spring, Hibernate, and JUnit to configure behavior without needing external XML or configuration files.
- Compile-time Checking: Some annotations enable tools to check code for issues at compile time.



## Syntax of Annotations:

Annotations are defined using the @ symbol followed by the annotation name. Optionally, you can add parameters (optional) within parentheses.

Example
```java
public @interface MyAnnotation {
    String value() default "Default Value";  // Optional element with default value
}

```

Built-in Annotations in Java:
- @Override: Indicates that a method overrides a method in the superclass.
- @Deprecated: Marks a method or class as deprecated, meaning it should no longer be used.
- @SuppressWarnings: Instructs the compiler to suppress specific warnings.
- @FunctionalInterface: Indicates that an interface is intended to be a functional interface (with only one abstract method).


## Custom Annotations:

You can also define your own annotations. A custom annotation can be defined using the @interface keyword.


# Example of Built-in and Custom Annotations

```java
// Using @Override to indicate that this method overrides a method from the superclass
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {  // This overrides the sound method from Animal
        System.out.println("Dog barks");
    }
}

public class AnnotationExample {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.sound();  // Output: Dog barks
    }
}

```

2. Using @Deprecated and @SuppressWarnings:

```java
public class DeprecatedExample {

    // Deprecated method (use with caution)
    @Deprecated
    public void oldMethod() {
        System.out.println("This method is deprecated");
    }

    // New preferred method
    public void newMethod() {
        System.out.println("This is the new method");
    }

    public static void main(String[] args) {
        DeprecatedExample example = new DeprecatedExample();
        example.oldMethod();  // Compiler may give a warning about deprecation
        example.newMethod();
    }
}

```

3. Custom Annotation Example:

You can create your own annotations to provide custom metadata:

```java
// Custom annotation definition
public @interface MyCustomAnnotation {
    String author() default "Unknown";
    String version() default "1.0";
}

class MyClass {
    @MyCustomAnnotation(author = "John Doe", version = "1.2")
    public void myMethod() {
        System.out.println("Method with custom annotation");
    }
}

public class AnnotationExample {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.myMethod();
        
        // You can access the annotation information through reflection
        MyCustomAnnotation annotation = obj.getClass().getDeclaredMethod("myMethod")
                                          .getAnnotation(MyCustomAnnotation.class);
        System.out.println("Author: " + annotation.author());
        System.out.println("Version: " + annotation.version());
    }
}

```

## 1. Retention Policy (When Annotations Are Available)

Annotations can have different retention policies, which specify when they are available during the program’s lifecycle. These retention policies control whether annotations are available at compile-time, runtime, or class-load-time.

- Retention Policies:
  - @Retention(RetentionPolicy.SOURCE):
    - Annotations are discarded by the compiler during the compilation process. They are not included in the compiled .class files and are not available at runtime. These annotations are usually used for documentation purposes or to provide information to tools during the source code phase.
    - Example: @SuppressWarnings is a source-level annotation that is used by the compiler to suppress warnings.
  
  - @Retention(RetentionPolicy.CLASS):
    - Annotations are available at compile-time and included in the compiled .class files but are not available at runtime. This is the default retention policy if you don’t explicitly specify one.
    - Example: Some framework-based annotations like @Entity (used in JPA/Hibernate) are often marked with RetentionPolicy.CLASS.

  - @Retention(RetentionPolicy.RUNTIME):
    - Annotations are retained at runtime and are available for reflection. These are the annotations you typically use when you want to inspect or process annotations dynamically at runtime (for example, using frameworks like Spring, Hibernate, JUnit, etc.).
    - Example: Annotations like @Override, @Autowired, @Test, etc., are available at runtime, allowing frameworks to process them via reflection.



## 2. Where Can Annotations Be Applied? (Target)
Annotations can be applied to different program elements, such as classes, methods, fields, constructors, etc.   
The @Target annotation specifies where an annotation can be applied.


- Common Targets for Annotations:
  - @Target(ElementType.TYPE):
    - This indicates that the annotation can be applied to a class, interface, or enum type.
    - Example: @Entity, @Component, @Controller (commonly used in frameworks like Hibernate, Spring).
  - @Target(ElementType.FIELD):
    - This indicates that the annotation can be applied to fields (i.e., member variables).
      - Example: @Autowired, @Inject (used in dependency injection).
  - @Target(ElementType.METHOD):
    - This indicates that the annotation can be applied to methods.
    - Example: @Override, @Test (used in testing frameworks like JUnit).
  - @Target(ElementType.PARAMETER):
    - This indicates that the annotation can be applied to method parameters.
    - Example: @RequestParam (used in Spring MVC).
  - @Target(ElementType.CONSTRUCTOR):
    - This indicates that the annotation can be applied to constructors.
    - Example: @Inject (used for constructor injection in dependency injection).
  - @Target(ElementType.LOCAL_VARIABLE):
    - This indicates that the annotation can be applied to local variables.
    - Example: @SuppressWarnings can be applied to local variables to suppress warnings for specific variables.
  - @Target(ElementType.ANNOTATION_TYPE):
    - This indicates that the annotation can be applied to other annotations.
    - Example: @Retention, @Target themselves are annotations that can be applied to other annotations.



## Example of Annotations with Retention and Target

Let’s look at some examples to see how @Retention and @Target work in practice.

Custom Annotation with Retention Policy:

```java
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) // Available at runtime
public @interface MyCustomAnnotation {
    String author() default "Unknown";
    String version() default "1.0";
}

```


Here, the annotation MyCustomAnnotation is marked with @Retention(RetentionPolicy.RUNTIME), meaning it will be available at runtime for reflection.

Applying Annotations to Different Targets:

```java
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Target(ElementType.TYPE) // Can be applied to a class or interface
@interface MyClassAnnotation {
    String description() default "Class-level annotation";
}

@Target(ElementType.METHOD) // Can be applied to methods
@interface MyMethodAnnotation {
    String value() default "Method-level annotation";
}

public class AnnotationExample {

    @MyClassAnnotation(description = "This is a class-level annotation")
    public class MyClass {

        @MyMethodAnnotation(value = "This is a method-level annotation")
        public void myMethod() {
            System.out.println("Method with MyMethodAnnotation");
        }
    }

    public static void main(String[] args) throws Exception {
        AnnotationExample example = new AnnotationExample();
        MyClass myClass = example.new MyClass();
        myClass.myMethod();

        // Access annotations using reflection
        MyClassAnnotation classAnnotation = myClass.getClass().getAnnotation(MyClassAnnotation.class);
        System.out.println("Class Annotation: " + classAnnotation.description());

        MyMethodAnnotation methodAnnotation = myClass.getClass().getMethod("myMethod").getAnnotation(MyMethodAnnotation.class);
        System.out.println("Method Annotation: " + methodAnnotation.value());
    }
}

```


# Why Annotations Alone Are Not Useful

Annotations in Java are just markers or metadata.   
For example, @Cacheable indicates that a method should be cached, but by itself, it doesn’t perform any caching.   
To make the annotation work, you need to have some processing logic that interprets the annotation and acts on it.


## How Annotations Get Their Power:

- AOP (Aspect-Oriented Programming):
  - In the case of Spring's @Cacheable, Spring AOP is used to intercept the method calls and implement caching logic. Without AOP (or similar mechanisms), annotations wouldn’t be able to trigger actions such as checking the cache, updating the cache, or skipping method execution.
  - The Cache Aspect we implemented earlier is an example of this. Without this aspect, the @MyCache annotation would not have any effect.
- Reflection
  - Some custom annotations are processed using reflection. For example, tools like JPA (Hibernate) process annotations such as @Entity, @Id, etc., via reflection to map Java objects to database tables. Similarly, you can create custom logic that reads annotations and makes decisions based on that.






































    
