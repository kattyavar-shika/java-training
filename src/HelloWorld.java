import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class HelloWorld {


  public static void test(Integer abc) {
    System.out.println(abc);

  }

  private static void anotherFunction() {
    System.out.println("Calling in diff way ...");
    Human obj = new Human();

    Class c1 = obj.getClass();

    //First thing first let get the class Name;

    System.out.println("Human class name is -> " + c1.getName());

    //Let find out  all the method in the given class

    Method[] methods = c1.getDeclaredMethods();

    for (Method method : methods) {
      System.out.println("Method name is -> " + method.getName());
      System.out.println("Method return type is ->" + method.getReturnType());
      System.out.println("Method access modififer ->" + method.getModifiers());
    }

    //Let talk about member variables..

    for (Field filed : c1.getDeclaredFields()) {
      System.out.println("Memeber varaiable name is -> " + filed.getName());
    }
  }

  public static void main(String[] args) {
    System.out.println("Hello World...");

    // java -jar jarName
    // Java HelloWorld..
  }
}


class Human {
  private String name;
  public String lastName;
  protected Integer age;
  Boolean gender;

  public Human() {
  }

  void setName(String name) {
    this.name = name;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  protected void setAge(Integer age) {
    this.age = age;
  }

  private void setGender(Boolean gender) {
    this.gender = gender;
  }

  public String testMeifYoucan() {
    return null;
  }
}

/*


    System.out.println("Hello World class loader name ->" + HelloWorld.class.getClassLoader());

    System.out.println("Connection.class loader name ->" + Connection.class.getClassLoader());

    System.out.println("String.class loader name ->" + String.class.getClassLoader());

    System.out.println("Test123.class loader name -> " + Test123.class.getClassLoader());


System.out.println("Hello World");

    long pid = ProcessHandle.current().pid();

    System.out.println("Here is my process id ... " + pid);

    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();

    System.out.println("Please enter something to stop it...");

 */