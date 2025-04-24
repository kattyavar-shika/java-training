# What is YAGNI 

> YAGNI = “You Aren’t Gonna Need It”  
> A software design principle that advises you to implement only what is necessary right now, and not what you anticipate needing in the future.




# Why It Matters
As professionals working in Java microservices:

- You're often tempted to make systems “future-proof” by adding flexibility/configurability early on.
- Studies and experience show that around 80% of anticipated features are never used. Designing for these adds cost without value.
- The result is: extra code, extra bugs, slower delivery, and harder maintenance.

**YAGNI helps you stay focused** on delivering value early and evolving the system based on real requirements, not assumptions.


# Clean Java Example (Microservice-Style Context)


Let’s say you’re writing a microservice for report generation. Your current requirement is to support **PDF export** only.

Without YAGNI (Over-Engineering)

```java
public class ReportExporter {

    public void export(String report, String format) {
        if ("PDF".equalsIgnoreCase(format)) {
            exportToPDF(report);
        } else if ("Excel".equalsIgnoreCase(format)) {
            exportToExcel(report); // Not needed — no Excel requirement yet!
        } else {
            throw new UnsupportedOperationException("Format not supported: " + format);
        }
    }

    private void exportToPDF(String report) {
        // logic to export to PDF
    }

    private void exportToExcel(String report) {
        // logic to export to Excel (wasted effort)
    }
}

```

- Problem: You've built Excel support without any business need.
- This might also introduce extra dependencies (Apache POI, etc.) — increasing complexity and testing load.


With YAGNI 

```java
public class ReportExporter {

    public void exportToPDF(String report) {
        // logic to export to PDF
    }
}

```

- Clean, focused code.
- When Excel support becomes an actual, funded requirement, you’ll build it then — with proper testing, validation, and product input.


# Real-World Professional Use Case
Context:

You’re building a Java-based microservice in a distributed system.

**Temptation (YAGNI violation)**:
- Add feature toggles for things that aren’t even on the roadmap yet.
  - A feature toggle (or feature flag) is a mechanism that allows you to turn a feature on or off at runtime without changing code.
  - You add a toggle for a feature that doesn’t exist yet, or that no one has asked for — just in case it might be needed someday.
    
Here's an example of a premature toggle being added — even though the new login feature hasn't been scoped or prioritized.

```java
if (FeatureFlags.isNewLoginEnabled()) {
    useNewLoginFlow();
} else {
    useLegacyLoginFlow();
}

```



- Abstract out database layers “in case” you switch from PostgreSQL to MongoDB later.
- Design for multi-tenancy even if you’re building an MVP for a single client.

**YAGNI Response:**
> “Let’s solve the current problem well. If a real need arises, we’ll refactor with purpose.”





# When to Intentionally Not Follow YAGNI

There are legit cases to prepare for the future:

- **Security**: You should always handle edge cases and harden APIs, even if “attacks” aren’t expected yet.
- **Interfaces/Contracts**: When designing public APIs, small design flaws become expensive. Think ahead carefully.
- **Cross-cutting concerns**: Logging, tracing, and observability should be built in from day one in microservices.


# Ask yourself these questions before writing new functionality:

> Am I solving a real, current requirement?  
> Is this feature confirmed, tested, and expected by the user or product team?  
> If I skip this now, would adding it later be costly or disruptive?  
> **If the answer is no to all — you probably aren’t gonna need it.**


#  YAGNI Summary 

| **Aspect**             | **Explanation**                                                                 |
|------------------------|---------------------------------------------------------------------------------|
| **What It Means**      | Don’t build features until they’re truly needed                                |
| **Core Benefit**       | Saves time, avoids complexity, keeps microservices lean and focused             |
| **Risk of Ignoring It**| Wasted effort, overengineering, longer delivery cycles                          |
| **When to Apply**      | Anytime you're tempted to code “just in case”                                   |
| **When to Skip It**    | API design, security, shared platform architecture                              |








