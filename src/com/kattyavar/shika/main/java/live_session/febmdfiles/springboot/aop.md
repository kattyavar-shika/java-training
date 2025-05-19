# Introduction to AOP

# What is AOP?

AOP (Aspect-Oriented Programming) is a programming paradigm that allows you to separate concerns in your application, especially those that cut across multiple layers or modules, like logging, security, or transaction management.


Spring provides AOP support through the spring-aop module, which uses proxies to apply aspects dynamically at runtime.


## Why Do We Need AOP? (Cross-Cutting Concerns)

In large applications, there are common tasks that are required across multiple parts of the application – for example:

- Logging method calls or exceptions
- Handling security checks (e.g., user permissions)
- Managing transactions
- Caching data
- Performance monitoring


These tasks are known as cross-cutting concerns because they affect multiple components.

Without AOP:

- You would have to add the same code (e.g., logging statements) in many places.
- This leads to code duplication, poor separation of concerns, and difficult maintenance.

With AOP:
- You centralize these concerns in one place (an Aspect), and Spring automatically applies them where needed.




## Spring Boot AOP Dependency

```maven
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

```gradle 
implementation 'org.springframework.boot:spring-boot-starter-aop'

```


# AOP Core Concepts with Code Examples


## Aspect 

A class that contains cross-cutting logic. It uses @Aspect and is managed as a Spring bean.

```java
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.service.*.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        System.out.println("Calling method: " + joinPoint.getSignature().getName());
    }
}

```

## Join Point

A point during execution — in Spring AOP, this is always a method execution.

In the above logBeforeMethod(), the JoinPoint refers to the method being called.

```java
public void logBeforeMethod(JoinPoint joinPoint) {
    // Example output: "Calling method: getUserById"
    System.out.println("Method called: " + joinPoint.getSignature().getName());
}

```


## Advice

The actual action that runs at the join point. Spring AOP supports several advice types.

Here are examples for each:

### @Before Advice

```java
@Before("execution(* com.example.service.*.*(..))")
public void logBefore() {
    System.out.println("Method is about to be called");
}

```

If you just want to run some code before the matched methods without needing details, your method can have no parameters.

But if you want to get details about the intercepted method (like method name, arguments, target object), you should accept a parameter of type JoinPoint.


```java
@Before("execution(* com.example.service.*.*(..))")
public void logBefore(JoinPoint joinPoint) {
    System.out.println("Method is about to be called: " + joinPoint.getSignature().getName());
}

```

Here, JoinPoint gives you access to method details, like the method name being called.

Note: 

- Both versions are valid depending on your needs.
- If you want method details, include JoinPoint.
- If not, no parameter is needed.


### @AfterReturning Advice

```java
@AfterReturning("execution(* com.example.service.*.*(..))")
public void logAfterSuccess() {
    System.out.println("Method executed successfully");
}

```

### @AfterThrowing Advice

```java
@AfterThrowing("execution(* com.example.service.*.*(..))")
public void logException() {
    System.out.println("An exception was thrown");
}

```

### @Around Advice

```java
@Around("execution(* com.example.service.*.*(..))")
public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("Before method: " + joinPoint.getSignature().getName());
    Object result = joinPoint.proceed();
    System.out.println("After method: " + joinPoint.getSignature().getName());
    return result;
}

```

## Pointcut

Defines where (which methods) advice should be applied.

```java
@Pointcut("execution(* com.example.service.*.*(..))")
public void serviceMethods() {}

```

You can then reuse it like:

```java
@Before("serviceMethods()")
public void logBefore() {
    System.out.println("Logging before a service method");
}

```


## Where Spring AOP Will Not Work

### Calls Within the Same Class (Self-invocation)

AOP won't be applied when a method in a class calls another method within the same class, even if that second method is annotated with an aspect.

```java
@Component
public class UserService {
    
    @LogExecutionTime
    public void methodA() {
        methodB(); // Aspect on methodB will NOT be triggered
    }

    @LogExecutionTime
    public void methodB() {
        // supposed to be logged
    }
}

```

Why? Spring AOP uses proxies. Self-invocation bypasses the proxy and directly calls the method.


## Private or Final Methods

Spring AOP cannot apply advice to:

- private methods
- final methods
- final classes

Why? Spring AOP uses dynamic proxies, which can't override or intercept final/private methods.


## Methods Not Managed by Spring (Non-Spring Beans)

If your class is not a Spring-managed bean (i.e., not annotated with @Component, @Service, etc.), AOP won’t work.

Why? The proxy is created only for Spring beans.

## Constructor Calls
Spring AOP cannot intercept constructor executions. It only works with method executions.

Use AspectJ if you need constructor-level interception.

## Static Methods

Spring AOP does not support advice on static methods.

Workaround: Move the logic to non-static methods if AOP is required.


# Summary: Where AOP Will Not Work

| **AOP will not work if...**                       | **Reason**                                    |
|--------------------------------------------------|-----------------------------------------------|
| Method calls another method in the same class    | Self-invocation bypasses proxy                 |
| Method is private, final, or in a final class    | Proxies can't override or intercept them       |
| Class is not a Spring-managed bean                | No proxy = no weaving                          |
| Intercepting constructors or static methods       | Spring AOP doesn't support it                  |
| Proxy configuration mismatch (JDK vs. CGLIB)     | Spring can’t apply advice in some proxy situations |


