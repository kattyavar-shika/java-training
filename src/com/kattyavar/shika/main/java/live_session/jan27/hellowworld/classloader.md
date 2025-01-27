# JVM

# Updated Summary Table of Class Loaders in Java 8 vs Java 9+

| **Class Loader (Java 8)**           | **Where It Loads Classes From (Java 8)**                                | **Class Loader (Java 9+)**              | **Where It Loads Classes From (Java 9+)**                                |
|-------------------------------------|------------------------------------------------------------------------|-----------------------------------------|------------------------------------------------------------------------|
| **Bootstrap Class Loader**          | `rt.jar` in `<JDK>/jre/lib/`                                            | **Bootstrap Class Loader**              | `java.base` module (in `jmods` directory)                              |
| **Extension Class Loader**          | `lib/ext/` directory or directories specified by `java.ext.dirs`        | **Platform Class Loader**               | Platform modules (like `java.sql`, `java.desktop`, etc., in `jmods`)    |
| **System Class Loader**             | **Classpath** (specified by `-cp` or `-classpath` at runtime)          | **System Class Loader**                 | **Classpath** or **Module Path** (if using modules)                    |
| **Custom Class Loaders**            | Custom sources like file systems, networks, etc.                       | Custom Class Loaders                    | Custom sources, but may interact with the **module system** (if modules are used) |


## To get class information 

```java
Human obj = new Human();
 Class c1 = obj.getClass();
 
 //To get all getDeclaredMethods
 Method[] methods = c1.getDeclaredMethods();
 
 //To get all member variables. 

Field[] fields = c1.getDeclaredFields();

//to access it type and name. 
 // field.getName() &&  field.getType()


//PlatformClassLoader
    System.out.println(Connection.class.getClassLoader());
  //AppClassLoader
  System.out.println(HelloWorld.class.getClassLoader());
  //BootStrap class Loaders
  System.out.println(String.class.getClassLoader()); // you will get null
  
```

## To check internal how many thread are required only for HelloWorld.

```java
public class HelloWorldInternalThreadInfo {
  public static void main(String[] args) {
    System.out.println("Hello World");

    long pid = ProcessHandle.current().pid();

    System.out.println("Use this command to check the process more information ");
    System.out.println("ps -T -p " + pid);

    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
  }
}
```

## To check how many class are loaded to run simple hello world program 


```shell
# To Compile 
javac HelloWorld.java

# To Check byte code of .class file
javap -c HelloWorld.class 
# To check how many class are loaded to just run Hello World
java -Xlog:class+load=debug HelloWorld
```