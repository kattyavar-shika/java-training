# 1. JVM Tuning

JVM tuning involves adjusting JVM parameters to optimize memory usage, garbage collection, and other aspects of the JVM's behavior.   
Key JVM parameters fall into categories like heap memory size, garbage collection (GC) behavior, thread management, etc.


## Step 1: Set JVM Heap Size

The heap is where Java objects are stored. You can optimize the heap size based on your application’s needs.

- Initial heap size (-Xms): Defines the starting heap size when the JVM is started.
- Maximum heap size (-Xmx): Specifies the maximum heap size the JVM can use.

```cmd
java -Xms512m -Xmx1g MyApp

```
This example sets the initial heap size to 512 MB and the maximum heap size to 1 GB.


## Step 2: Monitor Garbage Collection

Garbage collection (GC) can significantly impact performance.   
JVM provides several GC algorithms, and tuning GC can help manage application memory more efficiently.

Choose the right GC algorithm:
- Serial GC (-XX:+UseSerialGC): Best for single-threaded applications or systems with small heap sizes.
- Parallel GC (-XX:+UseParallelGC): A multi-threaded GC, suitable for multi-core processors.
  - You can further fine-tune the Parallel GC by adjusting the number of threads used for parallel garbage collection. The JVM allows you to specify the number of threads used by the Parallel GC through the -XX:ParallelGCThreads option.

```shell
java -XX:+UseParallelGC -Xms512m -Xmx2g -XX:ParallelGCThreads=4 ParallelGCExample

```

- G1 GC (-XX:+UseG1GC): Designed for large heaps and applications with low pause-time requirements.
- ZGC (-XX:+UseZGC): A low-latency garbage collector.

Monitor GC behavior:

Use the following options to log garbage collection stats:

```shell
java -Xlog:gc* MyApp

```

This logs GC events and helps you identify performance bottlenecks related to garbage collection.

## Step 3: Optimize Thread Management

Threads in Java can have a significant impact on performance. You can configure the number of threads based on the system and workload.

Max thread stack size (-Xss): Defines the stack size for each thread. Example:

```shell
java -Xss1m MyApp

```

## Step 4: Enable JIT (Just-in-Time) Compilation

JIT is a crucial part of JVM performance. It compiles bytecode to native code at runtime, improving the performance of Java applications.

Enable JIT (this is usually enabled by default, but you can control it):

```shell
java -XX:+UnlockDiagnosticVMOptions -XX:+PrintCompilation -XX:+LogCompilation MyApp

```



# JVM Profiling

Profiling helps in identifying performance bottlenecks in the Java application. The goal is to find inefficient methods, memory usage issues, and potential deadlocks.

You can use jvisualvm, jstack(for Thread Dump Analysis),  Use jmap for Heap Dumps

