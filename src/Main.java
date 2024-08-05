import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Let find out the use of args params...");

        System.out.println(" zero element  0 " + args[0]);
        System.out.println(" zero element 1 " + args[1]);


        /**
         * Encapsulation
         *  --- Data hiding ...
         *  -- Control access...
         * Inheritance
         *  Below is is-a relationship
         *  single Inheritance -- using extends keyword ... (only one class is allowed  in case class only.)
         *  multilevel Inheritance
         *      class A{ }
         *      class B extends A {}
         *      class C extends B{}
         *  Hierarchy Inheritance:
         *      class A {]
         *      class B extends A{}
         *      class C extends A {}
         *  Multiple Inheritance : As java does not support this as part of class. but same can be achieved using interface.
         *
         *  Can interface extends multiple interface : yes perfect
         *  Can interface implement interface ? : no perfect
         *  Can class implement multiple interface ? :
         *  interface IA {}, interface IB{}
         *  class A implements IA, IB {} //.. this is valid ...
         *
         *  there is another relationship is has-a

         * Polymorphism :
         *  Two type :
         *      compile time or Static
         *          overloading
         *          //Operator overloading ...(Java dont  support this )
         *          // Templates (Java has given the alternate (Generic <T>
         *      RunTime/Dyanmic dispatch
         *          overriding
         * Abstraction:
         *  abstract class
         *  interface: 100% abstract (default method, what about static method, what about private method (from java 9 onwards ) ...
         *
         * All datatype should be Object(not java object class)  only..
         * ---Primitive Data Type...
         *
         * All the method and variable should be access from Object only...
         *  static ... variable, method...
         *
         * Java does not support closure function as java script support its...
         *
         */



        Demo demo1 = new Demo();
        Demo demo2 = new Demo();

        Integer a = 10;
        Integer b = 20;
        //Integer c = a +b;

        Integer c = (int) a + (int) b;

        //int
        //char
        //long
        //double
        //byte
        //short
        //boolean

        //+, -, *, assignment operator (=)


    }
}

class Person {
    protected String name;
    protected Boolean isMale;
}

class Student extends Person {
    private String rollNumber;
}


class College  {
    private List<Student> students;

}


interface IGetItDone{
    void getTheReport();
    void runServer();
    Boolean connectToDb();
    Object getTheFileContent();
    java.lang.Object getThePerfume();
}

abstract class ABC {  // 0 to 100 %
    //If i have have all method as abstract 100%
    //if i have few non abstract method...

}

class Xyz{
    java.lang.Object getThePerfume(){
        //Go out side..
        //Take the the money...
        // ask him for KS... we don't know how he will react..
        return null;
    }
}


class Demo {
    private String name;
    private String lastName;
    private Integer age;
    private String wifeName;

    private Integer showMyAge() {
        return age;
    }
    private void showMyAge(Integer age){

    }
    private void showMyAge(String age){

    }
}

class BaseOuter {
    int x = 50;

    class BaseInner {
        int y = 100;

        void display() {
            System.out.println("In BaseInner display");
        }
    }
}


class Derived extends BaseOuter {

    void display() {
        super.x = 100;
    }

    class DerivedInner extends BaseInner {

        void innerMethod() {
            super.y = 1000;
        }

    }

}

class Object extends java.lang.Object {

    public Object() {
        System.out.println("This is not java parent Object class it your class have the same name...");
    }
}