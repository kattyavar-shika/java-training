
# Cohesion 

## Definition:

- Cohesion refers to the degree to which the elements (methods, variables) within a single module, class, or service are related to each other.
- A class or service with high cohesion has elements that are closely related and focused on performing a single task, 
- while a class or service with low cohesion has elements that are unrelated or loosely connected, making the service or class more difficult to maintain and understand.


> In simpler terms, cohesion measures how well the responsibilities within a class or service fit together. The higher the cohesion, the more focused and clear the responsibility of that class or service is.


## High Cohesion:

A highly cohesive class or service focuses on a single responsibility or task. All its methods and properties are strongly related to that responsibility. The more focused and unified the functionality is, the better.

Example: A UserService that handles only user-related tasks (e.g., creating a user, updating user information).


Here’s a scenario where the UserService and OrderService are tightly coupled and the responsibilities of each service are not clearly defined.

```java
// HighCohesionUserService.java

package com.example.highcohesion;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<Long, User> users = new HashMap<>();

    // High cohesion: Only handling user-related functionality
    public String createUser(Long userId, String name, String email) {
        users.put(userId, new User(userId, name, email));
        return "User created successfully";
    }

    public User getUser(Long userId) {
        return users.get(userId);
    }

    public String updateUser(Long userId, String name, String email) {
        User user = users.get(userId);
        if (user != null) {
            user.setName(name);
            user.setEmail(email);
            return "User updated successfully";
        } else {
            return "User not found";
        }
    }
}

```

### Low Cohesion:

- A low-cohesion class or service performs unrelated tasks, meaning its methods and properties are not strongly related to each other. 
- These services are harder to maintain and understand because they are trying to do too many things that don't naturally belong together.

Example: A UserService that not only handles user tasks but also performs order-related tasks, which is not related to its core responsibility of managing users.

```java
// LowCohesionUserService.java

package com.example.lowcohesion;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<Long, User> users = new HashMap<>();

    // Low cohesion: Mixing user creation and order creation in the same service
    public String createUserAndOrder(Long userId, String name, String email, Long orderId) {
        // User creation logic
        users.put(userId, new User(userId, name, email));
        
        // Order creation logic (unrelated task mixed in)
        OrderService orderService = new OrderService();
        orderService.createOrder(userId, orderId);  // Directly calling another service
        return "User and Order created successfully";
    }

    // Other methods...
}

```


## Why Cohesion is Important:
- High Cohesion makes a class or service easier to understand, test, and maintain.
- Low Cohesion leads to complexity, making the code harder to manage and extend. If classes have too many responsibilities, a change in one area could affect others, leading to a highly coupled system.


# Coupling

## Definition 

- Coupling refers to the degree of dependence between two classes, modules, or services. 
- In simpler terms, it measures how closely connected two components are. The more dependent they are on each other, the tighter the coupling.
- The less dependent they are, the looser the coupling.

**Tight Coupling**: 
- If two classes or services are tightly coupled, it means that one class or service has a strong dependency on the internal details of the other class/service. 
- This makes the system more rigid and harder to change because any modification to one class may require changes in others.

**Loose Coupling**: 
- If two classes or services are loosely coupled, they interact with each other via well-defined interfaces or abstractions, and don’t depend on each other’s internal details. 
- This results in a more flexible and maintainable system because you can modify one service without affecting others.


## Tight Coupling

In tight coupling, one class/service directly interacts with the internal details of another class/service, leading to a high degree of interdependence.

Tight Coupling Example

```java
// TightCouplingExample.java

package com.example.tightcoupling;

public class UserService {
    
    private OrderService orderService = new OrderService();  // Direct dependency (tight coupling)
    
    public void createUserAndOrder(Long userId, String name, Long orderId) {
        // Creating user
        System.out.println("User created: " + name);
        
        // Directly invoking OrderService
        orderService.createOrder(userId, orderId);  // This introduces tight coupling
    }
}

class OrderService {
    
    public void createOrder(Long userId, Long orderId) {
        // Order creation logic
        System.out.println("Order created for User: " + userId + ", Order ID: " + orderId);
    }
}

```

### Why is this Tight Coupling?
- The UserService class is directly dependent on the OrderService. Any change in the OrderService might require changes in UserService as well.
- It’s hard to test and maintain because both services are tightly connected. If OrderService changes, UserService might also need modification.


## Loose Coupling
- In loose coupling, classes or services do not depend on the internal details of each other. 
- They communicate via abstractions like interfaces or API calls. 
- This makes the system more flexible and easier to maintain because changes in one class won’t affect others as long as the interface remains the same.

Loose Coupling Example

```java
// LooseCouplingExample.java

package com.example.looselycoupled;

public class UserService {
    
    private OrderService orderService;  // No direct dependency, using abstraction (loose coupling)
    
    public UserService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void createUserAndOrder(Long userId, String name, Long orderId) {
        // Creating user
        System.out.println("User created: " + name);
        
        // Invoking OrderService via abstraction
        orderService.createOrder(userId, orderId);  // No tight coupling, just calling via abstraction
    }
}

interface OrderService {
    void createOrder(Long userId, Long orderId);
}

class OrderServiceImpl implements OrderService {
    
    public void createOrder(Long userId, Long orderId) {
        // Order creation logic
        System.out.println("Order created for User: " + userId + ", Order ID: " + orderId);
    }
}

```

### Why is this Loose Coupling?

- The UserService class is not directly dependent on the OrderService. Instead, it uses the OrderService interface, which means the implementation can be changed without affecting the UserService.
- The two services are decoupled, making the system more modular and flexible. You can change the implementation of OrderService without changing the UserService, as long as the interface remains the same.


