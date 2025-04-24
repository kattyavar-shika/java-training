# DRY Principle in Java — “Don't Repeat Yourself”

> **Definition: The DRY principle encourages developers to reduce duplication in logic, code, or structure, ensuring that each piece of knowledge or logic exists in only one place in the codebase.**

# Why Violating DRY Is a Problem
- Makes code hard to maintain
- If business rules change, you might forget to update all instances
- Increases chance of bugs and inconsistencies


# DRY Principle — Code Examples

Bad (Repeating Logic Everywhere) - Duplicated Tax Calculation in Multiple Services

```java
public class InvoiceService {
    public double calculateTax(double amount) {
        return amount * 0.18;
    }
}

public class PaymentService {
    public double calculateTax(double amount) {
        return amount * 0.18;
    }
}

```

The tax logic is duplicated — if tax rate changes, you need to update it in multiple places.

Good (Extract into a Utility Class)

```java
public class TaxUtil {
    public static double calculateTax(double amount) {
        return amount * 0.18;
    }
}

public class InvoiceService {
    public double getTotal(double amount) {
        return amount + TaxUtil.calculateTax(amount);
    }
}

public class PaymentService {
    public double getTotal(double amount) {
        return amount + TaxUtil.calculateTax(amount);
    }
}

```

> DRY applied: Logic is in one place. Easy to maintain and update.

----

# DRY in Methods — Avoid Copy-Paste

Bad

```java
public void sendWelcomeEmail(User user) {
    String body = "Hi " + user.getName() + ", welcome!";
    EmailService.send(user.getEmail(), "Welcome", body);
}

public void sendResetPasswordEmail(User user) {
    String body = "Hi " + user.getName() + ", click here to reset your password.";
    EmailService.send(user.getEmail(), "Reset Password", body);
}

```

Good (Extract reusable method)

```java
public void sendEmail(User user, String subject, String body) {
    EmailService.send(user.getEmail(), subject, body);
}

public void sendWelcomeEmail(User user) {
    String body = "Hi " + user.getName() + ", welcome!";
    sendEmail(user, "Welcome", body);
}

public void sendResetPasswordEmail(User user) {
    String body = "Hi " + user.getName() + ", click here to reset your password.";
    sendEmail(user, "Reset Password", body);
}

```

# Common Violations of DRY
- Copying the same validation logic across services
- Rewriting SQL queries for the same purpose
- Duplicating business logic across layers



# Summary

> DRY = Maintainable Code

**Benefits of DRY:**
- Easier updates
- Fewer bugs
- Better testability
- Cleaner architecture


Ask yourself:

> “Can this logic or structure be reused?”  
> If yes, refactor and apply DRY.

