# Inversion of Control (IoC)

## What is IoC?

**Inversion of Control (IoC)** is a design principle in which the control over object creation and management is transferred from the application (the programmer) to a framework or container.

In a traditional application, you create objects using the new keyword, and you manage their lifecycle (instantiation, initialization, etc.) directly. However, in the Spring Framework, the control is inverted: instead of the application creating and managing objects, Spring manages the object creation and their relationships for you.

This allows Spring to centralize the management of the application's components, which improves modularity, flexibility, and testability.


## How IoC Works in Spring?

- In Spring, **IoC** is implemented through the **Spring Container**, which is responsible for creating, configuring, and managing the lifecycle of beans. 
- Spring's IoC container uses **Dependency Injection (DI)** to inject the necessary dependencies into the beans (objects) at runtime.

Example of IoC in Spring:

Let’s say we have a Car class that depends on an Engine. Without IoC, you’d manually create instances of the objects:

```java
public class Car {
    private Engine engine;

    public Car() {
        this.engine = new Engine(); // Manual creation of dependency
    }

    public void start() {
        engine.run();
    }
}

```

> With IoC, Spring will create the Car and inject the Engine dependency automatically, instead of you having to manually instantiate it:

```java
@Component
public class Car {
    private final Engine engine;

    // Constructor injection (Best practice)
    @Autowired
    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.run();
    }
}

@Component
public class Engine {
    public void run() {
        System.out.println("Engine is running...");
    }
}

```


In this example:
- Spring will create a Car object and inject an instance of Engine into it using constructor injection.
- This way, Spring manages the dependencies and you don't need to worry about how the objects are instantiated or wired together.




# 2. Spring Beans

- In Spring, an object that is managed by the Spring IoC container is called a bean. 
- Beans are the building blocks of a Spring application. 
- They can be simple POJOs (Plain Old Java Objects) or more complex objects that represent the components of your application.


## Bean Definition:

A bean is defined either through annotations `(e.g., @Component, @Service, @Repository, @Controller)` or through XML configuration (though the annotation-based approach is more common in modern Spring applications).

- `@Component`: Marks a class as a Spring bean.
- `@Service, @Repository, and @Controller` are specialized forms of @Component used in different layers of the application.
  - `@Service`: Used for service-layer beans.
  - `@Repository`: Used for Data Access Object (DAO) beans.
  - `@Controller:` Used for web controllers (MVC).


```java
@Component
public class Car {
    private final Engine engine;

    @Autowired
    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.run();
    }
}

@Component
public class Engine {
    public void run() {
        System.out.println("Engine is running...");
    }
}

```

Here, both the Car and Engine classes are defined as Spring beans using the @Component annotation. The Spring IoC container will manage their lifecycle and inject dependencies as needed.

Bean Lifecycle:

In Spring, the lifecycle of a bean can be summarized as:

- Instantiation: The Spring container creates the bean.
- Dependency Injection: Dependencies are injected into the bean.
- Initialization: Spring calls any initialization methods (if defined, such as methods annotated with @PostConstruct).
- Destruction: When the application context is closed, Spring cleans up the bean by calling any destroy methods (if defined).


`You can define custom initialization and destruction methods for beans by implementing the InitializingBean and DisposableBean interfaces, or by using annotations like @PostConstruct and @PreDestroy.`



# Spring Container

The Spring Container is the core component that manages the lifecycle of beans in a Spring-based application. The container is responsible for:

- Instantiating beans
- Injecting dependencies into beans
- Managing the lifecycle of beans
- Providing access to beans via the ApplicationContext or BeanFactory

The Spring Container is implemented by various container types, but the most common one is the ApplicationContext.

**Types of Spring Containers:**
- BeanFactory: The most basic container, used in lightweight scenarios. It’s now rarely used since ApplicationContext provides more features.
- ApplicationContext: A more feature-rich container, which is the most commonly used. It supports event propagation, declarative mechanisms like AOP, and many other features.

```java
public class Main {
    public static void main(String[] args) {
        // Load the Spring context (IoC container)
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        // Retrieve a bean from the container
        Car car = context.getBean(Car.class);
        car.start();
    }
}

```

In this example:

- ApplicationContext is used to load the configuration class (AppConfig), which contains the bean definitions.
- Spring creates and injects the Car and Engine beans, managing their lifecycle.

`Configuration with @Configuration and @Bean:`

`You can also define beans in a Java class using @Configuration and @Bean annotations instead of using component scanning.`

```java
@Configuration
public class AppConfig {

    @Bean
    public Engine engine() {
        return new Engine();
    }

    @Bean
    public Car car() {
        return new Car(engine());
    }
}

```

`Here, @Configuration indicates that the class contains bean definitions. Each method annotated with @Bean defines a bean that the Spring container manages.`



# Types of Bean Scopes in Spring

Spring beans can have different scopes, which define their lifecycle and visibility within the container. The most commonly used scopes are:

- Singleton (default): Only one instance of the bean is created in the Spring container. This is the default scope for beans.
- Prototype: A new instance of the bean is created each time it is requested from the container.
- Request: A new bean is created for each HTTP request. (Used in web applications.)
- Session: A new bean is created for each HTTP session. (Used in web applications.)
- Application: A single bean instance is created for the entire Spring application.

Example of changing the scope to prototype:

```java
@Component
@Scope("prototype")
public class Car {
    // ...
}

```

# Autowiring in Spring

Autowiring is a feature that allows Spring to automatically inject dependencies into beans. This can be done through constructor injection, setter injection, or field injection.

Constructor Injection (Recommended):

```java
@Component
public class Car {

    private final Engine engine;

    @Autowired
    public Car(Engine engine) {
        this.engine = engine;
    }
}

```

Field Injection:

```java
@Component
public class Car {
    
    @Autowired
    private Engine engine;
}

```

# ApplicationContext and BeanFactory

ApplicationContext is an advanced version of BeanFactory, and it’s the most commonly used container in Spring. It provides additional features like internationalization (I18N), event propagation, and AOP support.

```java
ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

```

BeanFactory is a more basic interface, useful for lightweight applications. It only provides the basic functionality to get beans.



# Summary of Concepts

- Inversion of Control (IoC): The control of object creation and management is handed over to the Spring Container.
- Beans: Objects that are managed by the Spring container. They can be created using annotations like @Component or through XML configuration.
- Spring Container: The container that manages the beans and their lifecycle. The most commonly used container is ApplicationContext.




