## Why Coupling is Important:

The degree of coupling in your system can affect:

- Maintainability
  - **Tightly coupled** systems are harder to maintain. A change in one component requires changes in many other components, increasing the likelihood of bugs and making testing harder.
  - **Loosely coupled** systems are easier to maintain and extend. Changes in one component won’t affect others as long as the interface remains consistent.
- Flexibility
  - **Tight coupling** limits the ability to change or scale components independently. For example, if UserService and OrderService are tightly coupled, you can’t scale them independently based on traffic, because they rely on each other.
  - **Loose coupling** allows services to evolve independently. If OrderService needs to scale, it can do so without worrying about the UserService.
- Testability
  - **Tightly coupled** systems are harder to unit test because you may need to instantiate and configure many dependent services.
  - **Loosely coupled** systems are easier to unit test because you can mock dependencies and isolate the unit of work for testing.
- Reusability
  - Loosely coupled components are more reusable. If OrderService is decoupled from UserService, you can easily reuse OrderService in other parts of your application or even in other applications.


## Conclusion on Coupling:
- Tight Coupling makes the system rigid, difficult to maintain, and hard to test because the components are highly dependent on each other.
- Loose Coupling promotes flexibility, independence, and modularity by allowing components to interact without depending on each other’s internal details.
- The goal should always be to aim for **loose coupling** in your design, which makes the system more flexible, easier to test, and more maintainable.




# High Cohesion and Low Coupling in Microservices:

- In microservices architecture, high cohesion and low coupling are key principles that help build scalable, maintainable, and flexible systems. 
- Each microservice should be highly cohesive (focused on a single responsibility) and loosely coupled (able to interact with other services without heavy dependencies).


> Bad Example of Tight Coupling and Low Cohesion

In this example, we mix the responsibilities of creating users and creating orders within the same service.   
Additionally, the services are tightly coupled because UserService directly instantiates and interacts with OrderService.


```java
// UserService.java - Violating Cohesion and Coupling

package com.example.badexample;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private Map<Long, User> users = new HashMap<>();
    
    // Mixed responsibility - creating users and creating orders in one method
    public String createUserAndOrder(Long userId, String name, String email, Long orderId) {
        // User creation logic
        users.put(userId, new User(userId, name, email));
        
        // Order creation logic directly mixed here
        // Not following separation of concerns (violates cohesion)
        OrderService orderService = new OrderService();  // Tightly coupling UserService to OrderService
        orderService.createOrder(userId, orderId);  // Direct method call between services
        return "User and Order created successfully";
    }

    // Other methods...
}

```

Problem with the Above Code:

- **Low Cohesion**: 
  - The createUserAndOrder method is responsible for two unrelated tasks: creating a user and creating an order. 
  - These responsibilities should be handled by separate services, not mixed within the same service.
- **Tight Coupling**: 
  - UserService is tightly coupled to OrderService by directly creating an instance of OrderService and invoking its methods. 
  - If OrderService changes, UserService will likely need to change as well.


## Refactor: Apply High Cohesion and Low Coupling

Let's refactor the code to apply high cohesion and loose coupling:

- **Separate Concerns**: UserService should only handle user-related functionality, and OrderService should handle order-related functionality.
- **Decouple the Services**: Instead of calling methods directly between services, we will make an API call to decouple them.

Step 1: Refactor UserService (High Cohesion)
 
```java
// UserService.java - High Cohesion

package com.example.refactored;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    
    private Map<Long, User> users = new HashMap<>();
    
    // UserService is now focused on user-related functionality
    public String createUser(Long userId, String name, String email) {
        users.put(userId, new User(userId, name, email));
        return "User created successfully";
    }

    public User getUser(Long userId) {
        return users.get(userId);
    }
}

```
In this refactored UserService, we have focused solely on user-related functionality, making it cohesive.

Step 2: Refactor OrderService (Loose Coupling)

Now, we will refactor OrderService to decouple the communication with UserService. Instead of directly calling UserService methods, we will make a REST API call to fetch user data.

```java
// OrderService.java - Loose Coupling

package com.example.refactored;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final RestTemplate restTemplate;

    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Create order, and make an API call to fetch user details from UserService
    public String createOrder(Long userId, Long orderId) {
        // Make HTTP request to UserService to get user details
        String userServiceUrl = "http://localhost:8081/users/" + userId;
        User user = restTemplate.getForObject(userServiceUrl, User.class);
        
        if (user != null) {
            // Logic to create an order
            return "Order created for user: " + user.getName();
        } else {
            return "User not found";
        }
    }
}

```

In this refactored OrderService, instead of directly interacting with UserService, it communicates through a REST API, enabling loose coupling.

Step 3: Configure RestTemplate for HTTP Communication

We need to configure RestTemplate to allow OrderService to make HTTP requests to UserService.

```java
// AppConfig.java - RestTemplate Configuration

package com.example.refactored;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

```


### Key Takeaways from Refactoring:
- **High Cohesion**: UserService is now cohesive because it focuses solely on user-related logic, leaving order-related functionality to OrderService. This separation makes the code easier to maintain.
- **Loose Coupling**: OrderService is now decoupled from UserService. It doesn't need to know the internal details of UserService; it only makes a REST call to retrieve user information, allowing the two services to evolve independently.
- **Decoupling through HTTP**: By using RestTemplate, OrderService communicates with UserService via HTTP. This approach decouples the two services while still allowing them to interact.


## Final Thoughts:

- By refactoring the code to apply high cohesion and low coupling, we’ve improved the maintainability, scalability, and flexibility of our system. 
- These principles are foundational in microservices architecture because they allow services to evolve independently, be scaled independently, and remain resilient to changes.


