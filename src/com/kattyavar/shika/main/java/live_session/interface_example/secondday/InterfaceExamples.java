package com.kattyavar.shika.main.java.live_session.interface_example.secondday;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InterfaceExamples {

    public static void main(String[] args) {



        /*
        IC obj = new PatilImpl();
        obj.show();
        IPasswordVerify iPasswordVerify = new PasswordExtend();

        //base or its base ...

         */

        /*
        PrasadSir obj = new PrasadSir();
        obj.display();


        PrasadSir.APatil aPatil = new PrasadSir.MethodInnerClass();


         */

        A a = new B();
        a.show();

    }
}


class Data{

}

interface ILoadData {
    List<Data> loadData();
    default String getConfigFileName(){
        return "application.conf";
    } // application.conf
}

class ILoadDataImpl implements ILoadData {
    @Override
    public List<Data> loadData() {
        return List.of();
    }
}

class ILoadDataImp2 implements ILoadData {
    @Override
    public List<Data> loadData() {
        return List.of();
    }

    @Override
    public String getConfigFileName() {
        return "Amol.conf";
    }
}

class A {
    void show(){
        System.out.println("A::show");
    }
}

class  B  extends  A{
    @Override
    void show() {
        System.out.println("B::show");
    }

}


class PrasadSir {

    private String name;
    public String password;
    protected String age;

    interface APatil {
        default void display() {
            System.out.println(" in Apatil interface impl default ");
        }
    }

    static class MethodInnerClass implements APatil {
        @Override
        public void display() {
            System.out.println("Now I am in MethodInnerClass class.");
        }
    }

    void display() {

        String name;
        interface APatilInnerMethod {
            default void display() {
                System.out.println(" in Apatil interface impl default ");
            }
        }

        class MethodInnerClass implements PrasadSir.APatil {
            @Override
            public void display() {
                System.out.println("Now I am in MethodInnerClass class.");
            }
        }


        APatil obj = new MethodInnerClass();

        obj.display();
    }
}

interface IPasswordVerify {
    default Boolean verify(String password) {
        /*
                // Special char is not allowed
        // combination of letter, digit is allowed
        // only "@" is allowed as part of passwordl

        if all condition pass return true or return false...

        //Add the new condition here and close the topic ..
         */

        if (password.length() > 11) {
            return true;
        }
        return false;
    }


    static void staticMethod() {

    }
}

class PasswordExtend implements IPasswordVerify {
    @Override
    public Boolean verify(String password) {
        Boolean result = IPasswordVerify.super.verify(password);
        if (result == Boolean.TRUE) {
            //Then check for length
            if (password.length() > 11) {
                return true;
            }
        }
        return false;
    }
}


interface Product {
    interface MobileProduct {

    }

    interface FixNetProducdt {

    }
}


interface IOuterInterface {
    default void show() {
        System.out.println("Outer interface default method...");
    }

    void display();

    interface IInnerInterface {
        void innerInterfaceMethod();

        default void show() {
            System.out.println("Inner interface default method...");

        }
    }
}


class InnerInterfaceImpl implements IOuterInterface.IInnerInterface {

    @Override
    public void innerInterfaceMethod() {

    }
}


interface IA {
    default void show() {
        System.out.println("In IA show default method...");
    }
}


interface IB extends IA {

    @Override
    default void show() {
        IA.super.show();
    }
}

interface IC extends IA {
    @Override
    default void show() {
        System.out.println("In IC show default interface");
    }
}


class PatilImpl implements IB, IC {
    @Override
    public void show() {
        IC.super.show();
    }
}


interface InterfaceBase1 {
    default void show() {
        System.out.println("In interface InterfaceBase1 default method show...");
    }
}

interface InterfaceBase2 {

    default void show() {
        System.out.println(" in interface InterfaceBase2 default method show...");
    }
}

class DervicedClass implements InterfaceBase2, InterfaceBase1 {
    @Override
    public void show() {
        /*
        InterfaceBase2.super.show();
        InterfaceBase1.super.show();
         */
        //InterfaceBase2.super.show();
        System.out.println("This is the new way...");
    }
}




/*
interface IDemo {
    default void show() {
        System.out.println("Dummy impl of IDemo show method default way...");
    }
}

class DemoImpl implements IDemo {


}


 */






























