# What is Separation of Concerns (SoC)?

> Separation of Concerns means dividing your application into distinct sections, where each section (or “concern”) handles a specific responsibility — and nothing else.

Each "concern" should be:

- Focused
- Independent
- Replaceable/testable in isolation


# Why It Matters in Microservices

In Spring Boot microservices, SoC helps you build services that are:

- Easier to maintain (each part does one job well)
- Testable (you can write focused unit/integration tests)
- Scalable (you can evolve or replace one part without breaking others)
- Reusable (e.g. shared modules, libraries, or components)

# Typical Concerns in a Spring Boot Microservice

| **Layer**            | **Concern (Responsibility)**                               | **Example Class**          |
|----------------------|------------------------------------------------------------|----------------------------|
| **Controller**       | Handle HTTP requests, map routes, return responses         | `UserController`           |
| **Service**          | Business logic, orchestration                              | `UserService`              |
| **Repository (DAO)** | Data access, persistence logic                             | `UserRepository`           |
| **Model/Entity**     | Domain objects, data structures                            | `User`, `Order`            |
| **Config**           | External configuration, beans, security, etc.              | `SecurityConfig`, `AppConfig` |
| **Exception**        | Error handling, global exception mapping                    | `GlobalExceptionHandler`   |


# Let’s say we have a User microservice.

Without SoC (Anti-Pattern — everything in controller)

```java
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RuntimeException("User not found");
        }
    }
}

```

> **Issue** Business logic and exception handling are mixed into the controller.  
> Changes become risky. Testing is harder.


With SoC (Clean, Layered)

```java
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
}

```

```java
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
    }
}

```

```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

```

```java
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}

```

**Now each class handles a single concern:**
- Controller: routing
- Service: business rules
- Repository: data access
- Exception: error reporting


# Summary  

| **Concept**          | **Application in Spring Boot Microservices**               |
|----------------------|------------------------------------------------------------|
| **SoC**              | Divide logic by responsibilities                          |
| **In Code**          | Separate controllers, services, repositories, configs, exceptions |
| **Why It Matters**   | Easier testing, maintainability, scalability               |
| **Real World Use**   | Microservices are themselves concerns; use SoC inside them too |





