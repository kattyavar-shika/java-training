package com.kattyavar.shika.main.java.live_session.sep4;

public class EnumExample {


  private static final String MY_CONST = "my const values";

  private static final String DEVELOPER = "Developer";

  private static final int DEV_SALARY = 1000;

  static void letFindWhoIsParentOfEnumClass() {

    //We do not use new keyword.
    Status status = Status.ACCEPTED;

    Class<?> cls = status.getClass();

    System.out.println("Enum status parent class name = " + cls.getSuperclass().getName());

    System.out.println("java.lang.Enum parent class name " + cls.getSuperclass().getSuperclass().getName());

  }

  static void someMoreExample() {

    Status statusPending = Status.ACCEPTED;

    System.out.println("Value of Enum is = " + statusPending + " ordinal values is " + statusPending.ordinal());

    System.out.println("Let have look at all values ...");

    for (Status status : Status.values()) {
      System.out.println("Value of Enum is = " + status + " ordinal values is " + status.ordinal());
    }


  }


  static void withExtraAttributeExample() {

    GradeWithSalary gradeWithSalary = GradeWithSalary.DEVELOPER;

    System.out.println("Enum =" + gradeWithSalary + " it salary = " + gradeWithSalary.getSalary());

    gradeWithSalary.setSalary(999999);

    System.out.println("Enum =" + gradeWithSalary + " it salary = " + gradeWithSalary.getSalary());

    GradeWithSalary antherObject = GradeWithSalary.DEVELOPER;

    System.out.println(" another object " + antherObject + " it salary " + antherObject.getSalary());


    final Demo obj = new Demo("Patil");

    System.out.println(obj);

    obj.name = "Amol";

    System.out.println(obj);

  }

  static void enumOperationExample() {
    Operations operations = Operations.SUBTRACT;

    int x = 30;
    int y = 10;


    System.out.println("Enum operation name = " + operations + " apply operation result = " + operations.apply(x, y));

    System.out.println("Lets have look at all values...");

    for (Operations ops : Operations.values()) {

      System.out.println("Enum operation name = " + ops + " apply operation result = " + ops.apply(x, y));
    }

  }

  public static void main(String[] args) {
    enumOperationExample();
  }
}


enum GradeWithSalary {
  DEVELOPER(1000, "dev name"),
  TESTER(11000),
  MANAGER(500),
  PROJECTMANAGER(1);

  private int salary;

  GradeWithSalary(int salary, String name) {
    this.salary = salary;
  }


  GradeWithSalary(int salary) {
    this.salary = salary;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }
}

enum Status {
  OK,
  IAMINBETWEENOKNOK,
  NOK,
  ERROR,
  UNKNOWN,
  REJECTED,
  PENDING,
  ACCEPTED,
  SUSPENDED,
}


class Demo {
  public String name;

  public Demo(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Demo{" +
      "name='" + name + '\'' +
      '}';
  }
}

interface IDemo {
  void printMe();
}

//We can not extends but we can implement any interface in enum class.
enum Days implements IDemo {
  MONDAY,
  FRIDAY,
  SUNDAY;;

  @Override
  public void printMe() {

  }
}

enum Operations {
  ADD {
    @Override
    public int apply(int x, int y) {
      return x + y;
    }
  },
  SUBTRACT {
    @Override
    public int apply(int x, int y) {
      return x - y;
    }
  };


  public abstract int apply(int x, int y);

}